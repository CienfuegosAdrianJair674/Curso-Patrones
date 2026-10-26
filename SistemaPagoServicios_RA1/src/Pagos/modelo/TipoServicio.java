package Pagos.modelo;

public enum TipoServicio {

    LUZ("Luz"),
    AGUA("Agua"),
    INTERNET("Internet"),
    TELEFONIA("Telefonía");

    private final String descripcion;

    TipoServicio(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
