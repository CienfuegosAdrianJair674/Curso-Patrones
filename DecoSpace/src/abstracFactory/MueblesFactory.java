package abstracFactory;

import abstracProduct.Silla;
import abstracProduct.Sofa;

public interface MueblesFactory {
    Silla crearSilla();
    Sofa crearSofa();
}
