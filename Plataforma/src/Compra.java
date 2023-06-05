import java.util.ArrayList;

public class Compra {
    private Pasajero comprador;
    private ArrayList<Pasaje> pasajes;
    private TarjetaCredito tarjetaDeCredito;
    private int monto;
    private boolean pagado;

    public Compra(Pasajero comprador,  ArrayList<Pasaje> pasajes) {
        this.comprador = comprador;
        this.pasajes = pasajes;
        this.tarjetaDeCredito = null;
        this.pagado = false;

        int aux = 0;
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

    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }

    public Pasajero getComprador() {
        return comprador;
    }

    public void imprimirResumen(){
        System.out.println("-----RESUMEN DE COMPRA-------");
        System.out.println("Nombre del Comprador: " + comprador.getNombre());
        System.out.println("Monto total: " + monto);

        System.out.print("Forma de pago: ");
        if(tarjetaDeCredito == null){
            System.out.println(" Creditos");
        }else{
            System.out.println(" Tarjeta("  + tarjetaDeCredito.getNumero()+ ")");
        }

        System.out.print("Estado: ");
        if(pagado){
            System.out.println("pagado");
        }else{
            System.out.println(" impago");
        }


        System.out.println("Cantidad de pasajes comprados: " + pasajes.size());
        for (int i = 0; i < pasajes.size(); i++){
            System.out.println("Pasaje - " + i + pasajes.get(i));
        }
    }

    public String toString(){
        return ("Comprador: " + comprador.getNombre() + "/ Cantidad de pasajes: " + pasajes.size());
    }

    public boolean equals(Compra c){ // NECESITO IMPLEMENTARLO :)
        if(getPasajes().containsAll(c.getPasajes())){
            return true;
        } else{
            return false;
        }
    }

    public void setMonto(int monto){
        this.monto = monto;
    }
    public void pagarTarjeta(GestorPagos g) {
        if (this.tarjetaDeCredito != null) {
            this.pagado = g.procesarPago(this.tarjetaDeCredito, this.monto);
        }
    };

    public void pagarCredito(){
        this. pagado = this.comprador.consumirCredito(this.monto);
    }

    public boolean getEstado(){
        return pagado;
    }
}
