package util;

import model.Factura;
import model.Factura_Producto;
import daos.FacturaDAO;
import daos.Factura_ProductoDAO;
import model.Cliente;
import daos.ClienteDAO;
import daos.ProductoDAO;
import factory.daos.DAOFactory;
import model.Producto;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;

public class LoadCsv {

    private DAOFactory daoFactory;

    private String fileClientes = "src/main/java/util/CSVs/clientes.csv";
    private String fileFacturas = "src/main/java/util/CSVs/facturas.csv";
    private String fileProductos = "src/main/java/util/CSVs/productos.csv";
    private String fileFacturas_Productos = "src/main/java/util/CSVs/facturas-productos.csv";

    public LoadCsv(DAOFactory daoFactory) throws Exception {
        this.daoFactory = daoFactory;
    }

    public void readProductos() throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileProductos));

        ProductoDAO producto = daoFactory.getProductoDAO();

        for(CSVRecord row: parser) {
            Producto nuevo= new Producto(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Float.parseFloat(row.get("valor")));
            //producto.insertar(new Producto(Integer.parseInt(row.get("idProducto")),row.get("nombre"),Float.parseFloat(row.get("valor"))));
            producto.insertar(nuevo);
        }
    }

    public void readClientes()throws Exception {
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileClientes));

        ClienteDAO cliente = daoFactory.getClienteDAO();

        for(CSVRecord row:parser){
            Cliente nuevo= new Cliente(Integer.parseInt(row.get("idCliente")),row.get("nombre"),row.get("email"));

            cliente.insertar(nuevo);
        }

    }

    public void readFacturas()throws Exception{
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileFacturas));

        FacturaDAO factura = daoFactory.getFacturaDAO();
        for(CSVRecord row:parser){
            Factura nuevo= new Factura(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idCliente")));

            factura.insertar(nuevo);
        }
    }

    public void readFacturasProductos() throws Exception{
        CSVParser parser = CSVFormat.DEFAULT.withHeader().parse(new FileReader(fileFacturas_Productos));
        Factura_ProductoDAO facturaProducto=daoFactory.getFacturaProductoDAO();
        for(CSVRecord row:parser){
            Factura_Producto nuevo= new Factura_Producto(Integer.parseInt(row.get("idFactura")),Integer.parseInt(row.get("idProducto")),Integer.parseInt(row.get("cantidad")));

            facturaProducto.insertar(nuevo);
        }
    }



}
