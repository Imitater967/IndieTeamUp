package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpSession;
import tech.spiritualdarkness.itu.bean.model.User;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.UserResultStatus;

/**
 * @author Megumin
 */
public interface IUserService extends IService<User> {
    /**
     * 用户注册
     *
     * @param user 用户对象
     * @return 注册结果
     */
    Result<User, UserResultStatus> register(User user);

    /**
     * 用户登录
     *
     * @param user 用户对象
     * @return 登录结果
     */
    Result<User, UserResultStatus> login(User user);

    /**
     * 修改用户信息
     *
     * @param user 用户对象
     * @return 修改结果
     */
    Result<User, UserResultStatus> update(User user) throws Exception;

    /**
     * 判断用户是否登录（实际上就是从session取出用户id去数据库查询并比对）
     *
     * @param session 传入请求session
     * @return 返回结果，若用户已登录则返回用户信息
     */
    Result<User, UserResultStatus> isLogin(HttpSession session);
}
