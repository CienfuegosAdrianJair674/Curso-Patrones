package Pagos.Cliente;

import Pagos.Repositorio.PagoRepositorio;
import Pagos.abstractFactory.PagoFactory;
import Pagos.abstractProduct.ComprobantePago;
import Pagos.abstractProduct.ProcesarPago;
import Pagos.modelo.MetodoPago;
import Pagos.modelo.Pago;

import java.util.Map;
import java.util.Optional;

public class PagoServicioCliente {

    private final Map<MetodoPago, PagoFactory> fabricas;
    private final PagoRepositorio repositorio;

    public PagoServicioCliente(Map<MetodoPago, PagoFactory> fabricas,
                               PagoRepositorio repositorio) {
        this.fabricas = fabricas;
        this.repositorio = repositorio;
    }

    public Optional<String> registrarCobro(Pago pago) {
        PagoFactory fabrica = fabricas.get(pago.getMetodo());
        if (fabrica == null) {
            throw new IllegalStateException("Método de pago sin fábrica: " + pago.getMetodo());
        }

        ProcesarPago procesador = fabrica.crearProcesador();
        if (!procesador.procesar(pago.getMonto())) {      // dynamic binding
            return Optional.empty();
        }

        repositorio.guardar(pago);
        ComprobantePago comprobante = fabrica.crearComprobante();
        return Optional.of(comprobante.generar(pago));
    }
}
