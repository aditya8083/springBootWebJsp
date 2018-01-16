<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
    <html lang="en">
      <head>
        <title>Test</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        </head>
            <body>

               <form>
                    <a><% out.print((Map)request.getAttribute("flight"));%></a><br>

                    <input type="text" name="origin" value="">
                    <br>
                    destination <br>
                    <input type="text" name="destination" value="">
                    <br>
                    isRefundable <br>
                    <input type="text" name="isRefundable" value="">
                    <br><br>
                    <br>
                    originDepartDate <br>
                    <input type="text" name="originDepartDate" value="">
                    <br><br>
                    <br>
                    originDepartTime <br>
                    <input type="text" name="originDepartTime" value="">
                    <br><br>
                    <br>
                    flightName <br>
                    <input type="text" name="flightName" value="">
                    <br><br>
                    <br>
                    flightNumber <br>
                    <input type="text" name="flightNumber" value="">
                    <br><br>
                    <br>
                    seatRemain <br>
                    <input type="text" name="seatRemain" value="">
                    <br><br>
                    <br>
                    pricePerAdult <br>
                    <input type="text" name="pricePerAdult" value="">
                    <br><br>
                    <br>
                    pricePerChild <br>
                    <input type="text" name="pricePerChild" value="">
                    <br><br>
                    <br>
                    pricePerInfant <br>
                    <input type="text" name="pricePerInfant" value="">
                </form>

            </body>
        </html>

