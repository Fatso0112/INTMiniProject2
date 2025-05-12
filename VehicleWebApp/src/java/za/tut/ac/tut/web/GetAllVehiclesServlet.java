/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.tut.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

public class GetAllVehiclesServlet extends HttpServlet {

    @EJB
    private VehicleFacadeLocal vfl;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if(request.isUserInRole("Manager") || request.isUserInRole("TrafficCop")){
                List<Vehicle> vehicles = vfl.findAll();
                request.setAttribute("vehicles", vehicles);

                RequestDispatcher dispatcher = request.getRequestDispatcher("view_all_vehicles.jsp");
                dispatcher.forward(request, response);
        } else {
            response.sendRedirect("login.html");
        }
    }
}