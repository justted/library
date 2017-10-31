package ahpu.libra.web.controller.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ahpu.libra.entity.NoteResult;
import ahpu.libra.service.BookService;

@Controller
@RequestMapping("/book")
public class FindByBnumController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/findByBnum")
	@ResponseBody
	public NoteResult execute(String bnum){
		NoteResult result = bookService.findByBnum(bnum);
		return result;
	}
}
