package factory.dbs;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLImplementacion implements ConexionFactory {
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
        return Conexion.getInstancia(url, usuario, contrasena).getConexion();
    }

    @Override
    public void crearTablas(Connection conexion) throws SQLException {
        try (Statement statement = conexion.createStatement()) {
            String queryCliente = "CREATE TABLE IF NOT EXISTS cliente(" +
                    "idCliente INT AUTO_INCREMENT," +
                    "nombre VARCHAR(500)," +
                    "email VARCHAR(150)," +
                    "PRIMARY KEY(idCliente))";

            String queryFactura = "CREATE TABLE IF NOT EXISTS factura(" +
                    "idFactura INT AUTO_INCREMENT," +
                    "idCliente INT," +
                    "PRIMARY KEY(idFactura)," +
                    "FOREIGN KEY(idCliente) REFERENCES cliente(idCliente))";

            String queryProducto = "CREATE TABLE IF NOT EXISTS producto(" +
                    "idProducto INT AUTO_INCREMENT," +
                    "nombre VARCHAR(45)," +
                    "valor FLOAT," +
                    "PRIMARY KEY(idProducto))";

            String queryFacturaProducto = "CREATE TABLE IF NOT EXISTS factura_producto(" +
                    "idFactura INT," +
                    "idProducto INT," +
                    "cantidad INT," +
                    "PRIMARY KEY(idFactura, idProducto)," +
                    "FOREIGN KEY(idFactura) REFERENCES factura(idFactura)," +
                    "FOREIGN KEY(idProducto) REFERENCES producto(idProducto))";

            statement.execute(queryCliente);
            statement.execute(queryFactura);
            statement.execute(queryProducto);
            statement.execute(queryFacturaProducto);
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}