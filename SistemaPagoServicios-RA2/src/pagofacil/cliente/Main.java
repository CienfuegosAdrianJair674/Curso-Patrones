package pagofacil.cliente;

import pagofacil.adapter.AdaptadorPasarela;
import pagofacil.adapter.PasarelaExterna;
import pagofacil.builder.Recibo;
import pagofacil.builder.ReciboDirector;
import pagofacil.builder.ReciboServicioBuilder;
import pagofacil.composite.ComponenteServicio;
import pagofacil.composite.PaqueteServicios;
import pagofacil.composite.ServicioSimple;
import pagofacil.decorator.DescuentoPuntualidad;
import pagofacil.decorator.RecargoMora;
import pagofacil.factorymethod.FabricaBilletera;
import pagofacil.factorymethod.FabricaTarjeta;
import pagofacil.factorymethod.ProcesadorPago;

import java.util.Scanner;

public class Main {

    static ServicioSimple luz = new ServicioSimple("Luz", 85.50);
    static ServicioSimple agua = new ServicioSimple("Agua", 40.00);
    static ServicioSimple internet = new ServicioSimple("Internet", 99.90);
    static PaqueteServicios hogar = new PaqueteServicios("Paquete Hogar");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        hogar.agregar(luz);
        hogar.agregar(agua);
        hogar.agregar(internet);

        int opcion = 0;
        while (opcion != 3) {
            System.out.println();
            System.out.println("=== PagoFacil Servicios ===");
            System.out.println("1. Ver catálogo de servicios");
            System.out.println("2. Pagar un servicio");
            System.out.println("3. Salir");
            opcion = leerEntero(sc, "Opción: ", 1, 3);

            if (opcion == 1) {
                verCatalogo();
            } else if (opcion == 2) {
                pagarServicio(sc);
            }
        }

        System.out.println("Gracias por usar PagoFacil Servicios.");
        sc.close();
    }

    static int leerEntero(Scanner sc, String mensaje, int min, int max) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                valor = Integer.parseInt(sc.nextLine().trim());
                if (valor >= min && valor <= max) {
                    valido = true;
                } else {
                    System.out.println("Opción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número.");
            }
        }
        return valor;
    }

    static void verCatalogo() {
        System.out.println();
        System.out.println("--- Catálogo de servicios ---");
        hogar.mostrarDetalle("");
    }

    static void pagarServicio(Scanner sc) {
        String cliente = "";
        while (cliente.isEmpty()) {
            System.out.print("Nombre del cliente: ");
            cliente = sc.nextLine().trim();
        }

        System.out.println("1. Luz  2. Agua  3. Internet  4. Paquete Hogar");
        int opServicio = leerEntero(sc, "Servicio: ", 1, 4);
        ComponenteServicio servicio;
        if (opServicio == 1) {
            servicio = luz;
        } else if (opServicio == 2) {
            servicio = agua;
        } else if (opServicio == 3) {
            servicio = internet;
        } else {
            servicio = hogar;
        }
        double montoBase = servicio.calcularMonto();

        System.out.println("1. Pago puntual (descuento)  2. Pago con mora (recargo)  3. Sin ajuste");
        int opCondicion = leerEntero(sc, "Condición: ", 1, 3);
        if (opCondicion == 1) {
            servicio = new DescuentoPuntualidad(servicio);
        } else if (opCondicion == 2) {
            servicio = new RecargoMora(servicio);
        }

        System.out.println("1. Tarjeta  2. Billetera digital  3. Pasarela externa");
        int opMedio = leerEntero(sc, "Medio de pago: ", 1, 3);
        String nombreMedio;
        if (opMedio == 1) {
            nombreMedio = "Tarjeta";
        } else if (opMedio == 2) {
            nombreMedio = "Billetera digital";
        } else {
            nombreMedio = "Pasarela externa";
        }

        System.out.println();
        servicio.mostrarDetalle("");
        System.out.println("Total a pagar: S/ " + String.format("%.2f", servicio.calcularMonto()));

        ReciboDirector director = new ReciboDirector(new ReciboServicioBuilder());
        Recibo recibo = director.construirRecibo(cliente, servicio, montoBase, nombreMedio);

        String resultado;
        if (opMedio == 1) {
            resultado = new FabricaTarjeta().pagar(recibo);
        } else if (opMedio == 2) {
            resultado = new FabricaBilletera().pagar(recibo);
        } else {
            ProcesadorPago pasarela = new AdaptadorPasarela(new PasarelaExterna());
            resultado = pasarela.procesar(recibo);
        }

        System.out.println();
        System.out.println(resultado);
        System.out.println(recibo);
    }

}
