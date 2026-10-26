package pagofacil.decorator;

import pagofacil.composite.ComponenteServicio;
import pagofacil.singleton.ConfiguracionSistema;

public class RecargoMora extends DecoradorServicio {

    public RecargoMora(ComponenteServicio servicio) {
        super(servicio);
    }

    @Override
    public double calcularMonto() {
        double tasa = ConfiguracionSistema.getInstancia().getTasaMora();
        return servicio.calcularMonto() * (1 + tasa);
    }

    @Override
    public String getNombre() {
        return servicio.getNombre() + " + recargo por mora";
    }
}
