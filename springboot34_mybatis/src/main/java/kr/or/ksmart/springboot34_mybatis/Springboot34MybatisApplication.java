package kr.or.ksmart.springboot34_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "kr.or.ksmart.springboot34_mybatis")
public class Springboot34MybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot34MybatisApplication.class, args);
	}

}
