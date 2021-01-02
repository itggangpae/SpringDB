package db.dao;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import db.domain.Contact;

@Repository
public class SimpleJdbcCallDAO {
	@Autowired
	private SimpleJdbcCall jdbcTemplate;
	
	
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
