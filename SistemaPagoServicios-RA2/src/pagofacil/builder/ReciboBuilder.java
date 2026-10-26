package pagofacil.builder;

public interface ReciboBuilder {

    ReciboBuilder cliente(String cliente);
    ReciboBuilder servicios(String descripcion);
    ReciboBuilder montos(double montoBase, double montoTotal);
    ReciboBuilder moneda(String moneda);
    ReciboBuilder medioPago(String medioPago);
    Recibo build();
}
