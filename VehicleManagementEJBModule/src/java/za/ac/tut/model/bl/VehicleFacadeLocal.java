/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.model.entity.Vehicle;

/**
 *
 * @author farai
 */
@Local
public interface VehicleFacadeLocal {

    void create(Vehicle vehicle);

    void edit(Vehicle vehicle);

    void remove(Vehicle vehicle);

    Vehicle find(Object id);

    List<Vehicle> findAll();


    int count();
    
    void createVehicle(Vehicle vehicle);
    
    Long getVehicleCount();
    
    List<Vehicle> getAll();
    
    List<Vehicle> getVehiclesByOffenceType(String offenceType);
    
    
}
