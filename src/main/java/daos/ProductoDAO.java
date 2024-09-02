package daos;

import Model.Producto;

import java.util.List;

public abstract class ProductoDAO{

    public abstract void insertar(Producto elemento);


    public abstract List<Producto> obtenerTodos();


    public abstract void eliminar(Producto elemento);


    public abstract void actualizar(Producto elemento);
}
