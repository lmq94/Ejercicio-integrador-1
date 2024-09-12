package daos.derby;

import model.Factura;
import daos.FacturaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAODerby implements FacturaDAO {
    private Connection conexion;

    private static FacturaDAODerby instancia;

    private FacturaDAODerby(Connection conexion) {
        this.conexion = conexion;
    }

    public static FacturaDAODerby getInstancia(Connection conexion) {
        if (instancia == null) {
            instancia = new FacturaDAODerby(conexion);
        }
        return instancia;
    }


    @Override
    public void insertar(Factura factura) throws Exception {
        String query = "INSERT INTO Factura (idCliente) VALUES (?)";

        try (PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, factura.getIdCliente());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("No se pudo insertar la factura", e);
        }
    }

    @Override
    public void eliminar(Factura elemento) throws Exception  {
        String query = "DELETE FROM factura WHERE idFactura=?";
        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdFactura());
            int rowsaffected = ps.executeUpdate();

            if (rowsaffected==0){
                throw new Exception("No se encontro la factura con id: "+elemento.getIdFactura());
            }
        }catch (SQLException e){
            throw new Exception("Error al eliminar la factura: ",e);
        }
    }

    @Override
    public void actualizar(Factura elemento, Factura nuevo) throws Exception {
        String query = "UPDATE factura SET idCliente=? WHERE idFactura=?";
        //
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, elemento.getIdFactura());
            ps.setInt(2,elemento.getIdCliente());

            int affectedRow = ps.executeUpdate();

            if(affectedRow==0){
                throw new Exception("No se encontro el numero de factura con id: "+elemento.getIdCliente());
            }

        }catch(SQLException e){
            throw new Exception("Error al actualizar la factura: ",e);
        }

    }

    @Override
    public Factura getId(Factura elemento) throws Exception{
        String query = "SELECT * FROM factura WHERE idFactura=?";

        Factura factura =null;

        try(PreparedStatement ps = conexion.prepareStatement(query)){
            ps.setInt(1,elemento.getIdFactura());

            try ( ResultSet rs = ps.executeQuery()){
                if (rs.next()){
                    int idFactura=  rs.getInt("idFactura");
                    int idCliente = rs.getInt("idCliente");
                    factura = new Factura(idFactura,idCliente);
                }
            }catch (SQLException e){
                throw new Exception("La factura no existe con el id: "+elemento.getIdCliente());
            }
        }catch(SQLException e){
            throw new Exception("Error al obtener la factura: ",e);
        }
        return factura;
    }

    @Override
    public List<Factura> obtenerTodos() throws Exception {
        List<Factura> facturas = new ArrayList<>();
        String query = "SELECT * FROM factura";
        try ( PreparedStatement ps = conexion.prepareStatement(query);
              ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                int idFactura = rs.getInt("idFactura");
                int idCliente = rs.getInt("idCliente");

                System.out.println("Recuperados: "+idFactura+","+idCliente);
                facturas.add(new Factura(idFactura,idCliente));
            }

        }catch (SQLException e){
            throw new Exception("Error al obtener las factura: ",e);
        }
        return facturas;
    }
}
