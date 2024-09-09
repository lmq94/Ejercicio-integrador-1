import DTOs.ProductoDTO;
import conexion.Conexion;
import daos.ProductoDAO;
import factory.ConexionFactory;
import factory.DAOFactory;
import factory.DBFactory;
import factory.MySQLDAOFactory;
import model.Producto;
import util.LoadCsv;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        /* DATOS PARA MYSQL*/
        String url = "jdbc:mysql://localhost:3333/test_mysql";
        String usuario = "root";
        String contrasena = "root";
        String database = "test_mysql";

        /*DATOS PARA DERBY*/


        //Seleccion de la base de datos a usar(mysql o derby)
        ConexionFactory factory= DBFactory.getDB(database,url,usuario,contrasena);
        Connection conexion= factory.crearConexion();

        //creacion de tablas en la base de datos seleccionada
        factory.crearTablas(conexion);

        DAOFactory dao = new MySQLDAOFactory(conexion);

        LoadCsv cargador = new LoadCsv(dao);
        //cargador.readProductos();
        //cargador.readClientes();
        //cargador.readFacturas();
        //cargador.readFacturasProductos();


        ProductoDAO productoDao= dao.getProductoDAO();
        ProductoDTO producto=productoDao.obtenerProductoMasRecaudado();

        // Obtener producto con mayor recaudación (sin ID)
        ProductoDTO productoMayorRecaudacion = productoDao.obtenerProductoMasRecaudado();
        System.out.println("Producto con mayor recaudación: " + productoMayorRecaudacion.getNombre() +
                " con un total de recaudación de: " + productoMayorRecaudacion.getRecaudacion());





    }
}