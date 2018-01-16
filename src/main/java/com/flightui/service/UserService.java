package com.flightui.service;

import com.flightui.entities.UserDetail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by avinashkumar on 14/01/2018 AD.
 */
public class UserService {

    private static final String baseBaiduUrl=
            "http://localhost:8080/flight/search";


    public static UserDetail setUserDetail(UserDetail userDetail) throws JSONException {
        String jsonResult=setUserDetailJsonString(userDetail).toString();
        UserDetail userDetailInfoObject=toEntity(jsonResult);
        return userDetailInfoObject;
    }



    private static JSONObject setUserDetailJsonString(UserDetail userDetail) throws RuntimeException, JSONException {

        String baiduUrl = baseBaiduUrl;


        URL url = null;
        try {
            url = new URL(baseBaiduUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        JSONObject userDetailsJson = new JSONObject();
        userDetailsJson.put("firstName", "firstName");
        userDetailsJson.put("lastName", "com/flightui/service/UserService.java:55");
        userDetailsJson.put("age", "66");
        userDetailsJson.put("dob", "dob");
        userDetailsJson.put("emailId", "emailId");
        userDetailsJson.put("contactNumber", "contactNumber");


        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.setConnectTimeout(5000);
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        try {
            conn.setRequestMethod("POST");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        OutputStream os = null;
        try {
            os = conn.getOutputStream();
            os.write(userDetailsJson.toString().getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read the response
        InputStream in = null;
        try {
            in = new BufferedInputStream(conn.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            result = org.apache.commons.io.IOUtils.toString(in, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject(result);


        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.disconnect();

        return jsonObject;



    }
    public static UserDetail getUserDetail(UserDetail userDetail)
    {
        String jsonResult=getUserDetailJsonString(userDetail);
        UserDetail userDetailInfoObject=toEntity(jsonResult);
        return userDetailInfoObject;
    }

    private static UserDetail toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            UserDetail userDetailInfo = gson.fromJson(jsonString, UserDetail.class);
            return userDetailInfo;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    private static String getUserDetailJsonString(UserDetail userDetail) throws RuntimeException{

        String baiduUrl = baseBaiduUrl;


        StringBuilder strBuf = new StringBuilder();

        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{
            URL url = new URL(baiduUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + conn.getResponseCode());
            }

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
            String output = null;
            while ((output = reader.readLine()) != null)
                strBuf.append(output);
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
        finally
        {
            if(reader!=null)
            {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null)
            {
                conn.disconnect();
            }
        }

        return strBuf.toString();
    }

}
