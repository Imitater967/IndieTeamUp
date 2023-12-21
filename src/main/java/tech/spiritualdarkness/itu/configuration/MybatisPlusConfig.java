package tech.spiritualdarkness.itu.configuration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@MapperScan("tech.spiritualdarkness.itu.dao")
public class MybatisPlusConfig {
}
