package daos;

import java.util.List;

public interface DAO<T>{

    void insertar(T elemento);
    void eliminar(T elemento);
    void update (T elemento,T nuevo);
    T getId(int id);
    List<T> obtenerTodos();
}
