package ahpu.libra.service;

import ahpu.libra.entity.Book;
import ahpu.libra.entity.NoteResult;

public interface BookService {
	public NoteResult loadAllBook();
	
	public NoteResult saveBook(Book book);
	
	public NoteResult delBook(String bnum);
	
	public NoteResult updataBook(Book book);
	
	public NoteResult findByBname(String bname);
	
	public NoteResult findByBnum(String bnum);
}
