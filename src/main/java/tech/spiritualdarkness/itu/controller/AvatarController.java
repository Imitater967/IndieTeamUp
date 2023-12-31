package tech.spiritualdarkness.itu.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.spiritualdarkness.itu.bean.vo.response.Status;
import tech.spiritualdarkness.itu.service.FileService;

@Slf4j
@RestController
@RequestMapping("/avatar")
public class AvatarController {
    @Autowired
    FileService fileService;
    @PostMapping("/upload")
    public Status upload(@RequestParam("avatar") MultipartFile file, @RequestHeader String uuid) {
        log.info("save file name {}.png", uuid);
        String filePath = fileService.saveFile(file,uuid+".png");
        return Status.success(200,filePath);
    }

//    @GetMapping("/request")
//    public ResultBean downloadFile(HttpServletResponse response,
//                                   @RequestParam(value = "fileName") String fileName) {
//
//        Boolean result = fileService.downloadFile(response, fileName);
//        return ResultBean.success(result);
//    }
}
