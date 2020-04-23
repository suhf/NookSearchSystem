package co.nook.app.join;

import co.nook.app.member.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JoinController{

	MemberVO vo;
	@Autowired
	public JoinController( MemberVO vo){
		this.vo = vo;
	}


}
