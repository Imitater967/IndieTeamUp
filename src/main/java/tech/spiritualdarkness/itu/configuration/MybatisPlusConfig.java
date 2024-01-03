package tech.spiritualdarkness.itu.configuration;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.spiritualdarkness.itu.handler.MyMetaObjectHandler;

@Configuration
@MapperScan("tech.spiritualdarkness.itu.dao")
public class MybatisPlusConfig {
    @Bean
    public MetaObjectHandler metaObjectHandler(){
        return new MyMetaObjectHandler();
    }
}
