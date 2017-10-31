package ahpu.libra.web.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ahpu.libra.service.AdminService;
import ahpu.libra.entity.NoteResult;
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
	private final AdminService adminService;

	@Autowired
	public AdminLoginController(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping("/login")
	@ResponseBody
	public NoteResult execute(HttpServletRequest request){
		//获取请求头身份信息
		String admin = request.getHeader("Authorization");
		return adminService.checkLogin(admin);
	}
}
