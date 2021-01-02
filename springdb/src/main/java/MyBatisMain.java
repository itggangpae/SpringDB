
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import db.mybatis.service.GoodService;

public class MyBatisMain {

	public static void main(String[] args) {

		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService goodService = context.getBean(GoodService.class);

		goodService.insertGood();

		context.close();
		System.exit(0);
		 */

		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService goodService = context.getBean(GoodService.class);

		goodService.listGood();

		context.close();
		System.exit(0);
		 */

		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService goodService = context.getBean(GoodService.class);

		goodService.getGood();

		context.close();
		System.exit(0);
		 */

		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService goodService = context.getBean(GoodService.class);

		goodService.updateGood();

		context.close();
		System.exit(0);
		 */

		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		GoodService goodService = context.getBean(GoodService.class);
		 */

		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RootConfig.class);

		GoodService goodService = context.getBean("goodServiceImpl",GoodService.class);

		goodService.deleteGood();

		context.close();
		System.exit(0);

	}
}
