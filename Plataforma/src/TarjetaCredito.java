public class TarjetaCredito {
    private Long numero;
    private String banco;
    private String marca;

    public TarjetaCredito(Long numero, String banco, String marca){

        this.numero = numero;
        this.banco = banco;
        this.marca = marca;
        
    }
    public long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
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
    public boolean equals(TarjetaCredito tarjeta){
        if(getNumero() == tarjeta.getNumero()){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return "Numero: " + numero + " - Banco:" + banco;
    }
}
