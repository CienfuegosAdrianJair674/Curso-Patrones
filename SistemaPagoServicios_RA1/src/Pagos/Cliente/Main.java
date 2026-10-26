package Pagos.Cliente;

import Pagos.Repositorio.PagoRepositorio;
import Pagos.Repositorio.PagoRepositorioMemoria;
import Pagos.abstractFactory.PagoFactory;
import Pagos.autenticacion.AutenticadorMemoria;
import Pagos.autenticacion.AutenticadorOperador;
import Pagos.concreteFactory.PagoBilletera;
import Pagos.concreteFactory.PagoEfectivo;
import Pagos.concreteFactory.PagoTarjeta;
import Pagos.modelo.MetodoPago;
import Pagos.reporte.ReporteCaja;

import java.util.EnumMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PagoRepositorio repositorio = new PagoRepositorioMemoria();

        Map<MetodoPago, PagoFactory> fabricas = new EnumMap<>(MetodoPago.class);
        fabricas.put(MetodoPago.EFECTIVO, new PagoEfectivo());
        fabricas.put(MetodoPago.TARJETA, new PagoTarjeta());
        fabricas.put(MetodoPago.BILLETERA, new PagoBilletera());

        PagoServicioCliente cliente = new PagoServicioCliente(fabricas, repositorio);
        ReporteCaja reporte = new ReporteCaja(repositorio);
        AutenticadorOperador autenticador = new AutenticadorMemoria();

        try (Scanner scanner = new Scanner(System.in)) {
            new MenuConsola(scanner, autenticador, cliente, reporte).iniciar();
        }
    }
}
