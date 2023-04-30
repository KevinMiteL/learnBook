package db;
import java.sql.*;
public class JdbcUtil {
	//设计获得连接对象的方法getConnection()
	public static Connection getConnection() throws Exception{
		String driver = "com.mysql.cj.jdbc.Driver";    //驱动程序名
		String user = "root";                          //数据库用户名
		String password = "root";                      //数据库用户密码
		String dbName = "java_web_ch06_db";            //数据库名
		String url1="jdbc:mysql://localhost:3306/"+dbName;
		String url2 ="?user="+user+"&password="+password;
		String url3="&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
		String url =url1+url2+url3;          //形成带数据库读写编码的数据库连接字
		Class.forName(driver);             //加载并注册驱动程序【比如给手机充电，要选择相应的充电线，苹果手机用苹果的充电线，华为手机要用华为的充电线！不要选错！】
		Connection conn=DriverManager.getConnection(url); //创建连接对象
		return conn;
	}
	//设计释放结果集、执行语句和连接对象的方法free()
	public static void free(ResultSet rs, Statement st, Connection conn) throws Exception {
		 if (rs != null){ rs.close();}
		 if (st != null) {st.close();}
		 if (conn != null){ conn.close();}
		}
}