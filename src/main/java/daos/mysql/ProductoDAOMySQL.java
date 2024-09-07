package daos.mysql;


import DTOs.ProductoDTO;
import model.Producto;
import daos.ProductoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAOMySQL implements ProductoDAO {

    private Connection conexion;
    private static ProductoDAO instance;

    private ProductoDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    public static ProductoDAO getInstancia(Connection conexion) {
        if (instance == null) {
            instance = new ProductoDAOMySQL(conexion);
        }
        return instance;
    }

    //operaciones de dao para producto en msyql


    @Override
    public void insertar(Producto elemento) throws Exception {
        String query = "INSERT INTO producto (idProducto,nombre,valor) VALUES (?,?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1, elemento.getIdProducto());
            ps.setString(2, elemento.getNombre());
            ps.setFloat(3,elemento.getValor());
            ps.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Error al insertar el producto: ",e);
        }
    }

    @Override
    public void eliminar(Producto elemento) throws Exception {
        String query = "DELETE FROM producto WHERE idProducto=?";
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdProducto());
            int rowsaffected = ps.executeUpdate();

            if (rowsaffected==0){
                throw new Exception("No se encontro el producto con id: "+elemento.getIdProducto());
            }
        }catch (SQLException e){
            throw new Exception("Error al eliminar el producto: ",e);
        }
    }

    @Override
    public void actualizar(Producto elemento, Producto nuevo) throws Exception {
        String query = "UPDATE producto SET nombre=?,valor=? WHERE idProducto=?";
        //
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, elemento.getIdProducto());
            ps.setString(2,elemento.getNombre());
            ps.setFloat(3,elemento.getValor());

            int affectedRow = ps.executeUpdate();

            if(affectedRow==0){
                throw new Exception("No se encontro el el producto con id: "+elemento.getIdProducto());
            }

        }catch(SQLException e){
            throw new Exception("Error al actualizar el producto: ",e);
        }
    }

    @Override
    public Producto getId(Producto elemento) throws Exception {
        String query = "SELECT * FROM producto WHERE idProducto=?";

        Producto producto =null;

        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdProducto());

            try ( ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    int idProducto=  rs.getInt("idProducto");
                    String nombre = rs.getString("nombre");
                    Float valor = rs.getFloat("valor");
                    producto = new Producto(idProducto,nombre,valor);
                }
            }catch (SQLException e){
                e.printStackTrace();
                throw new Exception("El producto no existe con el id: "+elemento.getIdProducto());
            }
        }catch(SQLException e){
            throw new Exception("Error al obtener el producto: ",e);
        }
        return producto;
    }

    @Override
    public List<Producto> obtenerTodos() throws Exception {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT * FROM producto";
        try ( PreparedStatement ps = conexion.prepareStatement(query);
              ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idProducto = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                Float valor = rs.getFloat("valor");

                System.out.println("Recuperados: "+idProducto+","+nombre+","+valor);
                productos.add(new Producto(idProducto,nombre,valor));
            }

        }catch (SQLException e){
            throw new Exception("Error al obtener  el producto: ",e);
        }
        return productos;
    }

    @Override
    public ProductoDTO obtenerProductoMasRecaudado() throws Exception {
        String query = "SELECT p.nombre, p.valor, SUM(fp.cantidad) as cantidadVendida, " +
                "SUM(fp.cantidad * p.valor) as recaudacion " +
                "FROM producto p " +
                "JOIN factura_producto fp ON p.idProducto = fp.idProducto " +
                "GROUP BY p.nombre, p.valor " +
                "ORDER BY recaudacion DESC " +
                "LIMIT 1";

        try (PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                return new ProductoDTO(
                        rs.getString("nombre"),
                        rs.getFloat("valor"),
                        rs.getInt("cantidadVendida"),
                        rs.getFloat("recaudacion")
                );
            }
        }
        return null;
    }
}
