import java.util.ArrayList;
import java.util.Scanner;

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

    public TarjetaCredito elegirTarjeta(){
        for(int i = 0; i < tarjetas.size(); i++){           // Muestra por terminal todas las tarjetas con su indice
            System.out.println(i + "- " + tarjetas.get(i));
        }
        System.out.print("Ingresar indice de tarjeta a utilizar: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if (input >= 0 && input < tarjetas.size()){
            return tarjetas.get(input);                    // Retorna la tarjeta elegida
        }else{
            return this.elegirTarjeta();                   // Vuelve a llamar al metodo en el caso de que el input sea invalido
        }
    }
    public void addTarjeta(TarjetaCredito tc){
        if (!tarjetas.contains(tc)){
            tarjetas.add(tc);
        }
    }
    public ArrayList<Compra> getCompras(){
        return (ArrayList<Compra>) compras.clone();
    }

    public Compra elegirCompra(){
        if (compras.isEmpty()){
            return null;
        } else {
            for (int i = 0; i < compras.size(); i++) {
                System.out.println(i + "- " + compras.get(i));
            }
            System.out.print("Ingresar indice de compra a utilizar: ");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();

            if (input >= 0 && input < tarjetas.size()) {
                return compras.get(input);
            } else {
                return this.elegirCompra();
            }
        }
    }

    public void addCompra(Compra c){
        if (!compras.contains(c)){
            compras.add(c);
        }
    }

    public int getCreditoCompra(){
        return this.creditoCompra;
    }

    // Devuelve true si se puede consumir el saldo indicado, falso si no alcanzan los creditos del pasajero.
    public boolean consumirCredito(int monto){
        if (monto < this.getCreditoCompra()) {
            this.creditoCompra -= monto;
            return true;
        } else {
            return false;
        }

    }

    public void addCredito(int monto){
        this.creditoCompra += monto;
    }


}
