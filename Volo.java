package esercizi.esercizio23;
import java.util.ArrayList;

/*
- ... totTariffeSupplementari(...): metodo che calcola e restituisce il valore 
        dell'importo totale delle tariffe supplementari.

- ... pesoEccedenteTotale(...): metodo che calcola e restituisce il peso eccedente totale dei bagagli

- ... elencoBagagliMano(...): metodo privato che restituisce l'elenco dei soli bagagli a mano

- ... stampaInfoBagagliMano(...): metodo che stampa a schermo l'elenco dei soli bagagli a mano 
        e le relative informazioni

- ... elencoBagagliManoEccedenti(...): metodo privato che restituisce 
        l'elenco dei soli bagagli a mano con peso eccedente

- ... stampaInfoBagagliManoEccedenti(...): metodo che stampa a schermo l'elenco 
        dei soli bagagli a mano con peso eccedente e le relative informazioni

- l'elenco dei soli bagagli a mano ordinato per cognome passeggero crescente

- l'elenco dei bagagli da stiva con peso eccedente ordinato per peso decrescente
*/

public class Volo{
    
    private String codice;
    private ArrayList<Passeggero> listaPasseggeri;

    public Volo(String codice, ArrayList<Passeggero> listaPasseggeri) {
        this.codice = codice;
        this.listaPasseggeri = (ArrayList<Passeggero>)listaPasseggeri.clone();
    }
    
    public Volo(String codice) {
        this.codice = codice;
        this.listaPasseggeri = new ArrayList<>();
    }
    
    public Volo() {
        this.codice = "";
        this.listaPasseggeri = new ArrayList<>();
    }
    
    public Volo(Volo v) {
        this.codice = v.codice;
        this.listaPasseggeri = (ArrayList<Passeggero>)v.listaPasseggeri.clone();
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public ArrayList<Passeggero> getListaPasseggeri() {
        return listaPasseggeri;
    }

    public void setListaPasseggeri(ArrayList<Passeggero> listaPasseggeri) {
        this.listaPasseggeri = listaPasseggeri;
    }
    
    public ArrayList<Bagaglio> buildListaBagagli(){
        ArrayList<Bagaglio> lista = new ArrayList<>();
        
        for(Passeggero p: listaPasseggeri){
            lista.addAll(p.getBagagliPasseggero());
        }
        
        return lista;
    }
    
    /*- ... totTariffeSupplementari(...): metodo che calcola e restituisce il valore 
        dell'importo totale delle tariffe supplementari.*/
    public float totTariffeSupplementari(){
        float sum = 0;
        
        for(Passeggero p: listaPasseggeri){
            for(Bagaglio b: p.getBagagliPasseggero()){
                sum += b.calcoloTariffaEccedente();
            }
        }
        
        return sum;
    }
    
    //- ... pesoEccedenteTotale(...): metodo che calcola e restituisce il peso eccedente totale dei bagagli
    public float pesoEccedenteTotale(){
        float tot = 0;
        
        for(Passeggero p: listaPasseggeri){
            for(Bagaglio b: p.getBagagliPasseggero()){
                if(b.pesoEccedente() == 0) tot += b.peso - b.getPESO_ECCEDENTE();
            }
        }
        
        return tot;
    }
    
    //- ... elencoBagagliMano(...): metodo privato che restituisce l'elenco dei soli bagagli a mano
    private ArrayList<BagaglioAMano> elencoBagagliAMAno(){
        ArrayList<BagaglioAMano> lista = new ArrayList<>();
        
        for(Passeggero p: listaPasseggeri){
            for(Bagaglio b: p.getBagagliPasseggero()){
                if(b instanceof BagaglioAMano) lista.add((BagaglioAMano)b);
            }
        }
        
        return lista;
    } 
    
    private ArrayList<BagaglioInStiva> elencoBagaglioInStiva(){
        ArrayList<BagaglioInStiva> lista = new ArrayList<>();
        
        for(Passeggero p: listaPasseggeri){
            for(Bagaglio b: p.getBagagliPasseggero()){
                if(b instanceof BagaglioInStiva) lista.add((BagaglioInStiva)b);
            }
        }
        
        return lista;
    } 
    
    /*- ... stampaInfoBagagliMano(...): metodo che stampa a schermo l'elenco dei soli bagagli a mano 
        e le relative informazioni*/
    public void stampaInfoBagaglioMano(){
        for(BagaglioAMano b: elencoBagagliAMAno()){
            System.out.println("\n" + b.toString() + "\n");
        }
    }
    
    /*- ... elencoBagagliManoEccedenti(...): metodo privato che restituisce 
        l'elenco dei soli bagagli a mano con peso eccedente*/
    private ArrayList<BagaglioAMano> elencoBagagliManoEccedenti(){
        ArrayList<BagaglioAMano> lista = new ArrayList<>();
        for(BagaglioAMano b: elencoBagagliAMAno()){
            if(b.pesoEccedente() == 0) lista.add(b);
        }
        return lista;
    }
    
    /*- ... stampaInfoBagagliManoEccedenti(...): metodo che stampa a schermo l'elenco 
        dei soli bagagli a mano con peso eccedente e le relative informazioni*/
    public void stampaInfoBagagliManoEccedenti(){
        for(BagaglioAMano b: elencoBagagliManoEccedenti()){
            System.out.println("\n" + b.toString() + "\n");
        }
    }
    
    //- l'elenco dei soli bagagli a mano ordinato per cognome passeggero crescente
    public ArrayList<BagaglioAMano> elencoBagagliManoOrdineAlfa(){
        ArrayList<BagaglioAMano> lista = elencoBagagliAMAno();
        lista.sort(new CompareCognomi());
        return lista;
    }
    
    // l'elenco dei bagagli da stiva con peso eccedente ordinato per peso decrescente
    public ArrayList<BagaglioInStiva> elencoBagagliStivaOrdinePeso(){
        ArrayList<BagaglioInStiva> lista = elencoBagaglioInStiva();
        lista.sort(new ComparePeso());
        return lista;
    }
    
}
