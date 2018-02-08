package com.pecado.yukan.fund.config;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * <pre>
 * 描述： MyBatis基础配置
 * 构建组：ddjf-wx-group
 * 作者:haojing
 * 邮箱:haojing@ddjf.com.cn
 * 日期:2017/8/23 19:00
 * 版权：大道金服
 * </pre>
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig implements EnvironmentAware,TransactionManagementConfigurer {

    private Environment environment;

    @Override
    public void setEnvironment(final Environment environment) {
        this.environment = environment;
    }


    @Bean(name = "dataSource")
    public DataSource dataSource() throws Exception{

        Properties props = new Properties();
        props.put("driverClassName", environment.getProperty("jdbc.driver"));
        props.put("url", environment.getProperty("jdbc.url"));
        props.put("username", environment.getProperty("jdbc.username"));
        props.put("password", environment.getProperty("jdbc.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }



    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() {

        try {

            SqlSessionFactoryBean bean = new SqlSessionFactoryBean();

            /** 设置datasource */
            bean.setDataSource(dataSource());
            /** 设置typeAlias 包扫描路径 */
            bean.setTypeAliasesPackage("com.pecado.yukan.fund.entity");
            /** 设置mybatis configuration 扫描路径 */
            bean.setConfigLocation(new ClassPathResource("mybatis_config.xml"));
            //添加XML目录
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            /** 添加mapper 扫描路径 */
            bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Override
    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager(){

        try{
            return new DataSourceTransactionManager(dataSource());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }


}
