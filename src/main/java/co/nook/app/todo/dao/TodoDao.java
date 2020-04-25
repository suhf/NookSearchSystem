package co.nook.app.todo.dao;

import co.nook.app.todo.service.TodoService;
import co.nook.app.todo.vo.TodoVo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository("todoDao")
public class TodoDao implements TodoService{

	PreparedStatement psmt;
	ResultSet rs;


	final String SELECT_ALL = "SELECT * FROM userTodo";
	@Override
	public ArrayList<TodoVo> selectAll(Connection conn){
		ArrayList<TodoVo> list = new ArrayList<TodoVo>();
		try{
			psmt = conn.prepareStatement(SELECT_ALL);
			rs = psmt.executeQuery();

			while(rs.next()){
				TodoVo vo = new TodoVo();
				vo.setuNo(rs.getInt("uNo"));
				vo.setUserno(rs.getInt("userno"));
				vo.setuContent(rs.getString("uContent"));
				vo.setuDay(rs.getString("uDay"));
				vo.setuNpc(rs.getString("uNpc"));
				vo.setuCheck(rs.getString("uCheck"));
				list.add(vo);
			}
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}

		return list;
	}

	@Override
	public int insert(Connection conn, TodoVo vo){
		return 0;
	}

	@Override
	public int update(Connection conn, TodoVo vo){
		return 0;
	}

	@Override
	public int delete(Connection conn, TodoVo vo){
		return 0;
	}
}
