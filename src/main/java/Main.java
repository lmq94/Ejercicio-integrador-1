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

        //Seleccion de la base de datos a usar(mysql o derby)
        ConexionFactory factory= DBFactory.getDB("mysql","jdbc:mysql://localhost:3306/mysqlJdbc","usuario","123");
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
        Producto producto=productoDao.obtenerProductoMasRecaudado();

        if(producto !=null){
            System.out.println("Producto que más recaudó: " + producto.getNombre());
            System.out.println("Valor del producto: " + producto.getValor());
        }else{
            System.out.println("No se encontró ningún producto.");
        }




    }
}