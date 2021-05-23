package cl.inacap.Evaluacion2appModel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import cl.inacap.Evaluacion2appModel.dto.Solicitud;

/**
 * Session Bean implementation class SolicitudesDAO
 */
@Stateless
@LocalBean
public class SolicitudesDAO implements SolicitudesDAOLocal {

	private static List<Solicitud> solicitudes = new ArrayList<>();
	
    public SolicitudesDAO() {
    	
    }
    
	
	@Override
	public List<Solicitud> getAll() {
	
		
		return solicitudes;
	}

	@Override
	public void delete(Solicitud solicitud) {
		
		
		solicitudes.remove(solicitud);		
	}
	
	@Override
	public void save(Solicitud solicitud) {
		
		
		solicitudes.add(solicitud);
	}

	@Override
	public List<Solicitud> filterByNumber(int numeroSolicitud) {
		
		
		return null;
	}
	  /**
     * Default constructor. 
     */
    
}
