package factory;

import daos.ClienteDAO;
import daos.ClienteDAOMySQL;
import daos.ProductoDAO;

import java.sql.Connection;

public class MySQLDAOFactory implements DAOFactory{

    private Connection conexion;

    public MySQLDAOFactory(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new ClienteDAOMySQL(conexion);
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return ProductoDAOMySQL(conexion);
    }
}
