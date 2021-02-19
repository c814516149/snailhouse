package com.channing.snailhouse.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.ConstructorProperties;

@Configuration
@MapperScan(basePackages = {"com.channing.snailhouse.model"}, sqlSessionTemplateRef = "snailhouseSqlSessionTemplate")
public class SnailhouseSourceConfig {
    @Bean(name = "snailhouseSource")
    @ConfigurationProperties(prefix = "datasource")
    @Primary
    public DataSource getSnailhouseSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "snailhouseSqlSessionFactory")
    @Primary
    public SqlSessionFactory adsSqlSessionFactory(@Qualifier("snailhouseSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }

    @Bean(name="snailhouseSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate adsSqlSessionTemplate(@Qualifier("snailhouseSqlSessionFactory") SqlSessionFactory factory){
        return new SqlSessionTemplate(factory);
    }

    @Bean(name = "snailhouseJdbcTemplate")
    @Primary
    public JdbcTemplate gateWayJdbcTemplate(@Qualifier("snailhouseSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
