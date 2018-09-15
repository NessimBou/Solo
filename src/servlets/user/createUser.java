package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import services.User;

public class createUser extends HttpServlet {
	
	public createUser(){
		super();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException , IOException{
		
		String login = req.getParameter("login");
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String pwd = req.getParameter("pwd");
		JSONObject ret = new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");

			ret = User.createUser(login, pwd , nom, prenom);

		}catch(JSONException | ClassNotFoundException | SQLException  e){
			e.printStackTrace();
		
		}
		PrintWriter out = res.getWriter();
		res.setContentType("text/plain");
		out.print(ret.toString());
		
		
	}

}
