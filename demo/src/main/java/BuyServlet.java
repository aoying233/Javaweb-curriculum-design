import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

import Dao.GoodsDao;
import Dao.InfoDao;
import Dao.SaleDao;
import utils.IPUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BuyServlet", urlPatterns = { "/BuyServlet" })
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("name");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
			Statement stmt=con.createStatement();

			String sql="select * from orders WHERE name = '"+name+"'";
            PreparedStatement psmt=con.prepareStatement(sql);
            ResultSet rs=psmt.executeQuery();

            while(rs.next()){
                String good=rs.getString("good");
				String number=rs.getString("number");
				String price=GoodsDao.getPrice(good);
                SaleDao.addSale(name,good ,price ,number );
            }

			sql="DELETE FROM orders WHERE name = '"+name+"'";
			stmt.executeUpdate(sql);
			response.sendRedirect("/demo/finish.jsp");
			String ip=IPUtils.getVisitorIP(request);
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
			Date date=new Date();
			String time=df.format(date);
			InfoDao.addInfo(ip, time, "购买");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

