package factory;

public class DBFactory {

    public static ConexionFactory getDB(String tipo,String url,String usuario,String contrasena){
        return switch (tipo) {
            case "mysql" -> new MySQLImplementacion(url, usuario, contrasena);
            case "derby" -> new DerbyImplementacion(url, null, null);
            default -> new MySQLImplementacion(url, usuario, contrasena);
        };
    }

}
