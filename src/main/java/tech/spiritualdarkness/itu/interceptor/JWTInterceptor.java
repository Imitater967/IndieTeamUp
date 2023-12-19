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
import tech.spiritualdarkness.itu.bean.model.User;
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
        String token = request.getHeader("token");
        String username = request.getHeader("username");
        if(StringUtils.hasText(token)){
            throw new Exception("token不能为空");
        }

        try {
            User user = userDAO.getByUsername(username);
            if(user == null){
                log.error("不存在用户");
                return false;
            }
            JWTUtil.verify(token,user.getPassword());

        } catch (SignatureVerificationException e) {
            log.error("无效签名！ 错误 ->", e);
            return false;
        } catch (TokenExpiredException e) {
            log.error("token过期！ 错误 ->", e);
            return false;
        } catch (AlgorithmMismatchException e) {
            log.error("token算法不一致！ 错误 ->", e);
            return false;
        } catch (Exception e) {
            log.error("token无效！ 错误 ->", e);
            return false;
        }
        return true;
    }
}
