package cl.inacap.Evaluacion2appModel.dao;

import java.util.List;

import javax.ejb.Local;

import cl.inacap.Evaluacion2appModel.dto.Solicitud;

@Local
public interface SolicitudesDAOLocal {


	void save (Solicitud solicitud);
	List<Solicitud> getAll();
	void delete (Solicitud solicitud);
	List<Solicitud> filterByNumber (int numeroSolicitud);
	
}
