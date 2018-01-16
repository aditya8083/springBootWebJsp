package com.flightui.service;

import com.flightui.Util.HttpUtility;
import com.flightui.entities.FlightSearchRequest;
import com.flightui.entities.FlightSearchResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class FlightService {

    private static final String flightUrlPath= "http://localhost:8085/flight/search";

    public static Map<Integer,List<FlightSearchResponse>> getFlightPrice(FlightSearchRequest flightSearchRequest) throws JSONException {
        return  getFlightSearchResponseList(flightSearchRequest);
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

    private static Map<Integer,List<FlightSearchResponse>> getFlightSearchResponseList(FlightSearchRequest flightSearchRequest) throws RuntimeException, JSONException {
        String flightUrl = flightUrlPath;
        HashMap<String,String> flightRequestMap = getFlightSearchParams(flightSearchRequest);
        String flightSearchResp = HttpUtility.newRequest(flightUrl,HttpUtility.METHOD_GET, flightRequestMap);
        return transformedFlightSearchRes(flightSearchResp);
    }

    private static Map<Integer,List<FlightSearchResponse>> transformedFlightSearchRes(String flightSearchResp) throws JSONException {
        Map<Integer, List<FlightSearchResponse>> searchResults = new LinkedHashMap<>();
        List<FlightSearchResponse> oneWayFlightList = new LinkedList<>();
        JSONObject flightSearchResObj =  new JSONObject(flightSearchResp);
        JSONObject responseObj = flightSearchResObj.getJSONObject("response");
        JSONArray searchResultArray = responseObj.getJSONArray("search_results");
        if(searchResultArray.length() > 0){
            JSONArray onGoingFlightArray = searchResultArray.getJSONArray(0);   // oneWay flights
            getAllFlights(onGoingFlightArray,oneWayFlightList);
            searchResults.put(0,oneWayFlightList);
            if(searchResultArray.length() > 1){    // roundTrip flights
                List<FlightSearchResponse> returnTripFlightList = new LinkedList<>();
                JSONArray returnTripFlightArray = searchResultArray.getJSONArray(1);   // ReturnTrip flights
                getAllFlights(returnTripFlightArray,returnTripFlightList);
                searchResults.put(1,returnTripFlightList);
            }
        }
     return searchResults;
    }

    private static void getAllFlights(JSONArray flightJSONArray, List<FlightSearchResponse> flightList) throws JSONException {
        if(flightJSONArray.length() > 0)
        {
            for(int i=0 ; i < flightJSONArray.length() ; i++){
                try {
                    flightList.add(toEntity(flightJSONArray.getJSONObject(i).toString()));
                }catch(Exception e){
                    System.out.println("Getting Exception in Adding the response");
                }
            }
        }

    }


    private static HashMap<String,String> getFlightSearchParams(FlightSearchRequest flightSearchRequest) {
        HashMap<String,String> flightRequestMap = new HashMap<>();
        flightRequestMap.put("origin", flightSearchRequest.getOrigin());
        flightRequestMap.put("destination", flightSearchRequest.getDestination());
        flightRequestMap.put("originDepartDate", flightSearchRequest.getOriginDepartDate());
        flightRequestMap.put("destinationArrivalDate", flightSearchRequest.getDestinationArrivalDate());
        flightRequestMap.put("adults", Integer.toString(flightSearchRequest.getAdults()));
        flightRequestMap.put("infants", Integer.toString(flightSearchRequest.getInfants()));
        flightRequestMap.put("children", Integer.toString(flightSearchRequest.getChildren()));
        flightRequestMap.put("flightType", flightSearchRequest.getFlightType());
        return flightRequestMap;
    }







/*
        StringBuilder strBuf = new StringBuilder();

        HttpURLConnection conn=null;
        BufferedReader reader=null;
        try{
            URL url = new URL(flightUrl);
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : " + conn.getResponseCode());
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

        return strBuf.toString();*/
}
