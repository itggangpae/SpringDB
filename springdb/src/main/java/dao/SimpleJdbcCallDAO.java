package dao;
import java.util.*;
import javax.sql.*;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.*;

import domain.Contact;

public class SimpleJdbcCallDAO {
	private SimpleJdbcCall jdbcTemplate;
	
	public SimpleJdbcCallDAO(DataSource dataSource) {
		jdbcTemplate = new SimpleJdbcCall(dataSource);
	}
	
	public Map<String, Object> insert(Map<String, Object> map) {
		jdbcTemplate.withProcedureName("myproc");
		Map<String, Object> result = jdbcTemplate.execute (map);
		return result;
	}	
	
	public Map<String, Object> get(Map<String, Object> map) {
		jdbcTemplate.withProcedureName("read_contact");
		map.put("VID", 2);
		Map<String, Object> result = jdbcTemplate.execute(map);
		return result;
	}	
	
	public Map<String, Object> list(Map<String, Object> map) {
		jdbcTemplate.withProcedureName("all_contact");
		jdbcTemplate.returningResultSet("OUT_DATA",
                 BeanPropertyRowMapper.newInstance(Contact.class));
		Map<String, Object> result = jdbcTemplate.execute(map);
		return result;
	}	

}
