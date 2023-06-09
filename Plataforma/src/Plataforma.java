import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    private static final File ARCHIVOUSUARIOS = new File("Plataforma/src/Archivos/Usuarios.ddr");
    private ArrayList<Pasajero> pasajeros;

    public Plataforma() {
        pasajeros = new ArrayList<Pasajero>();
        this.cargarDatos();
    }

    public Pasajero loginPasajero() {
        System.out.print("Ingresar DNI: ");
        Scanner scanner = new Scanner(System.in);
        int inputDNI = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingresar contrasenia: ");
        String inputContrasenia = scanner.nextLine();

        Pasajero logeado = existePasajero(inputDNI);

        if (logeado != null) {
            boolean datosCorrectos = chequearContrasenia(inputDNI, inputContrasenia);

            if (datosCorrectos)
                System.out.println("Logueado");
            else {
                System.out.println("Contrasenia incorrecta");
                logeado = null;
            }
        } else {
            System.out.println("No existe un usuario con ese DNI");
        }

        return logeado;

    }

    private boolean chequearContrasenia(int inputDNI, String inputContrasenia) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getDni() == inputDNI)
                if (pasajero.getClaveAcceso().equals(inputContrasenia))
                    return true;
                else
                    return false;
        }

        return false;
    }

    private boolean contraseniaValida(String clave){
        char ch;
        boolean mayusc = false;
        boolean minusc= false;
        boolean num = false;
        boolean valido = false;

        if (clave.length() > 7){
            for (int i=0; i< clave.length(); i++){
                ch = clave.charAt(i);
                if (Character.isDigit(ch)){
                    num = true;
                }
                else if (Character.isUpperCase(ch)){
                    mayusc = true;
                }
                else if (Character.isLowerCase(ch)){
                    minusc = true;
                }
            }
        }
        if (minusc && mayusc && num){
            valido = true;
        }

        return valido;
    }

    public boolean registrarPasajero() {
        System.out.println("Registrarse");
        System.out.print("Ingresar DNI: ");
        Scanner scanner = new Scanner(System.in);
        int inputDNI = Integer.parseInt(scanner.nextLine());

        if (existePasajero(inputDNI) == null) {
            System.out.print("Ingresar nombre: ");
            Scanner scanner2 = new Scanner(System.in);
            String inputNombre = scanner2.nextLine();

            System.out.print("Ingresar apellido: ");
            String inputApellido = scanner2.nextLine();

            System.out.print("Ingresar contrasenia: ");
            String inputContrasenia = scanner2.nextLine();

            while (contraseniaValida(inputContrasenia) == false){
                System.out.println("Contraseña no valida");
                System.out.print("Ingresar otra contrasenia: ");
                inputContrasenia = scanner2.nextLine();
            }

            Pasajero aux = new Pasajero(inputNombre, inputApellido, inputContrasenia, inputDNI);
            aux.addCredito(1000);
            pasajeros.add(aux);
            return true;

        } else {
            System.out.println("Ya existe un usuario con ese DNI");
            return false;
        }
    }

    public Pasajero existePasajero(int dni) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getDni() == dni)
                return pasajero;
        }

        return null;
    }

    public Compra crearCompra(Pasajero comprador, ArrayList<Pasaje> pasajes, TarjetaCredito tarjeta) { //Se crea una compra utilizando una tarjeta de credito del comprador
        Compra c1 = new Compra(comprador, pasajes);
        c1.setTarjetaDeCredito(tarjeta);
        return c1;
    }

    public Compra crearCompra(Pasajero comprador, ArrayList<Pasaje> pasajes) {     // Se crea una compra utilizando los creditos del comprador
        Compra c1 = new Compra(comprador, pasajes);
        return c1;
    }

    private boolean addPasajero(Pasajero pasajero) {
        int dniUsuario = pasajero.getDni();
        boolean yaEstaReg = false;

        for (Usuario u : pasajeros) {
            if (u.getDni() == dniUsuario)
                yaEstaReg = true;
        }

        if (!yaEstaReg) {
            pasajeros.add(pasajero);
            return true;
        } else
            return false;
    }

    private void cargarDatos(){
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(ARCHIVOUSUARIOS))) {       //CARGA TODOS LOS PASAJEROS
            while(true){
                Pasajero aux = (Pasajero) input.readObject();
                this.addPasajero(aux);
            }
        } catch(ClassNotFoundException e){
        }catch(EOFException e) {
        }catch (IOException e) {

        }

    };
    public void guardarDatos() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(ARCHIVOUSUARIOS))) {       //GUARDA TODOS LOS PASAJEROS
            for (Pasajero p : pasajeros) {
                output.writeObject(p);
            };
        } catch (IOException e) {
            try {
                Path path = Path.of("Plataforma/src/Archivos");
                Files.createDirectories(path);
                ARCHIVOUSUARIOS.createNewFile();
                this.guardarDatos();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}