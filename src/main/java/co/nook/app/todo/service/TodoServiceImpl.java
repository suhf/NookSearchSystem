package co.nook.app.todo.service;

import co.nook.app.todo.dao.TodoDao;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

@Service("todoService")
public class TodoServiceImpl implements TodoService{
	TodoDao todoDao;

	@Autowired
	public TodoServiceImpl(TodoDao todoDao){
		this.todoDao = todoDao;
	}

	@Override
	public ArrayList<TodoVo> selectAll( int userNo){
		return todoDao.selectAll( userNo);
	}

	@Override
	public TodoVo selectLast() throws SQLException{
		return todoDao.selectLast();
	}

	@Override
	public int insert( TodoVo vo) {
		return todoDao.insert( vo);
	}

	@Override
	public int update(TodoVo vo){
		return todoDao.update( vo);
	}

	@Override
	public int delete( TodoVo vo){
		return todoDao.delete( vo);
	}
}
