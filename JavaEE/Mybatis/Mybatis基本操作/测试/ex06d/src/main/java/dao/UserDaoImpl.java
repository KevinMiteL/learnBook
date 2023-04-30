package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import biz.StudentMapper;
import db.JdbcUtil;
import db.MybatisUtil;
import javabean.User;

public class UserDaoImpl implements IUserDao {
    // 向数据库中添加用户记录的方法add(User user)，将对象user插入数据表中
    public int add(User user)  {
		Connection conn = null;
		PreparedStatement ps = null;
		
		int userNum = 0;
		
		if(user.getUserName().equals("") || user.getUserPwd().equals("")) //用户名或密码为空
			return userNum;
		
		try {
			conn = JdbcUtil.getConnection();
			String sql = "insert into user_b(username,userpassword)  values (?,?) ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			userNum = ps.executeUpdate();
			JdbcUtil.free(null, ps, conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("add 时出错，添加用户失败！");
		}
		return userNum;
    	
    }
    
    //查询全部用户的方法QueryAll()
    public List<User> QueryAll(){
//		Connection conn = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		List<User> userList = new ArrayList<User>();
//		try {
//			conn = JdbcUtil.getConnection();
//			String sql = "select * from user_b";
//			ps = conn.prepareStatement(sql);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//	            String xm= rs.getString("username");
//	            String mm= rs.getString("userpassword");
//				User user = new User(xm,mm);
//				userList.add(user);
//			}
//			JdbcUtil.free(rs, ps, conn);
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("QueryAll 时出错，添加用户失败！");
//		}
//
//		return userList;
    	
 
    	//使用mybatis的方式
    	SqlSession session=MybatisUtil.getFactory().openSession();
    	List<User> users=session.selectList("seclectStudent");
    	session.close(); 
    	
    	return users;
    }
}