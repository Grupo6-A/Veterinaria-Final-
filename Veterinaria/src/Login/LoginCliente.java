package Login;

public class LoginCliente {
	private int idusuario;
	private String nombre;
	private String Contraseña;
	public LoginCliente(int idusuario, String nombre, String contraseña) {
	
		this.idusuario = idusuario;
		this.nombre = nombre;
		Contraseña = contraseña;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return Contraseña;
	}
	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}
	
	
}
