public class Pasaje {
    private int numeroAsiento;
    private Pasajero pasajero;
    private Servicio servicio;
    private int precio;

    public Pasaje(int numeroAsiento, Servicio servicio, int precio) {
        this.numeroAsiento = numeroAsiento;
        this.pasajero = null;
        this.servicio = servicio;
        this.precio = precio;
    }

    public int getNumeroAsiento() {return numeroAsiento;}
    public Pasajero getPasajero() {return pasajero;}
    public Servicio getServicio() {return servicio;}
    public int getPrecio() {return precio;}
    public void setPasajero(Pasajero pasajero) {this.Pasajero = pasajero;}
    public void nuevoPrecio(int precio){ this.precio=precio;}
    public boolean isDisponible(){return this.pasajero == null;}
}
