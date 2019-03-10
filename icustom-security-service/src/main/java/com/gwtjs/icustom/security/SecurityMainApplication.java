package com.gwtjs.icustom.security;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.gwtjs.icustom.log.ICustomLogger;
import com.gwtjs.icustom.log.ICustomLoggerFactory;
import com.gwtjs.icustom.security.support.Appctx;

@SpringBootApplication @Configuration
@MapperScan(basePackages={"com.gwtjs.icustom"}/*,markerInterface=SqlMapper.class*/)//value={"com.gwtjs.**.dao"}
public class SecurityMainApplication {

	private static final ICustomLogger log = ICustomLoggerFactory
			.getLogger(SecurityMainApplication.class);

	@PostConstruct
	public void initApplication() throws IOException {
		log.info("Running with Security profile(s) : {}");
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SecurityMainApplication.class);
		Appctx.ctx = app.run(args);
		/*
		System.out.println(Appctx.getObject("customInvocationSecurityMetadataSourceService"));
		SpringApplication.run(SecurityMainApplication.class, args);
		 */

		/*
		 * UserService suserService = (UserService)
		 * Appctx.ctx.getBean("userService"); SysUserVO su=
		 * suserService.findByName("TEST"); BCryptPasswordEncoder bc=new
		 * BCryptPasswordEncoder(4);//将密码加密 可以先设置初始密码：000000
		 * su.setPassword(bc.encode
		 * (su.getPassword()));//然后使用密码为key值进行加密，运行主类后，会自动加密密码，可连接数据库查看。
		 * System.out.println("密码"+su.getPassword()); suserService.update(su);
		 */// 运行一次后记得注释这段重复加密会无法匹配

		log.info("Running with Security core successfull------");

	}
	
}