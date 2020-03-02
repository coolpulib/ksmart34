package kr.or.ksmart.springboot34_mybatis.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*@Configuration

//interface 클래스 위치 알려준다
@MapperScan(value="kr.or.ksmart.springboot34_mybatis")*/

public class MybatisConfig {
	
	/* @Bean(name="myb.atisSqlSessionFactory") */
	public SqlSessionFactory mybatisSqlSessionFactory(DataSource dataSource, ApplicationContext context) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setMapperLocations(context.getResources("classpath:mapper/**/*.xml"));
		bean.setDataSource(dataSource);
		
		return bean.getObject();
		
	}
	
}
