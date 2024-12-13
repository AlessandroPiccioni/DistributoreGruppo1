package distributtore;

public class distributtore {
	
	//Attributi
	protected String [] categoria= {"Calde", "Fredde"}; //Per determinare la categoria del prodotto 
	protected int cont =0;
	protected int quatScomparto =30;//Quantita per ogni scomparto
	
	//Costruttore 
	public distributtore (int cat) {
		this.cont = cat;
	}
	
    // Metodo per controllare se la categoria è valida
    public int lunghezzaCategoria() {
    	return categoria.length;
    }
    
    //Metodo per lo scomparto massimo
    public int getQuatScomparto() {
    	return quatScomparto;
    }
    
    
	//Metodo calcolo dello zucchero
	
	//Metodo calcolo del bicchiere
	
	//Metodo della bachetta 
	
	//Metodo calcolo monete 
	
	//Metodo per il totale dell'incasso
	
	//Metodo elenco dei prodotti acquistati con relative quantità

}
