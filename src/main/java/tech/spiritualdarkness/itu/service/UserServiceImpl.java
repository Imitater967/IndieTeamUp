package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.po.User;
import tech.spiritualdarkness.itu.dao.UserMapper;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.UserResultStatus;
import tech.spiritualdarkness.itu.util.JWTUtil;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    UserMapper userDAO;

    @Override
    public Result<User, UserResultStatus> register(User user) {
        Result<User, UserResultStatus> result = new Result<>();
        boolean exits = userDAO.getByUsername(user.getUsername())!=null;
        if(exits){
            result.setStatus(UserResultStatus.UserExits);
            return result;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        userDAO.add(user);
        user = userDAO.getByUsername(user.getUsername());
        result.setData(user);
        result.setStatus(UserResultStatus.RegisteredSuccessfully);
        return result;
    }

    @Override
    public Result<User, UserResultStatus> login(User user) {
        Result<User, UserResultStatus> result = new Result<>();
        User dbUser = userDAO.getByUsername(user.getUsername());
        boolean exits = dbUser !=null;
        if(!exits){
            result.setStatus(UserResultStatus.LoginFail);
            return result;
        }

        boolean passwordEqual =encoder.matches(user.getPassword(),dbUser.getPassword());
        if (!passwordEqual) {
            return result;
        }

        dbUser.setJwt_code(JWTUtil.createJwtToken(dbUser));
        result.setStatus(UserResultStatus.LoginFail);

        userDAO.login(dbUser.getUuid(),dbUser.getJwt_code());
        result.setStatus(UserResultStatus.LoginSuccess);
        result.setData(dbUser);
        return result;
    }

    @Override
    public Result<User, UserResultStatus> update(User user) throws Exception {
        return null;
    }

    @Override
    public Result<User, UserResultStatus> isLogin(HttpSession session) {
        return null;
    }
}
