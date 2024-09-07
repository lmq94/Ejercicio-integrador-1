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
        return ClienteDAOMySQL.getInstancia(conexion);
    }

    @Override
    public ProductoDAO getProductoDAO() {
        return ProductoDAOMySQL.getInstancia(conexion);
    }

    @Override
    public FacturaDAO getFacturaDAO(){
        return FacturaDAOMySQL.getInstancia(conexion);
    }

    @Override
    public Factura_ProductoDAO getFacturaProductoDAO() {
        return Factura_ProductoDAOMySQL.getInstancia(conexion);
    }
}
