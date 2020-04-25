package co.nook.app.user.dao;

import co.nook.app.common.Dao;
import co.nook.app.user.service.UserService;
import co.nook.app.user.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository("userDao")
public class UserDao implements UserService{
	PreparedStatement psmt;
	ResultSet rs;

	@Override
	public ArrayList<UserVo> allSelect(Connection conn){
		return null;
	}

	final String SELECT_BY_ID = "select * from user where id = ?";
	@Override
	public UserVo select(Connection conn, String id){

		UserVo vo = null;
		try{
			conn = Dao.getConnection();
			psmt = conn.prepareStatement(SELECT_BY_ID);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if(rs.next()){
				vo = new UserVo();
				vo.setUserNo(rs.getInt("userno"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setSalt(rs.getString("salt"));
			}

		}catch(SQLException e){
			e.printStackTrace();
		}

		return vo;
	}

	@Override
	public UserVo select(Connection conn, int userNo){
		return null;
	}


	final String INSERT = "INSERT INTO user (userno, id, password, salt) VALUES ( NEXTVAL(seq_user), ?, ?, ?)";
	@Override
	public int insert(Connection conn, UserVo vo){
		int result = 0;
		try{
			psmt = conn.prepareStatement(INSERT);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getSalt());
			result = psmt.executeUpdate();
		}catch(SQLException throwables){
			throwables.printStackTrace();
		}

		return result;
	}

	@Override
	public int update(Connection conn, UserVo vo){
		return 0;
	}

	@Override
	public int delete(Connection conn, UserVo vo){
		return 0;
	}
}
