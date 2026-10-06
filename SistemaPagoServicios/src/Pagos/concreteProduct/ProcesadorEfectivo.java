package Pagos.concreteProduct;

import Pagos.abstractProduct.ProcesarPago;

public class ProcesadorEfectivo implements ProcesarPago {

    @Override
    public boolean procesar(double monto) {
        System.out.println("[Caja] Recibiendo el efectivo...");
        return monto > 0;
    }
}
