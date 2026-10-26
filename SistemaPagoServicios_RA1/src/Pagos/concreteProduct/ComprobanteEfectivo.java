package Pagos.concreteProduct;

import Pagos.abstractProduct.ComprobantePago;
import Pagos.modelo.Pago;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ComprobanteEfectivo implements ComprobantePago {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    @Override
    public String generar(Pago pago) {
        return String.format(Locale.US, """
                ===== BOLETA - PAGO EN EFECTIVO =====
                Operación : %s
                DNI       : %s
                Servicio  : %s
                Monto     : S/ %.2f
                Fecha     : %s
                Atendió   : %s
                """,
                pago.getCodigoOperacion(), pago.getDni(), pago.getServicio(),
                pago.getMonto(), pago.getFecha().format(FORMATO), pago.getOperador());
    }
}
