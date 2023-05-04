import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
@WebServlet(name = "CartServlet" ,urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        List<Map<Object, Object>> list = new ArrayList<>();
        try{
            Connection conn = DBUtil.connectDB();
	        String sql = "select * from Goods ";
            Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql.toString());
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
            while(rs.next()){
                Map<Object, Object> map = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    map.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(map);
            }
        }catch (Exception e) {
			e.printStackTrace();
		}
    
        req.setAttribute("list",list);
        req.getRequestDispatcher("cart.jsp").forward(req,resp);
    }
}