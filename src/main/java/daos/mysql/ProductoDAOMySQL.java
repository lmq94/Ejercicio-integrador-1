package daos.mysql;

import Model.Producto;
import daos.ProductoDAO;

import java.sql.Connection;
import java.util.List;

public class ProductoDAOMySQL implements ProductoDAO {

    private Connection conexion;

    public ProductoDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    //operaciones de dao para producto en msyql


    @Override
    public void insertar(Producto elemento) throws Exception {

    }

    @Override
    public void eliminar(Producto elemento) throws Exception {

    }

    @Override
    public void actualizar(Producto elemento, Producto nuevo) throws Exception {

    }

    @Override
    public Producto getId(Producto elemento) throws Exception {
        return null;
    }

    @Override
    public List<Producto> obtenerTodos() throws Exception {
        return List.of();
    }
}
