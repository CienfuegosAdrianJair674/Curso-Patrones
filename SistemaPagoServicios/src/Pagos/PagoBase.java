package Pagos;

public abstract class PagoBase implements PasarelaPago{
    protected String codigoOperacion = "OP-" + System.currentTimeMillis();
}
