package com.flightui.controller;

import com.flightui.entities.UserDetail;
import com.flightui.service.UserService;
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
@WebServlet(urlPatterns = "/user.do")
public class UserController extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        PrintWriter out = response.getWriter();


        try {

            BufferedReader reader = request.getReader();
            Gson gson = new Gson();


            UserDetail userDetail = gson.fromJson(reader, UserDetail.class);
            UserDetail userDetailSaved= UserService.setUserDetail(userDetail);

           // out.print(userDetailSaved.toString());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

}
