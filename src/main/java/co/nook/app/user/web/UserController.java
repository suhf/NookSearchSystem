package co.nook.app.user.web;

import co.nook.app.HomeController;
import co.nook.app.common.Dao;
import co.nook.app.common.SHAEncrypt;
import co.nook.app.user.service.UserService;
import co.nook.app.user.vo.UserVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.HashMap;

@Controller
public class UserController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}


	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinProcess(@RequestParam String id, @RequestParam String pw, Model model){
		Connection conn = Dao.getConnection();
		UserVo vo = new UserVo();

		String salt = SHAEncrypt.generateSalt();
		String encPw= SHAEncrypt.getEncrypt(pw, salt);

		vo.setId(id);
		vo.setPassword(encPw);
		vo.setSalt(salt);

		int result = userService.insert(conn, vo );
		Dao.close(conn);
		String view = "login/login_form";
		if(result == 0){
			view = "join/join";
		}

		return view;
	}

	@RequestMapping(value = "/join_page.do")
	public String toJoinPage(Model model){
		return "join/join";
	}

	@RequestMapping("/todo_page.do")
	public String toTodoPage(Model model){
		return "todo/todo_form";
	}

}
