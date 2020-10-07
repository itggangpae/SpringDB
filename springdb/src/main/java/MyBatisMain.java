import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.service.GoodService;

public class MyBatisMain {

	public static void main(String[] args) {
		/*
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		*/
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(RootConfig.class);
		
		GoodService goodService = context.getBean("goodServiceImpl",
				GoodService.class);
		
		//goodService.getList();
		
		//goodService.codeSearch();
		//goodService.insertGood();
		//goodService.deleteGood();
		//goodService.updateGood();
		
		
		goodService.getList();
		//goodService.codeSearch();
		
		context.close();
		System.exit(0);
	}
}
