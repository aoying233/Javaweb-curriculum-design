package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import entity.Sale;

public class SaleDao {
    public static void addSale(String name,String good,String price,String number){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
			Statement stmt=con.createStatement();
			String sql="INSERT INTO sale VALUES ('"+name+"','"+good+"','"+price+"','"+number+"')";
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    public List<Sale> readSale(){
        List<Sale> list=new ArrayList<Sale>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select * from sale";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String name=rs.getString("name");
                String good=rs.getString("good");
                String price=rs.getString("price");
                String number=rs.getString("number");
                Sale sl=new Sale(name, good,price,number);
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

    public static List<String> recommend(){
        List<String> list=new ArrayList<String>();
        Connection con=null;
        PreparedStatement psmt=null;
        ResultSet rs=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S" );
            String sql="select DISTINCT good from sale LIMIT 3";
            psmt=con.prepareStatement(sql);
            rs=psmt.executeQuery();

            while(rs.next()){
                String good=rs.getString("good");
                list.add(good);
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
