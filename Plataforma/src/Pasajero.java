<<<<<<< HEAD
import java.util.ArrayList;

public class Pasajero extends Usuario{
    private ArrayList<TarjetaCredito> tarjetas;
    private ArrayList<Compra> compras;
    private int creditoCompra;

    public Pasajero(String nombre, String apellido, String claveAcceso, int dni){
        super(nombre, apellido, claveAcceso, dni);
        compras = new ArrayList<Compra>();
        tarjetas = new ArrayList<TarjetaCredito>();
    }
    public ArrayList<TarjetaCredito> getTarjetas(){
        return (ArrayList<TarjetaCredito>) tarjetas.clone();
    }

    public void addTarjeta(TarjetaCredito tc){
        if (!tarjetas.contains(tc)){
            tarjetas.add(tc);
        }
    }
    public ArrayList<Compra> getCompras(){
        return (ArrayList<Compra>) compras.clone();
    }
    public void addCompra(Compra c){
        if (!compras.contains(c)){
            compras.add(c);
        }
    }

=======
public class Pasajero {
    
>>>>>>> compra
}
