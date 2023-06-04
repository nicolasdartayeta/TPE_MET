public class Pasaje {
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 92686f5cafae40384c6ae10b8fa9885d00bd7c3e
    private int numeroAsiento;
    private Pasajero pasajero;
    private Servicio servicio;
    private int precio;

<<<<<<< HEAD
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
=======
    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public int getPrecio() {
        return precio;
    }
>>>>>>> 92686f5cafae40384c6ae10b8fa9885d00bd7c3e
=======
    int numeroAsiento;
    Pasajero pasajero;
    Servicio servicio;
    int precio;
    
    public int getNumAsiento(){
        return  servicio.getAsiento();
    }
    public Pasajero getPasajero(){
        return pasajero;
    }

    public Servicio getServicio(){
        return  servicio;
    }
    public int getPrecio(){
        return precio;
    }
    
    public void setPasajero(Pasajero newPasajero){
        pasajero = newPasajero;
    }

    public void setPrecio(int newPrecio){
        precio = newPrecio;
    }
>>>>>>> compra
}
