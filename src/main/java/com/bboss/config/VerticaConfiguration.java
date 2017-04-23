package com.bboss.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.bboss.util.ObjectUtil;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;


/*@Configuration
@EnableConfigurationProperties(DruidProperties.class)
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.bboss.dao.vertica",sqlSessionTemplateRef = "verticaSqlSessionTemplate")
*/public class VerticaConfiguration {
	
	
	@Value("${database.vertica.url}")
    private String url;
    @Value("${database.vertica.driver-class-name}")
    private String driverClassName;
    @Value("${database.vertica.username}")
    private String username;
    @Value("${database.vertica.password}")
    private String password;
 

    @Autowired
    private DruidProperties properties;

    @Bean("verticaDataSource")
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        if (properties.getMaxWait() > 0) {
        	dataSource.setMaxWait(properties.getMaxWait());
        }
        //private long timeBetweenEvictionRunsMillis;
        if (properties.getTimeBetweenEvictionRunsMillis() > 0) {
        	dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        }
        //private String validationQuery;
        if (ObjectUtil.isEmpty(properties.getValidationQuery())) {
        	dataSource.setValidationQuery(properties.getValidationQuery());
        }
        if (properties.getMaxPoolPreparedStatementPerConnectionSize() > 0) {
        	dataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        }
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
       
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
    
    
    @Bean(name = "verticaSqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("verticaDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.bboss.model");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mybatis/*Mapper.xml"));
        return  factoryBean.getObject();
    }

    @Bean(name = "verticaTransactionManager")
    public DataSourceTransactionManager testTransactionManager(@Qualifier("verticaDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "verticaSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("verticaSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
