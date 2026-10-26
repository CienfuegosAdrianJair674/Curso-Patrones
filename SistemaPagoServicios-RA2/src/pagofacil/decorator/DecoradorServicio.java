package pagofacil.decorator;

import pagofacil.composite.ComponenteServicio;

public abstract class DecoradorServicio implements ComponenteServicio {

    protected ComponenteServicio servicio;

    public DecoradorServicio(ComponenteServicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String getNombre() {
        return servicio.getNombre();
    }

    @Override
    public void mostrarDetalle(String sangria) {
        servicio.mostrarDetalle(sangria);
    }

}
