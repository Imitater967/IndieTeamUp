package tech.spiritualdarkness.itu.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FileService {

    @Value("${server.port}")
    private String port;


    @Value("${pic.dir}")
    private String picDir;


    public String saveFile(MultipartFile multipartFile,String uuid) {

        String filename =uuid;

        File file = new File(picDir, filename);

        try {
            multipartFile.transferTo(file);
            log.info("Saved file",file.getAbsolutePath());
        } catch (IOException e) {
            log.error("save file error,{}", e.getMessage());
            return "";
        }

        return getFileUrl(filename);
    }

//    public List<String> getFiles() {
//        List<String> fileUrls = new ArrayList<>();
//
//        File file = new File(picDir);
//        if (file.isDirectory()) {
//            File[] files = file.listFiles();
//            if (files != null) {
//                for (File file1 : files) {
//                    fileUrls.add(getFileUrl(file1.getName()));
//                }
//            }
//        }
//        return fileUrls;
//    }

    private String getFileUrl(String fileName) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            String fileUrl = "http://" + address.getHostAddress() + ":" + port + picDir + fileName;
            log.info("fileUrl:{}", fileUrl);
            return fileUrl;
        } catch (UnknownHostException e) {
            log.error("get host error,{}", e.getMessage());
            return "";
        }
    }

//    public Boolean downloadFile(HttpServletResponse response, String fileName) {
//        File file = new File(picDir + fileName);
//        if (file.exists()) {
//            try {
//                FileInputStream fileInputStream = new FileInputStream(file);
//
//                response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
//                ServletOutputStream outputStream = response.getOutputStream();
//
//                FileCopyUtils.copy(fileInputStream, outputStream);
//                return true;
//            } catch (IOException e) {
//                log.error("download file error: {}", e.getMessage());
//                return false;
//            }
//        }
//        return false;
//    }

}