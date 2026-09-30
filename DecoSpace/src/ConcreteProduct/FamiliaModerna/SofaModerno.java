package ConcreteProduct.FamiliaModerna;

import abstracProduct.Sofa;

public class SofaModerno implements Sofa {
    @Override
    public void reclinarse() {
        System.out.println("Reclinándose en un sofá moderno ergonómico.");
    }
}
