package serviceTool;

import org.json.JSONException;
import org.json.JSONObject;


/**Classe Permettant de créer les messages d'erreur
 *
 */
public class ServiceRefused {

	public ServiceRefused(){
		
	}
	/**
	 * Renvoie le message d'erreur + idErreur
	 * @param message d'erreur
	 * @param IdError l'identifiant de l'erreur
	 * @return le message d'erreur+id
	 * @throws JSONException
	 */
	public static JSONObject serviceRefused( String message, int IdError) throws JSONException{
		JSONObject ret = new JSONObject();
		if (message == null){
			ret.put("Erreur", -1);
		}else{
			ret.put("Status", "KO");
			ret.put("Message", message);
			ret.put("IdError", IdError);
		}
		return ret;
	}
}
