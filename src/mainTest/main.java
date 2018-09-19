package mainTest;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import com.mongodb.DBCollection;

import bd.BdUser;
import services.Planning;
import services.User;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, JSONException, UnknownHostException {

		String login = "coucou";
		//String password = "coucou";
//		String nom = "coucou" ;
//		String prenom = "coucou";
		String test = "salut";
		Connection sql= bd.Database.getMySQLConnection();
		//System.out.println(User.createUser(login, password, nom, prenom));
		//User.login(login,password);
		
		DBCollection mango = bd.Database.getCollection("planning");
		//ystem.out.println(Planning.ajoueRDV(login, test, "5", "5", "5", "5", "5"));
		System.out.println(Planning.supprimerRdv(login, test, "5", "5", "5", "5", "5"));
		
	//	String key = BdUser.getKey(login);
	//	System.out.println(user.logout(key));
	
	
	//	System.out.println(BdUser.samePass(login,test));
	//	System.out.println(User.login(login, password));
	//	String key = BdUser.getKey(login);
	//	System.out.println(User.logout(key));
//		Statement lecture = sql.createStatement();
//		ResultSet curseur = lecture.executeQuery("Select t from session where idUser = '"+login+"';");
//		while (curseur.next()){
//			System.out.println(curseur.getString("t"));
//		}
//			System.out.println(curseur.getString("id"));
//			System.out.println(curseur.getString("login"));
//			System.out.println(curseur.getString("nom"));
//			System.out.println(curseur.getString("prenom"));
//			System.out.println(curseur.getString("password"));

//		curseur.close();
//		lecture.close();
//		mango.close();
		sql.close();
//

		
	}

}
