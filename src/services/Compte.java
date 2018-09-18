package services;

import java.net.UnknownHostException;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import bd.Database;
import serviceTool.ServiceRefused;

public class Compte {
	
	/**
	 * Ajoue de depense
	 * @param titre : titre de la depense
	 * @param valeur : valeur de la depense
	 * @return JSON si bon ou erreur
	 * @throws UnknownHostException
	 * @throws JSONException
	 */
	public static JSONObject ajouesomme(String titre,String valeur) throws UnknownHostException, JSONException {
		BasicDBObject compte = new BasicDBObject();
		JSONObject ret = new JSONObject();
		if(valeur != null) {
			DBCollection col = Database.getCollection("compte");
			compte.put("titre",titre);
			compte.put("somme", valeur);
			col.insert(compte);
			ret.put("Status", "OK");
			return ret;
		}
		return ServiceRefused.serviceRefused("ajoue depense pas faites", 10);
	}
	
	public static JSONObject supprimerdepense(String id) {
		BasicDBObject compte = new BasicDBObject();
		JSONObject ret = new JSONObject();
		if (BD)
	}
}
