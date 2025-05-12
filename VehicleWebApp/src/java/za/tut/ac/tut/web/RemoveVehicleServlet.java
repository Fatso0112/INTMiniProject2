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
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.VehicleFacadeLocal;
import za.ac.tut.model.entity.Vehicle;

/**
 *
 * @author farai
 */
@ServletSecurity(@HttpConstraint(rolesAllowed = {"Manager"}))
public class RemoveVehicleServlet extends HttpServlet {

    @EJB
    private VehicleFacadeLocal vfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("vehicleId"));

        try {
            Vehicle vehicle = vfl.find(id);
            if (vehicle != null) {
                vfl.remove(vehicle);
                request.setAttribute("message", "Vehicle removed successfully.");
            } else {
                request.setAttribute("error", "Vehicle not found.");
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("remove_result.jsp");
            dispatcher.forward(request, response);

        } catch (Exception e) {
           e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error removing vehicle");
        }
    }
}