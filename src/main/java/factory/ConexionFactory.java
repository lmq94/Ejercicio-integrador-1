package factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexionFactory {

    Connection crearConexion() throws SQLException;
    void crearTablas(Connection conexion) throws SQLException;

}
