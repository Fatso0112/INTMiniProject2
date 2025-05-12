/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.tut.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.VehicleFacadeLocal;
import za.ac.tut.model.entity.Vehicle;

/**
 *
 * @author farai
 */

public class EditVehicleServlet extends HttpServlet {

    @EJB
    private VehicleFacadeLocal vfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
       if(request.isUserInRole("Manager")){
            Long id = Long.parseLong(request.getParameter("id"));
            String name = request.getParameter("vehicleName");
            String reg = request.getParameter("vehicleRegistration");
            String offence = request.getParameter("offenceType");
            String dateStr = request.getParameter("offenceDate");

            try {
                Vehicle vehicle = vfl.find(id);
                vehicle.setVehicleName(name);
                vehicle.setVehicleRegistration(reg);
                vehicle.setOffenceType(offence);
                vehicle.setOffenceDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(dateStr));

                vfl.edit(vehicle);
                request.setAttribute("message", "Vehicle updated successfully.");
                RequestDispatcher rd = request.getRequestDispatcher("edit_success.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
               e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error editing vehicle");
            }
       }else {
            response.sendRedirect("login.html");
        }
    }
}