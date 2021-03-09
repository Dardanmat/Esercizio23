package esercizi.esercizio23;

//- un bagaglio a mano viene considerato come "eccedente" se supera i kg 8
//- La tariffa supplementare che si deve pagare per un bagaglio a mano è 8,5 €/kg

public class BagaglioAMano extends Bagaglio{

    public static float PESO_ECCEDENTE = 8;
    public static float TARIFFA_PESO_ECCEDENTE = (float)8.5;
    
    public BagaglioAMano(float peso, Passeggero propietario, String codiceBagaglio) {
        super(peso, propietario, codiceBagaglio);
    }

    public BagaglioAMano() {
    }

    public BagaglioAMano(Bagaglio b) {
        super(b);
    }    

    @Override
    public String toString() {
        return super.toString()+"\nBagaglio a mano";
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
