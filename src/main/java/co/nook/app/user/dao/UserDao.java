package co.nook.app.user.dao;

import co.nook.app.user.service.UserMapper;
import co.nook.app.user.service.UserService;
import co.nook.app.user.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository("userDao")
public class UserDao implements UserService{

	JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDao (JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ArrayList<UserVo> allSelect(){
		return null;
	}

	final String SELECT_BY_ID = "select * from user where id = ?";
	@Override
	public UserVo select( String id ){
		try {
			return jdbcTemplate.queryForObject(SELECT_BY_ID, new UserMapper(), id );
		} catch (EmptyResultDataAccessException e) {
			// EmptyResultDataAccessException 예외 발생시 null 리턴
			return null;
		}

	}

	@Override
	public UserVo select( int userNo){
		return null;
	}


	final String INSERT = "INSERT INTO user (userno, id, password, salt) VALUES ( NEXTVAL(seq_user), ?, ?, ?)";
	@Override
	public int insert( UserVo vo){
		int n =jdbcTemplate.update(INSERT,
				vo.getId(),
				vo.getPassword(),
				vo.getSalt()
		);
		return n;
	}

	@Override
	public int update( UserVo vo){
		return 0;
	}

	@Override
	public int delete( UserVo vo){
		return 0;
	}
}
