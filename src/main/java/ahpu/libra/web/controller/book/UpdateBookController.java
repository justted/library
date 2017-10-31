package ahpu.libra.web.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ahpu.libra.entity.Book;
import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.BookService;

@Controller
@RequestMapping("/book")
public class UpdateBookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/updatebook")
	@ResponseBody
	public NoteResult execute(Book book){
		NoteResult result = bookService.updataBook(book);
		return result;
	}
}
