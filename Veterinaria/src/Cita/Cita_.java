package Cita;

public class Cita_ {
	private int idCita;
	private String hora;
	private int idUsuario;
	private String fecha;
	private String urgencias;
	private String observaciones;
	public Cita_(int idCita, String hora, int idUsuario, String fecha, String urgencias, String observaciones) {


		this.idCita = idCita;
		this.hora = hora;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.urgencias = urgencias;
		this.observaciones = observaciones;
	}
	public int getIdCita() {
		return idCita;
	}
	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getUrgencias() {
		return urgencias;
	}
	public void setUrgencias(String urgencias) {
		this.urgencias = urgencias;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
}
