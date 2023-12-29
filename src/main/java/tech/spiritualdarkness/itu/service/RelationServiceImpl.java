package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.JobEmployeeRelation;
import tech.spiritualdarkness.itu.bean.vo.relation.Relationship;
import tech.spiritualdarkness.itu.bean.vo.response.RelationStatus;
import tech.spiritualdarkness.itu.dao.JobEmployeeRelationMapper;


@Service
public class RelationServiceImpl implements IRelationService{
    public final int maxFriend = 30;

    @Autowired
    JobEmployeeRelationMapper relationMapper;
    @Override
    public Relationship queryRelationShip(int uuid) {
        return null;
    }

    @Override
    public RelationStatus friendCompany(int uuid, int targetId, boolean friend) {
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("employee_uuid",uuid);
        var records = relationMapper.selectList(wrapper);
        //判断是否超出最大记录数
        if(records.size()>=maxFriend&&friend){
            return RelationStatus.OutOfBounds;
        }

        wrapper.eq("company_uuid", targetId);

        //0. 缓存数据
        JobEmployeeRelation relation = relationMapper.selectOne(wrapper);
        //1. 删除记录
        relationMapper.delete(wrapper);
        //如果是Unfriend则删除记录
        if(!friend){
            return RelationStatus.UnFriendCompanySuccess;
        }
        //如果是friend,则添加记录
        if (relation == null) {
            relation = new JobEmployeeRelation();
            relation.setCompany_uuid(targetId);
            relation.setEmployee_uuid(uuid);
        }
        relation.setEmployee_agree(true);
        relationMapper.insert(relation);

        return RelationStatus.FriendCompanySuccess;
    }

    @Override
    public RelationStatus friendEmployee(int uuid, int targetId, boolean friend) {
        QueryWrapper wrapper =new QueryWrapper();
        wrapper.eq("company_uuid",uuid);
        var records = relationMapper.selectList(wrapper);
        //判断是否超出最大记录数
        if(records.size()>=maxFriend&&friend){
            return RelationStatus.OutOfBounds;
        }

        wrapper.eq("employee_uuid", targetId);

        //0. 缓存数据
        JobEmployeeRelation relation = relationMapper.selectOne(wrapper);
        //1. 删除记录
        relationMapper.delete(wrapper);
        //如果是Unfriend则删除记录
        if(!friend){
            return RelationStatus.UnFriendEmployeeSuccess;
        }
        //如果是friend,则添加记录
        if (relation == null) {
            relation = new JobEmployeeRelation();
            relation.setEmployee_uuid(targetId);
            relation.setCompany_uuid(uuid);
        }
        relation.setCompany_agree(true);
        relationMapper.insert(relation);

        return RelationStatus.FriendEmployeeSuccess;
    }
}
