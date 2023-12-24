package tech.spiritualdarkness.itu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    public Result<FindJobResume, ResumeStatus> queryJobResume(
            @PathVariable String uuid
    ) {
        Integer uuidInt = null;
        try {
            uuidInt = Integer.parseInt(uuid);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(ResumeStatus.ArgError, null);
        }
        return findJobResumeService.getById(uuidInt);
    }
    @PostMapping("/find_job/update")
    public Result<FindJobResume, ResumeStatus> updateJobResume(
            @RequestHeader int uuid,
            @RequestBody FindJobResume resume
            ){
        resume.setUuid(uuid);
        return findJobResumeService.update(resume);
    }
}


//    @RequestParam String real_name,
//    @RequestParam int age,
//    @RequestParam int work_type,
//    @RequestParam int sex,
//    @RequestParam int pay_method,
//    @RequestParam int work_method,
//    @RequestParam int min_qualify,
//    @RequestParam String current_province,
//    @RequestParam String expect_province,
//    @RequestParam String first_job,
//    @RequestParam String second_job,
//    @RequestParam int salary_stock,
//    @RequestParam int salary,
//    @RequestParam String introduce,
//@RequestParam