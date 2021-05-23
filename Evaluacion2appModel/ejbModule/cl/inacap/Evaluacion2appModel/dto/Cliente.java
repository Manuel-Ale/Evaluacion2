package cl.inacap.Evaluacion2appModel.dto;

import java.util.List;

public class Cliente {
	
	private String Nombre;
	private String rut;
	private List<Solicitud> solicitud;
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	
	
	
	
}
