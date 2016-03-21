package com.vishnu.healthyfy;

import android.os.AsyncTask;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by VISHNUPRASAD on 20/03/16.
 */
public class UpdateTask extends AsyncTask<String,String,String> {
    public static  ObjectMapper OBJECT_MAPPER= null;
    public OnDataLoaded onDataLoaded ;
    public UpdateTask(NewAppWidget newAppWidget)
    {OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        onDataLoaded = newAppWidget;
    }
    @Override
    protected String doInBackground(String... params) {

        try{
            URL url = new URL("https://www.hackerearth.com/api/events/upcoming/?format=json");
            HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoInput(true);


            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String response;
            StringBuilder stringBuilder = new StringBuilder();
            while((response = bufferedReader.readLine()) != null)
            {
                stringBuilder.append(response);
            }
            bufferedReader.close();
            response = stringBuilder.toString();
            return response;
        }
        catch (Exception e)
        {e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        System.out.println(s);
        ChallengeList challengeList = null;
        try {
            challengeList = OBJECT_MAPPER.readValue(s,ChallengeList.class);
            onDataLoaded.loadedData(challengeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(challengeList);



    }
    public interface OnDataLoaded
    {
        public void loadedData(ChallengeList challengeList);
    }
}
