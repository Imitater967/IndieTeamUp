package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tech.spiritualdarkness.itu.bean.model.User;
import tech.spiritualdarkness.itu.dao.IUserMapper;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResultStatus;

@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper,User> implements IUserService {

    @Autowired
    IUserMapper userDAO;

    @Override
    public Result<User> register(User user) {
//        Result<User> result = new Result<>();
//        // 先去数据库找用户名是否存在
//        User getUser = userDAO.getByUsername(user.getUsername());
//        if (getUser != null) {
//            result.setResultStatus(ResultStatus.UserSignUpNameExists);
//            return result;
//        }
//        // 加密储存用户的密码
////        user.setPassword(DigestUtils.md5Hex(user.getPassword()));
//        // 存入数据库
//        userDAO.add(user);
//        // 返回成功消息
//        result.setResultStatus(ResultStatus.UserSignUpSucceed);
//        return result;
        return null;
    }

    @Override
    public Result<User> login(User user) {
//        Result<User> result = new Result<>();
//        // 去数据库查找用户
//        User getUser = userDAO.getByUsername(user.getUsername());
//        if (getUser == null) {
//            result.setResultStatus(ResultStatus.UserSignInFail);
//            return result;
//        }
//        // 比对密码（数据库取出用户的密码是加密的，因此要把前端传来的用户密码加密再比对）
//        if (!getUser.getPassword().equals(DigestUtils.md5Hex(user.getPassword()))) {
//            result.setResultStatus(ResultStatus.UserSignInFail);
//            return result;
//        }
//        // 设定登录成功消息
//        result.setResultStatus(ResultStatus.UserSignInSucceed);
//        return result;
        return null;
    }

    @Override
    public Result<User> update(User user) throws Exception {
        return null;
    }

    @Override
    public Result<User> isLogin(HttpSession session) {
//        Result<User> result = new Result<>();
//        // 从session中取出用户信息
//        User sessionUser = (User) session.getAttribute(UserAPI.SESSION_NAME);
//        // 若session中没有用户信息这说明用户未登录
//        if (sessionUser == null) {
//            result.setResultFailed("用户未登录！");
//            return result;
//        }
//        // 登录了则去数据库取出信息进行比对
//        User getUser = userDAO.getById(sessionUser.getId());
//        // 如果session用户找不到对应的数据库中的用户或者找出的用户密码和session中用户不一致则说明session中用户信息无效
//        if (getUser == null || !getUser.getPassword().equals(sessionUser.getPassword())) {
//            result.setResultFailed("用户信息无效！");
//            return result;
//        }
//        result.setResultSuccess("用户已登录！", getUser);
//        return result;
        return null;
    }

}
