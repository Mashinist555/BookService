package com.summerschool.bookservice.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@PropertySource("classpath:database.properties")
@EnableTransactionManagement
public class PersistenceConfig {

    @Autowired
    private Environment environment;

    //Get properties from the file using @Value annotation:
    @Value("${dataSource.userName}")
    private String userName;
    
    @Value("${dataSource.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        final BasicDataSource basicDataSource = new BasicDataSource();
        //or get properties from the file using injected Environment
        basicDataSource.setDriverClassName(environment.getProperty("dataSource.driverName"));
        basicDataSource.setUrl(environment.getProperty("dataSource.url"));
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean(name = "entityManagerFactory")
    @Autowired
    public LocalContainerEntityManagerFactoryBean getSessionFactory(DataSource dataSource) throws IOException {
        final LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        factoryBean.setJpaDialect(new HibernateJpaDialect());
        factoryBean.setPackagesToScan("com.summerschool.bookservice.beans");
        factoryBean.setJpaProperties(PropertiesLoaderUtils.loadProperties(new ClassPathResource("persistence.properties")));
        return factoryBean;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor getExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Autowired
    @Bean(name = "entityManager")
    public EntityManager getEntityManager(EntityManagerFactory entityManagerFactory) {
        return entityManagerFactory.createEntityManager();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public PlatformTransactionManager getTransactionManager(EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager tm = new JpaTransactionManager();
        tm.setEntityManagerFactory(entityManagerFactory);
        return tm;
    }
    
    @Autowired
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
