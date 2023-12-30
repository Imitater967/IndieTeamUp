package tech.spiritualdarkness.itu.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import tech.spiritualdarkness.itu.bean.po.User;
import tech.spiritualdarkness.itu.dao.UserMapper;
import tech.spiritualdarkness.itu.util.JWTUtil;

@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    final
    UserMapper userDAO;

    public JWTInterceptor(UserMapper userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        boolean devEnv = true;
        if(devEnv){
            log.warn("警告警告警告");
            log.warn("当前未开启正版验证");
            log.warn("警告警告警告");
            return true;
        }

        String token = request.getHeader("token");
        String uuid = request.getHeader("uuid");
        String username = request.getHeader("username");
        if(!StringUtils.hasText(token)){
            log.debug("token为空");
            return false;
        }

        try {
            User user = userDAO.getByUsername(username);
            if(user == null){
                log.debug("不存在用户");
                return false;
            }
            if(!user.getUsername().equals(username)){
                log.debug("用户名和token不匹配");
                return false;
            }
            if(!(user.getUuid().toString().equals(uuid))){
                log.debug("uuid不匹配");
                return false;
            }

            JWTUtil.verify(token,user.getPassword());

        } catch (SignatureVerificationException e) {
            log.debug("无效签名！ 错误 ->", e);
            return false;
        } catch (TokenExpiredException e) {
            log.debug("token过期！ 错误 ->", e);
            return false;
        } catch (AlgorithmMismatchException e) {
            log.debug("token算法不一致！ 错误 ->", e);
            return false;
        } catch (Exception e) {
            log.debug("token无效！ 错误 ->", e);
            return false;
        }
        return true;
    }
}
