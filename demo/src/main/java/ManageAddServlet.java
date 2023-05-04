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

import Dao.SellerDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ManageAddServlet", urlPatterns = { "/ManageAddServlet" })
public class ManageAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		SellerDao dao = new SellerDao();
		try {
			if (!dao.searchSellerName(name)) {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
				Statement stmt=con.createStatement();
				String sql="INSERT INTO seller VALUES ('"+name+"','"+password+"')";
				stmt.executeUpdate(sql);
				response.sendRedirect("/demo/manage.jsp");
			} 
			else {
				request.setAttribute( "flag_manage","false");
				request.getRequestDispatcher("/manage.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

