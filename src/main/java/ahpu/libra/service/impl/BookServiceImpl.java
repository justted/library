package ahpu.libra.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ahpu.libra.dao.BookDao;
import ahpu.libra.entity.Book;
import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.BookService;
@Service("bookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;
	
	//查询所有图书
	public NoteResult loadAllBook() {
		NoteResult result = new NoteResult();
		List<Book> books = bookDao.findAll();
		result.setData(books);
		result.setStatus(0);
		result.setMsg("查询图书成功");
		return result;
	}
	
	//插入（添加）一条图书记录
	public NoteResult saveBook(Book book) {
		NoteResult result = new NoteResult();
		//检查书名、索书号是否已存在
		Book b1 = bookDao.checkBookName(book.getBname());
		Book b2 = bookDao.findByBnum(book.getBnum());
		//System.out.println(b1+","+b2);
		if(b1!=null){
			result.setStatus(2);
			result.setMsg("书名已存在");
			return result;
		}
		if(b2!=null){
			result.setStatus(2);
			result.setMsg("索书号已存在");
			return result;
		}
		
		int i = bookDao.save(book);
		if(i==1){
			result.setData(i);
			result.setStatus(0);
			result.setMsg("添加图书成功");
			return result;
		}else {
			result.setData(i);
			result.setStatus(1);
			result.setMsg("添加图书失败");
			return result;
		}		
		
	}

	//删除一条图书记录
	public NoteResult delBook(String bnum) {
		NoteResult result = new NoteResult();
		//删除成功返回1，删除失败返回-1
		int i = bookDao.delete(bnum);
		if(i==1){
			result.setStatus(0);
			result.setMsg("删除图书成功");
			result.setData(i);
		}else{
			result.setStatus(1);
			result.setMsg("删除图书失败");
			result.setData(i);
		}
		return result;
	}

	//修改（更新）一条图书记录
	public NoteResult updataBook(Book book) {
		NoteResult result = new NoteResult();
		//检查书名、索书号是否已存在
		//如果不修改索书号和书名，就会查到数据，显示索书号、书名已存在。
//		Book b1 = bookDao.findByBname(book.getBname());
//		Book b2 = bookDao.findByBnum(book.getBnum());
//		if(b1!=null){
//			result.setStatus(2);
//			result.setMsg("书名已存在");
//			return result;
//		}
//		//有点问题
//		if(b2!=null){
//			result.setStatus(2);
//			result.setMsg("索书号已存在");
//			return result;
//		}
		
		int i = bookDao.modify(book);
		if(i==1){
			result.setData(i);
			result.setStatus(0);
			result.setMsg("修改图书成功");
		}else {
			result.setData(i);
			result.setStatus(1);
			result.setMsg("修改图书失败");
		}	
		return result;
	}

	//根据书名查找图书
	public NoteResult findByBname(String bname) {
		NoteResult result = new NoteResult();
		List<Book> books = bookDao.findByBname("%"+bname+"%");
		if(books.size()>0){
			result.setData(books);
			result.setStatus(0);
			result.setMsg("按书名查找图书成功");
		}else {
			result.setData(null);
			result.setStatus(1);
			result.setMsg("按书名查找图书失败");
		}	
		return result;
	}
	
	//根据索书号查找图书
	public NoteResult findByBnum(String bnum) {
		NoteResult result = new NoteResult();
		Book book = bookDao.findByBnum(bnum);
		if(book!=null){
			result.setData(book);
			result.setStatus(0);
			result.setMsg("按索书号查找图书成功");
		}else {
			result.setData(null);
			result.setStatus(1);
			result.setMsg("按索书号查找图书失败");
		}	
		return result;
	}

}
