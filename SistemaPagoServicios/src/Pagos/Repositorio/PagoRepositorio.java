package Pagos.Repositorio;

import Pagos.modelo.Pago;

import java.util.List;

public interface PagoRepositorio {
    void guardar(Pago pago);
    List<Pago> listar();
}
