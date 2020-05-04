package co.nook.app.DefaultTodo.service;

import co.nook.app.DefaultTodo.vo.DefaultTodoVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultTodoMapper implements RowMapper<DefaultTodoVo>{
	@Override
	public DefaultTodoVo mapRow(ResultSet rs, int rowNum) throws SQLException{
		DefaultTodoVo vo = new DefaultTodoVo();

		vo.setdTodoNo(rs.getInt("dTodoNo"));
		vo.setdIsAlways(rs.getString("dIsAlways"));
		vo.setdContent(rs.getString("dContent"));
		vo.setdDay(rs.getString("dDay"));
		vo.setdMinCount(rs.getInt("dMinCount"));
		vo.setdMaxCount(rs.getInt("dMaxCount"));
		vo.setdNpcName(rs.getString("dNpcName"));
		vo.setdIsEvent(rs.getString("dIsEvent"));
		vo.setdEventStartDate(rs.getString("dEventStartDate"));
		vo.setdEventStartHour(rs.getInt("dEventStartHour"));
		vo.setdEventEndDate(rs.getString("dEventEndDate"));
		vo.setdEventEndHour(rs.getInt("dEventEndHour"));
		vo.setdSpecialFunction(rs.getString("dSpecialFunction"));
		vo.setdSpecialData1(rs.getString("dSpecialData1"));
		vo.setdSpecialData2(rs.getString("dSpecialData2"));
		vo.setdSpecialData3(rs.getString("dSpecialData3"));
		vo.setdSpecialData4(rs.getString("dSpecialData4"));

		return vo;
	}
}
