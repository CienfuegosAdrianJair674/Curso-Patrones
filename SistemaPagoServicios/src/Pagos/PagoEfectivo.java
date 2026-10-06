package Pagos;

public class PagoEfectivo extends PagoBase{
    @Override
    public boolean procesar(String cuenta, double monto) {
        System.out.println("Cobrando S/ " + monto + " a la billetera " + cuenta);
        return true;
    }

    @Override
    public boolean reembolsar(String codigoOperacion, double monto) {
        throw new UnsupportedOperationException("No admite reembolso");
    }

    @Override
    public String generarQR(double monto) {
        return "QR-" + monto;
    }

    @Override
    public boolean validarCVV(String cvv) {
        throw new UnsupportedOperationException("No aplica CVV");
    }
}
