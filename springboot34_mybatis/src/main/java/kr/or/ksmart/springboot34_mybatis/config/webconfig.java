package kr.or.ksmart.springboot34_mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.springboot34_mybatis.interceptor.CommonInterceptor;
import kr.or.ksmart.springboot34_mybatis.interceptor.LoginInterceptor;

@Configuration// 설정에 관한 클래스임을 알려줌
public class webconfig implements WebMvcConfigurer{

	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(commonInterceptor).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/css/**");
		//addPathPatterns 내가 어떤 주소에 인터셉터에 걸리게 할거
		//excludePathPatterns 인터셉터에 걸리게 하지 않을 거(뺄거)_여기는 두 개 뺄거라서 두번 쓴거임.
		
		
		registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/").excludePathPatterns("/mInsert")
		        .excludePathPatterns("/login").excludePathPatterns("/css/**");
	}
		
	
}
