package Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import entity.Goods;


public class CartDao {
    public List<Goods> readCart(String name){
        List<Goods> list=new ArrayList<Goods>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select * from orders WHERE name = '"+name+"'";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String good=rs.getString("good");
                String number=rs.getString("number");
                Goods sl=new Goods(good, number);
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
    
    public boolean searchOrders(String name,String good)throws Exception{
		boolean flag = false;
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
		try {
            Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql = "select * from orders where name = '"+name+"' and good='"+good+"'";
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
