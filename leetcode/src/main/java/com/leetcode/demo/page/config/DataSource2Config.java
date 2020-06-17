package com.leetcode.demo.page.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = DataSource2Config.PACKAGE,sqlSessionFactoryRef = "sqlSessionFactory2")
public class DataSource2Config {
    static final String PACKAGE = "com.leetcode.demo.page.dao.datasources2";
    static final String MAPPER_LOCATION = "classpath*:com/leetcode/demo/page/mapper/datasources2/*Mapper.xml";

    @Value("${spring.datasource.datasource2.url}")
    private String url;
    @Value("${spring.datasource.datasource2.username}")
    private String username;
    @Value("${spring.datasource.datasource2.password}")
    private String password;
    @Value("${spring.datasource.datasource2.driverClassName}")
    private String driverClassName;


    @Bean(name = "datasource2")
    public DataSource datasource2(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDriverClassName(driverClassName);
        return dataSource;
    }

    @Bean(name = "transactionManager2")
    public DataSourceTransactionManager transactionManager2(){
        return new DataSourceTransactionManager(datasource2());
    }

    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory1(@Qualifier("datasource2") DataSource datasource2) throws Exception {
        final SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(datasource2);
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(DataSource2Config.MAPPER_LOCATION));
        return sessionFactoryBean.getObject();
    }
}
