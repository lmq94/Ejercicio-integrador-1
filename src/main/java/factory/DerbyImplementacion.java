package factory;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DerbyImplementacion implements ConexionFactory {

    private String url;

    public DerbyImplementacion(String url,String usuario,String contrasena) {
        this.url = url;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        return Conexion.getInstancia(url).getConexion();
    }


    @Override
    public void crearTablas(Connection conexion) throws SQLException {
        try (Statement statement = conexion.createStatement()) {
            String queryCliente = "CREATE TABLE cliente (" +
                    "idCliente INT GENERATED ALWAYS AS IDENTITY," +
                    "nombre VARCHAR(500)," +
                    "email VARCHAR(150)," +
                    "PRIMARY KEY (idCliente))";

            String queryFactura = "CREATE TABLE factura (" +
                    "idFactura INT GENERATED ALWAYS AS IDENTITY," +
                    "idCliente INT," +
                    "PRIMARY KEY (idFactura)," +
                    "FOREIGN KEY (idCliente) REFERENCES cliente(idCliente))";

            String queryProducto = "CREATE TABLE producto (" +
                    "idProducto INT GENERATED ALWAYS AS IDENTITY," +
                    "nombre VARCHAR(45)," +
                    "valor FLOAT," +
                    "PRIMARY KEY (idProducto))";

            String queryFacturaProducto = "CREATE TABLE factura_producto (" +
                    "idFactura INT," +
                    "idProducto INT," +
                    "cantidad INT," +
                    "PRIMARY KEY (idFactura, idProducto)," +
                    "FOREIGN KEY (idFactura) REFERENCES factura(idFactura)," +
                    "FOREIGN KEY (idProducto) REFERENCES producto(idProducto))";

            // Intentar crear las tablas, manejando excepciones si las tablas ya existen
            try {
                statement.execute(queryCliente);
            } catch (SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) { // Error code for table already exists
                    throw e;
                }
            }

            try {
                statement.execute(queryFactura);
            } catch (SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) {
                    throw e;
                }
            }

            try {
                statement.execute(queryProducto);
            } catch (SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) {
                    throw e;
                }
            }

            try {
                statement.execute(queryFacturaProducto);
            } catch (SQLException e) {
                if (!e.getSQLState().equals("X0Y32")) {
                    throw e;
                }
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }




}
