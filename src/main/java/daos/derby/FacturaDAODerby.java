package daos.derby;

import Model.Factura;
import daos.FacturaDAO;

import java.sql.Connection;
import java.util.List;

public class FacturaDAODerby implements FacturaDAO {
    private Connection conexion;

    public FacturaDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void insertar(Factura elemento) {

    }

    @Override
    public void eliminar(Factura elemento) {

    }

    @Override
    public void actualizar(Factura elemento, Factura nuevo) {

    }

    @Override
    public Factura getId(Factura elemento) {
        return null;
    }

    @Override
    public List<Factura> obtenerTodos() {
        return List.of();
    }
}
