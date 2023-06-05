import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        Pasajero pasajero1 = new Pasajero("Fede", "gar", "1234", 33333333);

        TarjetaCredito tarjeta = new TarjetaCredito((double) 45251511, "Galicia", "aa");
        pasajero1.addTarjeta(tarjeta);

        Pasaje p1 = new Pasaje(10, 10);  // SE CREA EL PASAJE



        //ELEGIR OPCION

        boolean fin = false;
        ArrayList<Pasaje> listaSeleccionados = new ArrayList<Pasaje>();
        while (!fin) {
            System.out.println(" Seleccionar pasajes [0] | Comprar pasajes seleccionados [1] | Obtener resumen compra [2]");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 0: p1.setPasajero(pasajero1);                          //EL PASAJERO ELIGE LOS PASAJES
                        listaSeleccionados.add(p1);
                        break;
                case 1: System.out.println("Pagar con tarjeta [0] | Pagar con creditos [1]");        //COMPRAR PASAJE
                        input = scanner.nextInt();
                        if (input == 0){
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados, pasajero1.elegirTarjeta()));
                        }else  if (input == 1){
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados));
                        };
                        break;
                case 2: Compra aux = pasajero1.elegirCompra();   // PASAJERO ELIGE QUE COMPRA SE REFIERE
                        aux.imprimirResumen();                   // SE IMPRIME EL RESUMEN DE LA COMPRA QUE ELIGIO EL PASAJERO
                        break;

                default: fin = true;
                        break;//TERMINA
            }
        }
    }
}