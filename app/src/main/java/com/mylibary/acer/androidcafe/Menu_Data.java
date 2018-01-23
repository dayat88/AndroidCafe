package com.mylibary.acer.androidcafe;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by ACER on 1/20/2018.
 */

public class Menu_Data {
    private  static  String jsondata;

    public  void setJsondata(String json){
        jsondata = json;
        Log.i("data",jsondata);
    }

    public static ArrayList<Menu> getListMenu(){
        String response = null;
        Menu menu = null;

        FetchMenuData conn = (FetchMenuData) new FetchMenuData();
        conn.execute();
        try {
            jsondata = conn.get();
        }catch (InterruptedException e){
            e.printStackTrace();
        }catch (ExecutionException e){
            e.printStackTrace();
        }

        ArrayList<Menu> list = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(jsondata);
            Gson gson = new Gson();
            int i = 0;
            while (i< jsonArray.length()){
                list.add(gson.fromJson(jsonArray.getJSONObject(i).toString(),
                        Menu.class));
                i++;
            }
        }catch (JSONException e){
            e.printStackTrace();
        }

        return  list;
    }
}
