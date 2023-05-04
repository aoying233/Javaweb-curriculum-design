import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import com.mysql.cj.jdbc.Driver;

import Dao.GoodsDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GoodsAddServlet", urlPatterns = { "/GoodsAddServlet" })
public class GoodsAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		GoodsDao dao = new GoodsDao();
		try {
			if (!dao.searchGoodsName(name)) {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
				Statement stmt=con.createStatement();
				String sql="INSERT INTO goods VALUES ('"+name+"','"+price+"')";
				stmt.executeUpdate(sql);
				response.sendRedirect("/demo/goods.jsp");
			} 
			else {
				request.setAttribute( "flag_goods","false");
				request.getRequestDispatcher("/goods.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

