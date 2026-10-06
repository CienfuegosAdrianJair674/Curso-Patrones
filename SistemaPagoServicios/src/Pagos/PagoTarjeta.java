package Pagos;

public class PagoTarjeta extends PagoBase{
    @Override
    public boolean procesar(String cuenta, double monto) {
        System.out.println("Cobrando S/ " + monto + " a la tarjeta " + cuenta);
        return true;
    }

    @Override
    public boolean reembolsar(String cod, double monto) {
        System.out.println("Reembolso tarjeta " + cod);
        return true;
    }

    @Override
    public String generarQR(double monto) {
        throw new UnsupportedOperationException("La tarjeta no usa QR");
    }

    @Override
    public boolean validarCVV(String cvv) {
        return cvv.length() == 3;
    }
}
