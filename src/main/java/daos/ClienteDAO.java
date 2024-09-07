package daos;

import DTOs.ClienteDTO;
import model.Cliente;

import java.util.List;

public interface ClienteDAO extends DAO<Cliente> {
    List<ClienteDTO> getClientesOrdenadosPorFacturacion() throws Exception;

}
