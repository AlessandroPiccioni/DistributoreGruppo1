package distributtore;

public class distributtore {
	
	//Attributi
	//ArrayLsit che contiene i prodotti
	private prodotti [][] prodotto = new prodotti[10][3];
	protected String [] categoria= {"Calde", "Fredde"}; //Per determinare la categoria del prodotto 
	protected int quatScomparto =30;//Quantita per ogni scomparto
	private int quatBichieri =10;
	private int quatZucchero = 10;
	private int quatBacchette = 10;
	private int quatBichieriMax =30;
	private int quatZuccheroMax = 30;
	private int quatBacchetteMax = 30;
	
	//Metodi get e set
	
	public int getquatBichieriMax() {
		return this.quatBichieriMax;
	}
	
	public void setquatBichieriMax(int a) {
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatBichieriMax= a ;
	}
	
	public int getquatZuccheroMax() {
		return this.quatBichieriMax;
	}
	
	public void setquatZuccheroMax(int a) {
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatBichieriMax= a ;
	}
	
	public int getquatBacchetteMax() {
		return this.quatBichieriMax;
	}
	
	public void setquatBacchetteMax(int a) {
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatBichieriMax= a ;
	}
	
    public String[] getCategoria() {
		return categoria;
	}

	public prodotti[][] getProdotto() {
		return prodotto;
	}

	public void setProdotto(prodotti[][] prodotto) {
		this.prodotto = prodotto;
	}

	public void setCategoria(String[] categoria) {
		this.categoria = categoria;
	}

	public int getQuatBichieri() {
		return quatBichieri;
	}

	public void setQuatBichieri(int quatBichieri) {
		this.quatBichieri = quatBichieri;
	}

	public int getQuatZucchero() {
		return quatZucchero;
	}

	public void setQuatZucchero(int quatZucchero) {
		this.quatZucchero = quatZucchero;
	}

	public int getQuatBacchette() {
		return quatBacchette;
	}

	public void setQuatBacchette(int quatBacchette) {
		this.quatBacchette = quatBacchette;
	}

	public void setQuatScomparto(int quatScomparto) {
		this.quatScomparto = quatScomparto;
	}

	// Metodo per controllare se la categoria è valida
    public int lunghezzaCategoria() {
    	return categoria.length;
    }
    
    //Metodo per lo scomparto massimo
    public int getQuatScomparto() {
    	return quatScomparto;
    }
    
	//Metodo decremento bicchieri
	public void decrementoQuatBichieri() {
		System.out.println("Erogazione del bicchiere");
		this.quatBichieri--;
		if(this.quatBichieri==0) {
			System.err.println("Bichieri finiti.");
		}
	}
	
	//Metodo decremento bicchieri
	public void decrementoQuatZucchero(int quatZucchero) {
		System.out.println("Erogazione dello zucchero");
		this.quatZucchero -= quatZucchero;
		if(this.quatZucchero==0) {
			System.err.println("Zucchero finiti.");
		}
	}
    
	//Metodo decremento bicchieri
	public void decrementoQuatBachette() {
		System.out.println("Erogazione delle bacchette");
		this.quatBacchette--;
		if(this.quatBacchette==0) {
			System.err.println("Bacchette finiti.");
		}
	}
    
	//Metodo calcolo dello zucchero
	
	//Metodo calcolo del bicchiere
	
	//Metodo della bachetta 
	
	//Metodo calcolo monete 
	
	//Metodo per il totale dell'incasso
	
	//Metodo elenco dei prodotti acquistati con relative quantità

}
