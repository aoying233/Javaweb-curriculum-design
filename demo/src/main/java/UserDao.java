import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

import entity.DBUtil;

import java.sql.SQLException;

//工具类
public class UserDao {
	public boolean queryByParams(List<Map<String, Object>> params) throws Exception {//查询
		Connection conn = DBUtil.connectDB();
		StringBuilder sql = new StringBuilder("SELECT * FROM tb_info WHERE 1=1");
		
		for(Map<String, Object> param : params) {
			sql.append(" and ");
			sql.append(" " +param.get("col")+ " ");
			sql.append(" " + param.get("rel") + " ");
			sql.append(" " +  "'"+param.get("value") + "'"+ " ");
		}
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql.toString());
		if(rs.next()) {
			return true;
		}
		else{
			return false;
		}
	}
	public boolean addUser(User user) throws Exception {//增加
		Connection conn = DBUtil.connectDB();
		String sql = "INSERT INTO tb_info(name,password)"
				+ " VALUES(?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassword());
		pstmt.execute();
		return true;
	}
	public boolean searchUser(String name,String password)throws Exception{
		boolean flag = false;
		try {
			Connection conn = DBUtil.connectDB();
			String sql = "select * from tb_info where name = '"+name+"' and password='"+password+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	
}

