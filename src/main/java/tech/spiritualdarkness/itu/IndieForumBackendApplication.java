package tech.spiritualdarkness.itu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan({"tech.spiritualdarkness.itu.dao"})
@SpringBootApplication()
public class IndieForumBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndieForumBackendApplication.class, args);
	}

}
