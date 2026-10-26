package pagofacil.factorymethod;

import pagofacil.builder.Recibo;

public interface ProcesadorPago {
   String procesar(Recibo recibo);
}
