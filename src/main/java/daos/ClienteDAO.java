package daos;

import Model.Cliente;

import java.util.List;

public abstract class ClienteDAO {

    public abstract void insertar(Cliente elemento);


    public abstract List<Cliente> obtenerTodos();


    public abstract void eliminar(Cliente elemento);


    public abstract void actualizar(Cliente elemento);
}
