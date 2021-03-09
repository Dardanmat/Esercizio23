package esercizi.esercizio23;
import java.util.ArrayList;

public class Passeggero extends Persona{
    
    private ArrayList<Bagaglio> bagagliPasseggero;
    private String numPosto;

    public Passeggero(ArrayList<Bagaglio> bagagliPasseggero, String numPosto, String nome, String cognome, String email, String codiceFiscale) {
        super(nome, cognome, codiceFiscale);
        this.bagagliPasseggero = (ArrayList<Bagaglio>)bagagliPasseggero.clone();
        this.numPosto = numPosto;
    }
    
    public Passeggero(String numPosto, String nome, String cognome, String email, String codiceFiscale) {
        super(nome, cognome, codiceFiscale);
        this.bagagliPasseggero = new ArrayList<>();
        this.numPosto = numPosto;
    }

    public Passeggero() {
        this.bagagliPasseggero = new ArrayList<>();
        this.numPosto = "";
    }

    public Passeggero(Passeggero p) {
        super(p);
        this.bagagliPasseggero = (ArrayList<Bagaglio>)p.bagagliPasseggero.clone();
        this.numPosto = p.numPosto;
    }

    public ArrayList<Bagaglio> getBagagliPasseggero() {
        return bagagliPasseggero;
    }

    public void setBagagliPasseggero(ArrayList<Bagaglio> bagagliPasseggero) {
        this.bagagliPasseggero = bagagliPasseggero;
    }

    public String getNumPosto() {
        return numPosto;
    }

    public void setNumPosto(String numPosto) {
        this.numPosto = numPosto;
    }

    public boolean addBagaglio(Bagaglio b){
        if(b == null) return false;
        return bagagliPasseggero.add(b);
    }
    
    public Bagaglio removeBagaglio(Bagaglio b){
        return removeBagaglio(b.codiceBagaglio);
    }
    
    public Bagaglio removeBagaglio(String s){
        if(s == null) return null;
        if(bagagliPasseggero.isEmpty()) return null;
        
        for(int i = 0; i < bagagliPasseggero.size(); i++){
            if(bagagliPasseggero.get(i).equals(s)) return bagagliPasseggero.remove(i);
        }
        return null;
    }
    
}
