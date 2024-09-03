package daos.derby;

import Model.Producto;
import daos.ProductoDAO;

import java.sql.Connection;
import java.util.List;

public class ProductoDAODerby implements ProductoDAO {

    private Connection conexion;

    public ProductoDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Producto elemento) throws Exception {

    }

    @Override
    public void eliminar(Producto elemento) throws Exception{

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
