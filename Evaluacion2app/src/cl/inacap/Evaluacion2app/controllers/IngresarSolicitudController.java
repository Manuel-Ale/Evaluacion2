package cl.inacap.Evaluacion2app.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.inacap.Evaluacion2appModel.dto.Cliente;
import cl.inacap.Evaluacion2appModel.dto.Solicitud;
/**
 * Servlet implementation class IngresarSolicitudController
 */
@WebServlet("/IngresarSolicitudController.do")
public class IngresarSolicitudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private SolicitudesDAO solicitudesDAO;
	/**
     * @see HttpServlet#HttpServlet()
     */
    public IngresarSolicitudController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("WEB-INF/vistas/IngresarSolicitud.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> errores = new ArrayList<String>();
		AtomicInteger numSolicitud = new AtomicInteger();
		String rut = request.getParameter("rut-txt").trim();
		if (rut.isEmpty()) {
			errores.add("Ingrese un RUT.");
		} else {
			try {
				String numerosRut = rut.substring(0, rut.length()-2),
						rutInvertido, auxRut, 
						digitoVerificador = rut.substring(rut.length()-1), auxVerificador;
				StringBuilder st = new StringBuilder (numerosRut);
				rutInvertido = st.reverse().toString();
				int multiplicador = 2, sumatoria = 0;

				for (int i = 0; i < rutInvertido.length(); ++i) {
					if (multiplicador > 7) {
						multiplicador = 2;
					}
					auxRut = rutInvertido.substring(i, (i+1));
					sumatoria = sumatoria + Integer.parseInt(auxRut) * multiplicador;
					++multiplicador;
				}
				
				auxVerificador = Integer.toString(11 - (sumatoria % 11));
				
				if (!digitoVerificador.equals(auxVerificador)) {
					errores.add("Rut no valido.");
				}
			} catch (Exception Ex) {
				errores.add("Rut no valido.");
			}
		}
		
		String nombre = request.getParameter("nombre-txt");
		if (nombre.isEmpty()) {
			errores.add("Ingrese nombre valido.");
		} else {
			if (!nombre.contains(" ")) {
				errores.add("Ingrese un nombre valido.");
			}
		}
		
		String tipo = request.getParameter("tipo-txt");
		
		if (errores.isEmpty()) {
			
			Cliente cliente = new Cliente();
			
			Solicitudes solicitud = new Solicitud();
			
			cliente.setRut(rut);
			
			cliente.setNombre(nombre);
			
			solicitud.setTipo(tipo);
			
			solicitud.setCliente(cliente);
			
			solicitud.setNumeroSolicitud(numSolicitud.incrementAndGet());
			
			solicitudesDAO.save(solicitud);
			
		}
		doGet(request, response);
	}
}
