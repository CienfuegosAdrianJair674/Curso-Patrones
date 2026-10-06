package Pagos.modelo;

import java.time.LocalDateTime;
import java.util.UUID;

public class Pago {
    private final String codigoOperacion;
    private final String dni;
    private final TipoServicio servicio;
    private final double monto;
    private final MetodoPago metodo;
    private final String operador;
    private final LocalDateTime fecha;

    public Pago(String dni, TipoServicio servicio, double monto,
                MetodoPago metodo, String operador) {
        this.codigoOperacion = "OP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.dni = dni;
        this.servicio = servicio;
        this.monto = monto;
        this.metodo = metodo;
        this.operador = operador;
        this.fecha = LocalDateTime.now();
    }

    public String getCodigoOperacion(){
        return codigoOperacion;
    }

    public String getDni(){
        return dni;
    }

    public TipoServicio getServicio() {
        return servicio;
    }

    public double getMonto(){
        return monto;
    }

    public MetodoPago getMetodo(){
        return metodo;
    }
    public String getOperador(){
        return operador;
    }
    public LocalDateTime getFecha(){
        return fecha;
    }
}
