package cl.inacap.Evaluacion2appModel.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.Evaluacion2appModel.dto.Cliente;

/**
 * Session Bean implementation class ClientesDAO
 */
@Stateless
@LocalBean
public class ClientesDAO implements ClientesDAOLocal {

   private static List<Cliente> clientes = new ArrayList<>();
   
   public ClientesDAO() {
   
    }
   
	@Override
	public List<Cliente> getAll() {
		
		
		return clientes;
	}

	@Override
	public void delete(Cliente cliente) {
		
		
		clientes.remove(cliente);
	}
	
	@Override
	public void save(Cliente cliente) {
		
		
		clientes.add(cliente);
		
	}
	
	@Override
	public List<Cliente> filterByName(String Nombre) {
		
		return clientes.stream().filter(c->c.getNombre().
				contains(Nombre)).collect(Collectors.
						toList());
	}
	 
    
}
