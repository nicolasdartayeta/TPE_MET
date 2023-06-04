import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    private ArrayList<Usuario> usuarios;

    public Plataforma (){
        usuarios = new ArrayList<Usuario>();
    }

    public boolean login(){
        System.out.println("LOGEARSE");
        System.out.print("Ingresar nombre: ");
        Scanner scanner = new Scanner(System.in);
        String inputNombre = scanner.nextLine();
        System.out.print("Ingresar contrasenia: ");
        String inputContrasenia = scanner.nextLine();

        if (existeUsuario(inputNombre, inputContrasenia)){
            System.out.println("INGRESADO");
            return true;
        }else{
            System.out.println(" datos erroneos");
            return false;
        }
    }
    public boolean registrarse(){
        System.out.println("Registrarse");
        System.out.print("Ingresar nombre: ");
        Scanner scanner = new Scanner(System.in);
        String inputNombre = scanner.nextLine();
        System.out.print("Ingresar contrasenia: ");
        String inputContrasenia = scanner.nextLine();

        if (existeUsuario(inputNombre, inputContrasenia)){
            System.out.println("YA EXISTE");
            return false;
        }else{
            System.out.print("Ingresar apellido: ");
            String inputApellido = scanner.nextLine();
            System.out.print("Ingresar DNI: ");
            int inputDNI = scanner.nextInt();
            Usuario aux = new Usuario(inputNombre, inputApellido, inputContrasenia, inputDNI);
            usuarios.add(aux);
            return true;
        }
    }

    public boolean existeUsuario(String nombre, String contrasenia){
        for(int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).getNombre().equals(nombre) && usuarios.get(i).getClaveAcceso().equals(contrasenia)){
                return true;
            }
        }
        return false;
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

}
