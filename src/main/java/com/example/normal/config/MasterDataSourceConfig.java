package com.example.normal.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
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
 * 主数据库配置
 *
 * @Author HaiQing.Yu
 * @Date 2022/10/9 15:19
 */
@Configuration
@MapperScan(basePackages = {MasterDataSourceConfig.BASE_PACKAGE}, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    static final String BASE_PACKAGE = "com.example.normal.mapper.master";
    static final String MAPPER_LOCATION = "classpath:mapper/master/*.xml";

    @Value("${spring.datasource.MyDb1.driver-class-name}")
    private String myDb1Driver;
    @Value("${spring.datasource.MyDb1.url}")
    private String myDb1Url;
    @Value("${spring.datasource.MyDb1.username}")
    private String myDb1Username;
    @Value("${spring.datasource.MyDb1.password}")
    private String myDb1Password;

    @Primary
    @Bean(name = "masterDataSource")
    public DataSource masterDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(myDb1Username);
        druidDataSource.setPassword(myDb1Password);
        druidDataSource.setDriverClassName(myDb1Driver);
        druidDataSource.setUrl(myDb1Url);
        return druidDataSource;
    }

    @Primary
    @Bean(name = "masterDataSourceTransactionManager")
    public DataSourceTransactionManager masterDataSourceTransactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Primary
    @Bean(name = "masterSqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
        final MybatisSqlSessionFactoryBean factoryBean = new MybatisSqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return factoryBean.getObject();
    }

}
