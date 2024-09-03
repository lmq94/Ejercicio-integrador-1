package daos.mysql;

import Model.Cliente;
import daos.ClienteDAO;

import java.sql.Connection;
import java.util.List;

public class ClienteDAOMySQL implements ClienteDAO {
    private Connection conexion;

    public ClienteDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    //operaciones para cliente dao en mysql


    @Override
    public void actualizar(Cliente elemento, Cliente nuevo) throws Exception {

    }

    @Override
    public Cliente getId(Cliente elemento) throws Exception {
        return null;
    }

    @Override
    public void insertar(Cliente elemento) throws Exception {

    }

    @Override
    public List<Cliente> obtenerTodos() throws Exception {
        return List.of();
    }

    @Override
    public void eliminar(Cliente elemento) throws Exception {

    }


}
