package distributtore;

public class prodotti extends distributtore {
	
	//Attributi
	private String nome =" ";
	private String id= " "; //Id univoco dei prodotti
	private double prezzo =0;
	private int quantita = 0;
	private int cont =0;

	//Costruttore 
	public prodotti (String id, String nome, double prezzo, int quat, int cont) {
		this.nome= nome;
		this.id=id;
		this.prezzo= prezzo;
		this.quantita=quat;
		this.cont=cont;
	} 
	
	//Metodo per ottenere il cont
	public int getCont() {
		return cont;
	}
	
	//set del cont
	public void setCont(String cont) {
		this.nome= cont;
	}
	
	
	
	//Metodo get e set degli attributi 
	//Get per ottenere il valore
	//Set per modificare il valore degli attributi
	
	//get del nome
	public String getNome() {
		return this.nome; 
	}
	
	//set del nome
	public void setNome(String nome) {
		this.nome= nome;
	}
	
	//get dell'id
	public String getId() {
		return this.id; 
	}
	
	//set dell'id
	public void setId(String id) {
		this.id= id;
	}
	
	//get del prezzo
	public double getPrezzo() {
		return this.prezzo; 
	}
	
	//set del prezzo
	public void setPrezzo(double prezzo) {
		this.prezzo= prezzo;
	}
	
	//get della quantita
	public double getQuantita() {
		return this.quantita; 
	}
	
	//set della quanita
	public void setQuantita(int quantita) {
		this.quantita= quantita;
	}
	public void decrQuantita() {
		this.quantita=this.quantita-1;
		
		
	}
	public void incrQuantita() {
		this.quantita++;
		
		
	}
	
	
	
}
