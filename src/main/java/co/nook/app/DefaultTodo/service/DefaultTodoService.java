package co.nook.app.DefaultTodo.service;

import java.util.List;

public interface DefaultTodoService{
	public List<DefaultTodoVO> selectAll();
	public DefaultTodoVO select(DefaultTodoVO vo);
	public void insert(DefaultTodoVO vo);
	public void update(DefaultTodoVO vo);
	public void delete(DefaultTodoVO vo);
	public void truncate();

}
