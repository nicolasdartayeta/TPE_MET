public interface GestorPagos {
    public abstract boolean procesarPago(TarjetaCredito t, Integer monto);
}
