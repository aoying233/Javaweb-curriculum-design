import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import Dao.InfoDao;
import Dao.SellerDao;
import utils.IPUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 //登录验证
@WebServlet(name = "SellerLoginServlet", urlPatterns = { "/SellerLoginServlet" })
public class SellerLoginServlet extends HttpServlet {
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
			if (dao.searchSeller(name,password)) {
				HttpSession session = request.getSession();
				session.setAttribute("name",name);
				RequestDispatcher dis = request.getRequestDispatcher("goods.jsp");
				dis.forward(request, response);
				String ip=IPUtils.getVisitorIP(request);
				DateFormat df=new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
				Date date=new Date();
				String time=df.format(date);
				InfoDao.addInfo(ip, time, "销售人员登录");
			} 
			else {
				request.setAttribute( "flag_login","false");
				request.getRequestDispatcher("/login.jsp").forward(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

