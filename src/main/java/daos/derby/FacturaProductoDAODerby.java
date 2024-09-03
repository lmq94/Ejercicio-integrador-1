package daos.derby;

import daos.FacturaProductoDAO;
import model.FacturaProducto;

import java.sql.Connection;
import java.util.List;

public class FacturaProductoDAODerby implements FacturaProductoDAO {
    private Connection conexion;

    public FacturaProductoDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(FacturaProducto elemento) throws Exception {

    }

    @Override
    public void eliminar(FacturaProducto elemento) throws Exception {

    }

    @Override
    public void actualizar(FacturaProducto elemento, FacturaProducto nuevo) throws Exception {

    }

    @Override
    public FacturaProducto getId(FacturaProducto elemento) throws Exception {
        return null;
    }

    @Override
    public List<FacturaProducto> obtenerTodos() throws Exception {
        return List.of();
    }
}
