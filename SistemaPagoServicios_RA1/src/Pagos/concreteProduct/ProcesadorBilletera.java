package Pagos.concreteProduct;

import Pagos.abstractProduct.ProcesarPago;

public class ProcesadorBilletera implements ProcesarPago {
    @Override
    public boolean procesar(double monto) {
        System.out.println("[QR] Confirmando pago con billetera digital...");
        return monto > 0;
    }
}
