<%-- 
    Document   : find_result
    Created on : 12 May 2025, 7:24:12 PM
    Author     : farai
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="za.ac.tut.model.entity.Vehicle" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <title>Find Vehicle Result</title>
</head>
<body>

    <%
        List<Vehicle> vehicles = (List<Vehicle>) request.getAttribute("vehicles");
        if (vehicles != null && !vehicles.isEmpty()) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>

    <h1>Matching Vehicle Results</h1>
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
        <h2>No matching vehicles found.</h2>
    <%
        }
    %>

    <br>
    <p>
        Click <a href="menu.html">here</a> to return to the menu
    </p>
    
    

</body>
</html>

