package com.gm.statistical.config.datasource;

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

/**
 * @Description: 内部系统库数据源配置
 * @Author: zrk
 * @Date: 2020/2/13
 */
@Configuration
@MapperScan(basePackages = GmDataSourceConfig.PACKAGE, sqlSessionFactoryRef="gmSqlSessionFactory")
public class GmDataSourceConfig {

    static final String PACKAGE = "com.gm.statistical.dao.gmdata";
    static final String MAPPER_LOCATION = "classpath:mapper/gmdata/*.xml";

    @Value("${spring.datasource.gm.url}")
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
    @Bean(name = "gmDataSource")
    public DataSource gmDataSource() {
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
    @Bean(name = "gmTransactionManager")
    public DataSourceTransactionManager gmTransactionManager() {
        return new DataSourceTransactionManager(gmDataSource());
    }

    /**
     * 配置业务SqlSessionFactory
     */
    @Bean(name = "gmSqlSessionFactory")
    public SqlSessionFactory gmSqlSessionFactory(@Qualifier("gmDataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(GmDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
