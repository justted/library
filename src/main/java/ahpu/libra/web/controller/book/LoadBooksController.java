package ahpu.libra.web.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.BookService;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/loadbooks")
	@ResponseBody
	public NoteResult execute(){
		NoteResult result  = bookService.loadAllBook();
		return result;
	}
}
