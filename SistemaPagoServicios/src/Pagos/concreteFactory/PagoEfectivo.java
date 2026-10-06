package Pagos.concreteFactory;

import Pagos.abstractFactory.PagoFactory;
import Pagos.abstractProduct.ComprobantePago;
import Pagos.abstractProduct.ProcesarPago;
import Pagos.concreteProduct.ComprobanteEfectivo;
import Pagos.concreteProduct.ProcesadorEfectivo;

public class PagoEfectivo implements PagoFactory {
    @Override
    public ProcesarPago crearProcesador() {
        return new ProcesadorEfectivo();
    }

    @Override
    public ComprobantePago crearComprobante() {
        return new ComprobanteEfectivo();
    }
}
