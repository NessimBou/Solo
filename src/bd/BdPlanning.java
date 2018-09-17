package bd;

import java.net.UnknownHostException;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import serviceTool.ServiceRefused;

public class BdPlanning {
	public BdPlanning(){
		super();
	}
	
	/**
	 * Fonction de recherche Rdv exist dans mongo
	 * @param id : id  du rdv(à supprimer)
	 * @param jour : jour du rdv 
	 * @param mois : mois du rdv
	 * @param annee : annee du rdv
	 * @param heure : heure du rdv
	 * @param minute : minute du rdv 
	 * @return true/false
	 * @throws UnknownHostException
	 */
	public static boolean rdvExist(String id,String jour,String mois,String annee,String heure,String minute) throws UnknownHostException{
		DBCollection col = Database.getCollection("planning");
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		query.put("jour", Integer.parseInt(jour));
		query.put("mois", Integer.parseInt(mois));
		query.put("annee", Integer.parseInt(annee));
		query.put("heure", Integer.parseInt(heure));
		query.put("minute", Integer.parseInt(minute));
		DBCursor cursor = col.find(query);
		if(cursor.hasNext()){
			cursor.close();
			return true;
		}
		cursor.close();
		return false;
		
		
	}
	/**
	 * Supprimer un rdv ( on peut surement supprimer le rdv à partir de l'id pas besoin de tout les parametres)
	 * @param id : id  du rdv(à supprimer)
	 * @param titre : titre du rdv
	 * @param jour : jour du rdv 
	 * @param mois : mois du rdv
	 * @param annee : annee du rdv
	 * @param heure : heure du rdv
	 * @param minute : minute du rdv 
	 * @return JSON Message si supprimer
	 * @throws UnknownHostException
	 * @throws JSONException
	 */
	public static JSONObject suppressionRdv(String id,String titre,String jour,String mois,String annee,String heure,String minute) throws UnknownHostException, JSONException{
		
		JSONObject ret = new JSONObject();
		DBCollection col = Database.getCollection("planning");
		BasicDBObject query = new BasicDBObject();
		query.put("Titre", titre);
		query.put("jour", jour);
		query.put("mois", mois);
		query.put("annee", annee);
		query.put("heure", heure);
		query.put("minute",minute);;
		query.put("id", id);
		DBCursor cursor = col.find(query);
		
		if(cursor.hasNext()){
			col.remove(cursor.next());
			cursor.close();
			ret.put("Status", "OK");
			ret.put("message remove", "ok");
			return ret;
		}
		cursor.close();
		return ServiceRefused.serviceRefused("Erreur suppression", 8);
	}
	
	/**
	 * Verifie que l'id du rdv exist( à changer avec _id)
	 * @param id : id du rdv
	 * @return boolean
	 * @throws UnknownHostException
	 */
	public static boolean IdExist(String id) throws UnknownHostException {
		JSONObject ret = new JSONObject();
		DBCollection col = Database.getCollection("planning");
		BasicDBObject query = new BasicDBObject();
		query.put("id", id);
		DBCursor cursor = col.find(query);
		if(cursor.hasNext()) {
			cursor.close();
			return true;
		}
		cursor.close();
		return false;
	}
	
	public static JSONObject modifierRdv(String id, String titre, String jour, String mois, String annee, String heure,String minute) throws UnknownHostException {
		JSONObject ret = new JSONObject();
		DBCollection col = Database.getCollection("planning");
		BasicDBObject query = new BasicDBObject();
		//query.put("", arg1)
		return null;
	}
}
