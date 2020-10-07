import java.sql.Connection;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })

public class MyBatisTest {
	@Resource(name="dataSource")
	private DataSource ds;

	@Test
	public void testConection() throws Exception {
		try (Connection con = ds.getConnection()) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	private SqlSessionFactory sqlFactory;

	@Test
	public void testFactory() {
		System.out.println(sqlFactory);
	}

	@Test
	public void testSession() throws Exception {
		try (SqlSession session = sqlFactory.openSession()) {
			System.out.println(session);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
