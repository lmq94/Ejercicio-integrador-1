package daos.mysql;

import daos.FacturaProductoDAO;
import Model.Factura_Producto;

import java.util.List;

public class FacturaProductoDAOMySQL implements FacturaProductoDAO {

    @Override
    public void insertar(Factura_Producto elemento) throws Exception {

    }

    @Override
    public void eliminar(Factura_Producto elemento) throws Exception {

    }

    @Override
    public void actualizar(Factura_Producto elemento, Factura_Producto nuevo) throws Exception {

    }

    @Override
    public Factura_Producto getId(Factura_Producto elemento) throws Exception {
        return null;
    }

    @Override
    public List<FacturaProducto> obtenerTodos() throws Exception {
        return List.of();
    }
}
