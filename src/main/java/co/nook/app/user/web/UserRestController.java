package co.nook.app.user.web;

import co.nook.app.common.Dao;
import co.nook.app.common.SHAEncrypt;
import co.nook.app.user.service.UserService;
import co.nook.app.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
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
	public HashMap<String, Object> userCheck(@RequestBody HashMap<String, Object> map, Model model ){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		Connection conn = Dao.getConnection();
		String id = (String)map.get("id");

		UserVo vo = userService.select(conn, id);
		Dao.close(conn);
		if( vo == null ){
			responseMap.put("result", "false");
		}else{
			responseMap.put("result", "true");
		}

		return responseMap;
	}

	@ResponseBody
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.POST)
	public HashMap<String, Object> loginCheck(@RequestBody HashMap<String, Object> map, HttpServletRequest request, Model model){
		HashMap<String, Object> responseMap = new HashMap<String, Object>();
		String id = (String)map.get("id");
		String pw = (String)map.get("pw");
		Connection conn = Dao.getConnection();
		UserVo vo = userService.select(conn, id);
		Dao.close(conn);
		if(vo == null){
			responseMap.put("result", "false");
			return responseMap;
		}

		String encPw = SHAEncrypt.getEncrypt(pw, vo.getSalt());

		if( vo.getPassword().equals(encPw)){
			responseMap.put("result", "true");
			request.getSession().setAttribute("userNo", vo.getUserNo());
			return responseMap;
		}

		responseMap.put("result", "false");
		return responseMap;
	}
}
