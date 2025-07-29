# INTMiniProject2

## Overview

INTMiniProject2 is a Java-based Vehicle Management System designed to manage vehicle records and their associated offences. The project leverages Java EE technologies, including EJB modules for business logic and JPA for database management, and provides a web interface built with HTML.

## Features

- **Vehicle Registration Management:** Add, edit, and remove vehicle records.
- **Offence Management:** Associate offences (type, date, etc.) with vehicles.
- **Role-based Access:** Secure operations, restricting certain actions to roles like Manager and TrafficCop.
- **Database Integration:** Uses Apache Derby for persistent storage of vehicle and offence data.
- **Web Interface:** Simple navigation for end-users to interact with the system.

## Project Structure

- `VehicleManagementEJBModule/`: Contains the core Java EJB business logic and persistence layer.
  - `za.ac.tut.model.entity.Vehicle`: Represents the vehicle entity.
  - `za.ac.tut.model.bl.VehicleFacade`: Business logic for managing vehicles.
- `VehicleWebApp/`: HTML files for the user interface.
- `VehicleManagementDB/`: Derby database files (do not edit manually; see below).

## How to Run

1. **Prerequisites:**
   - Java Development Kit (JDK) 8 or later.
   - Apache Derby (included in some Java EE servers).
   - Java EE application server (e.g., GlassFish or Payara).

2. **Setup Steps:**
   - Import the project into your preferred Java IDE.
   - Ensure the Derby database is configured correctly. **Do not modify files in `VehicleManagementDB/`; this could corrupt the database.**
   - Deploy the EJB module to your Java EE server.
   - Deploy the web application (`VehicleWebApp`) to the same server.
   - Access the site via your browser (typically at `http://localhost:8080/VehicleWebApp`).

## Usage

- On the homepage, follow the link to the menu to access available options.
- Only authorized users with roles (Manager, TrafficCop) can perform management operations.

## Important Notes

- **Database Safety:**  
  Files in the `VehicleManagementDB/` directory and its subdirectories are managed by Apache Derby. Editing, adding, or deleting any of these files may cause data corruption and result in a non-recoverable database.

- **Code Structure:**  
  - The `Vehicle` entity manages vehicle details and offences.
  - Business logic is handled in the `VehicleFacade` class, supporting CRUD operations and queries by offence type.

## License

This project does not yet specify a license.

## Author

Developed by [farai](https://github.com/Fatso0112).

---

For questions or contributions, please open an issue or submit a pull request.
