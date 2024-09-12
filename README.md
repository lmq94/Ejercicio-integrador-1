
# Proyecto JDBC con MySQL y Derby

## Requisitos previos

Antes de comenzar, asegúrate de tener los siguientes componentes instalados:

- Docker
- Java JDK
- Apache Derby (solo si vas a trabajar con Derby)

## Configuración de la base de datos

### Uso de MySQL con Docker

Para trabajar con MySQL, primero debes levantar un contenedor Docker utilizando el archivo `docker-compose.yml`.

#### Pasos para iniciar el contenedor de MySQL:

1. Asegúrate de tener Docker instalado en tu sistema.
2. Ejecuta el siguiente comando en la raíz del proyecto para levantar el contenedor:
   ```bash
   docker-compose up
Esto pondrá en marcha un contenedor con MySQL en el puerto 3307, listo para ser utilizado en tu aplicación.

#### Uso de Derby

Si prefieres trabajar con Apache Derby, no es necesario un contenedor Docker. La base de datos se creará automáticamente al ejecutar el programa en la configuración de Derby, y estará disponible en el puerto 1527 en localhost.
Cuando ejecutes la aplicación con la configuración de Derby en Main.java, la base de datos será generada automáticamente.
El código de la clase Main está preparado para conectarse a una base de datos a la vez. Por defecto, está configurado para MySQL, pero puedes cambiar fácilmente a Derby modificando ciertos parámetros.

#### Cambiar a Derby

Si quieres usar Derby, debes ajustar los siguientes valores en Main.java:

URL de conexión para Derby: jdbc:derby://localhost:1527/arqui_db;create=true;

Usuario y contraseña: No es necesario establecer credenciales, puedes dejarlos vacíos

Tipo de base de datos: Cambia la variable database a "derby":
   
   ```bash
   String url = "jdbc:derby://localhost:1527/arqui_db;create=true";
   String usuario = "";
   String constraseña = "";
   String database = "derby";
   ```


Uso del DAO: Cambia el DAO a Derby descomentando esta linea de codigo:


   ```bash
   DAOFactory dao = new DerbyDAOFactory(conexion);
   ```


#### Volver a MySQL

Si deseas volver a usar MySQL, simplemente restaura las siguientes configuraciones en Main.java:

URL de conexión para MySQL:

   ```bash
   String url = "jdbc:mysql://localhost:3307/test_db";
   ```

Credenciales de acceso:
   
   ```bash
   String usuario = "root";
   String contrasena = "root";
   ```

Tipo de base de datos:

   ```bash
   String database = "mysql";
   ```

Uso del DAO:

   ```bash
   DAOFactory dao = new MySQLDAOFactory(conexion);
   ```


## Archivos CSV


Los archivos .csv que contienen los datos de prueba están ubicados en el directorio util/CSVs. El programa accede a estos archivos mediante una ruta relativa, por lo que no es necesario moverlos.

En Main.java hay un bloque de código que permite cargar los datos desde los archivos .csv. Esta parte del código está comentada por defecto y solo debe ejecutarse una vez.

Para cargar los datos, descomenta las siguientes líneas en Main.java:
   
   ```bash
   cargador.readProductos();
   cargador.readClientes();
   cargador.readFacturas();
   cargador.readFacturasProductos();
   ```

 Esto insertará los datos en la base de datos utilizando los archivos CSV.
 

## Notas adicionales

Asegúrate de utilizar solo una base de datos a la vez. Si estás utilizando Derby, comenta las configuraciones de MySQL y viceversa.
La carga de datos desde los .csv solo debe realizarse en la primera ejecución del programa.
