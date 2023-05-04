import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import Dao.CartDao;
import Dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "OrdersAddServlet", urlPatterns = { "/OrdersAddServlet" })
public class OrdersAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("name");
		String good = request.getParameter("good");
		String number = request.getParameter("number");
		CartDao dao = new CartDao();
        GoodsDao gdao = new GoodsDao();
		try {
            if (gdao.searchGoodsName(good)){
                if (!dao.searchOrders(name,good)) {
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
				    Statement stmt=con.createStatement();
				    String sql="INSERT INTO orders VALUES ('"+name+"','"+good+"','"+number+"')";
				    stmt.executeUpdate(sql);
				    response.sendRedirect("/demo/cart.jsp");
			    } 
			    else{
                    Class.forName("com.mysql.jdbc.Driver");
				    Connection con=DriverManager.getConnection("jdbc:mysql://localhost/db_info","root" ,"Bvfe2sI1Mf)S");
				    Statement stmt=con.createStatement();
				    String sql="UPDATE orders SET number = '"+number+"' WHERE name = '"+name+"' AND good = '"+good+"'";
				    stmt.executeUpdate(sql);
				    response.sendRedirect("/demo/cart.jsp");
                }
            }
            else {
				request.setAttribute( "flag_cart","false");
				request.getRequestDispatcher("/cart.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

