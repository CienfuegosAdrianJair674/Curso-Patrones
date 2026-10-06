package Pagos;

public interface PasarelaPago {
    boolean procesar(String cuenta, double monto);
    boolean reembolsar(String codigoOperacion, double monto);
    String generarQR(double monto);
    boolean validarCVV(String cvv);
}
