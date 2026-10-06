package Pagos.autenticacion;

import Pagos.modelo.Operador;

import java.util.Map;
import java.util.Optional;

public class AutenticadorMemoria implements AutenticadorOperador{

    private final Map<String, String> claves = Map.of(
            "operador1", "1234",
            "operador2", "5678");

    @Override
    public Optional<Operador> autenticar(String usuario, String clave) {
        if (claves.containsKey(usuario) && claves.get(usuario).equals(clave)) {
            return Optional.of(new Operador(usuario));
        }
        return Optional.empty();
    }
}
