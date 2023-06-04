import java.util.ArrayList;

public class Compra {
    Pasajero comprador;
    ArrayList<Pasaje> pasajes;
    TarjetaCredito tarjeta;
    int monto;

    public void setTarjeta(TarjetaCredito newTarjeta){
        tarjeta = newTarjeta;
    }
    public void setMonto(int newMonto){
        monto = newMonto;
    }
    public void addPasaje(Pasaje newPasaje){
        pasajes.add(newPasaje);
    }
    public boolean pagar(GestorPagos g){
        return g.procesarPago(this.tarjeta, this.monto);
    }
}
