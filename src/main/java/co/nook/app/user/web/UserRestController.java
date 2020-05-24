package co.nook.app.user.web;

import co.nook.app.common.SHAEncrypt;
import co.nook.app.user.service.UserService;
import co.nook.app.user.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;

@RestController
public class UserRestController{


	UserService userService;

	@Autowired
	public UserRestController(UserService userService){
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping( value = "/userCheck.do", method= RequestMethod.POST)
	public HashMap<String, Object> userCheck(@RequestBody UserVO userVo, Model model ){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		System.out.println(userVo.getId());

		UserVO vo = null;
		try{
			vo = userService.select(userVo);
			responseMap.put("result", "false");
		}catch(Exception e){
			responseMap.put("result", "true");
		}

		return responseMap;
	}

	@ResponseBody
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	public HashMap<String, Object> loginCheck(@RequestBody UserVO userVo, HttpServletRequest request, Model model){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		UserVO vo = null;
		try{
			vo = userService.select(userVo);
		}catch(Exception e){
			e.printStackTrace();
			responseMap.put("result", "false");
			return responseMap;
		}

		String encPw = SHAEncrypt.getEncrypt(userVo.getPassword(), vo.getSalt());
		if( vo.getPassword().equals(encPw)){
			responseMap.put("result", "true");
			request.getSession().setAttribute("userNo", vo.getUserNo());
			return responseMap;
		}


		responseMap.put("result", "false");

		return responseMap;
	}
}
