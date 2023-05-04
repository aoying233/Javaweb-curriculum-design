package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Goods;

import java.sql.SQLException;

public class GoodsDao {
	public List<Goods> readGoods(){
        List<Goods> list=new ArrayList<Goods>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select * from goods";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String name=rs.getString("name");
                String price=rs.getString("price");
                Goods sl=new Goods(name, price);
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
    
    public boolean searchGoods(String name,String price)throws Exception{
		boolean flag = false;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
			String sql = "select * from goods where name = '"+name+"' and price='"+price+"'";
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

	public boolean searchGoodsName(String name)throws Exception{
		boolean flag = false;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
			String sql = "select * from goods where name = '"+name+"'";
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

    public static String getPrice(String good)throws Exception{
		String price=null;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
			String sql = "select * from goods where name = '"+good+"'";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();
			if(rs.next()){
				price=rs.getString("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return price;
	}
}

