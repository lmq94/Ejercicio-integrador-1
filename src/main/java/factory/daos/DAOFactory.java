package factory.daos;

import daos.ClienteDAO;
import daos.FacturaDAO;
import daos.Factura_ProductoDAO;
import daos.ProductoDAO;

public interface DAOFactory {

    ClienteDAO getClienteDAO();
    ProductoDAO getProductoDAO();
    FacturaDAO getFacturaDAO();
    Factura_ProductoDAO getFacturaProductoDAO();

}
