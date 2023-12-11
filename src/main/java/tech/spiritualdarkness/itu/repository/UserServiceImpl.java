package tech.spiritualdarkness.itu.repository;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import tech.spiritualdarkness.itu.bean.model.User;
import tech.spiritualdarkness.itu.dao.UserMapper;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
