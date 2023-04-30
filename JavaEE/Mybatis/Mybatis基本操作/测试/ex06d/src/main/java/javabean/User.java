package javabean;
import java.util.List;
public class User {
    private String userName;
	private String userPwd;
	
    public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

    public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }
    public User() {}//无参构造方法
    //判定两个对象中的属性userName是否相同，当相同时，返回1
    public int pdUser(User u) {
        int f = 0;
        if (u.userName.equals(this.userName)) {
            f = 1;
        }
        return f;
    }
    //判定一个对象与一个集合对象中是否有相同的属性userName
    public int pdListUser(List<User> u) {
        int f = 0;
        for (int i = 0; i < u.size(); ++i) {
            User u2 = u.get(i);
            if (this.pdUser(u2) == 1) {
                f = 1;
                break;
            }
        }
        return f;
    }
    //以下省略了各属性的setter/getter方法
}