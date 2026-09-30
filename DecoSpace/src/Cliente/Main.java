package Cliente;

import ConcreteFactory.ModernoFactory;
import ConcreteFactory.VictorianoFactory;
import abstracFactory.MueblesFactory;

public class Main {
    public static void main(String[] args){
        String tipoFamilia = "Victoriano";
        MueblesFactory factory;

        if( tipoFamilia.equalsIgnoreCase("Moderna")){
            factory = new ModernoFactory();
        }else{
            factory = new VictorianoFactory();
        }
        Habitacion hab = new Habitacion(factory);
        hab.amueblar();
    }
}
