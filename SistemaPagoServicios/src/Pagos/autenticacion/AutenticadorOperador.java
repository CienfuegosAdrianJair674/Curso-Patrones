package Pagos.autenticacion;

import Pagos.modelo.Operador;
import java.util.Optional;

public interface AutenticadorOperador {
    Optional<Operador> autenticar(String usuario, String clave);
}
