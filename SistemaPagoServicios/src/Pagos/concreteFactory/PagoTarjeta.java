package Pagos.concreteFactory;

import Pagos.abstractFactory.PagoFactory;
import Pagos.abstractProduct.ComprobantePago;
import Pagos.abstractProduct.ProcesarPago;
import Pagos.concreteProduct.ComprobanteTarjeta;
import Pagos.concreteProduct.ProcesadorTarjeta;

public class PagoTarjeta implements PagoFactory {
    @Override
    public ProcesarPago crearProcesador() {
        return new ProcesadorTarjeta();
    }

    @Override
    public ComprobantePago crearComprobante() {
        return new ComprobanteTarjeta();
    }
}
