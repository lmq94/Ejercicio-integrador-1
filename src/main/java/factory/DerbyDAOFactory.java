package factory;

import daos.ClienteDAO;
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
}
