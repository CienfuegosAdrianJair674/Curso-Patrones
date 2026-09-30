package ConcreteProduct.FamiliaVictoriana;

import abstracProduct.Sofa;

public class SofaVictoriana implements Sofa {
    @Override
    public void reclinarse() {
        System.out.println("Reclinándose en un sofá victoriano de terciopelo");
    }
}
