package pagofacil.builder;

public class Recibo {

    private String numero;
    private String cliente;
    private String servicios;
    private double montoBase;
    private double total;
    private String medioPago;
    private String moneda;

    Recibo(String numero, String cliente, String servicios, double montoBase,
           double total, String medioPago, String moneda) {
        this.numero = numero;
        this.cliente = cliente;
        this.servicios = servicios;
        this.montoBase = montoBase;
        this.total = total;
        this.medioPago = medioPago;
        this.moneda = moneda;
    }

    public String getNumero() { return numero; }
    public String getCliente() { return cliente; }
    public String getServicios() { return servicios; }
    public double getMontoBase() { return montoBase; }
    public double getTotal() { return total; }
    public String getMedioPago() { return medioPago; }
    public String getMoneda() { return moneda; }

    @Override
    public String toString() {
        return "----- RECIBO " + numero + " -----\n"
                + "Cliente: " + cliente + "\n"
                + "Servicios: " + servicios + "\n"
                + "Monto base: " + moneda + " " + String.format("%.2f", montoBase) + "\n"
                + "Total: " + moneda + " " + String.format("%.2f", total) + "\n"
                + "Medio de pago: " + medioPago + "\n"
                + "-------------------------";
    }

}
