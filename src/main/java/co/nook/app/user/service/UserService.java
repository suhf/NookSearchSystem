package co.nook.app.user.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface UserService{
	List<UserVO> allSelect();
	UserVO select(UserVO vo);
	void insert( UserVO vo );
	void update( UserVO vo );
	void delete( UserVO vo );
}
