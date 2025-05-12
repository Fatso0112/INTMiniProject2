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

public class FindVehicleServlet extends HttpServlet {

    @EJB
    private VehicleFacadeLocal vfl;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("vehicleId"));
        Vehicle vehicle = vfl.find(id);

        request.setAttribute("vehicle", vehicle);
        RequestDispatcher dispatcher = request.getRequestDispatcher("find_result.jsp");
        dispatcher.forward(request, response);
    }
}