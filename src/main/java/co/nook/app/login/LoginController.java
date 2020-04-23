package co.nook.app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController{


	ModelAndView mav;

	public LoginController(@Autowired ModelAndView mav){
		this.mav = mav;
	}

	@RequestMapping("/loginCheck.do")
	public ModelAndView loginCheck(@RequestParam String id, @RequestParam String pw, HttpServletRequest request, Model model){

		mav.setViewName("todo/todo_form");
		request.getSession().setAttribute("id", id);



		return mav;
	}
}
