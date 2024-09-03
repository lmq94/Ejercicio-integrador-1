package daos;

import java.util.List;

public interface DAO<T>{

    void insertar(T elemento) throws Exception;
    void eliminar(T elemento) throws Exception;
    void actualizar (T elemento,T nuevo) throws Exception;
    T getId(T elemento) throws Exception;
    List<T> obtenerTodos() throws Exception;
}
