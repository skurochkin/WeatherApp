package data;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by slavkurochkin on 1/19/16.
 */
public class CityPreference {

    SharedPreferences prefs;
    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public String getCity(){
        return prefs.getString("city", "Boston,US");
    }

    public void setCity(String city){
        prefs.edit().putString("city", city).commit();
    }
}
