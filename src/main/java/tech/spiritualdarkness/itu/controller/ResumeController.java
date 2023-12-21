package tech.spiritualdarkness.itu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;
import tech.spiritualdarkness.itu.service.IFindJobResumeService;

@Slf4j
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private IFindJobResumeService findJobResumeService;

    @GetMapping("/find_job/query/{uuid}")
    public Result<FindJobResume, ResumeStatus> getFindJobResume(
            @PathVariable String uuid
    ){
        Integer uuidInt = null;
        try {
            uuidInt = Integer.parseInt(uuid);
        }catch (Exception e){
              log.debug(e.getMessage());
              return new Result<>(ResumeStatus.ArgError,null);
        }
        return findJobResumeService.getByUuid(uuidInt);
    }
}
