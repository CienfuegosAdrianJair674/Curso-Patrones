package Pagos.modelo;

public enum MetodoPago {
    EFECTIVO("Efectivo"),
    TARJETA("Tarjeta"),
    BILLETERA("Billetera digital");

    private final String descripcion;

    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
