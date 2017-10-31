package ahpu.libra.dao;


import ahpu.libra.entity.Admin;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AdminDaoTest {
	@Test
	public void test1(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		AdminDao dao = ac.getBean("adminDao",AdminDao.class);
		Admin admin = dao.findByName("刘献民");
		System.out.println(admin.getAd_name()+":"+admin.getAd_password());
	}
}
