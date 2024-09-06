package daos.mysql;

import model.Cliente;
import daos.ClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOMySQL implements ClienteDAO {
    private Connection conexion;

    public ClienteDAOMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    //operaciones para cliente dao en mysql


    @Override
    public void actualizar(Cliente elemento, Cliente nuevo) throws Exception {
        String query = "UPDATE cliente SET nombre=?,email=? WHERE idCliente=?";
        //
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, elemento.getNombre());
            ps.setString(2, elemento.getEmail());
            ps.setInt(3,elemento.getIdCliente());

            int affectedRow = ps.executeUpdate();

            if(affectedRow==0){
                throw new Exception("No se encontro el cliente con id: "+elemento.getIdCliente());
            }

        }catch(SQLException e){
            throw new Exception("Error al actualizar el cliente: ",e);
        }
    }

    @Override
    public Cliente getId(Cliente elemento) throws Exception {
        String query = "SELECT * FROM cliente WHERE idCliente=?";

        Cliente cliente =null;

        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdCliente());

            try ( ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                  int idCliente=  rs.getInt("idCliente");
                   String nombre= rs.getString("nombre");
                    String email=rs.getString("email");
                    cliente = new Cliente(idCliente,nombre,email);
                }
            }catch (SQLException e){
                e.printStackTrace();
                throw new Exception("El cliente no existe con el id: "+elemento.getIdCliente());
            }
        }catch(SQLException e){
            throw new Exception("Error al obtener el cliente: ",e);
        }
        return cliente;
    }

    @Override
    public void insertar(Cliente elemento) throws Exception {
        String query = "INSERT INTO cliente(idCliente,nombre,email) VALUES(?,?,?)";
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdCliente());
            ps.setString(2,elemento.getNombre());
            ps.setString(3,elemento.getEmail());
            ps.executeUpdate();

        }catch (SQLException e){
            throw new Exception("Error al insertar el cliente: ",e);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM cliente";
        try ( PreparedStatement ps = conexion.prepareStatement(query);
        ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idCLiente = rs.getInt("idCliente");
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                System.out.println("Recuperados: "+idCLiente+","+nombre+","+email);
                clientes.add(new Cliente(idCLiente,nombre,email));
            }

        }catch (SQLException e){
            throw new Exception("Error al obtener el cliente: ",e);
        }
        return clientes;
    }

    @Override
    public void eliminar(Cliente elemento) throws Exception {
        String query = "DELETE FROM cliente WHERE idCliente=?";
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdCliente());
            int rowsaffected = ps.executeUpdate();

            if (rowsaffected==0){
                throw new Exception("No se encontro el cliente con id: "+elemento.getIdCliente());
            }
        }catch (SQLException e){
            throw new Exception("Error al eliminar el cliente: ",e);
        }
    }


}
