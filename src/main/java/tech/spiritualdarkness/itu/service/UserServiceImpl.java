package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.User;
import tech.spiritualdarkness.itu.dao.IUserMapper;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper,User> implements IUserService {

    @Override
    public String printHi() {
        return "hi";
    }
}
