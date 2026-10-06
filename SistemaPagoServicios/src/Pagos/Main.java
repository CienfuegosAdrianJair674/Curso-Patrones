package Pagos;

public class Main {

    public static void main(String[] args) {
        new PagoService().pagar("Luz del Sur", 120.50,
                "BILLETERA", "4111-XXXX");
    }
}