package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.po.JobEmployeeRelation;
import tech.spiritualdarkness.itu.bean.po.UserContact;
import tech.spiritualdarkness.itu.dao.JobEmployeeRelationMapper;
import tech.spiritualdarkness.itu.dao.UserContactMapper;

import java.util.List;
import java.util.function.Consumer;

@Service
public class ContactServiceImpl extends ServiceImpl<UserContactMapper, UserContact> implements  IContactService {

    @Autowired
    JobEmployeeRelationMapper relationMapper;

    @Override
    public UserContact findByUuid(String self,String uuid) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("employee_agree",true);
        wrapper.eq("company_agree",true);
        wrapper.and(new Consumer<QueryWrapper<UserContact>>() {
            @Override
            public void accept(QueryWrapper<UserContact> userContactQueryWrapper) {
                userContactQueryWrapper.eq("company_uuid",uuid);
                userContactQueryWrapper.eq("employee_uuid",self);
                userContactQueryWrapper.or();
                userContactQueryWrapper.eq("company_uuid",self);
                userContactQueryWrapper.eq("employee_uuid",uuid);
            }
        });
//        System.out.println(wrapper.getTargetSql());
        List<JobEmployeeRelation> list = relationMapper.selectList(wrapper);
//        list.forEach(x-> System.out.println(x.toString()));
        boolean isFriend = !list.isEmpty();

        boolean isSelf = uuid.equals(self);

        if (isSelf || isFriend) {
            return baseMapper.selectById(uuid);

        }
        return null;
    }

    @Override
    public void updateByUuid(UserContact contact) {
        baseMapper.deleteById(contact);
        baseMapper.insert(contact);
    }
}
