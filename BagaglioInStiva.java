package esercizi.esercizio23;

//- un bagaglio da stiva viene considerato "eccedente" se supera i kg 25
//- La tariffa supplementare che si deve pagare per un bagaglio da stiva è 5 €/kg

public class BagaglioInStiva extends Bagaglio{
    
    public static float PESO_ECCEDENTE = 25;
    public static float TARIFFA_PESO_ECCEDENTE = 5;

    public BagaglioInStiva(float peso, Passeggero propietario, String codiceBagaglio) {
        super(peso, propietario, codiceBagaglio);
    }

    public BagaglioInStiva() {
    }

    public BagaglioInStiva(Bagaglio b) {
        super(b);
    }
    
        @Override
    public float getPESO_ECCEDENTE() {
        return PESO_ECCEDENTE;
    }

    @Override
    public float getTARIFFA_PESO_ECCEDENTE() {
        return TARIFFA_PESO_ECCEDENTE;
    }

    @Override
    public float pesoEccedente() {
        if(peso < PESO_ECCEDENTE) return PESO_ECCEDENTE - peso;
        return 0;
    }

    @Override
    public float calcoloTariffaEccedente() {
        return pesoEccedente()*TARIFFA_PESO_ECCEDENTE;
    }
    
}
