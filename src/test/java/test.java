import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.mybatis.Pager;
import dao.mapper.PmsUserMapper;
import dao.model.PmsUser;
import service.testservice;

public class test {

	  /*@Test
	   public void userServiceTest(){
		  
	        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
	        testservice ts = (testservice)context.getBean("testservice");
	        
	        //System.out.println(ts.add());
	        
	        
	        System.out.println(ts.delete2());
	  }*/
	  public static void main(String[] args) {
		
		  ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
		  testservice ts = (testservice)context.getBean("testservice");
		  
		  //System.out.println(ts.add());
		  //System.out.println(ts.deleteby());
		  // PmsUser pu= ts.get();
		 // PmsUser pu= (PmsUser) ts.get2();
		 // List<PmsUser> pulist=(List<PmsUser>) ts.getList();
		  
		  //List<PmsUser> pulist=(List<PmsUser>) ts.getALL();
		  //List<PmsUser> pulist2=(List<PmsUser>) ts.getALLORDREBY();
		  //List<PmsUser> pu=(List<PmsUser>) ts.runsql2();
		  
		  Pager<PmsUser> pu=(Pager<PmsUser>) ts.getpage();
		  
	 }
}
