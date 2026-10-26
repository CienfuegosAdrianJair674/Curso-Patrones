package pagofacil.decorator;

import pagofacil.composite.ComponenteServicio;
import pagofacil.singleton.ConfiguracionSistema;

public class DescuentoPuntualidad extends DecoradorServicio{

    public DescuentoPuntualidad(ComponenteServicio servicio) {
        super(servicio);
    }

    @Override
    public double calcularMonto() {
        double tasa = ConfiguracionSistema.getInstancia().getDescuentoPuntualidad();
        return servicio.calcularMonto() * (1 - tasa);
    }

    @Override
    public String getNombre() {
        return servicio.getNombre() + " + descuento por puntualidad";
    }

}
