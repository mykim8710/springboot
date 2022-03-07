package com.example.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

// @Repository 방식 MyBatis 설정
@Configuration
//@ComponentScan(value="com.example.springboot.**.repository")
public class MybatisConfig2 {
    @Autowired
    ApplicationContext applicationContext;

//    @Bean
//    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception { // mybatis 사용을 위한 sessionFactory bean 등록
//        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
//        sqlSessionFactory.setDataSource(dataSource);
//        sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")); // mybatis 설정파일 등록
//        return sqlSessionFactory;
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlsessionFactory) throws Exception { // mybatis 사용을 위한 sqlSession bean 등록
//        return new SqlSessionTemplate(sqlsessionFactory.getObject());
//    }

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

          PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
          sessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/*.xml"));
          sessionFactory.setConfigLocation(applicationContext.getResource("classpath:mybatis-config.xml"));
          sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
          return sessionFactory.getObject();
      }
}
