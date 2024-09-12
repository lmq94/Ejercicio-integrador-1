package factory.dbs;

public class DBFactory {

    public static ConexionFactory getDB(String tipo,String url,String usuario,String contrasena){
        switch (tipo){
            case "mysql":
                return new MySQLImplementacion(url,usuario,contrasena);

            case "derby":
                return new DerbyImplementacion(url);

            default:
                return new MySQLImplementacion(url,usuario,contrasena);
        }
    }

}
