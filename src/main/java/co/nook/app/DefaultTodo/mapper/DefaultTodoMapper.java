package co.nook.app.DefaultTodo.mapper;

import co.nook.app.DefaultTodo.service.DefaultTodoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@MapperScan("defaultTodoMapper")
public interface DefaultTodoMapper extends DefaultTodoService{
}
