import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Plataforma plataforma = new Plataforma();

        Pasajero pasajero1 = new Pasajero("Fede", "gar", "1234", 33333333);

        TarjetaCredito tarjeta1 = new TarjetaCredito((long) 45251511, "Galicia", "Visa");
        pasajero1.addTarjeta(tarjeta1);

        TarjetaCredito tarjeta2 = new TarjetaCredito((long) 44377287, "Macro", "Master");
        pasajero1.addTarjeta(tarjeta2);

        Pasaje pasaje1 = new Pasaje(10, 10);  // SE CREA EL PASAJE

        GestoPagosVisa pagosVisa = new GestoPagosVisa();

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
                        System.out.println("El usuario ya tiene tarjetas precargadas"); // TODO implementar funciones del pasajero
                        input = scanner.nextInt();

                        if (input == 0) {
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados, pasajero1.elegirTarjeta()));
                        } else if (input == 1) {
                            pasajero1.addCompra(plataforma.crearCompra(pasajero1, listaSeleccionados));
                        };
                    } else {
                        System.out.println("No se selecciono ningun pasaje");
                    }
                    break;
                case 2:
                    Compra aux = pasajero1.elegirCompra();   // PASAJERO ELIGE QUE COMPRA SE REFIERE
                    if (aux != null){
                        aux.imprimirResumen(); // SE IMPRIME EL RESUMEN DE LA COMPRA QUE ELIGIO EL PASAJERO

                        if (!aux.getEstado()) {
                            System.out.println("Desea confirmar la compra? y or n");
                            Scanner scanner2 = new Scanner(System.in);
                            String inputS = scanner2.nextLine();

                            if (inputS.equals("y")) {
                                if (aux.getTarjetaDeCredito() == null) {
                                    aux.pagarCredito();
                                    if (aux.getEstado()) {
                                        System.out.println("Compra pagada");
                                    } else {
                                        System.out.println("No se realizo el pago");
                                    }
                                } else {
                                    aux.pagarTarjeta(pagosVisa);
                                }
                            }
                        }
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