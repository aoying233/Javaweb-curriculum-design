import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//注册验证
@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		
		UserDao dao = new UserDao();
		try {
			if(dao.addUser(user)) {
				RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
				dis.forward(request, response);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

