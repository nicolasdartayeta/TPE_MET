public class Pasaje {
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
}
