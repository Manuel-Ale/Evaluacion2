package cl.inacap.Evaluacion2app.controllers;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.Evaluacion2appModel.dao.ClientesDAOLocal;
import cl.inacap.Evaluacion2appModel.dao.SolicitudesDAOLocal;
import cl.inacap.Evaluacion2appModel.dto.Cliente;
import cl.inacap.Evaluacion2appModel.dto.Solicitud;

@WebServlet("/VerSolicitudController.do")
public class VerSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private SolicitudesDAOLocal solicitudesDAO;
	
    public VerSolicitudController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setAttribute("solicitudes", solicitudes.);
		
		request.getRequestDispatcher("WEB-INF/vistas/VerSolicitud.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
