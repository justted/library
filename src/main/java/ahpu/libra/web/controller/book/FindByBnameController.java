package ahpu.libra.web.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.BookService;

@Controller
@RequestMapping("/book")
public class FindByBnameController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/findByBname")
	@ResponseBody
	public NoteResult execute(String bname){
		NoteResult result = bookService.findByBname(bname);
		return result;
	}
}
