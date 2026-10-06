package Pagos.Cliente;

import Pagos.autenticacion.AutenticadorOperador;
import Pagos.modelo.MetodoPago;
import Pagos.modelo.Operador;
import Pagos.modelo.Pago;
import Pagos.modelo.TipoServicio;
import Pagos.reporte.ReporteCaja;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class MenuConsola {

    private static final int MAX_INTENTOS = 3;

    private final Scanner scanner;
    private final AutenticadorOperador autenticador;
    private final PagoServicioCliente cliente;
    private final ReporteCaja reporte;

    public MenuConsola(Scanner scanner, AutenticadorOperador autenticador,
                       PagoServicioCliente cliente, ReporteCaja reporte) {
        this.scanner = scanner;
        this.autenticador = autenticador;
        this.cliente = cliente;
        this.reporte = reporte;
    }

    public void iniciar() {
        Optional<Operador> operador = login();
        if (operador.isEmpty()) {
            System.out.println("Demasiados intentos fallidos. FIN.");
            return;
        }
        menu(operador.get());
        System.out.println("FIN.");
    }

    private Optional<Operador> login() {
        for (int i = 1; i <= MAX_INTENTOS; i++) {
            String usuario = leerLinea("Usuario: ");
            String clave = leerLinea("Clave: ");
            Optional<Operador> operador = autenticador.autenticar(usuario, clave);
            if (operador.isPresent()) {
                System.out.println("Bienvenido, " + usuario + ".");
                return operador;
            }
            System.out.println("Credenciales incorrectas (" + i + "/" + MAX_INTENTOS + ").");
        }
        return Optional.empty();
    }

    private void menu(Operador operador) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1. Cobrar");
            System.out.println("2. Reporte");
            System.out.println("3. Salir");
            switch (leerEntero("Opción: ")) {
                case 1 -> cobrar(operador);
                case 2 -> mostrarReporte();
                case 3 -> salir = true;
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void cobrar(Operador operador) {
        String dni = leerDni();
        TipoServicio servicio = elegir("Servicio:", TipoServicio.values());
        double monto = leerMonto();
        MetodoPago metodo = elegir("Método de pago:", MetodoPago.values());

        Pago pago = new Pago(dni, servicio, monto, metodo, operador.getUsuario());
        Optional<String> comprobante = cliente.registrarCobro(pago);
        System.out.println(comprobante.orElse("El pago fue rechazado."));
    }

    private void mostrarReporte() {
        Map<MetodoPago, Double> totales = reporte.totalesPorMetodo();
        double general = 0;
        System.out.println("\n----- REPORTE DE CAJA -----");
        for (Map.Entry<MetodoPago, Double> entrada : totales.entrySet()) {
            System.out.printf(Locale.US, "%-18s S/ %.2f%n", entrada.getKey(), entrada.getValue());
            general += entrada.getValue();
        }
        System.out.printf(Locale.US, "%-18s S/ %.2f%n", "TOTAL", general);
    }

    private String leerDni() {
        while (true) {
            String dni = leerLinea("DNI (8 dígitos): ");
            if (dni.matches("\\d{8}")) {
                return dni;
            }
            System.out.println("DNI inválido.");
        }
    }

    private double leerMonto() {
        while (true) {
            String texto = leerLinea("Monto (S/): ").replace(',', '.');
            try {
                double monto = Double.parseDouble(texto);
                if (monto > 0) {
                    return monto;
                }
            } catch (NumberFormatException e) {
                // se repite la solicitud
            }
            System.out.println("Monto inválido.");
        }
    }

    private <T> T elegir(String titulo, T[] opciones) {
        while (true) {
            System.out.println(titulo);
            for (int i = 0; i < opciones.length; i++) {
                System.out.println("  " + (i + 1) + ". " + opciones[i]);
            }
            int n = leerEntero("Opción: ");
            if (n >= 1 && n <= opciones.length) {
                return opciones[n - 1];
            }
            System.out.println("Opción inválida.");
        }
    }

    private int leerEntero(String mensaje) {
        try {
            return Integer.parseInt(leerLinea(mensaje));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }
}
