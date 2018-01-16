package com.flightui.service;

import com.flightui.entities.FlightSearchRequest;
import com.flightui.entities.FlightSearchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by avinashkumar on 14/01/2018 AD.
 */
public class FlightService {

    private static final String baseBaiduUrl=
            "http://localhost:8080/flight/search";

    public static FlightSearchResponse getFlightPrice(FlightSearchRequest flightSearchRequest)
    {
        String jsonResult=getFlightSearchJsonString(flightSearchRequest);
        FlightSearchResponse flightSearchInfoObject=toEntity(jsonResult);
        return flightSearchInfoObject;
    }

    private static FlightSearchResponse toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            FlightSearchResponse flightSearchInfo = gson.fromJson(jsonString, FlightSearchResponse.class);
            return flightSearchInfo;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    private static String getFlightSearchJsonString(FlightSearchRequest flightSearchRequest) throws RuntimeException{

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
