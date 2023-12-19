package tech.spiritualdarkness.itu.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mysql.cj.util.StringUtils;
import tech.spiritualdarkness.itu.bean.model.User;

import java.util.Calendar;

public class JWTUtil {

    private static Calendar getExpireTime(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DATE,7);
        return instance;
    }
    public static String createJwtToken(User user){
        Calendar date = getExpireTime();
        JWTCreator.Builder builder = JWT.create();
        builder.withClaim("uuid",user.getId())
                .withClaim("username",user.getUsername());
        return builder.withExpiresAt(getExpireTime().getTime())
                .sign(Algorithm.HMAC256(user.getPassword()));
    }
    public static DecodedJWT verify(String token, String password) throws Exception {
        if(StringUtils.isNullOrEmpty(token)){
            throw new Exception("token为空");
        }
        JWTVerifier build = JWT.require(Algorithm.HMAC256(password)).build();
        return build.verify(token);
    }
}
