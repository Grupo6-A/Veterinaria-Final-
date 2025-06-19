package Login;

import java.util.ArrayList;

public class LoginPersonal {
	private int idpersonal;
	private String nombre;
	private String contraseña;
	public LoginPersonal(int idpersonal, String nombre, String contraseña) {
	
		this.idpersonal = idpersonal;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}
	public int getIdpersonal() {
		return idpersonal;
	}
	public void setIdpersonal(int idpersonal) {
		this.idpersonal = idpersonal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
}


