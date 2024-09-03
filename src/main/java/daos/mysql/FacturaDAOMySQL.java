package daos.mysql;

import Model.Factura;
import daos.FacturaDAO;

import java.sql.Connection;
import java.util.List;

public class FacturaDAOMySQL implements FacturaDAO {

    private Connection conexion;

    public FacturaDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public Factura getId(Factura elemento) throws Exception {
        return null;
    }

    @Override
    public void insertar(Factura elemento) throws Exception {

    }

    @Override
    public List<Factura> obtenerTodos() throws Exception {
        return List.of();
    }

    @Override
    public void eliminar(Factura elemento) throws Exception {

    }

    @Override
    public void actualizar(Factura elemento,Factura nuevo) throws Exception {

    }
}
