package com.example.normal.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.MyDb1.driver-class-name}")
    private String MyDb1Driver;
    @Value("${spring.datasource.MyDb1.url}")
    private String MyDb1Url;
    @Value("${spring.datasource.MyDb1.username}")
    private String MyDb1Username;
    @Value("${spring.datasource.MyDb1.password}")
    private String MyDb1Password;

//    @Value("${spring.datasource.MyDb2.driver-class-name}")
//    private String MyDb2Driver;
//    @Value("${spring.datasource.MyDb2.url}")
//    private String MyDb2Url;
//    @Value("${spring.datasource.MyDb2.username}")
//    private String MyDb2Username;
//    @Value("${spring.datasource.MyDb2.password}")
//    private String MyDb2Password;

    @Value("${spring.datasource.druid.maxActive}")
    private Integer maxActive;
    @Value("${spring.datasource.druid.initialSize}")
    private Integer initialSize;
    @Value("${spring.datasource.druid.maxWait}")
    private Integer maxWait;
    @Value("${spring.datasource.druid.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${spring.datasource.druid.maxPoolPreparedStatementPerConnectionSize}")
    private Integer maxPoolPreparedStatementPerConnectionSize;
    @Value("${spring.datasource.druid.minIdle}")
    private Integer minIdle;
    @Value("${spring.datasource.druid.connectionProperties}")
    private String connectionProperties;
    @Value("${spring.datasource.druid.timeBetweenEvictionRunsMillis}")
    private Integer timeBetweenEvictionRunsMillis;
    @Value("${spring.datasource.druid.minEvictableIdleTimeMillis}")
    private Integer minEvictableIdleTimeMillis;
    @Value("${spring.datasource.druid.validationQuery}")
    private String validationQuery;
    @Value("${spring.datasource.druid.validationQuery1}")
    private String validationQuery1;
    @Value("${spring.datasource.druid.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${spring.datasource.druid.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.datasource.druid.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.datasource.druid.filters}")
    private String filters;
    @Value("${spring.datasource.druid.use-global-data-source-stat}")
    private boolean useGlobalDataSourceStat;

    @Bean(name = "dsMyDb1")
    @Qualifier("dsMyDb1")
    public DataSource dataSourceMyDb1() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(MyDb1Url);
        datasource.setUsername(MyDb1Username);
        datasource.setPassword(MyDb1Password);
        datasource.setDriverClassName(MyDb1Driver);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
//        try {
//            datasource.setFilters(filters);
//        } catch (SQLException e) {
//            System.err.println("druid configuration initialization filter: " + e);
//        }
        datasource.setConnectionProperties(connectionProperties);
        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        return datasource;
    }

//    @Bean(name = "dsMyDb2")
//    @Qualifier("dsMyDb2")
//    public DataSource dataSourceMyDb2() {
//        DruidDataSource datasource = new DruidDataSource();
//        datasource.setUrl(MyDb2Url);
//        datasource.setUsername(MyDb2Username);
//        datasource.setPassword(MyDb2Password);
//        datasource.setDriverClassName(MyDb2Driver);
//        datasource.setInitialSize(initialSize);
//        datasource.setMinIdle(minIdle);
//        datasource.setMaxActive(maxActive);
//        datasource.setMaxWait(maxWait);
//        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
//        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
//        datasource.setValidationQuery(validationQuery);
//        datasource.setTestWhileIdle(testWhileIdle);
//        datasource.setTestOnBorrow(testOnBorrow);
//        datasource.setTestOnReturn(testOnReturn);
//        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
////        try {
////            datasource.setFilters(filters);
////        } catch (SQLException e) {
////            System.err.println("druid configuration initialization filter: " + e);
////        }
//        datasource.setConnectionProperties(connectionProperties);
//        datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
//        return datasource;
//    }



}
