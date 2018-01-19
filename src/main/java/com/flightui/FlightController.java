package com.flightui;

import com.flightui.entities.FlightSearchRequest;
import com.flightui.entities.FlightSearchResponse;
import com.flightui.service.FlightService;
import com.google.gson.Gson;
import org.json.JSONException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@WebServlet(urlPatterns = "/flight/*")
public class FlightController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		PrintWriter out = response.getWriter();


		try {

			BufferedReader reader = request.getReader();
			Gson gson = new Gson();

			FlightSearchRequest flightSearchRequest = gson.fromJson(reader, FlightSearchRequest.class);

			Map<Integer,List<FlightSearchResponse>> flightMap = new HashMap<>();
                    //FlightService.getFlightPrice(flightSearchRequest);

			out.print(flightMap.toString());
			System.out.println("====================reached Here===============");
			request.setAttribute("flight", flightMap);
			try {
				//getServletConfig().getServletContext().getRequestDispatcher(
                  //      "flightSearchResult.jsp").forward(request, response);
                ServletContext ctx = getServletConfig().getServletContext();

				RequestDispatcher dispatcher =
                        ctx.getRequestDispatcher("flightSearchResult.jsp");
				System.out.println("forwarding now...");
				dispatcher.forward( request, response );
				System.out.println("====================reached Here Also===============");
			} catch (ServletException e) {
				e.printStackTrace();
			}


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.close();
		}

	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    doPost(request,response);
    }

}
