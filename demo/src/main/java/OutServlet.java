import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.InfoDao;
import utils.IPUtils;

@WebServlet(name = "OutServlet",urlPatterns ={ "/OutServlet" })
public class OutServlet extends HttpServlet {
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//false代表：不创建session对象，只是从request中获取。
		HttpSession session = request.getSession(false);
		if(session==null){
			return;
		}
		session.removeAttribute("name");
		response.sendRedirect("login.jsp");
		String ip=IPUtils.getVisitorIP(request);
		DateFormat df=new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
		Date date=new Date();
		String time=df.format(date);
		InfoDao.addInfo(ip, time, "注销");
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}