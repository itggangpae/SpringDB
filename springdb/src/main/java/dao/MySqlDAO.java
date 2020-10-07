package dao;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class MySqlDAO {
	private SimpleJdbcInsert simpleJdbcInsert;
	private SimpleJdbcCall simpleJdbcCall;

	public MySqlDAO(DataSource dataSource) {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
		simpleJdbcInsert.withTableName("contact");
		simpleJdbcCall = new SimpleJdbcCall(dataSource);
		simpleJdbcCall.withProcedureName("myproc");
	}
	
	public void method(){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("vname", "윤봉길");
		map.put("vphonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("vbirthday", new Date(cal.getTimeInMillis()));
		simpleJdbcCall.execute(map);
		
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
		simpleJdbcInsert.usingColumns("name", "phonenumber", "birthday");  
		map.put("name", "안중근");
		map.put("phonenumber", "01010001997");
		cal = new GregorianCalendar();
		map.put("birthday", new Date(cal.getTimeInMillis()));
		Number id = simpleJdbcInsert.executeAndReturnKey(map);
		System.out.println("추가된 인덱스:" + id);
	}
}
