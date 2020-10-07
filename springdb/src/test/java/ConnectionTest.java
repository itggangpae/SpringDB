import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
public class ConnectionTest {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "system";
	private static final String PW = "wnddkd";
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
}
*/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations ={"classpath:applicationContext.xml"})
public class ConnectionTest {
	@Inject
	private DataSource ds;
	@Test
	public void testConection()throws Exception{
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
