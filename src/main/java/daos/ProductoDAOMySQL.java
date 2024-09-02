package daos;

import Model.Producto;

import java.sql.Connection;
import java.util.List;

public class ProductoDAOMySQL extends ProductoDAO  {

    private Connection conexion;

    public ProductoDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    //operaciones de dao para producto en msyql


    @Override
    public void insertar(Producto elemento) {

    }

    @Override
    public List<Producto> obtenerTodos() {
        return List.of();
    }

    @Override
    public void eliminar(Producto elemento) {

    }

    @Override
    public void actualizar(Producto elemento) {

    }
}
