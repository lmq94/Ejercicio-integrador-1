package factory.daos;

import daos.ClienteDAO;
import daos.FacturaDAO;
import daos.Factura_ProductoDAO;
import daos.ProductoDAO;
import daos.derby.ClienteDAODerby;
import daos.derby.FacturaDAODerby;
import daos.derby.FacturaProductoDAODerby;
import daos.derby.ProductoDAODerby;

import java.sql.Connection;

public class DerbyDAOFactory implements DAOFactory{

    private Connection conexion;

    public DerbyDAOFactory(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return ClienteDAODerby.getInstancia(conexion);
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return ProductoDAODerby.getInstancia(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO() {return FacturaDAODerby.getInstancia(conexion);}

    @Override
    public Factura_ProductoDAO getFacturaProductoDAO() {
        return FacturaProductoDAODerby.getInstancia(conexion);
    }
}
