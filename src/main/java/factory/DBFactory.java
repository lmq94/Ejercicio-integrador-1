package factory;

public class DBFactory {

    public static ConexionFactory getDB(String tipo,String url,String usuario,String contrasena){
        switch (tipo){
            case "mysql":
                return new MySQLImplementacion(url,usuario,contrasena);
                break;
            case "derby":
                return new DerbyImplementacion(url,usuario,contrasena);
                break;
            default:
                return new MySQLImplementacion(url,usuario,contrasena);
                break;
        }
    }

}
