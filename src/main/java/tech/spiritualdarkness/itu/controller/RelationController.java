package tech.spiritualdarkness.itu.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.spiritualdarkness.itu.bean.vo.relation.Relationship;
import tech.spiritualdarkness.itu.bean.vo.response.RelationStatus;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.service.IRelationService;

@Slf4j
@RestController
@RequestMapping("/relation")
public class RelationController {
    private final IRelationService relationService;

    public RelationController(IRelationService relationService) {
        this.relationService = relationService;
    }

    //关注员工
    @PostMapping("/friend_employee/")
    public RelationStatus friendEmployee(
            @RequestHeader Integer uuid,
            @RequestBody Integer target_uuid,
            @RequestBody Boolean friend
    ){
        if(uuid == null || target_uuid == null || friend == null){
            return RelationStatus.ArgError;
        }
        return relationService.friendEmployee(uuid,target_uuid,friend);
    }

    //关注员工
    @PostMapping("/friend_company/")
    public RelationStatus friendCompany(
            @RequestHeader Integer uuid,
            @RequestBody Integer target_uuid,
            @RequestBody Boolean friend
    ){
        if(uuid == null || target_uuid == null || friend == null){
            return RelationStatus.ArgError;
        }
        return relationService.friendCompany(uuid,target_uuid,friend);
    }

    @GetMapping("/query")
    public Result<Relationship,RelationStatus> queryRelationship(
            @RequestHeader Integer uuid
    ){
        Relationship relationship = new Relationship();
        if(uuid == null){
            return new Result<>(RelationStatus.ArgError,null);
        }

        return new Result<>(RelationStatus.QuerySuccess,relationService.queryRelationShip(uuid));
    }
}
