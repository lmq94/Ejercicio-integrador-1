package daos.mysql;

import model.Factura_Producto;
import daos.Factura_ProductoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Factura_ProductoDAOMySQL implements Factura_ProductoDAO {
    private Connection conexion;

    private static Factura_ProductoDAO instance;

    public Factura_ProductoDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    public static Factura_ProductoDAO getInstancia(Connection conexion) {
        if (instance == null) {
            instance = new Factura_ProductoDAOMySQL(conexion);
        }
        return instance;
    }

    @Override
    public void insertar(Factura_Producto elemento) throws Exception {
        String query = "INSERT INTO factura_producto (idFactura, idProducto, cantidad) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, elemento.getIdFactura());
            stmt.setInt(2, elemento.getIdProducto());
            stmt.setInt(3, elemento.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al insertar factura_producto", e);
        }
    }

    @Override
    public void eliminar(Factura_Producto elemento) throws Exception {
        String query = "DELETE FROM factura_producto WHERE idFactura = ? AND idProducto = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, elemento.getIdFactura());
            stmt.setInt(2, elemento.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al eliminar factura_producto", e);
        }
    }

    @Override
    public void actualizar(Factura_Producto elemento, Factura_Producto nuevo) throws Exception {
        String query = "UPDATE factura_producto SET cantidad = ? WHERE idFactura = ? AND idProducto = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, nuevo.getCantidad());
            stmt.setInt(2, elemento.getIdFactura());
            stmt.setInt(3, elemento.getIdProducto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar factura_producto", e);
        }
    }

    @Override
    public Factura_Producto getId(Factura_Producto elemento) throws Exception {
        String query = "SELECT * FROM factura_producto WHERE idFactura = ? AND idProducto = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(query)) {
            stmt.setInt(1, elemento.getIdFactura());
            stmt.setInt(2, elemento.getIdProducto());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Factura_Producto(rs.getInt("idFactura"), rs.getInt("idProducto"), rs.getInt("cantidad"));
                }
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener factura_producto", e);
        }
        return null;
    }

    @Override
    public List<Factura_Producto> obtenerTodos() throws Exception {
        List<Factura_Producto> lista = new ArrayList<>();
        String query = "SELECT * FROM factura_producto";
        try (PreparedStatement stmt = conexion.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Factura_Producto facturaProducto = new Factura_Producto(
                        rs.getInt("idFactura"),
                        rs.getInt("idProducto"),
                        rs.getInt("cantidad")
                );
                lista.add(facturaProducto);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener todos los registros de factura_producto", e);
        }
        return lista;
    }
}
