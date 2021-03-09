package esercizi.esercizio23;


public abstract class Persona {
    
    protected String nome;
    protected String cognome;
    protected String codiceFiscale;

    public Persona(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
    }
    
    public Persona() {
        this.nome = "";
        this.cognome = "";
        this.codiceFiscale = "";
    }
    
    public Persona(Persona p) {
        this.nome = p.nome;
        this.cognome = p.cognome;
        this.codiceFiscale = p.codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }
    
    @Override
    public boolean equals(Object obj){
        return (obj instanceof Persona)? ((Persona)obj).codiceFiscale.equals(codiceFiscale): false;
    }
    
    public String getNomeCognome(){
        return nome + " " + cognome; 
    }
    
}
