import java.util.ArrayList;
import java.util.Scanner;

public class Plataforma {
    private ArrayList<Usuario> usuarios;

    public Plataforma (){
        usuarios = new ArrayList<Usuario>();
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
