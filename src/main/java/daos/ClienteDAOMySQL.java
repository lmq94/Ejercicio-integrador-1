package daos;

import Model.Cliente;

import java.sql.Connection;
import java.util.List;

public class ClienteDAOMySQL extends ClienteDAO {
    private Connection conexion;

    public ClienteDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    //operaciones para cliente dao en mysql


    @Override
    public void insertar(Cliente elemento) {

    }

    @Override
    public List<Cliente> obtenerTodos() {
        return List.of();
    }

    @Override
    public void eliminar(Cliente elemento) {

    }

    @Override
    public void actualizar(Cliente elemento) {

    }
}
