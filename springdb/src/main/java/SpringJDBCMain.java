import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import db.dao.MySqlDAO;
import db.dao.SpringJdbcConfig;

public class SpringJDBCMain {
	public static void main(String[] args) {
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		JdbcTemplateDAO dao = context.getBean(JdbcTemplateDAO.class);
		
		System.out.println(dao.count());
		System.out.println("===================");
		System.out.println(dao.select());
		System.out.println("===================");
		System.out.println(dao.selectOne("Hunter"));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		JdbcTemplateDAO dao = context.getBean(JdbcTemplateDAO.class);
		Contact contact = new Contact();
		contact.setId(0);
		contact.setName("jessica");
		contact.setPhoneNumber("01037901997");
		contact.setBirthday(new Date(new GregorianCalendar().getTimeInMillis()));
		int result = dao.insert(contact);
		if(result > 0 )
			System.out.println("삽입 성공");
		else
			System.out.println("삽입 실패");
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		NamedContactDAO dao = context.getBean(NamedContactDAO.class);
		System.out.println(dao.selectOne("jessica"));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		SimpleJdbcInsertDAO dao = context.getBean(SimpleJdbcInsertDAO.class);
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("id", 4);
		map.put("name", "jessica");
		map.put("phonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("birthday", new Date(cal.getTimeInMillis()));
		System.out.println(dao.insert(map));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		SimpleJdbcInsertDAO dao = context.getBean(SimpleJdbcInsertDAO.class);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("vname", "윤봉길");
		map.put("vphonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("vbirthday", new Date(cal.getTimeInMillis()));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		SimpleJdbcCallDAO dao = context.getBean(SimpleJdbcCallDAO.class);
		
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("vname", "윤봉길");
		map.put("vphonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("vbirthday", new Date(cal.getTimeInMillis()));
		
		System.out.println(dao.insert(map));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		SimpleJdbcCallDAO dao = context.getBean(SimpleJdbcCallDAO.class);
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("VID", 2);
		System.out.println(dao.get(map));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		SimpleJdbcCallDAO dao = context.getBean(SimpleJdbcCallDAO.class);
		Map<String, Object>map = new HashMap<String, Object>();
		System.out.println(dao.list(map));
		*/
		
		/*
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		MySqlDAO dao = context.getBean(MySqlDAO.class);
		dao.method();
		
		context.close();
		*/
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SpringJdbcConfig.class);
		MySqlDAO dao = context.getBean(MySqlDAO.class);
		dao.method();
		
		context.close();
	}
}

