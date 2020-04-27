package co.nook.app.user.web;

import co.nook.app.common.SHAEncrypt;
import co.nook.app.user.service.UserService;
import co.nook.app.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
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
	public HashMap<String, Object> userCheck(@RequestBody UserVo userVo, Model model ) throws SQLException{
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		String id = userVo.getId();

		UserVo vo = userService.select(id);

		if( vo == null ){
			responseMap.put("result", "false");
		}else{
			responseMap.put("result", "true");
		}

		return responseMap;
	}

	@ResponseBody
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	public HashMap<String, Object> loginCheck(@RequestBody UserVo userVo, HttpServletRequest request, Model model) throws SQLException{
		HashMap<String, Object> responseMap = new HashMap<String, Object>();

		UserVo vo = userService.select(userVo.getId());
		if(vo == null){
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
