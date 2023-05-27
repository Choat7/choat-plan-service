package com.choat.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableCaching
//@MapperScan("com.choat.plan.postgre.mybatisplus.dao")
public class ChoatPlanServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChoatPlanServiceApplication.class, args);
	}

}
