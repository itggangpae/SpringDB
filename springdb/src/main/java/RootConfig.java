import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "db.mybatis" })
@MapperScan(basePackages = { "db.mybatis" })
public class RootConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:xe");
        dataSource.setUsername("system");
        dataSource.setPassword("wnddkd");
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}
	
	@Bean
	public SimpleJdbcInsert simpleJdbcInsertFactory() throws Exception{
		return new SimpleJdbcInsert(dataSource());
	}
	
	@Bean
	public DataSourceTransactionManager dataSourceTransactionManagerFactory() throws Exception{
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
	

}
