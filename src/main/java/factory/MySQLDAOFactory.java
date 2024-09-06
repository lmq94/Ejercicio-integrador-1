package factory;

import daos.ClienteDAO;
import daos.FacturaDAO;
import daos.Factura_ProductoDAO;
import daos.mysql.ClienteDAOMySQL;
import daos.ProductoDAO;
import daos.mysql.FacturaDAOMySQL;
import daos.mysql.Factura_ProductoDAOMySQL;
import daos.mysql.ProductoDAOMySQL;

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
        return new ProductoDAOMySQL(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO(){
        return new FacturaDAOMySQL(conexion);
    }

    @Override
    public Factura_ProductoDAO getFacturaProductoDAO() {
        return new Factura_ProductoDAOMySQL(conexion);
    }
}
