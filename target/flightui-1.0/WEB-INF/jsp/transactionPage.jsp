<%@ page import="org.json.JSONObject" %>
<!DOCTYPE html>
    <html lang="en">
      <head>
        <title>Test</title>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        </head>
            <body>

               <form>
                    <a><% out.print((JSONObject)request.getAttribute("transaction"));%></a><br>
                    <input type="text" name="amount" value="">
                    <br>
                    transactionDate <br>
                    <input type="text" name="transactionDate" value="">
                    <br>
                    customerId <br>
                    <input type="text" name="customerId" value="">
                    <br><br>
                    <br>
                    paymentId <br>
                    <input type="text" name="paymentId" value="">
                    <br><br>
                    <br>
                    paymentStatus <br>
                    <input type="text" name="paymentStatus" value="">
                    <br><br>
                    <br>
                    paymentMethod <br>
                    <input type="text" name="paymentMethod" value="">
                    <br><br>
                    <br>
                    paymentEngine <br>
                    <input type="text" name="paymentEngine" value="">
                    <br><br>
                    <br>
                    walletId <br>
                    <input type="text" name="walletId" value="">
                    <br><br>
                    <br>
                    orderSource <br>
                    <input type="text" name="orderSource" value="">
                    <br><br>
                </form>

            </body>
        </html>

