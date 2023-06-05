import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        Pasajero pasajero1 = new Pasajero("Fede", "gar", "1234", 33333333);

        TarjetaCredito tarjeta = new TarjetaCredito((double) 45251511, "Galicia", "aa");
        pasajero1.addTarjeta(tarjeta);

        Pasaje pasaje1 = new Pasaje(10, 10);  // SE CREA EL PASAJE



        //ELEGIR OPCION

        boolean fin = false;
        ArrayList<Pasaje> listaSeleccionados = new ArrayList<Pasaje>();

        while (!fin) {
            System.out.println(" Seleccionar pasajes [0] | Comprar pasajes seleccionados [1] | Obtener resumen compra [2] | Otro numero para salir");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            switch (input) {
                case 0:
                    System.out.println("La funcionalidad de seleccionar pasaje no esta implementada. Se elige un pasaje automaticamente.");
                    pasaje1.setPasajero(pasajero1);                          //EL PASAJERO ELIGE LOS PASAJES
                    listaSeleccionados.add(pasaje1);
                    break;
                case 1:
                    if (!listaSeleccionados.isEmpty()) {
                        System.out.println("Pagar con tarjeta [0] | Pagar con creditos [1]");        //COMPRAR PASAJE
                        input = scanner.nextInt();

                        if (input == 0) {
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados, pasajero1.elegirTarjeta()));
                        } else if (input == 1) {
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados));
                        }
                        ;
                    } else {
                        System.out.println("No se selecciono ningun pasaje");
                    }
                    break;
                case 2:
                    Compra aux = pasajero1.elegirCompra();   // PASAJERO ELIGE QUE COMPRA SE REFIERE
                    if (aux != null){
                        aux.imprimirResumen();                   // SE IMPRIME EL RESUMEN DE LA COMPRA QUE ELIGIO EL PASAJERO
                    } else {
                        System.out.println("No se tienen compras");
                    }
                    break;

                default: fin = true;
                        break;//TERMINA
            }
        }
    }
}