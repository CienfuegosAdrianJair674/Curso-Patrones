package pagofacil.factorymethod;

import pagofacil.builder.Recibo;

public abstract class FabricaProcesador {

    public abstract ProcesadorPago crearProcesador();

    public String pagar(Recibo recibo) {
        ProcesadorPago procesador = crearProcesador();
        return procesador.procesar(recibo);
    }

}
