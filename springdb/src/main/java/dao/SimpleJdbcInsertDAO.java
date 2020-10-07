package dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class SimpleJdbcInsertDAO {
	private SimpleJdbcInsert jdbcTemplate;

	public SimpleJdbcInsertDAO(DataSource dataSource) {
		jdbcTemplate = new SimpleJdbcInsert(dataSource);
		jdbcTemplate.withTableName("contact");
	}

	public int insert(HashMap<String, Object> map) {
		return jdbcTemplate.execute(map);
	}
}
