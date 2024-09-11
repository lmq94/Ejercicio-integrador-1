import DTOs.ClienteDTO;
import DTOs.ProductoDTO;
import daos.ClienteDAO;
import daos.ProductoDAO;
import factory.daos.DAOFactory;
import factory.daos.MySQLDAOFactory;
import factory.dbs.ConexionFactory;
import factory.dbs.DBFactory;
import util.LoadCsv;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        //CASO DE UTILIZAR MYSQL
        String url = "jdbc:mysql://localhost:3306/mysqlJdbc";
        String usuario = "usuario";
        String contrasena = "123";
        String database = "mysqlJdbc";


        /* //CASO DE UTILIZAR DERBY
        String url="jdbc:derby://localhost:1527/arqui_db;create=true";
        String usuario = "";
        String contrasena = "";
        String database = "derby";
         **/


        //CREACION DE LA CONEXION A LA BASE DE DATOS SELECCIONADA
        ConexionFactory factory= DBFactory.getDB(database,url,usuario,contrasena);
        Connection conexion= factory.crearConexion();

        //CREAR LAS TABLAS
        factory.crearTablas(conexion);

        DAOFactory dao = new MySQLDAOFactory(conexion);

        LoadCsv cargador = new LoadCsv(dao);

        //UTILIZAR EN LA PRIMER EJECUCION DEL MAIN SOLAMENTE
        //cargador.readProductos();
        //cargador.readClientes();
        //cargador.readFacturas();
        //cargador.readFacturasProductos();


        ProductoDAO productoDao= dao.getProductoDAO();
        ProductoDTO producto=productoDao.obtenerProductoMasRecaudado();

        //MUESTRA RESOLUCION ENUNCIADO 3
        // Obtener producto con mayor recaudación (sin ID) 
        System.out.println("-------------------------");
        System.out.println("RETORNAR EL PRODUCTO QUE MÁS RECAUDÓ ");
        ProductoDTO productoMayorRecaudacion = productoDao.obtenerProductoMasRecaudado();
        System.out.println("Producto con mayor recaudación: " + productoMayorRecaudacion.getNombre() +
                ", con un total de recaudación de: " + productoMayorRecaudacion.getRecaudacion());
        System.out.println("-------------------------");

        //MUESTRA RESOLUCION ENUNCIADO 4
        //Listar clientes ordenados por facturacion,de manera descendente
        System.out.println("--------------------------");
        System.out.println("RETORNAR CLIENTES POR ORDEN FACTURADO");
        ClienteDAO clienteDao=dao.getClienteDAO();
        List<ClienteDTO> clientes = clienteDao.getClientesOrdenadosPorFacturacion();
        System.out.println("Clientes ordenados por total facturado:");
        for (ClienteDTO cliente : clientes) {
            //System.out.println(cliente.getNombre() + " - Total facturado: " + cliente.getTotalFacturado());
            System.out.println(cliente);
        }
        System.out.println("--------------------------");





    }
}