package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import tech.spiritualdarkness.itu.bean.model.User;

public interface IUserService extends IService<User> {
    public String printHi();
}
