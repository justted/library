package ahpu.libra.dao;

import java.util.List;

import ahpu.libra.entity.Book;
import org.springframework.stereotype.Component;


@Component
public interface BookDao {
	//修改一条图书信息
	public int modify(Book book);
		
	//查询一条对应id的图书信息
	public Book findById(int id);
		
	//删除对应bnum的图书记录
	public int delete(String bnum);
	
	//插入一条图书信息
	public int save(Book book);
		
	//查询表中所有Book数据，返回Book集合
	public List<Book> findAll();
	
	//按索书号查询图书
	public Book findByBnum(String Bnum);
		
	//按书名查询图书---模糊查询
	public List<Book> findByBname(String Bname);
	
	//检测书名是否已经存在
	public Book checkBookName(String name);
}
