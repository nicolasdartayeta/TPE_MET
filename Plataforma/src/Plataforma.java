import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    private ArrayList<Usuario> usuarios;

    public Plataforma (){
        usuarios = new ArrayList<Usuario>();
    }

    public Usuario login(){
        System.out.println("LOGEARSE");
        System.out.print("Ingresar DNI: ");
        Scanner scanner = new Scanner(System.in);
        int inputDNI = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingresar contrasenia: ");
        String inputContrasenia = scanner.nextLine();

        Usuario logeado = existeUsuario(inputDNI);

        if (logeado != null){
            boolean datosCorrectos = chequearContrasenia(inputDNI, inputContrasenia);
            if (datosCorrectos)
                System.out.println("Logueado");
            else
                System.out.println("Contrasenia incorrecta");
        } else {
            System.out.println("No existe un usuario con ese DNI");

        }
        return logeado;

    }

    private boolean chequearContrasenia(int inputDNI, String inputContrasenia){
        for (Usuario u: usuarios){
            if (u.getDni() == inputDNI)
                if (u.getClaveAcceso() == inputContrasenia)
                    return true;
                else
                    return false;
        }

        return false;
    }
    public boolean registrarse(){
        System.out.println("Registrarse");
        System.out.print("Ingresar DNI: ");
        Scanner scanner = new Scanner(System.in);
        int inputDNI = scanner.nextInt();

        if (existeUsuario(inputDNI) == null){
            System.out.print("Ingresar nombre: ");
            String inputNombre = scanner.nextLine();
            System.out.print("Ingresar contrasenia: ");
            String inputContrasenia = scanner.nextLine();
            System.out.print("Ingresar apellido: ");
            String inputApellido = scanner.nextLine();
            Usuario aux = new Usuario(inputNombre, inputApellido, inputContrasenia, inputDNI);
            usuarios.add(aux);
            return true;

        } else {
            System.out.println("Ya existe un usuario con ese DNI");
            return false;
        }
    }

    public Usuario existeUsuario(int dni){
        for (Usuario u: usuarios){
            if (u.getDni() == dni)
                return u;
        }

        return null;
    }

    public Compra crearCompra(Pasajero comprador, ArrayList<Pasaje> pasajes, TarjetaCredito tarjeta){ //Se crea una compra utilizando una tarjeta de credito del comprador
        Compra c1 = new Compra(comprador, pasajes);
        c1.setTarjetaDeCredito(tarjeta);
        return c1;
    }
    public Compra crearCompra(Pasajero comprador, ArrayList<Pasaje> pasajes){     // Se crea una compra utilizando los creditos del comprador
        Compra c1 = new Compra(comprador, pasajes);
        return c1;
    }

    private boolean addUsuario(Usuario usuario){
        int dniUsuario = usuario.getDni();
        boolean yaEstaReg = false;

        for (Usuario u: usuarios){
            if (u.getDni() == dniUsuario)
                yaEstaReg = true;
        }

        if (!yaEstaReg) {
            usuarios.add(usuario);
            return true;
        } else
            return false;
    }
}
