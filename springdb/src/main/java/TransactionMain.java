import org.springframework.context.support.GenericXmlApplicationContext;

import dao.TransactionDAO;

public class TransactionMain {
	public static void main(String[] args) {
		// applicationContext.xml 파일의 내용을 가지고 객체를 생성할 수 있는 객체 만들기
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		TransactionDAO tDao = context.getBean("transactionDAO", TransactionDAO.class);
		tDao.insert();
		context.close();
	}
}