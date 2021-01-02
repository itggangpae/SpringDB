import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import db.hibernate.service.GoodHibernateService;

public class HibernateMain {

	public static void main(String[] args) {
		/*
		GenericXmlApplicationContext context = 
			new GenericXmlApplicationContext(
				"classpath:applicationContext.xml");
		*/
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(HibernateConfig.class);
		GoodHibernateService goodService = context.getBean(GoodHibernateService.class);
		//goodService.insertGood();
		goodService.listGood();
		context.close();
	}
}
