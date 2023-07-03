import java.io.Serializable;

public class Pasaje implements Serializable {
    private int numeroAsiento;
    private Pasajero pasajero;
    // TODO private Servicio servicio; cuando se implemente servicio
    private int precio;

    public Pasaje(int numeroAsiento, int precio) {
        this.numeroAsiento = numeroAsiento;
        this.pasajero = null;
        //this.servicio = servicio;
        this.precio = precio;
    }

    public int getNumeroAsiento() {return numeroAsiento;}
    public Pasajero getPasajero() {return pasajero;}

    // TODO public Servicio getServicio() {return servicio;} cuando se implemente servicio

    public int getPrecio() {return precio;}
    public void setPasajero(Pasajero pasajero) {this.pasajero = pasajero;}
    public void nuevoPrecio(int precio){ this.precio=precio;}
    public boolean isDisponible(){return this.pasajero == null;}

    @Override
    public String toString() {
        return (" - Numero de asiento: " + this.getNumeroAsiento() + " - Nombre del pasajero: " + this.getPasajero().getNombre());
    }
}
