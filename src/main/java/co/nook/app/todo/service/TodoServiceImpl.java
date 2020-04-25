package co.nook.app.todo.service;

import co.nook.app.todo.dao.TodoDao;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;

@Service("todoService")
public class TodoServiceImpl implements TodoService{
	TodoDao todoDao;

	@Autowired
	public TodoServiceImpl(TodoDao todoDao){
		this.todoDao = todoDao;
	}

	@Override
	public ArrayList<TodoVo> selectAll(Connection conn){
		return todoDao.selectAll(conn);
	}

	@Override
	public int insert(Connection conn, TodoVo vo){
		return todoDao.insert(conn, vo);
	}

	@Override
	public int update(Connection conn, TodoVo vo){
		return todoDao.update(conn, vo);
	}

	@Override
	public int delete(Connection conn, TodoVo vo){
		return todoDao.delete(conn, vo);
	}
}
