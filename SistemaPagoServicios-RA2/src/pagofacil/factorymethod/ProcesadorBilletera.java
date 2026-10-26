package pagofacil.factorymethod;

import pagofacil.builder.Recibo;

public class ProcesadorBilletera implements ProcesadorPago{


    @Override
    public String procesar(Recibo recibo) {
        return "Pago con billetera digital aprobado por " + recibo.getMoneda() + " "
                + String.format("%.2f", recibo.getTotal());
    }
}
