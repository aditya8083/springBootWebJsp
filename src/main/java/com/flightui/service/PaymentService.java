package com.flightui.service;

import com.flightui.entities.BookingResponse;
import com.flightui.entities.PaymentRequest;
import com.flightui.entities.PaymentResponse;
import com.flightui.entities.Transactions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by avinashkumar on 14/01/2018 AD.
 */
public class PaymentService {

    private static final String baseBaiduUrl= "http://localhost:8000/payment/card/payment";


    public static Transactions makePayment(PaymentRequest paymentRequest) throws JSONException {
        System.out.println(paymentRequest);
        Transactions jsonResult = pay(paymentRequest);
        System.out.println(jsonResult.toString());
        //Transactions transactionDetailsInfoObject = toEntity(jsonResult);
        return jsonResult;
    }

    private static Transactions toEntity(String jsonString)
    {
        try{
            Gson gson = new GsonBuilder().create();
            Transactions transactionDetails = gson.fromJson(jsonString, Transactions.class);
            return transactionDetails;
        }
        catch(JsonSyntaxException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    private static Transactions pay(PaymentRequest paymentRequest) throws RuntimeException, JSONException {

        String baiduUrl = baseBaiduUrl;


        URL url = null;
        try {
            url = new URL(baseBaiduUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        Gson gson = new GsonBuilder().create();

        System.out.println(paymentRequest.getAmount());

        String paymentDetails = gson.toJson(paymentRequest);

        JSONObject paymentDetailsJson = new JSONObject(paymentDetails);

        System.out.println(paymentDetailsJson);


        PaymentResponse baseResponse = null;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE);

        HttpEntity<PaymentRequest> entity = new HttpEntity<PaymentRequest>(paymentRequest, headers);

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("name", "postgres");
        map.add("password", "coviam@123");
        ResponseEntity<BookingResponse> response =
                restTemplate.exchange(baiduUrl, HttpMethod.POST, entity, BookingResponse.class, map);

        if (!(response.getStatusCode() == HttpStatus.OK)) {
            baseResponse = new PaymentResponse(true, HttpStatus.OK.value(), "refund initiated");

        } else {
            baseResponse = new PaymentResponse(true, HttpStatus.OK.value(), response.getBody().getTransactions());

        }

        System.out.println(baseResponse.getTransactions());



//        HttpURLConnection conn = null;
//        try {
//            conn = (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        conn.setConnectTimeout(5000);
//        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//        conn.setDoOutput(true);
//        conn.setDoInput(true);
//        try {
//            conn.setRequestMethod("POST");
//        } catch (ProtocolException e) {
//            e.printStackTrace();
//        }
//
//        OutputStream os = null;
//        try {
//            os = conn.getOutputStream();
//            os.write(paymentDetailsJson.toString().getBytes("UTF-8"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            os.flush();
//            os.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        int responseCode = 0;
//        JSONObject jsonObject=null;
//        try {
//            responseCode = conn.getResponseCode();
//            System.out.println("POST Response Code :: " + responseCode);
//
//            if (responseCode == HttpURLConnection.HTTP_OK) { //success
//                BufferedReader in = new BufferedReader(new InputStreamReader(
//                        conn.getInputStream()));
//                String inputLine;
//                StringBuffer response = new StringBuffer();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//                // print result
//                System.out.println(response.toString());
//                 jsonObject = HTTP.toJSONObject(response.toString());
//            } else {
//                System.out.println("POST request not worked");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return jsonObject;
        return baseResponse.getTransactions();



    }
}
