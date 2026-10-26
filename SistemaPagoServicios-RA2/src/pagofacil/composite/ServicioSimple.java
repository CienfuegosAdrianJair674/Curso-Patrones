package pagofacil.composite;

public class ServicioSimple implements ComponenteServicio {

    private String nombre;
    private double monto;

    public ServicioSimple(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }

    @Override
    public double calcularMonto() {
        return monto;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarDetalle(String sangria) {
        System.out.println(sangria + "- " + nombre + ": S/ " + String.format("%.2f", monto));
    }
}
