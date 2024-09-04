package daos.derby;

import daos.FacturaProductoDAO;
import Model.Factura_Producto;

import java.sql.Connection;
import java.util.List;

public class FacturaProductoDAODerby implements FacturaProductoDAO {
    private Connection conexion;

    public FacturaProductoDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

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
        return List.of();
    }
}
