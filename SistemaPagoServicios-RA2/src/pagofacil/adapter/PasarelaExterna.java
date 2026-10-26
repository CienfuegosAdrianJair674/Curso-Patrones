package pagofacil.adapter;

public class PasarelaExterna {

    public boolean realizarTransaccion(double importe, String divisa) {
        return importe <= 10000;
    }

}
