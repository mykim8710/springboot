package com.example.springboot.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

// @Mapper 방식 MyBtis 설정
//@Configuration
//@MapperScan(basePackages = "com.example.springboot.**.repository")	// 프로젝트 패키지 내의 모든 폴더 안에 @mapper를 scan
public class MybatisConfig1 {
    //@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.example.springboot.**.domain"); 											// 프로젝트 패키지 내의 모든 Domain class 경로설정
        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("mappers/**/*.xml"));	// mapper.xml(SQL Query)파일들의 경로설정
        sqlSessionFactory.setVfs(SpringBootVFS.class);
        return sqlSessionFactory.getObject();
    }
}
