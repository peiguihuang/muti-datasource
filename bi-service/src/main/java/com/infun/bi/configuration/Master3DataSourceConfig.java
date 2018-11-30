package com.infun.bi.configuration;

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
 * @Author:jianghuimin
 * @Date: 2017/6/28
 * @Time:11:02
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Master3DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "master2SqlSessionFactory")
public class Master3DataSourceConfig {
        // 精确到 master 目录，以便跟其他数据源隔离
        static final String PACKAGE = "com.infun.bi.mybatis.mapper.master3";
    static final String MAPPER_LOCATION = "classpath:com/infun/bi/mapper/master3/*Mapper.xml";

    @Value("${master3.datasource.url}")
        private String url;

        @Value("${master3.datasource.username}")
        private String user;

        @Value("${master3.datasource.password}")
        private String password;

        @Value("${master3.datasource.driverClassName}")
        private String driverClass;

        @Bean(name = "master3DataSource")
        public DataSource master2DataSource() {
            DruidDataSource dataSource = new DruidDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            return dataSource;
        }

        @Bean(name = "master3TransactionManager")
        public DataSourceTransactionManager master2TransactionManager() {
            return new DataSourceTransactionManager(master2DataSource());
        }

        @Bean(name = "master3SqlSessionFactory")
        public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("master3DataSource") DataSource master2DataSource) throws Exception {
            final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
            sessionFactory.setDataSource(master2DataSource);
            sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                    .getResources(Master3DataSourceConfig.MAPPER_LOCATION));
            return sessionFactory.getObject();
    }
}