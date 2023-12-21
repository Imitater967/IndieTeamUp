package tech.spiritualdarkness.itu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeResult;

@RestController
@RequestMapping("/resume")
public class ResumeController {
    @GetMapping("/find_job/{uuid}")
    public Result<FindJobResume, ResumeResult> getFindJobResume(
            @PathVariable String uuid
    ){

        return null;
    }
}
