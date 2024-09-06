package factory;

import daos.ClienteDAO;
import daos.FacturaDAO;
import daos.Factura_ProductoDAO;
import daos.ProductoDAO;
import daos.derby.ClienteDAODerby;
import daos.derby.ProductoDAODerby;

import java.sql.Connection;

public class DerbyDAOFactory implements DAOFactory{

    private Connection conexion;

    public DerbyDAOFactory(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteDAODerby(conexion);
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return new ProductoDAODerby(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO() {
        return null;
    }

    @Override
    public Factura_ProductoDAO getFacturaProductoDAO() {
        return null;
    }
}
