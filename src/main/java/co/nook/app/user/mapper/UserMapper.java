package co.nook.app.user.mapper;

import co.nook.app.user.service.UserService;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan("userMapper")
public interface UserMapper extends UserService{
}
