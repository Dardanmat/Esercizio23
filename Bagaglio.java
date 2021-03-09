package esercizi.esercizio23;

/*
Creare la classe astratta Bagaglio che rappresenta un bagaglio da imbarcare su un volo aereo 
con le informazioni quali il peso e il nome e il cognome del proprietario (passeggero).

La classe dovrà implementare un costruttore parametrico, i metodi get e set delle varie proprietà e i seguenti metodi astratti:
- … pesoEccedente (…) che restituisce il valore del peso eccedente se il bagaglio supera il peso consentito 
(altrimenti restituisce zero).
- … tariffaSupplementare (…) che calcola e restituisce il valore della tariffa supplementare 
da pagare nel caso in cui il bagaglio abbia un peso eccedente a quello consentito.
*/

public abstract class Bagaglio {
    
    protected float peso;
    protected Passeggero propietario;
    protected String codiceBagaglio;

    public Bagaglio(float peso, Passeggero propietario, String codiceBagaglio) {
        this.peso = peso;
        this.propietario = propietario;
        this.codiceBagaglio = codiceBagaglio;
    }

    public Bagaglio() {
        this.peso = 0;
        this.propietario = new Passeggero();
        this.codiceBagaglio = "";
    }
    
    public Bagaglio(Bagaglio b) {
        this.peso = b.peso;
        this.propietario = b.propietario;
        this.codiceBagaglio = b.codiceBagaglio;
    }
    
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Passeggero getPropietario() {
        return propietario;
    }

    public void setPropietario(Passeggero propietario) {
        this.propietario = propietario;
    }

    public String getCodiceBagaglio() {
        return codiceBagaglio;
    }

    public void setCodiceBagaglio(String codiceBagaglio) {
        this.codiceBagaglio = codiceBagaglio;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof String) return obj.equals(codiceBagaglio);
        return (obj instanceof Bagaglio)? ((Bagaglio)obj).codiceBagaglio.equals(codiceBagaglio): false;
    }
    
    @Override
    public String toString(){
        return "Propietario: " + propietario.getNomeCognome() + 
                "\nCodice bagaglio: " + this.codiceBagaglio + 
                "\nPeso bagaglio: " + this.peso;
    }
    
    public abstract float getPESO_ECCEDENTE();
    public abstract float getTARIFFA_PESO_ECCEDENTE();
    
    public abstract float pesoEccedente();
    public abstract float calcoloTariffaEccedente();
    
}
