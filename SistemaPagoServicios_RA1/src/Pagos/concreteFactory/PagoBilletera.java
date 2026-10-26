package Pagos.concreteFactory;

import Pagos.abstractFactory.PagoFactory;
import Pagos.abstractProduct.ComprobantePago;
import Pagos.abstractProduct.ProcesarPago;
import Pagos.concreteProduct.ComprobanteBilletera;
import Pagos.concreteProduct.ProcesadorBilletera;

public class PagoBilletera implements PagoFactory {
    @Override
    public ProcesarPago crearProcesador() {
        return new ProcesadorBilletera();
    }

    @Override
    public ComprobantePago crearComprobante() {
        return new ComprobanteBilletera();
    }
}
