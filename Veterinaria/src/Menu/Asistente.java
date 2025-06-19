package Menu;

public class Asistente {
	private int idAsistente;
	private String dni;
	public Asistente(int idAsistente, String dni) {
	
		this.idAsistente = idAsistente;
		this.dni = dni;
	}
	public int getIdAsistente() {
		return idAsistente;
	}
	public void setIdAsistente(int idAsistente) {
		this.idAsistente = idAsistente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}
