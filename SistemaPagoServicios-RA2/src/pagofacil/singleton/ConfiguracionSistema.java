package pagofacil.singleton;

public final class ConfiguracionSistema {

    private String moneda = "S/";
    private double tasaMora = 0.02;
    private double descuentoPuntualidad = 0.05;

    private ConfiguracionSistema() {
    }

    private static class Holder {
        private static final ConfiguracionSistema INSTANCIA = new ConfiguracionSistema();
    }

    public static ConfiguracionSistema getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getTasaMora() {
        return tasaMora;
    }

    public double getDescuentoPuntualidad() {
        return descuentoPuntualidad;
    }

}
