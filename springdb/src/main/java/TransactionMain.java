import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import db.mybatis.serviceimpl.TransactionDAO;

public class TransactionMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RootConfig.class);
		TransactionDAO tDao = context.getBean(TransactionDAO.class);
		tDao.insert();
		context.close();
	}
}