package services;

import java.net.UnknownHostException;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

import bd.BdPlanning;
import bd.Database;
import serviceTool.ServiceRefused;

public class Planning {

	public Planning(){
		super();
	}
	
	/**
	 * Ajouter un rendez vous 
	 * @param id : id du rendez vous
	 * @param titre : titre du rendez vous 
	 * @param jour : jour du rendez vous
	 * @param mois : mois du rendez vous
	 * @param annee : annee du rendez vous
	 * @param heure : heure du rendez vous 
	 * @param minute : minute du rendez vous
	 * @return Retrun un message en json object 
	 * @throws UnknownHostException
	 * @throws JSONException
	 */
	public static JSONObject ajoueRDV(String id,String titre,String jour,String mois,String annee,String heure,String minute) throws UnknownHostException, JSONException{
		BasicDBObject rdv = new BasicDBObject();
		JSONObject ret = new JSONObject();
		if(!BdPlanning.rdvExist(id,jour,mois,annee,heure,minute)){
			DBCollection col = Database.getCollection("planning");
			rdv.put("Titre", titre);
			rdv.put("jour", jour);
			rdv.put("mois", mois);
			rdv.put("annee", annee);
			rdv.put("heure", heure);
			rdv.put("minute",minute);
			rdv.put("id", id);
			
			col.insert(rdv);
			ret.put("Status", "OK");
			return ret;
		}
		return ServiceRefused.serviceRefused("Rdv Exist", 7);
		
	}
	/**Supprimer un rendez vous
	 * 
	 * @param id : id du rendez vous
	 * @param titre : titre du rendez vous 
	 * @param jour : jour du rendez vous
	 * @param mois : mois du rendez vous
	 * @param annee : annee du rendez vous
	 * @param heure : heure du rendez vous 
	 * @param minute : minute du rendez vous
	 * @return
	 * @throws UnknownHostException
	 * @throws JSONException
	 */
	public static JSONObject supprimerRdv(String id,String titre,String jour,String mois,String annee,String heure,String minute) throws UnknownHostException, JSONException{
		
		JSONObject ret = new JSONObject();
		if(BdPlanning.rdvExist(id,jour,mois,annee,heure,minute)){
			ret = BdPlanning.suppressionRdv(id,titre,jour,mois,annee,heure,minute);
			return ret;
		}
		return ServiceRefused.serviceRefused("Rdv Exist pas", 9);
	}
	
	
	/**
	 * Modifier les données du rdv
	 * @param id : id  du rdv
	 * @param titre : titre du rdv
	 * @param jour : jour du rdv 
	 * @param mois : mois du rdv
	 * @param annee : annee du rdv
	 * @param heure : heure du rdv
	 * @param minute : minute du rdv 
	 * @return JSON
	 * @throws UnknownHostException 
	 * @throws JSONException 
	 */
	public static JSONObject modifierRdv(String id, String titre, String jour, String mois, String annee, String heure, String minute) throws UnknownHostException, JSONException{
		JSONObject ret = new JSONObject();
		if(BdPlanning.IdExist(id)) {
			ret = BdPlanning.modifierRdv(id,titre,jour,mois,annee,heure,minute);
			return ret;
		}
		return ServiceRefused.serviceRefused("le Rdv n'existe pas", 9);
	}
	
}
