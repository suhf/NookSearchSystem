package co.nook.app.DefaultTodo.serviceImpl;

import co.nook.app.DefaultTodo.mapper.DefaultTodoMapper;
import co.nook.app.DefaultTodo.service.DefaultTodoService;
import co.nook.app.DefaultTodo.service.DefaultTodoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("defaultTodoService")
public class DefaultTodoServiceImpl implements DefaultTodoService{

	public DefaultTodoMapper mapper;

	@Autowired
	public DefaultTodoServiceImpl(DefaultTodoMapper defaultTodoMapper){
		this.mapper = mapper;
	}


	@Override
	public List<DefaultTodoVO> selectAll(){
		return mapper.selectAll();
	}

	@Override
	public DefaultTodoVO select(DefaultTodoVO vo){
		return mapper.select(vo);
	}

	@Override
	public void insert(DefaultTodoVO vo){
		 mapper.insert(vo);
	}

	@Override
	public void update(DefaultTodoVO vo){
		 mapper.update(vo);
	}

	@Override
	public void delete(DefaultTodoVO vo){
		 mapper.delete(vo );
	}

	@Override
	public void truncate(){
		mapper.truncate();
	}
}
