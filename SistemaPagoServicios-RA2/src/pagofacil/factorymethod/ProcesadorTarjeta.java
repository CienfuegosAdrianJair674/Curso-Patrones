package pagofacil.factorymethod;

import pagofacil.builder.Recibo;

public class ProcesadorTarjeta implements ProcesadorPago{

    @Override
    public String procesar(Recibo recibo) {
        return "Pago con tarjeta aprobado por " + recibo.getMoneda() + " "
                + String.format("%.2f", recibo.getTotal());
    }
}
