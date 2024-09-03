package daos.derby;

import Model.Cliente;
import daos.ClienteDAO;

import java.sql.Connection;
import java.util.List;

public class ClienteDAODerby implements ClienteDAO {

    private Connection conexion;

    public ClienteDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

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
    public void actualizar(Cliente elemento,Cliente nuevo) {

    }

    @Override
    public Cliente getId(Cliente elemento) {
        return null;
    }
}
