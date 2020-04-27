package co.nook.app.todo.service;

import co.nook.app.todo.vo.TodoVo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface TodoService{
	public ArrayList<TodoVo> selectAll( int userNo ) throws SQLException;
	public TodoVo selectLast() throws SQLException;
	public int insert( TodoVo vo ) throws SQLException;
	public int update( TodoVo vo ) throws SQLException;
	public int delete( TodoVo vo ) throws SQLException;
}
