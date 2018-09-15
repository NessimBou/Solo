package services;

import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import serviceTool.ServiceRefused;
import bd.BdUser;

public class User {

	public User(){
		
	}
	/**
	 * Methode pour creer un user
	 * @param nom de l'user
	 * @param prenom de l'user
	 * @param login de l'useer
	 * @param mdp de l'user
	 * @return un message si il est creer ou pas 
	 * @throws JSONException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static JSONObject createUser(String login,String mdp,String nom,String prenom) throws JSONException, ClassNotFoundException, SQLException{
		
		JSONObject ret = new JSONObject();
		if(nom == null || prenom == null ||mdp == null || login == null ){
			return ServiceRefused.serviceRefused("Variable null",1);
		}
		if(!BdUser.UserExit(login)){
			BdUser.addToDBUser(login, mdp, nom, prenom);
			ret.put("Status", "Ok");
			ret.put("User ajouté", "ok");
			return ret;
		}
		return ServiceRefused.serviceRefused("User existe deja ",2);
	}
	
	/**
	 * Connexion de l'utilisateur
	 * @param login utilisateur
	 * @param password utilisateur
	 * @return cle de connexion
	 * @throws JSONException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static JSONObject login(String login, String password) throws JSONException, ClassNotFoundException, SQLException{
		
		if ( login == null || password == null){
			return ServiceRefused.serviceRefused("Variable null",1);
		}
		try {
			if(BdUser.UserExit(login)){
				if(BdUser.samePass(login, password)){
					JSONObject ret = new JSONObject();
					ret = BdUser.connexion(login);
					return ret;
				}else{
					return ServiceRefused.serviceRefused("Mauvais Mot de passe", 4);
				}
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return ServiceRefused.serviceRefused("User n'existe pas", 5);
	}
	
	/**
	 * Deconnexion utilisateur à partir de la cle
	 * @param key de connexion
	 * @return Json 
	 * @throws JSONException
	 */
	public static JSONObject logout(String key) throws JSONException{
		JSONObject ret = new JSONObject();
		if(key == null){
			return ServiceRefused.serviceRefused("Variable null",1);
		}
		try{
			if(BdUser.keyExist(key)){
				ret = BdUser.logout(key);
				return ret;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return ServiceRefused.serviceRefused("Erreur deconnexion", 6); 
	}
}
