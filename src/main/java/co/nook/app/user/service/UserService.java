package co.nook.app.user.service;
import co.nook.app.user.vo.UserVo;

import java.sql.Connection;
import java.util.ArrayList;

public interface UserService{
	public ArrayList<UserVo> allSelect(Connection conn);
	public UserVo select(Connection conn, String id);
	public UserVo select(Connection conn, int userNo);
	public int insert(Connection conn, UserVo vo);
	public int update(Connection conn, UserVo vo);
	public int delete(Connection conn, UserVo vo);
}
