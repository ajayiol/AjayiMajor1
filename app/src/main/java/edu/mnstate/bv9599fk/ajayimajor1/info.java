package edu.mnstate.bv9599fk.ajayimajor1;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by nick_ on 10/18/2017.
 */

public class info {
    private String club;
    private String name;
    private String foot;
    private String number;

    public info (){}

    public info(String tmpClub,String tmpName, String tmpFoot,String tmpNum){
        this.setName(tmpName);
        this.setClub(tmpClub);
        this.setFoot(tmpFoot);
        this.setNumber(tmpNum);
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public String toString(){
        return(club+" " + name + " " + foot + " " + number);
    }

    public static ArrayList<info> createData(String jsonFileName, Context context) throws JSONException{
        final ArrayList<info> teamList = new ArrayList<>();
        try{
            String jsonString = loadJsonFromAsset(jsonFileName,context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray theInfo = json.getJSONArray("teamInfo");
            for(int i = 0; i < theInfo.length(); i++){
                info in = new info();
                String tmp;
                tmp = theInfo.getJSONObject(i).getString("club");in.setClub(tmp);
                tmp = theInfo.getJSONObject(i).getString("name");in.setName(tmp);
                tmp = theInfo.getJSONObject(i).getString("foot");in.setFoot(tmp);
                tmp = theInfo.getJSONObject(i).getString("number");in.setNumber(tmp);
                teamList.add(in);

            }
        }catch (JSONException e){e.printStackTrace();}
        return teamList;
    }

    private static String loadJsonFromAsset(String fileName, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

        } catch (java.io.IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}



