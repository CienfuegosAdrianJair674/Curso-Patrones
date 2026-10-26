package Pagos.abstractProduct;

import Pagos.modelo.Pago;

public interface ComprobantePago {
    String generar(Pago pago);
}
