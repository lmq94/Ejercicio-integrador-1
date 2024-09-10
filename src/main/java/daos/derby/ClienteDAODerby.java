package daos.derby;

import DTOs.ClienteDTO;
import daos.mysql.ClienteDAOMySQL;
import model.Cliente;
import daos.ClienteDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAODerby implements ClienteDAO {

    private static ClienteDAODerby instancia;
    private final Connection conexion;

    private ClienteDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

    public static ClienteDAODerby getInstancia(Connection conexion) {
        if (instancia == null) {
            instancia = new ClienteDAODerby(conexion);
        }
        return instancia;
    }

    @Override
    public void insertar(Cliente elemento) throws Exception {
        // Asegúrate de que el número de columnas coincida con el número de valores
        String query = "INSERT INTO Cliente (nombre, email) VALUES (?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            // El número de valores debe coincidir con el número de columnas especificadas
            ps.setString(1, elemento.getNombre());
            ps.setString(2, elemento.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("No se pudo crear el cliente ", e);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() throws Exception {

        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT id, nombre, facturacion FROM Cliente";

        try (Statement statement = conexion.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                int idCLiente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                System.out.println("Recuperados: "+idCLiente+","+nombre+","+email);
                clientes.add(new Cliente(idCLiente,nombre,email));
            }

        } catch (SQLException e) {
            throw new Exception("Error al obtener los clientes: ",e);
        }

        return clientes;
    }

    @Override
    public void eliminar(Cliente elemento) throws Exception {
        String query = "DELETE FROM Cliente WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, elemento.getIdCliente());

            int affectedRow = ps.executeUpdate();
            if (affectedRow == 0) {
                throw new Exception("No se encontró el cliente con id: " + elemento.getIdCliente());
            }
        } catch (Exception e) {
            throw new Exception("No se pudo eliminar al cliente", e);
        }
    }


    @Override
    public void actualizar(Cliente elemento, Cliente nuevo) throws Exception {
        String query = "UPDATE Cliente SET nombre = ?, email = ? WHERE idCLiente = ?";
        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, nuevo.getNombre());
            ps.setString(2, nuevo.getEmail());
            ps.setInt(3, elemento.getIdCliente());

            int affectedRow = ps.executeUpdate();

            if (affectedRow == 0) {
                throw new Exception("No se encontró el cliente con id: " + elemento.getIdCliente());
            }
        } catch (SQLException e) {
            throw new Exception("Error al actualizar el cliente: " + e.getMessage());
        }
    }
    @Override
    public Cliente getId(Cliente elemento) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT id, nombre, email FROM Cliente WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, elemento.getIdCliente());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("No se encontro el cliente",e);
        }

        return cliente;
    }

    @Override
    public List<ClienteDTO> getClientesOrdenadosPorFacturacion() throws Exception {
        String query = "SELECT c.nombre, SUM(fp.cantidad * p.valor) as totalFacturado " +
                "FROM cliente c " +
                "JOIN factura f ON c.idCliente = f.idCliente " +
                "JOIN factura_producto fp ON f.idFactura = fp.idFactura " +
                "JOIN producto p ON fp.idProducto = p.idProducto " +
                "GROUP BY c.nombre " +
                "ORDER BY totalFacturado DESC";

        List<ClienteDTO> clientes = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                clientes.add(new ClienteDTO(
                        rs.getString("nombre"),
                        rs.getFloat("totalFacturado")
                ));
            }
        }
        return clientes;
    }
}
