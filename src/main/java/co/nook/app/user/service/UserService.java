package co.nook.app.user.service;
import co.nook.app.user.vo.UserVo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface UserService{
	public ArrayList<UserVo> allSelect() throws SQLException;
	public UserVo select(String id) throws SQLException;
	public UserVo select( int userNo) throws SQLException;
	public int insert( UserVo vo ) throws SQLException;
	public int update( UserVo vo ) throws SQLException;
	public int delete( UserVo vo ) throws SQLException;
}
