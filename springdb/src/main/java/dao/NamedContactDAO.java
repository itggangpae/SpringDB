package dao;

import java.sql.*;
import java.util.*;

import javax.sql.*;

import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.*;

import domain.Contact;

public class NamedContactDAO {
	private NamedParameterJdbcTemplate jdbcTemplate;

	public NamedContactDAO(DataSource dataSource) {
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	public Contact selectOne(String name) {
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("name", name);
		
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("name", name);

		return jdbcTemplate.queryForObject("select * from contact where name=:name", map, new RowMapper<Contact>() {
			@Override
			public Contact mapRow(ResultSet rs, int rownum) throws SQLException {
				Contact contact = new Contact();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setPhoneNumber(rs.getString("phonenumber"));
				contact.setBirthday(rs.getDate("birthday"));
				return contact;
			}
		});
	}
}
