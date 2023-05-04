package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import entity.Seller;


public class SellerDao {
    public List<Seller> readSeller(){
        List<Seller> list=new ArrayList<Seller>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select * from seller";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String name=rs.getString("name");
                String password=rs.getString("password");
                Seller sl=new Seller(name, password);
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
    
    public boolean searchSeller(String name,String password)throws Exception{
		boolean flag = false;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
			String sql = "select * from seller where name = '"+name+"' and password='"+password+"'";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

    public boolean searchSellerName(String name)throws Exception{
		boolean flag = false;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
			String sql = "select * from seller where name = '"+name+"'";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
