package com.gm.statistical.config.datasource;

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

/**
 * @Description: 课程库数据源配置
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Configuration
@MapperScan(basePackages = ClassDataSourceConfig.PACKAGE, sqlSessionFactoryRef="classSqlSessionFactory")
public class ClassDataSourceConfig {

    static final String PACKAGE = "com.gm.statistical.dao.classdata";
    static final String MAPPER_LOCATION = "classpath:mapper/classdata/*.xml";

    @Value("${spring.datasource.class.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    /**
     * 配置数据业务数据源
     */
    @Bean(name = "classDataSource")
    @Primary
    public DataSource classDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 配置业务事物管理
     */
    @Bean(name = "classTransactionManager")
    @Primary
    public DataSourceTransactionManager classTransactionManager() {
        return new DataSourceTransactionManager(classDataSource());
    }

    /**
     * 配置业务SqlSessionFactory
     */
    @Bean(name = "classSqlSessionFactory")
    @Primary
    public SqlSessionFactory classSqlSessionFactory(@Qualifier("classDataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ClassDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
