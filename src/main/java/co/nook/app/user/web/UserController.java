package co.nook.app.user.web;

import co.nook.app.HomeController;
import co.nook.app.common.SHAEncrypt;
import co.nook.app.user.service.UserService;
import co.nook.app.user.service.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public class UserController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	UserService userService;

	@Autowired
	public UserController(UserService userService){
		this.userService = userService;
	}

	@RequestMapping(value = "/join.do", method = RequestMethod.POST)
	public String joinProcess(UserVO userVo, Model model) throws SQLException{

		String salt = SHAEncrypt.generateSalt();
		String encPw= SHAEncrypt.getEncrypt(userVo.getPassword(), salt);

		userVo.setPassword(encPw);
		userVo.setSalt(salt);

		String view = "login/login_form";
		try{
			userService.insert( userVo );
		}catch(Exception e){
			e.printStackTrace();
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
		return "main/main";
	}

	@RequestMapping(value = "/login_page.do")
	public String toLoginPage(Model model){
		return "login/login_form";
	}

}
