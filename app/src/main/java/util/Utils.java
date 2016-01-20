package util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by slavkurochkin on 1/16/16.
 */
public class Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String API_TOKEN = "&APPID=your_api";
    public static final String ICON_URL = "http://openweathermap.org/img/w/";

    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException{
        JSONObject jOdj = jsonObject.getJSONObject(tagName);
        return jOdj;
    }

    public static String getString(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagName);

    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException{
        return (float) jsonObject.getDouble(tagName);

    }
    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getDouble(tagName);

    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException{
        return jsonObject.getInt(tagName);

    }


}
