package co.nook.app.DefaultTodo.dao;

import co.nook.app.DefaultTodo.service.DefaultTodoMapper;
import co.nook.app.DefaultTodo.service.DefaultTodoService;
import co.nook.app.DefaultTodo.vo.DefaultTodoVo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("defaultTodoDao")
public class DefaultTodoDao implements DefaultTodoService{

	JdbcTemplate jdbcTemplate;

	public DefaultTodoDao( JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}

	private final String SELECT_ALL = "SELECT * from defaultTodo";
	@Override
	public ArrayList<DefaultTodoVo> selectAll(){
		return (ArrayList<DefaultTodoVo>)jdbcTemplate.query(SELECT_ALL , new DefaultTodoMapper());
	}

	@Override
	public DefaultTodoVo select(int key){
		return null;
	}

	private final String INSERT = "INSERT INTO defaultTodo " +
			"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	@Override
	public int insert(DefaultTodoVo vo){
		return jdbcTemplate.update(INSERT,
				vo.getdTodoNo(),
				vo.getdIsAlways(),
				vo.getdContent(),
				vo.getdDay(),
				vo.getdMinCount(),
				vo.getdMaxCount(),
				vo.getdNpcName(),
				vo.getdIsEvent(),
				vo.getdEventStartDate(),
				vo.getdEventStartHour(),
				vo.getdEventEndDate(),
				vo.getdEventEndHour(),
				vo.getdSpecialFunction(),
				vo.getdSpecialData1(),
				vo.getdSpecialData2(),
				vo.getdSpecialData3(),
				vo.getdSpecialData4()
		);
	}

	@Override
	public int update(DefaultTodoVo vo){
		return 0;
	}

	@Override
	public int delete(int key){
		return 0;
	}

	private final String TRUNCATE = "TRUNCATE TABLE defaultTodo";
	@Override
	public void truncate(){
		jdbcTemplate.update(TRUNCATE);
	}
}
