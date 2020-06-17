package com.leetcode.demo.page.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSource1Config.PACKAGE,sqlSessionFactoryRef = "sqlSessionFactory1")
public class DataSource1Config {
    static final String PACKAGE = "com.leetcode.demo.page.dao.datasources1";
    static final String MAPPER_LOCATION = "classpath*:com/leetcode/demo/page/mapper/datasources1/*Mapper.xml";

    @Value("${spring.datasource.datasource1.url}")
    private String url;
    @Value("${spring.datasource.datasource1.username}")
    private String username;
    @Value("${spring.datasource.datasource1.password}")
    private String password;
    @Value("${spring.datasource.datasource1.driverClassName}")
    private String driverClassName;


    @Bean(name = "dataSource1")
    @Primary
    public DataSource dataSource1(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager transactionManager1(){
        return new DataSourceTransactionManager(dataSource1());
    }

    @Bean(name = "sqlSessionFactory1")
    @Primary
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("dataSource1") DataSource dataSource1) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource1);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource1Config.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
