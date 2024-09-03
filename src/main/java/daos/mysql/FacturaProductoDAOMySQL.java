package daos.mysql;

import daos.FacturaProductoDAO;
import model.FacturaProducto;

import java.util.List;

public class FacturaProductoDAOMySQL implements FacturaProductoDAO {

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
