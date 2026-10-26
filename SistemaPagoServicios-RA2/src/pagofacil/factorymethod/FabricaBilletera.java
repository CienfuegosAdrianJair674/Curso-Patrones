package pagofacil.factorymethod;

public class FabricaBilletera extends FabricaProcesador{
    @Override
    public ProcesadorPago crearProcesador() {
        return new ProcesadorBilletera();
    }
}
