package Pagos.concreteProduct;

import Pagos.abstractProduct.ProcesarPago;

public class ProcesadorTarjeta implements ProcesarPago{

    @Override
    public boolean procesar(double monto) {
        System.out.println("[POS] Autorizando pago con tarjeta...");
        return monto > 0;
    }
}
