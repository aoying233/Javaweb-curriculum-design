package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Info;

public class InfoDao {
    public static void addInfo(String ip,String time,String op){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
			Statement stmt=con.createStatement();
			String sql="INSERT INTO info VALUES ('"+ip+"','"+time+"','"+op+"')";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    public List<Info> readInfo(){
        List<Info> list=new ArrayList<Info>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select * from info";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String ip=rs.getString("ip");
                String time=rs.getString("time");
                String op=rs.getString("operation");
                Info sl=new Info(ip, time,op);
                list.add(sl);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rs!=null){
                    rs.close();
                }
                if(psmt!=null){
                    psmt.close();
                }
                if(con!=null){
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
}
