package co.nook.app.user.service;

import co.nook.app.user.vo.UserVo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserVo>{
	@Override
	public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException{
		UserVo vo = new UserVo();
		vo.setId(rs.getString("id"));
		vo.setUserNo(rs.getInt("userno"));
		vo.setPassword(rs.getString("password"));
		vo.setSalt(rs.getString("salt"));

		return vo;
	}
}
