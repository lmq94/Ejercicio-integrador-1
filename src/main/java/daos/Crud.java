package daos;

import java.util.List;

public interface Crud<T> {
    void insertar(T elemento);
    List<T> obtenerTodos();
    void eliminar(T elemento);
    void actualizar(T elemento);

}
