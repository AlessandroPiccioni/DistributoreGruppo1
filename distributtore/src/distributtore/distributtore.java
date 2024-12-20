package distributtore;

import java.util.ArrayList;

public class distributtore
{

	// Attributi
	// ArrayLsit che contiene i prodotti
	public prodotti[][] prodotto = new prodotti[10][3];
	protected String[] categoria = { "Calde", "Fredde" }; // Per determinare la categoria del prodotto
	private int quatScomparto = 30;// Quantita per ogni scomparto
	//Quantita dei bicchieri, zucchero, bacchete
	private int quatBichieri = 10;
	private int quatZucchero = 10;
	private int quatBacchette = 10;
	//Quantita massima dei bicchieri, zucchero, bacchete
	private int quatBichieriMax = 30;
	private int quatZuccheroMax = 30;
	private int quatBacchetteMax = 30;
	//Incasso totale
	private double incasso = 0;
	//Lo storico dei prodotti acquistati
	private ArrayList<prodotti> prodAcquistati = new ArrayList<prodotti>();

	// Metodi get e set

	public int getquatBicchieriMax()
	{
		return this.quatBichieriMax;
	}

	public void setquatBicchieriMax(int a)
	{
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatBichieriMax = a;
	}

	public int getquatZuccheroMax()
	{
		return this.quatZuccheroMax;
	}

	public void setquatZuccheroMax(int a)
	{
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatZuccheroMax = a;
	}

	public int getquatBacchetteMax()
	{
		return this.quatBacchetteMax;
	}

	public void setquatBacchetteMax(int a)
	{
		System.out.println(String.format("Hai inserito la nuova quantita di %d", a));
		this.quatBacchetteMax = a;
	}

	public String[] getCategoria()
	{
		return categoria;
	}

	public prodotti[][] getProdotto()
	{
		return prodotto;
	}

	/*public void setProdotto(prodotti[][] prodotto)
	{
		this.prodotto = prodotto;
	}*/

	public void setCategoria(String[] categoria)
	{
		this.categoria = categoria;
	}

	public int getQuatBichieri()
	{
		return quatBichieri;
	}

	public void setQuatBichieri(int quatBichieri)
	{
		this.quatBichieri = quatBichieri;
	}

	public int getQuatZucchero()
	{
		return quatZucchero;
	}

	public void setQuatZucchero(int quatZucchero)
	{
		this.quatZucchero = quatZucchero;
	}

	public int getQuatBacchette()
	{
		return quatBacchette;
	}

	public void setQuatBacchette(int quatBacchette)
	{
		this.quatBacchette = quatBacchette;
	}

	public void setQuatScomparto(int quatScomparto)
	{
		this.quatScomparto = quatScomparto;
	}

	// Metodo per controllare se la categoria è valida
	public int lunghezzaCategoria()
	{
		return categoria.length;
	}

	// Metodo per lo scomparto massimo
	public int getQuatScomparto()
	{
		return quatScomparto;
	}

	public double getIncasso()
	{
		return incasso;
	}

	// Metodo decremento bicchieri
	public void decrementoQuatBichieri()
	{
		System.out.println("Erogazione del bicchiere");
		this.quatBichieri--;
		//Controlla se i bicchieri vada a 0
		if (this.quatBichieri == 0)
		{
			System.err.println("Bicchieri finiti.");
		}
	}

	// Metodo decremento bicchieri
	public void decrementoQuatZucchero(int quatZucchero)
	{
		System.out.println("Erogazione dello zucchero");
		this.quatZucchero -= quatZucchero;
		if (this.quatZucchero == 0)
		{
			System.err.println("Zucchero finito.");
		}
	}

	// Metodo decremento bicchieri
	public void decrementoQuatBachette()
	{
		System.out.println("Erogazione delle bacchette");
		this.quatBacchette--;
		if (this.quatBacchette == 0)
		{
			System.err.println("Bacchette finite.");
		}
	}

	// metodo per decrementare quantità
	public void decrementoQuantita(int riga, int colonna)
	{
		if(prodotto[riga][colonna]!=null) {
			prodotto[riga][colonna].decrQuantita();
			
			// somma totale prodotti acquistati
			incasso += prodotto[riga][colonna].getPrezzo();
			//Controla che dopo l 'acquisto il prodotto vada a 0
			if (prodotto[riga][colonna].getQuantita() <= 0)
			{
				System.out.println(String.format("Il prodotto %s è stato acquistato. non rimane nessuna quantità disponibile",
						getProdotto()[riga][colonna].getNome()));
				//Lo azzero
				prodotto[riga][colonna]=null;
				return;
			}
			System.out.println(String.format("Il prodotto %s è stato acquistato. ne rimangono %d",
					getProdotto()[riga][colonna].getNome(), getProdotto()[riga][colonna].getQuantita()));
		}
		else
		{
			System.err.println("Error: Prodotto non è stato trovato.");
		}
	}

	// metodo per cercare nella lista prodotti acquistati
	public int cercaProdottoAcquistato(String id)
	{
		for (int i = 0; i < prodAcquistati.size(); i++)
		{
			//trova il prodotto
			if (id.equals(prodAcquistati.get(i).getId()))
			{
				return i;
			}

		}
		return -1;
	}
	
	

	// prodotti acquistati con relative quantità
	public void prodottiAcquistati(int riga, int colonna)
	{
		//Controlla se il rpodotto esiste
		if (prodotto[riga][colonna]!=null) {
			//Cerca se il prodotto è stato salvato nello storico
			int sup=cercaProdottoAcquistato(prodotto[riga][colonna].getId());
			if(sup==-1) { //=true
				prodAcquistati.add(new prodotti(prodotto[riga][colonna].getId(),prodotto[riga][colonna].getNome(),prodotto[riga][colonna].getPrezzo(),1,prodotto[riga][colonna].getCont()));
				
			}
			else {
				prodAcquistati.get(sup).incrQuantita();
			}
			decrementoQuantita(riga,colonna);
		}else {
			System.err.println("Prodotto non è stato trovato.");
		}
	}
	//Metodo per salvare i prodotti acqustati
	public void listaProdottiAcquistati() {
		//Controlla che los torico degli aacquisti sia vuoto
		if(prodAcquistati.isEmpty()) {
			System.out.println("Non è stato ancora acquistato nessun prodotto");
			return;
			
		} 
		for (prodotti z:prodAcquistati) {
			System.out.println(String.format("[ID: %s, Nome: %s, Categoria: %s, Quantità: %d]", z.getId(), z.getNome(), z.getCategoria()[z.getCont()], z.getQuantita()));
		}
	}

}