package daos;

import DTOs.ProductoDTO;
import model.Producto;

import java.util.List;

public interface ProductoDAO extends DAO<Producto>{
    ProductoDTO obtenerProductoMasRecaudado() throws Exception;

}
