package co.nook.app.DefaultTodo.service;

import co.nook.app.DefaultTodo.dao.DefaultTodoDao;
import co.nook.app.DefaultTodo.vo.DefaultTodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("defaultTodoService")
public class DefaultTodoServiceImpl implements DefaultTodoService{

	public DefaultTodoDao defaultTodoDao;

	@Autowired
	public DefaultTodoServiceImpl(DefaultTodoDao defaultTodoDao){
		this.defaultTodoDao = defaultTodoDao;
	}


	@Override
	public ArrayList<DefaultTodoVo> selectAll(){
		return defaultTodoDao.selectAll();
	}

	@Override
	public DefaultTodoVo select(int key){
		return defaultTodoDao.select(key);
	}

	@Override
	public int insert(DefaultTodoVo vo){
		return defaultTodoDao.insert(vo);
	}

	@Override
	public int update(DefaultTodoVo vo){
		return defaultTodoDao.update(vo);
	}

	@Override
	public int delete(int key){
		return defaultTodoDao.delete(key);
	}

	@Override
	public void truncate(){
		defaultTodoDao.truncate();
	}
}
