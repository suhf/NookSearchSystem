package co.nook.app.DefaultTodo.service;

import co.nook.app.DefaultTodo.vo.DefaultTodoVo;

import java.util.ArrayList;

public interface DefaultTodoService{
	public ArrayList<DefaultTodoVo> selectAll();
	public DefaultTodoVo select(int key);
	public int insert(DefaultTodoVo vo);
	public int update(DefaultTodoVo vo);
	public int delete(int key);
	public void truncate();

}
