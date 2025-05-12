/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.model.entity.Vehicle;

/**
 *
 * @author farai
 */
@Stateless
public class VehicleFacade extends AbstractFacade<Vehicle> implements VehicleFacadeLocal {

    @PersistenceContext(unitName = "VehicleManagementEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehicleFacade() {
        super(Vehicle.class);
    }    
    
    @Override
    @RolesAllowed({"Manager", "TrafficCop"})
    public Long getVehicleCount() {
        String queryStr = "SELECT COUNT(v) FROM Vehicle v";
        Query query = em.createQuery(queryStr);
        Long cnt = (Long)query.getSingleResult();

        return cnt;
    }

    @Override
    @RolesAllowed({"Manager", "TrafficCop"})
    public List<Vehicle> getAll() {
        String queryStr = "SELECT v FROM Vehicle v";
        Query query = em.createQuery(queryStr);
        List<Vehicle> vehicles = query.getResultList();

        return vehicles;
    }

    @Override
    @RolesAllowed({"Manager", "TrafficCop"})
    public List<Vehicle> getVehiclesByOffenceType(String offenceType) {
       String queryStr = "SELECT v FROM Vehicle v WHERE v.offenceType = :offenceType";
        Query query = em.createQuery(queryStr);
        query.setParameter("offenceType", offenceType);
        
        List<Vehicle> vehicles = query.getResultList();
        return vehicles;
    }

    @RolesAllowed({"Manager", "TrafficCop"})
    @Override
    public void createVehicle(Vehicle vehicle) {
        create(vehicle);
    }
}
