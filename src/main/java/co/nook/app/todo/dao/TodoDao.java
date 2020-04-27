package co.nook.app.todo.dao;

import co.nook.app.todo.service.TodoMapper;
import co.nook.app.todo.service.TodoService;
import co.nook.app.todo.vo.TodoVo;
import co.nook.app.user.service.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository("todoDao")
public class TodoDao implements TodoService{

	JdbcTemplate jdbcTemplate;

	@Autowired
	public TodoDao(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}


	final String SELECT_ALL = "SELECT * FROM userTodo where userno = ?";
	@Override
	public ArrayList<TodoVo> selectAll(int userNo){
		return (ArrayList<TodoVo>)jdbcTemplate.query(SELECT_ALL, new TodoMapper(), userNo);
	}
	final String SELECT_LAST = "SELECT * FROM userTodo where uNo = LASTVAL(seq_user_todo)";
	@Override
	public TodoVo selectLast() throws SQLException{
		try {
			return jdbcTemplate.queryForObject(SELECT_LAST, new TodoMapper() );
		} catch (EmptyResultDataAccessException e) {
			// EmptyResultDataAccessException 예외 발생시 null 리턴
			return null;
		}
	}

	final String INSERT = "INSERT INTO userTodo (uNo, userno, uContent, uCheck, uSub1, uSub2) " +
			"values (NEXTVAL(seq_user_todo), ?, ?, ?, 0, ?)";
	@Override
	public int insert(TodoVo vo){
		int n = jdbcTemplate.update(INSERT,
				vo.getUserno(),
				vo.getuContent(),
				vo.getuCheck(),
				vo.getuSub2()
		);

		return n;
	}

	final String UPDATE = "UPDATE userTodo SET uContent = ?, uCheck = ?, uSub1 = ?, uSub2 = ? WHERE uNo = ?";
	@Override
	public int update( TodoVo vo){
		System.out.println("변경 Userno : "+vo.getuNo());
		System.out.println("변경 Contetn : " +vo.getuContent());
		int n = jdbcTemplate.update(UPDATE,
				vo.getuContent(),
				vo.getuCheck(),
				vo.getuSub1(),
				vo.getuSub2(),
				vo.getuNo()
		);


		System.out.println("변경 : " +n);
		return n;
	}

	@Override
	public int delete( TodoVo vo){
		return 0;
	}
}
