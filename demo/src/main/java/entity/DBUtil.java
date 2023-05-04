package entity;

import java.sql.Connection;
import java.sql.DriverManager;
 //连接数据库
public class DBUtil {
 
	
	public static Connection connectDB() throws Exception {
		//1、加载数据库驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//2、获取数据库连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
		
		return conn;
	}
	
}