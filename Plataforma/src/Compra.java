import java.util.ArrayList;

public class Compra {
    private Pasajero comprador;
    private ArrayList<Pasaje> pasajes;
    private TarjetaCredito tarjetaDeCredito;
    private float monto;
    private boolean pagado;

    public Compra(Pasajero comprador,  ArrayList<Pasaje> pasajes) {
        this.comprador = comprador;
        this.pasajes = pasajes;
        this.tarjetaDeCredito = null;
        this.pagado = false;

        float aux = 0;
        for (int i = 0; i < pasajes.size(); i++){
            aux = aux + pasajes.get(i).getPrecio();
        }
        monto = aux;
    }

    public TarjetaCredito getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    public void setTarjetaDeCredito(TarjetaCredito tarjetaDeCredito) {  //Agrega una tarjeta de credito
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

    public boolean equals(Compra c){ // NECESITO IMPLEMENTARLO :)

    }

}
