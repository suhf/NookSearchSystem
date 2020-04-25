package co.nook.app.todo.web;

import co.nook.app.common.Dao;
import co.nook.app.todo.dao.TodoDao;
import co.nook.app.todo.service.TodoService;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public HashMap<String, Object> getTodoData(Model model){
		HashMap<String, Object> map = new HashMap<String, Object>();
		Connection conn = Dao.getConnection();
		ArrayList<TodoVo> list = todoService.selectAll(conn);
		Dao.close(conn);

		map.put("list", list);

		return map;
	}
}
