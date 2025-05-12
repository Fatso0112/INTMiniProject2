/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.tut.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.VehicleFacadeLocal;
import za.ac.tut.model.entity.Vehicle;

/**
 *
 * @author farai
 */

@DeclareRoles({"TrafficCop", "Manager"})
@WebServlet("/UploadVehicleServlet.do")
@ServletSecurity(@HttpConstraint(rolesAllowed = {"TrafficCop"}))
public class UploadVehicleServlet extends HttpServlet {

    @EJB
    private VehicleFacadeLocal vfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        // Retrieve form data
        String vehicleName = request.getParameter("vehicleName");
        String vehicleReg = request.getParameter("vehicleRegistration");
        String offenceType = request.getParameter("offenceType");
        String offenceDateStr = request.getParameter("offenceDate");

        try {
            // Parse offence date
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
            Date offenceDate = sdf.parse(offenceDateStr);

            // Create new vehicle object
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleName(vehicleName);
            vehicle.setVehicleRegistration(vehicleReg);
            vehicle.setOffenceType(offenceType);
            vehicle.setOffenceDate(offenceDate);
            vehicle.setCretionDate(new Date()); // Current timestamp

            // Persist using EJB
            vfl.create(vehicle);

            RequestDispatcher dispatcher = request.getRequestDispatcher("add_vehicle_outcome.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error saving vehicle");
        }
    }
}