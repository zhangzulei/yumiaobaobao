package com.yumiaobaobao.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@MapperScan("com.yumiaobaobao.app.*.dao")
@MapperScan("com.yumiaobaobao.app.*.*.dao")
@MapperScan("com.yumiaobaobao.app.*.*.*.dao")
@ServletComponentScan(basePackages = "com.yumiaobaobao.app.user.userlogin.phonelogin.controller.*")
public class YumiaobaobaoApplication {

	public static void main(String[] args) {

		SpringApplication.run(YumiaobaobaoApplication.class, args);
	}

}
