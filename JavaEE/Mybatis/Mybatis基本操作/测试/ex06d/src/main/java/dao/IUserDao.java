package dao;

import java.util.List;

//import org.apache.ibatis.annotations.Select;

import javabean.User;

public interface IUserDao {
	public int add(User user);	
	
	//@Select("select * from user_b")
	public List<User> QueryAll();
}
