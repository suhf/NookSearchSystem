package co.nook.app.user.service;

import co.nook.app.user.dao.UserDao;
import co.nook.app.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.util.ArrayList;

@Service("userService")
public class UserServiceImpl implements UserService{

	UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao){
		this.userDao = userDao;
	}


	@Override
	public ArrayList<UserVo> allSelect(Connection conn){
		return userDao.allSelect(conn);
	}

	@Override
	public UserVo select(Connection conn, String id){
		return userDao.select(conn, id);
	}

	@Override
	public UserVo select(Connection conn, int userNo){
		return userDao.select(conn, userNo);
	}

	@Override
	public int insert(Connection conn, UserVo vo){
		return userDao.insert(conn, vo);
	}

	@Override
	public int update(Connection conn, UserVo vo){
		return userDao.update(conn, vo);
	}

	@Override
	public int delete(Connection conn, UserVo vo){
		return userDao.delete(conn, vo);
	}
}
