package ConcreteProduct.FamiliaVictoriana;

import abstracProduct.Silla;

public class SillaVictoriana implements Silla {
    @Override
    public void probar() {
        System.out.println("Sentándose en una silla victoriana tallada a mano.");
    }
}
