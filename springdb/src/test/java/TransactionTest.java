import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import db.mybatis.serviceimpl.TransactionDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})

public class TransactionTest {
	@Autowired
	TransactionDAO tDao;
	
	@Test
	public void transactionTest() {
		tDao.insert();
	}
}
