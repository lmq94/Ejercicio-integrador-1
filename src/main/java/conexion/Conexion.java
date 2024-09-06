package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instancia;
    private Connection conexion;
    private String url;
    private String usuario;
    private String contrasena;

    private Conexion(String url,String usuario,String contrasena)throws SQLException{
        try {
            this.url=url;
            this.usuario=usuario;
            this.contrasena=contrasena;
            this.conexion= DriverManager.getConnection(url,usuario,contrasena);
        }catch (SQLException e){
                System.out.println("Error SQL: " + e.getMessage());
                throw new SQLException("No se pudo conectar a la base", e);
        }
    }

    public Connection getConexion(){
        return conexion;
    }

    public static Conexion getInstancia(String url,String usuario,String contrasena)throws SQLException{
        if(instancia==null)
            instancia=new Conexion(url,usuario,contrasena);
        return instancia;
    }
}
