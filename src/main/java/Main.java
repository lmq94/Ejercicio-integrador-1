import factory.ConexionFactory;
import factory.DBFactory;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        //Seleccion de la base de datos a usar(mysql o derby)
        ConexionFactory factory= DBFactory.getDB("","","","");
        Connection conexion= factory.crearConexion();

        //creacion de tablas en la base de datos seleccionada
        factory.crearTablas(conexion);






    }
}