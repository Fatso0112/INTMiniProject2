package za.ac.tut.model.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2025-05-12T17:57:21")
@StaticMetamodel(Vehicle.class)
public class Vehicle_ { 

    public static volatile SingularAttribute<Vehicle, String> vehicleName;
    public static volatile SingularAttribute<Vehicle, String> offenceType;
    public static volatile SingularAttribute<Vehicle, Long> id;
    public static volatile SingularAttribute<Vehicle, String> vehicleRegistration;
    public static volatile SingularAttribute<Vehicle, Date> offenceDate;
    public static volatile SingularAttribute<Vehicle, Date> cretionDate;

}