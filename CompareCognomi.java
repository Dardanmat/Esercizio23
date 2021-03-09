package esercizi.esercizio23;
import java.util.Comparator;


public class CompareCognomi implements Comparator<Bagaglio>{

    @Override
    public int compare(Bagaglio o1, Bagaglio o2) {
        return o1.getPropietario().getCognome().compareToIgnoreCase(o2.getPropietario().getCognome());
    }
    
}
