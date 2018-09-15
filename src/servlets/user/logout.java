package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.*;

import org.json.JSONException;
import org.json.JSONObject;

import services.User;


public class logout extends HttpServlet{
	public logout(){
		super();
	}
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String key = req.getParameter("key");
		JSONObject ret = new JSONObject();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			ret = User.logout(key);
		} catch (JSONException | ClassNotFoundException   e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = res.getWriter();
		res.setContentType("text/plain");
		out.print(ret.toString());
	
	}

}
