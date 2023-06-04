import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        if (plataforma.registrarse()){
            Pasajero pasajero1 = new Pasajero("Fede", "gar", "1234", 33333333);

            TarjetaCredito tarjeta = new TarjetaCredito((double) 45251511, "Galicia", "aa");
            pasajero1.addTarjeta(tarjeta);

            Pasaje p1 = new Pasaje(10, 10);
            p1.setPasajero(pasajero1);

            ArrayList<Pasaje> lista = new ArrayList<Pasaje>();
            lista.add(p1);


            System.out.println("1 con tarjeta o 0 con credito");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input == 1){ // compra con TARJETA
                pasajero1.addCompra(plataforma.crearCompra(pasajero1, lista, pasajero1.elegirTarjeta()));
            }else  if (input == 0){ // compra con CREDITO
                pasajero1.addCompra(plataforma.crearCompra(pasajero1, lista));
            }
            
            Compra aux = pasajero1.elegirCompra();   // PASAJERO ELIGE QUE COMPRA SE REFIERE
            aux.imprimirResumen();                   // SE IMPRIME EL RESUMEN DE LA COMPRA QUE ELIGIO EL PASAJERO
        }
    }
}