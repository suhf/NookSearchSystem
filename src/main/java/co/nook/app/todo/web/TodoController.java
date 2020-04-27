package co.nook.app.todo.web;

import co.nook.app.todo.service.TodoService;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class TodoController{


	TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService){
		this.todoService = todoService;
	}


	@ResponseBody
	@RequestMapping(value = "/getTodoData.do")
	public HashMap<String, Object> getTodoData(HttpServletRequest request, Model model) throws SQLException{
		HttpSession session = request.getSession();
		HashMap<String, Object> map = new HashMap<String, Object>();

		int userNo = (int)session.getAttribute("userNo");
		ArrayList<TodoVo> list = todoService.selectAll( userNo);
		HashMap<Integer, Integer> boardMap = new HashMap<Integer, Integer>();
		int index = 1;
		for(TodoVo vo : list){
			boardMap.put(index, vo.getuNo());
			vo.setuNo(index);
			++index;
		}

		session.setAttribute("todoMap", boardMap);


		map.put("list", list);

		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/todoUpdate.do")
	public HashMap<String, Object> todoUpdate(HttpServletRequest request,
											  @RequestBody HashMap<String, Object> map,
											  Model model) throws SQLException{
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

			int result = todoService.update( vo);
			returnMap.put("result", result);
		}
		return returnMap;
	}

	@ResponseBody
	@RequestMapping("/insertTodo.do")
	public HashMap<String, Object> insertTodo( HttpServletRequest request, @RequestBody HashMap<String, Object> map) throws SQLException{
		HashMap<String, Object> returnMap = new HashMap<String, Object>();
		int userno = (int)request.getSession().getAttribute("userNo");
		HttpSession session = request.getSession();
		HashMap<Integer, Integer> boardMap = (HashMap<Integer, Integer>)session.getAttribute("todoMap");

		String content = (String)map.get("content");
		String sub2 = (String)map.get("sub2");
		String check = map.get("check").toString();
		String lno = (String)map.get("lineNo");
		System.out.println(lno);
		int lineNo = Integer.parseInt(lno);

		TodoVo vo =  new TodoVo();
		vo.setuContent(content);
		vo.setuSub2(sub2);
		vo.setuCheck(check);
		vo.setUserno(userno);

		int result = todoService.insert(vo);

		if( result != 0 ){
			vo = todoService.selectLast();
			boardMap.put(lineNo, vo.getuNo());
			returnMap.put("item", vo);
			returnMap.put("result", "true");
		}else{
			returnMap.put("result", "false");
		}



		return returnMap;

	}
}
