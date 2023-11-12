package me.qingqing.indieforumbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class IndieForumBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IndieForumBackendApplication.class, args);
	}

}
