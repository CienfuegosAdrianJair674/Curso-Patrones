package ConcreteFactory;

import ConcreteProduct.FamiliaVictoriana.SillaVictoriana;
import ConcreteProduct.FamiliaVictoriana.SofaVictoriana;
import abstracFactory.MueblesFactory;
import abstracProduct.Silla;
import abstracProduct.Sofa;

public class VictorianoFactory implements MueblesFactory {
    @Override
    public Silla crearSilla() {
        return new SillaVictoriana();
    }

    @Override
    public Sofa crearSofa() {
        return new SofaVictoriana();
    }
}
