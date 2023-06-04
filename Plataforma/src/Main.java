import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();
        Pasajero pasajero1 = new Pasajero("Fede", "gar", "1234", 33333333);

        TarjetaCredito tarjeta = new TarjetaCredito(1232131313, "Galicia", "aa");
        pasajero1.addTarjeta(tarjeta);

        Pasaje p1 = new Pasaje(10, 10);
        p1.setPasajero(pasajero1);

        ArrayList<Pasaje> lista = new ArrayList<Pasaje>();
        lista.add(p1);


        System.out.println("1 con tarjeta o 0 con credito");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")){ // TARJETA
            plataforma.crearCompra(pasajero1, lista, pasajero1.elegirTarjeta());
        }else  if (input.equals("0")){
            plataforma.crearCompra(pasajero1, lista);
        }

    }
}