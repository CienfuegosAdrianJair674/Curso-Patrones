package pagofacil.composite;

import java.util.ArrayList;
import java.util.List;

public class PaqueteServicios implements ComponenteServicio {

    private String nombre;
    private List<ComponenteServicio> hijos = new ArrayList<>();

    public PaqueteServicios(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ComponenteServicio componente) {
        hijos.add(componente);
    }

    @Override
    public double calcularMonto() {
        double total = 0;
        for (ComponenteServicio hijo : hijos) {
            total += hijo.calcularMonto();
        }
        return total;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarDetalle(String sangria) {
        System.out.println(sangria + "+ " + nombre + ": S/ " + String.format("%.2f", calcularMonto()));
        for (ComponenteServicio hijo : hijos) {
            hijo.mostrarDetalle(sangria + "    ");
        }
    }

}
