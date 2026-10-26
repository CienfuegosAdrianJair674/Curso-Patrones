package Pagos.reporte;

import Pagos.Repositorio.PagoRepositorio;
import Pagos.modelo.MetodoPago;
import Pagos.modelo.Pago;
import java.util.EnumMap;
import java.util.Map;

public class ReporteCaja {

    private final PagoRepositorio repositorio;

    public ReporteCaja(PagoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Map<MetodoPago, Double> totalesPorMetodo() {
        Map<MetodoPago, Double> totales = new EnumMap<>(MetodoPago.class);
        for (MetodoPago metodo : MetodoPago.values()) {
            totales.put(metodo, 0.0);
        }
        for (Pago pago : repositorio.listar()) {
            totales.merge(pago.getMetodo(), pago.getMonto(), Double::sum);
        }
        return totales;
    }
}
