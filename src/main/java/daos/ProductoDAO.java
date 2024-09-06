package daos;

import model.Producto;

import java.util.List;

public interface ProductoDAO extends DAO<Producto>{
    Producto obtenerProductoMasRecaudado();

}
