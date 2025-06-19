package Login;

import java.util.ArrayList;
import Registro_Cliente.RegistroCliente;

public class Array_Personal_Cliente {
    private ArrayList<LoginPersonal> lpersonal;
    private ArrayList<RegistroCliente> rcliente;

    public Array_Personal_Cliente() {
        rcliente = new ArrayList<>();
        lpersonal = new ArrayList<>();
        AdicionarPersonal(new LoginPersonal(111, "111", "111"));
        AdicionarPersonal(new LoginPersonal(101, "Jose", "1"));
        AdicionarCliente(new RegistroCliente(99, "Marta", "Lopez", 12345678, "marta@gmail.com", 987654321, "123"));
    }

    public void AdicionarPersonal(LoginPersonal a) { lpersonal.add(a); }
    public void AdicionarCliente(RegistroCliente nuevo) { rcliente.add(nuevo); }
    public LoginPersonal ObtenerPersonal(int x) { return lpersonal.get(x); }
    public RegistroCliente ObtenerCliente(int x) { return rcliente.get(x); }
    public int TamañoPersonal() { return lpersonal.size(); }
    public int TamañoCliente() { return rcliente.size(); }
}
