package by.example.team_board.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Arrays;
import java.util.Properties;

@Configuration
@PropertySource("classpath:teamBoardTest.properties")
@EnableTransactionManagement
//@ComponentScan(basePackages = "by.example.team_board")

public class TestConfig {
    final static Logger logger = LoggerFactory.getLogger(TestConfig.class);
    //@Value("${jdbc.driver}")
    private static String jdbcDriver = "org.h2.Driver";
   // @Value("${jdbc.url}")
    private static String jdbcUrl = "jdbc:h2:mem:people;DB_CLOSE_DELAY=-1";
    //@Value("${jdbc.user}")
    private static String user = "sa";
    //@Value("${jdbc.password}")
    private static String password = "sa";
    //@Value("${hibernate.dialect}")
    private static String hibernateDialect = "org.hibernate.dialect.H2Dialect";
    @Value("${hibernate.hbm2ddl.auto}")
    private static String hibernateHbm2ddlAuto;
    @Value("${hibernate.show_sql}")
    private static String hibernateShowSql;
    @Value("${hibernate.createDatabaseIfNotExist}")
    private static String createDatabaseIfNotExist;


    @Bean
    public static DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(jdbcDriver);
            dataSource.setJdbcUrl(jdbcUrl);
            dataSource.setUser(user);
            dataSource.setPassword(password);
        } catch (PropertyVetoException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
        }
        return dataSource;
    }

    @Bean
    public static LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("by.example.team_board.entity");
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        hibernateProperties.setProperty("hibernate.show_sql", hibernateShowSql);
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
        hibernateProperties.setProperty("hibernate.createDatabaseIfNotExist", createDatabaseIfNotExist);
        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
