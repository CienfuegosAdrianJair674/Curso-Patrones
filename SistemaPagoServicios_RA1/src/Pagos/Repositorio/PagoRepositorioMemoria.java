package Pagos.Repositorio;

import Pagos.modelo.Pago;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PagoRepositorioMemoria implements PagoRepositorio{

    private final List<Pago> pagos = new ArrayList<>();

    @Override
    public void guardar(Pago pago) {
        pagos.add(pago);
    }

    @Override
    public List<Pago> listar() {
        return Collections.unmodifiableList(new ArrayList<>(pagos));
    }
}
