package com.mylibary.acer.androidcafe;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ACER on 1/20/2018.
 */

public class FetchMenuData extends AsyncTask <Void, Void, String> {

    public AsyncResponse delegate = null ;

    @Override
    protected String doInBackground(Void...params){

        HttpURLConnection urlConnection =null;
        BufferedReader reader = null;

        String forecastJsonStr = null;

         try {
             URL url = null;
             try {
                 url = new
                         URL("http://560057.youcanlearnit.net/services/json/itemsfeed.php");
             } catch (MalformedURLException e) {
                 e.printStackTrace();
             }
             try {
                 urlConnection = (HttpURLConnection) url.openConnection();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             urlConnection.setRequestMethod("GET");
             urlConnection.connect();

             // Read the input stream into a String
             InputStream inputStream = urlConnection.getInputStream();
             StringBuffer buffer = new StringBuffer();
             if (inputStream == null) {
                 return null;
             }
             reader = new BufferedReader(new InputStreamReader(inputStream));

             String line;
             while ((line = reader.readLine()) != null) {
                 buffer.append(line + "\n");
             }
             if (buffer.length() == 0) {
                 return null;
             }
             forecastJsonStr = buffer.toString();
             return forecastJsonStr;
         } catch (IOException e){
             Log.e("PlaceholderFragment", "Error", e);
             return  null;
         }finally {
             if (urlConnection != null){
                 urlConnection.disconnect();
             }
             if (reader != null){
                 try{
                     reader.close();
                 }catch (final IOException e){
                     Log.e("PlaceholderFragment","Error closing stream", e);
                 }
             }
         }
    }

    @Override
    protected void onPostExecute(String s ){
        super.onPostExecute(s);
    }
}


