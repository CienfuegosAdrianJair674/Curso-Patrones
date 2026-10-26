package pagofacil.builder;

import pagofacil.composite.ComponenteServicio;
import pagofacil.singleton.ConfiguracionSistema;

public class ReciboDirector {

    private ReciboBuilder builder;

    public ReciboDirector(ReciboBuilder builder) {
        this.builder = builder;
    }

    public Recibo construirRecibo(String cliente, ComponenteServicio servicio,
                                  double montoBase, String medioPago) {
        return builder.cliente(cliente)
                .servicios(servicio.getNombre())
                .montos(montoBase, servicio.calcularMonto())
                .moneda(ConfiguracionSistema.getInstancia().getMoneda())
                .medioPago(medioPago)
                .build();
    }
}
