package tech.spiritualdarkness.itu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.spiritualdarkness.itu.bean.model.FindEmployeeResume;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.ResumeStatus;
import tech.spiritualdarkness.itu.service.IFindEmployeeService;
import tech.spiritualdarkness.itu.service.IFindJobResumeService;

@Slf4j
@RestController
@RequestMapping("/resume")
public class ResumeController {
    @Autowired
    private IFindJobResumeService findJobResumeService;
    @Autowired
    private IFindEmployeeService findEmployeeService;

    @GetMapping("/find_employee/query/{uploader_id}")
    public Result<FindEmployeeResume, ResumeStatus> queryFindEmployeeResume(
            @PathVariable String uploader_id) {
        Integer uuidInt = null;
        try {
            uuidInt = Integer.parseInt(uploader_id);
        } catch (Exception e) {
            log.debug(e.getMessage());
            return new Result<>(ResumeStatus.ArgError, null);
        }
        return findEmployeeService.getById(uuidInt);
    }
    @PostMapping("/find_employee/update")
    public Result<FindEmployeeResume, ResumeStatus> updateFindEmployeeResume(
            @RequestHeader int uuid,
            @RequestBody FindEmployeeResume resume
    ){

        resume.setPublisher_uuid(uuid);

//
//        resume.setFinance(10);
//        resume.setIntroduce("这个是一个超级nice的项目");
//        resume.setFinish_stage(FinishStage.Preparing);
//        resume.setGame_type(GameType.Arcade);
//        resume.setQualify(Qualify.PERSONAL);
//        resume.setSalary(10);
//        resume.setSalary_stock(6);
//        Calendar calendar=Calendar.getInstance();
//        calendar.set(2022,1,1);
//        resume.setFinish_date(calendar.getTime());
//        resume.setPay_method(PayMethod.FREE);
//        resume.setWork_method(WorkMethod.PART_TIME);
//        ObjectMapper mapper = new ObjectMapper();
//        log.info(mapper.writeValueAsString(resume));
        return findEmployeeService.update(resume);
    }

    @GetMapping("/find_job/query/{uuid}")
    public Result<FindJobResume, ResumeStatus> queryFindJobResume(
            @PathVariable String uuid) {
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
    public Result<FindJobResume, ResumeStatus> updateFindJobResume(
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