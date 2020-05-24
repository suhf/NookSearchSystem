package co.nook.app.user.serviceImpl;

import co.nook.app.user.mapper.UserMapper;
import co.nook.app.user.service.UserService;
import co.nook.app.user.service.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{

	UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserMapper userMapper){
		this.userMapper = userMapper;
	}

	@Override
	public List<UserVO> allSelect() {
		return userMapper.allSelect();
	}

	@Override
	public UserVO select(UserVO vo){
		System.out.println("Select GO");
		return userMapper.select(vo);
	}

	@Override
	public void insert(UserVO vo){
		userMapper.insert(vo);
	}

	@Override
	public void update(UserVO vo){

	}

	@Override
	public void delete(UserVO vo){

	}
}
