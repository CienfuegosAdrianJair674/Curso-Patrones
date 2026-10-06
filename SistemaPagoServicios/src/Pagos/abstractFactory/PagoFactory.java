package Pagos.abstractFactory;

import Pagos.abstractProduct.ComprobantePago;
import Pagos.abstractProduct.ProcesarPago;

public interface PagoFactory {
    ProcesarPago crearProcesador();
    ComprobantePago crearComprobante();
}
