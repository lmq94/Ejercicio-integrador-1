package daos.derby;

import model.Factura_Producto;
import daos.Factura_ProductoDAO;

import java.sql.Connection;
import java.util.List;

public class FacturaProductoDAODerby implements Factura_ProductoDAO {
    private Connection conexion;


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
    public List<Factura_Producto> obtenerTodos() throws Exception {
        return null;
    }
}
