package pagofacil.adapter;

import pagofacil.factorymethod.ProcesadorPago;
import pagofacil.builder.Recibo;

public class AdaptadorPasarela implements ProcesadorPago {

    private PasarelaExterna pasarela;

    public AdaptadorPasarela(PasarelaExterna pasarela) {
        this.pasarela = pasarela;
    }

    @Override
    public String procesar(Recibo recibo) {
        boolean aprobado = pasarela.realizarTransaccion(recibo.getTotal(), recibo.getMoneda());
        if (aprobado) {
            return "Pago aprobado por la pasarela externa por " + recibo.getMoneda() + " "
                    + String.format("%.2f", recibo.getTotal());
        }
        return "Pago rechazado por la pasarela externa";
    }

}
