package factory;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLImplementacion implements ConexionFactory{
    private String url;
    private String usuario;
    private String contrasena;

    public MySQLImplementacion(String url, String usuario, String contrasena) {
        this.url = url;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        return Conexion.getInstancia(url,usuario,contrasena).getConexion();
    }

    @Override
    public void crearTablas(Connection conexion) throws SQLException {
            try (Statement statement = conexion.createStatement()) {
                    String queryCliente = "CREATE TABLE IF NOT EXISTS cliente("+"idCliente INT," +
                            "nombre VARCHAR(500)," +
                            "email VARCHAR(150)," +
                            "PRIMARY KEY(idCliente))";

                    String queryFactura=" CREATE TABLE IF NOT EXISTS factura(" +"idFactura INT," +
                            "idCliente INT," +
                            "PRIMARY KEY(idFactura)," +
                            "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";
                    String queryProducto = "CREATE TABLE IF NOT EXISTS producto("+"idProducto INT," +
                            "nombre VARCHAR(45)," +
                            "valor FLOAT," +
                            "PRIMARY KEY(idProducto))";
                    String queryfactura_producto = "CREATE TABLE IF NOT EXISTS factura_producto("+"idFactura INT," +
                            "idProducto INT," +
                            "cantidad INT," +
                            "FOREIGN KEY(idFactura,idProducto) REFERENCES factura(idFactura),producto(idProducto))";

                    statement.execute(queryCliente);
                    statement.execute(queryFactura);
                    statement.execute(queryProducto);
                    statement.execute(queryfactura_producto);
            }catch (SQLException e){
                throw new SQLException(e);
            }
    }
}
