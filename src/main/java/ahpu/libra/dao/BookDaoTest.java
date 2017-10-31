package ahpu.libra.dao;

import ahpu.libra.entity.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class BookDaoTest {
	@Test
	//查询所有图书记录
	public void test1(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		List<Book> books = dao.findAll();
		for(Book book:books){
			System.out.println(book.getBname()+book.getBnum());
		}
		
	}
	
	@Test
	//按书名查找图书
	//设计缺陷：只能实现查找完整书名，不能进行模糊查找
	public void test2(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		Book book = dao.checkBookName("JAVA入门到精通");
		System.out.println(book.getBnum()+book.getBname());
		
	}
	
	@Test
	//save 插入一条图书信息
	public void test3(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		Book book = new Book();
		book.setBnum("100200300412");
		book.setBname("JavaEE开发技术");
		book.setBwriter("胡平");
		book.setBpublish("安徽工程大学出版社");
		book.setStatus("0");
		book.setBeizhu("JEE");
		System.out.println(dao.save(book));
	}
	
	@Test
	//删除一条图书记录
	public void test4(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		int i = dao.delete("100200300");
		System.out.println(i);
	}
	
	@Test 
	//更新一条图书记录
	public void test5(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		Book book = new Book();
		book.setId(19);
		book.setBnum("100200300444");
		book.setBname("矩阵的深入研究");
		book.setBwriter("邹健");
		book.setBpublish("安徽工程大学出版社");
		book.setStatus("1");
		book.setBeizhu("数学、矩阵论");
		int i = dao.modify(book);
		System.out.println(i);
	}
	
	@Test
	//按书名查找图书
	public void test6(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		Book book = dao.checkBookName("数据库原理及应用");
		System.out.println("数据库："+book.getBnum()+book.getBwriter());
	}
	
	@Test
	//按索书号查询图书
	public void test7(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		Book book = dao.findByBnum("100200300408");
		System.out.println(book.getBname()+book.getBwriter());
	}

	@Test
	//按书名查找图书（模糊查询）
	public void test8(){
		String app = "applicationContext.xml";
		ApplicationContext ac = new ClassPathXmlApplicationContext(app);
		BookDao dao = ac.getBean("bookDao",BookDao.class);
		List<Book> books = dao.findByBname("%入门%");
		for(Book book:books){
			System.out.println("Books："+book.getBname()+book.getBwriter());
		}
		
	}
}
