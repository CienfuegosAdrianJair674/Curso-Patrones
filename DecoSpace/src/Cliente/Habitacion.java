package Cliente;

import abstracFactory.MueblesFactory;
import abstracProduct.Silla;
import abstracProduct.Sofa;

public class Habitacion {
    private Silla silla;
    private Sofa sofa;

    public Habitacion(MueblesFactory factory){
        this.silla = factory.crearSilla();
        this.sofa = factory.crearSofa();
    }

    public void amueblar(){
        silla.probar();
        sofa.reclinarse();
    }
}
