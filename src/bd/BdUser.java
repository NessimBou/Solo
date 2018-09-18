package bd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import serviceTool.ServiceRefused;

public class BdUser {

	public BdUser(){
		
	}
	
	/**Methode ajoutant un utilisateur a la base de donnee
	 * 
	 * @param login identifiant de l'user
	 * @param mdp mdp de l'user
	 * @param nom nom de l'user
	 * @param Prenom prenom de l'user
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public static void addToDBUser(String login,String mdp, String nom,String prenom) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "INSERT into user values('"+nom+"','"+prenom+"','"+login+"','"+mdp+"');";
		int resultat= lecture.executeUpdate(query);
		if(resultat == 1){
			System.out.println("User ajoute a la bdd");
		}else{
			System.out.println("Erreur ajout");			
		}
		lecture.close();
		c.close();
	}
	
	/**
	 * Methode permettant de savoir si l'utilisateur existe
	 * @param login login de l'utilisateur 
	 * @return true/false;
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean UserExit(String login) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Select * from user where login ='"+login+"';";
		ResultSet resultat = lecture.executeQuery(query);
		while(resultat.next()){
			resultat.close();
			lecture.close();
			c.close();
			return true;
		}
		resultat.close();
		lecture.close();
		c.close();
		return false;
	}
	
	/**
	 * Verification password
	 * @param login utilisateur
	 * @param password utilisateur
	 * @return True/false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean samePass(String login,String password) throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Select * from user where login ='"+login+"';";
		ResultSet resultat = lecture.executeQuery(query);
		while(resultat.next()){
			
			if(resultat.getString("password").equals(password)){
				lecture.close();
				resultat.close();
				c.close();
				return true;
			}
		}
		lecture.close();
		resultat.close();
		c.close();
		return false;
	}
	
	/**
	 * Connexion de l'utilisateur
	 * @param login utilisateur
	 * @return La cl� de connexion
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws JSONException
	 */
	public static JSONObject connexion(String login) throws ClassNotFoundException, SQLException, JSONException{
		String key = UUID.randomUUID().toString();
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Insert into session values('"+login+"',NOW(),'"+key+"');";
		int resultat = lecture.executeUpdate(query);
		if(resultat == 1){
			JSONObject ret = new JSONObject();
			ret.put("Status","OK");
			ret.put("key", key);
			lecture.close();
			c.close();
			return ret;
		}
		lecture.close();
		c.close();
		return ServiceRefused.serviceRefused("Echec Connexion", 3);
		
		
	}
	/**
	 * Verifie que la cle existe
	 * @param key connexion 
	 * @return true/false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static boolean keyExist(String key) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Select * from session where cle='"+key+"';";
		ResultSet resultat = lecture.executeQuery(query);
		while(resultat.next()){
			resultat.close();
			lecture.close();
			c.close();
			return true;
		}
		resultat.close();
		lecture.close();
		c.close();
		return false;
	}
	
	
	/**
	 * Methode permettant d'avoir le login � partir de la cl� 
	 * @param key de connexion 
	 * @return login 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String keyToLogin(String key) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Select * from session where cle='"+key+"';";
		ResultSet resultat = lecture.executeQuery(query);
		while(resultat.next()){
			String nom = resultat.getString("login");
			resultat.close();
			lecture.close();
			c.close();
			return nom;
		}
		resultat.close();
		lecture.close();
		c.close();
		return null;
	}
	
	/**
	 * supprime la ligne de connexion dans la table session
	 * @param key connexion
	 * @return Json 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws JSONException
	 */
	public static JSONObject logout(String key) throws SQLException, ClassNotFoundException, JSONException{

		JSONObject ret = new JSONObject();
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Delete from session where cle ='"+key+"';";
		int resultat = lecture.executeUpdate(query);
		if(resultat == 1){
			ret.put("Status", "OK");
			ret.put("Deconnexion", "Au revoir");
			lecture.close();
			c.close();
			return ret;	
		}
		lecture.close();
		c.close();
		return ServiceRefused.serviceRefused("Erreur deconnexion", 6);
	}
	
	/**
	 * recupere la cle de connexion
	 * @param login utilisateur
	 * @return String cle
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static String getKey(String login) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = Database.getMySQLConnection();
		Statement lecture = c.createStatement();
		String query = "Select * from session where login='"+login+"';";
		ResultSet resultat = lecture.executeQuery(query);
		while(resultat.next()){
			String key = resultat.getString("cle");
			resultat.close();
			lecture.close();
			c.close();
			return key;
		}
		resultat.close();
		lecture.close();
		c.close();
		return null;
	}
	
	
}
