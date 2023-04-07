package kr.co.softsoldesk.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softsoldesk.beans.JdbcBean;
import kr.co.softsoldesk.config.BeanConfigClass;
import kr.co.softsoldesk.db.JdbcDAO;

public class MainClass {

	public static void main(String[] args) {
		
		System.out.println("================================================================================");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		// insert
		JdbcBean bean1 = new JdbcBean();
		/*
		 bean1.setInt_data(1); 
		 bean1.setStr_data("JAVA");
		 dao.insert_data(bean1);
		 */
		System.out.println("저장완료 ");
		
		// update
		/*
		JdbcBean bean3 = new JdbcBean();
		bean3.setInt_data(3);
		bean3.setStr_data("Python");
		dao.update_data(bean3);
		System.out.println("갱신완료");
		*/
		
		// delete
		JdbcBean bean4 = new JdbcBean();
		dao.delete_data(2);
		System.out.println("삭제완료");
		
		// select
		List<JdbcBean> list =dao.select_data();
		
		for(JdbcBean bean2 : list) {
			System.out.println("int_data : " + bean2.getInt_data());
			System.out.println("Str_data : " + bean2.getStr_data());
			System.out.println("---------------------------------");
		}
		
		ctx.close();
	}

}
