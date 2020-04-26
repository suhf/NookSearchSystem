package co.nook.app.todo.web;

import co.nook.app.common.Dao;
import co.nook.app.todo.dao.TodoDao;
import co.nook.app.todo.service.TodoService;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class TodoController{


	TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService){
		this.todoService = todoService;
	}


	@ResponseBody
	@RequestMapping(value = "/getTodoData.do")
	public HashMap<String, Object> getTodoData(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();

		Connection conn = Dao.getConnection();
		int userNo = (int)session.getAttribute("userNo");
		ArrayList<TodoVo> list = todoService.selectAll(conn, userNo);
		HashMap<Integer, Integer> boardMap = new HashMap<Integer, Integer>();
		int index = 1;
		for(TodoVo vo : list){
			boardMap.put(index, vo.getuNo());
			vo.setuNo(index);
			++index;
		}

		session.setAttribute("todoMap", boardMap);

		Dao.close(conn);

		map.put("list", list);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/todoUpdate.do")
	public HashMap<String, Object> todoUpdate(HttpServletRequest request,
											  @RequestBody HashMap<String, Object> map,
											  Model model){
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		HttpSession session =request.getSession();
		HashMap<Integer, Integer> boardMap = (HashMap<Integer, Integer>)session.getAttribute("todoMap");
		int todoNo = Integer.parseInt((String)map.get("todoNo"));
		String content = (String)map.get("content");
		String check = (String)map.get("check");
		Object o1 = map.get("sub1");
		Object o2 = map.get("sub2");
		String sub1 = null;
		String sub2 = null;
		if( o1 != null){
			sub1= o1.toString();
		}
		if( o2 != null){
			sub2= o2.toString();
		}

		Connection conn = Dao.getConnection();
		if(!(check.equals("true") || check.equals("false")))
		{
			returnMap.put("result", 0);
		}else{
			TodoVo vo = new TodoVo();
			vo.setuNo(boardMap.get(todoNo));
			vo.setuCheck(check);
			vo.setuContent(content);
			vo.setuSub1(sub1);
			vo.setuSub2(sub2);

			int result = todoService.update(conn, vo);
			returnMap.put("result", result);
		}
		Dao.close(conn);
		return returnMap;
	}
}
