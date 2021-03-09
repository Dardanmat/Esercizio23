package esercizi.esercizio23;
import java.util.Comparator;


public class ComparePeso implements Comparator<Bagaglio>{

    @Override
    public int compare(Bagaglio o1, Bagaglio o2) {
        if(o1.getPeso() > o2.getPeso()) return 1;
        if(o1.getPeso() < o2.getPeso()) return -1;
        return 0;
    }
    
}
