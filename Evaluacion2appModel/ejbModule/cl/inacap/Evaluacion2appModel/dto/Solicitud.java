package cl.inacap.Evaluacion2appModel.dto;

public class Solicitud {

	private int numeroSolicitud;
	private String tipo;
	private Cliente cliente;
	
	public int getNumeroSolicitud() {
		return numeroSolicitud;
	}
	public void setNumeroSolicitud(int numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
