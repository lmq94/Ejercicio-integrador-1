import conexion.Conexion;
import factory.ConexionFactory;
import factory.DBFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        //Seleccion de la base de datos a usar(mysql o derby)
        ConexionFactory factory= DBFactory.getDB("mysql","jdbc:mysql://localhost:3307/test_db","root","root");
        Connection conexion= factory.crearConexion();

        //creacion de tablas en la base de datos seleccionada
        factory.crearTablas(conexion);





    }
}