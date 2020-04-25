package co.nook.app.todo.service;

import co.nook.app.todo.vo.TodoVo;

import java.sql.Connection;
import java.util.ArrayList;

public interface TodoService{
	public ArrayList<TodoVo> selectAll(Connection conn);
	public int insert(Connection conn, TodoVo vo);
	public int update(Connection conn, TodoVo vo);
	public int delete(Connection conn, TodoVo vo);
}
