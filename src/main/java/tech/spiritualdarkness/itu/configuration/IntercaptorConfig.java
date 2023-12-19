package tech.spiritualdarkness.itu.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.spiritualdarkness.itu.interceptor.JWTInterceptor;

@Configuration
public class IntercaptorConfig implements WebMvcConfigurer {
    final
    JWTInterceptor jwtInterceptor;

    public IntercaptorConfig(JWTInterceptor jwtInterceptor) {
        this.jwtInterceptor = jwtInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                        .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");
    }
}
