package factory.daos;

import factory.dbs.ConexionFactory;
import factory.dbs.DerbyImplementacion;
import factory.dbs.MySQLImplementacion;

import java.sql.Connection;

public class DAOSelect {

    public static DAOFactory getDB(String tipo, Connection conexion){
        switch (tipo){
            case "mysql":
                return new MySQLDAOFactory(conexion);

            case "derby":
                return new DerbyDAOFactory(conexion);

            default:
                return new MySQLDAOFactory(conexion);
        }
    }

}
