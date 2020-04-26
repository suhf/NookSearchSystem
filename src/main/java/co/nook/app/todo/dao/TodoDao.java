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


	final String SELECT_ALL = "SELECT * FROM userTodo where userno = ?";
	@Override
	public ArrayList<TodoVo> selectAll(Connection conn, int userNo){
		ArrayList<TodoVo> list = new ArrayList<TodoVo>();
		try{
			psmt = conn.prepareStatement(SELECT_ALL);
			psmt.setInt(1, userNo);
			rs = psmt.executeQuery();


			while(rs.next()){
				TodoVo vo = new TodoVo();
				vo.setuNo(rs.getInt("uNo"));
				vo.setuContent(rs.getString("uContent"));
				vo.setuCheck(rs.getString("uCheck"));
				vo.setuSub1(rs.getString("uSub1"));
				vo.setuSub2(rs.getString("uSub2"));
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

	final String UPDATE = "UPDATE userTodo SET uContent = ?, uCheck = ?, uSub1 = ?, uSub2 = ? WHERE uNo = ?";
	@Override
	public int update(Connection conn, TodoVo vo){
		int result = 0;
		try{
			psmt = conn.prepareStatement(UPDATE);
			psmt.setString(1, vo.getuContent());
			psmt.setString(2, vo.getuCheck());
			psmt.setString(3, vo.getuSub1());
			psmt.setString(4, vo.getuSub2());
			psmt.setInt(5, vo.getuNo());


			result = psmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}


		return result;
	}

	@Override
	public int delete(Connection conn, TodoVo vo){
		return 0;
	}
}
