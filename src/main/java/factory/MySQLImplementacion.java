package factory;

import conexion.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

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

    }
}
