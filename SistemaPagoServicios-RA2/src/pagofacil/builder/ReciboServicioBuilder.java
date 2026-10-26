package pagofacil.builder;

public class ReciboServicioBuilder implements  ReciboBuilder{

    private static int contador = 0;

    private String cliente;
    private String servicios;
    private double montoBase;
    private double total;
    private String medioPago;
    private String moneda;

    @Override
    public ReciboBuilder cliente(String cliente) {
        this.cliente = cliente;
        return this;
    }

    @Override
    public ReciboBuilder servicios(String servicios) {
        this.servicios = servicios;
        return this;
    }

    @Override
    public ReciboBuilder montos(double montoBase, double total) {
        this.montoBase = montoBase;
        this.total = total;
        return this;
    }

    @Override
    public ReciboBuilder moneda(String moneda) {
        this.moneda = moneda;
        return this;
    }

    @Override
    public ReciboBuilder medioPago(String medioPago) {
        this.medioPago = medioPago;
        return this;
    }

    @Override
    public Recibo build() {
        // se valida antes de crear el recibo
        if (cliente == null || servicios == null || medioPago == null || moneda == null || total <= 0) {
            throw new IllegalStateException("Faltan datos para generar el recibo");
        }
        contador++;
        String numero = String.format("R-%03d", contador);
        return new Recibo(numero, cliente, servicios, montoBase, total, medioPago, moneda);
    }
}
