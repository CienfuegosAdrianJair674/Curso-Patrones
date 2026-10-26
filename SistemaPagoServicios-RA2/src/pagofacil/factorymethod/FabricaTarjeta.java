package pagofacil.factorymethod;

public class FabricaTarjeta extends FabricaProcesador{
    @Override
    public ProcesadorPago crearProcesador() {
        return new ProcesadorTarjeta();
    }
}
