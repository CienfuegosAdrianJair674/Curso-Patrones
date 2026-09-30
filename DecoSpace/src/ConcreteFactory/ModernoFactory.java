package ConcreteFactory;

import ConcreteProduct.FamiliaModerna.SillaModerna;
import ConcreteProduct.FamiliaModerna.SofaModerno;
import abstracFactory.MueblesFactory;
import abstracProduct.Silla;
import abstracProduct.Sofa;

public class ModernoFactory implements MueblesFactory {
    @Override
    public Silla crearSilla() {
        return new SillaModerna();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaModerno();
    }
}
