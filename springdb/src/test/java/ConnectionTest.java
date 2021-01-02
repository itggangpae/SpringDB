import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"classpath:applicationContext.xml"})
public class ConnectionTest {
	/*
	//오라클 설정
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "system";
	private static final String PW = "wnddkd";
	*/
	
	//MySQL 설정
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/cyberadam?characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "";
	
	@Test
	public void testConnection() throws Exception{
		Class.forName(DRIVER);
		try(Connection con = 
				DriverManager.getConnection(URL, USER, PW)){
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource ds;
	
	@Test
	public void testDataSourceConection()throws Exception{
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Autowired
	@Qualifier("mysqlDataSource")
	private DataSource mysqlds;
	
	@Test
	public void testMySQLDataSourceConection()throws Exception{
		try(Connection con = mysqlds.getConnection()){
			System.out.println("MySQL:" + con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}