package db.dao;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = { "db" })
public class SpringJdbcConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/cyberadam?characterEncoding=UTF-8&serverTimezone=UTC");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}


	@Bean
	public JdbcTemplate jdbcTemplate() throws Exception {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate() throws Exception {
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean
	public SimpleJdbcInsert simpleJdbcInsert() throws Exception {
		return new SimpleJdbcInsert(dataSource());
	}

	@Bean
	public SimpleJdbcCall simpleJdbcCall() throws Exception {
		return new SimpleJdbcCall(dataSource());
	}
}
