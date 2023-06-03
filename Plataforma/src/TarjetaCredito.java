public class TarjetaCredito {
    private double numero;
    private String banco;
    private String marca;

    public TarjetaCredito(double numero, String banco, String marca){

        this.numero = numero;
        this.banco = banco;
        this.marca = marca;
        
    }
    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}
