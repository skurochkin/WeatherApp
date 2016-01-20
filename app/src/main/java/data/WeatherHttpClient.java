package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import util.Utils;

/**
 * Created by slavkurochkin on 1/16/16.
 */
public class WeatherHttpClient {

    public String getWeatherData(String place){
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            connection = (HttpURLConnection)(new URL(Utils.BASE_URL + place + Utils.API_TOKEN)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true); //Sets the flag indicating whether this {@code URLConnection} allows input
            connection.setDoOutput(true);
            connection.connect();

            //Read the response
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            while ((line = bufferedReader.readLine()) != null)
                stringBuffer.append(line + "\r\n");

            inputStream.close();
            connection.disconnect();
            return stringBuffer.toString();

        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {

            }

            connection.disconnect();
        }

        return null;
    }
}
