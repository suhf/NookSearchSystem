package co.nook.app.todo.service;

import co.nook.app.todo.vo.TodoVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoMapper implements RowMapper<TodoVo>{
	@Override
	public TodoVo mapRow(ResultSet rs, int rowNum) throws SQLException{
		TodoVo vo = new TodoVo();
		vo.setuNo(rs.getInt("uNo"));
		vo.setUserno(rs.getInt("userno"));
		vo.setuContent(rs.getString("uContent"));
		vo.setuCheck(rs.getString("uCheck"));
		vo.setuSub1(rs.getString("uSub1"));
		vo.setuSub2(rs.getString("uSub2"));

		return vo;
	}
}
