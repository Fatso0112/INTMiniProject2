<%-- 
    Document   : view_all_vehicles
    Created on : 12 May 2025, 7:34:01 PM
    Author     : farai
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Vehicle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Vehicles</title>
    </head>
    <body>
        <%
           List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
           if (vehicles != null && !vehicles.isEmpty()) {
               SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       %>

       <h1>All Registered Vehicle Offences</h1>
       <table border="1">
           <tr>
               <th>ID</th>
               <th>Vehicle Name</th>
               <th>Registration</th>
               <th>Offence</th>
               <th>Offence Date</th>
               <th>Creation Date</th>
           </tr>

           <%
               for (int i = 0; i < vehicles.size(); i++) {
                   Vehicle v = vehicles.get(i);
                   Long id = v.getId();
                   String name = v.getVehicleName();
                   String registration = v.getVehicleRegistration();
                   String offence = v.getOffenceType();
                   Date offenceDate = v.getOffenceDate();
                   Date creationDate = v.getCretionDate();

                   String formattedOffenceDate = (offenceDate != null) ? sdf.format(offenceDate) : "N/A";
                   String formattedCreationDate = (creationDate != null) ? sdf.format(creationDate) : "N/A";
           %>

           <tr>
               <td><%=id%></td>
               <td><%=name%></td>
               <td><%=registration%></td>
               <td><%=offence%></td>
               <td><%=formattedOffenceDate%></td>
               <td><%=formattedCreationDate%></td>
           </tr>

           <%
               }
           %>
       </table>

       <%
           } else {
       %>
           <h2>No vehicle records found.</h2>
       <%
           }
       %>

       <br>
       <p>
           Click <a href="menu.html">here</a> to return to the menu or <a href="index.html">here</a> to go to home.
       </p>
    </body>
</html>
