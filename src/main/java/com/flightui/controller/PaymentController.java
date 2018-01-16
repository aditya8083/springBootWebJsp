package com.flightui.controller;

import com.flightui.entities.PaymentRequest;
import com.flightui.entities.Transactions;
import com.flightui.service.PaymentService;
import com.google.gson.Gson;
import org.json.JSONException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by avinashkumar on 14/01/2018 AD.
 */
@WebServlet(urlPatterns = "/payment")
public class PaymentController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();


        try {

            BufferedReader reader = request.getReader();
            Gson gson = new Gson();

            PaymentRequest paymentRequest = gson.fromJson(reader, PaymentRequest.class);

            if(paymentRequest!=null){
                Transactions transactionDetails = PaymentService.makePayment(paymentRequest);

                out.print(transactionDetails.toString());
                request.setAttribute("transaction", transactionDetails);
                try {
                    getServletConfig().getServletContext().getRequestDispatcher(
                            "/transactionPage.jsp").forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }else
            {
                System.out.println("request null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }
}
