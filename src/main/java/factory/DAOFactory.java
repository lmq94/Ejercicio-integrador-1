package factory;

import daos.ClienteDAO;
import daos.ProductoDAO;

public interface DAOFactory {

    ClienteDAO getClienteDAO();
    ProductoDAO getProductoDAO();


}
