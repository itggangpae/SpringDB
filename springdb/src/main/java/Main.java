import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.GenericXmlApplicationContext;

import dao.ContactDAO;
import dao.MySqlDAO;
import dao.NamedContactDAO;
import dao.SimpleJdbcCallDAO;
import dao.SimpleJdbcInsertDAO;
import domain.Contact;

public class Main {
	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				"applicationContext.xml");
		//ContactDAO dao = context.getBean("contactDao", ContactDAO.class);
		/*
		System.out.println(dao.count());
		System.out.println("===================");
		System.out.println(dao.select());
		System.out.println("===================");
		System.out.println(dao.selectOne("Hunter"));
		*/
		
		/*
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
		NamedContactDAO dao = context.getBean("namedContactDao", NamedContactDAO.class);
		System.out.println(dao.selectOne("jessica"));
		 */
		
		/*
		SimpleJdbcInsertDAO dao = context.getBean("simpleJdbcInsertDao", SimpleJdbcInsertDAO.class);
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("id", 4);
		map.put("name", "jessica");
		map.put("phonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("birthday", new Date(cal.getTimeInMillis()));
		System.out.println(dao.insert(map));
		 */
		
		/*
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("vname", "윤봉길");
		map.put("vphonenumber", "01031391997");
		GregorianCalendar cal = new GregorianCalendar();
		map.put("vbirthday", new Date(cal.getTimeInMillis()));
		SimpleJdbcCallDAO dao = context.getBean("simpleJdbcCallDao", SimpleJdbcCallDAO.class);
		System.out.println(dao.insert(map));
		*/
		
		/*
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("VID", 2);
		SimpleJdbcCallDAO dao = context.getBean("simpleJdbcCallDao", SimpleJdbcCallDAO.class);
		System.out.println(dao.get(map));
		*/
		
		/*
		Map<String, Object>map = new HashMap<String, Object>();
		SimpleJdbcCallDAO dao = context.getBean("simpleJdbcCallDao", SimpleJdbcCallDAO.class);
		System.out.println(dao.list(map));
		*/
		
		MySqlDAO dao = context.getBean("mySqlDao", MySqlDAO.class);
		dao.method();

		
		context.close();
	}
}

