package com.flightui.controller;

import com.flightui.entities.FlightSearchRequest;
import com.flightui.entities.FlightSearchResponse;
import com.flightui.service.FlightService;
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


@WebServlet(urlPatterns = "/flight")
public class FlightController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();


		try {

			BufferedReader reader = request.getReader();
			Gson gson = new Gson();

			FlightSearchRequest flightSearchRequest = gson.fromJson(reader, FlightSearchRequest.class);

			FlightSearchResponse flightInfoObject = FlightService.getFlightPrice(flightSearchRequest);

			out.print(flightInfoObject.toString());
			request.setAttribute("flight", flightInfoObject);
			try {
				getServletConfig().getServletContext().getRequestDispatcher(
                        "/flightSearchResult.jsp").forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

}
