import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "db.hibernate" })
public class HibernateConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
        dataSource.setUrl("jdbc:log4jdbc:mysql://localhost:3306/cyberadam?characterEncoding=UTF-8&serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() throws Exception{
		
		LocalSessionFactoryBean localSessionFactoryBean =  new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setMappingResources("db/hibernate/dao/good.hbm.xml");	
		Properties props = new Properties();
	    props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
	    localSessionFactoryBean.setHibernateProperties(props);

		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() throws Exception{
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setDataSource(dataSource());
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
	}
}
