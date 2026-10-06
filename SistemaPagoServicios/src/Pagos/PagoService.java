package Pagos;

public class PagoService {
    public void pagar(String servicio, double monto, String tipoPago, String cuenta) {

        if (monto <= 0) {
            System.out.println("Monto inválido");
            return;
        }

        PasarelaPago pasarela;
        if (tipoPago.equals("TARJETA")) {
            pasarela = new PagoTarjeta();
        } else if (tipoPago.equals("BILLETERA")) {
            pasarela = new PagoEfectivo();
        } else {
            System.out.println("Tipo de pago no soportado");
            return;
        }
        boolean ok = pasarela.procesar(cuenta, monto);


        if (ok) {
            String comprobante;
            if (tipoPago.equals("TARJETA")) {
                comprobante = "BOLETA ELECTRÓNICA - " + servicio + " - S/ " + monto;
            } else {
                comprobante = "VOUCHER DIGITAL - " + servicio + " - S/ " + monto;
            }
            System.out.println(comprobante);


            System.out.println("Enviando correo al cliente...");
        }
    }
}
