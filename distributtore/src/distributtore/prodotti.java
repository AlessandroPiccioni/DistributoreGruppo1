package distributtore;

public class prodotti extends distributtore {
	
	//Attributi
	protected String nome =" ";
	protected String id= " "; //Id univoco dei prodotti
	protected double prezzo =0;
	protected int quantita = 0;
	
	//Costruttore 
	public prodotti (String id, String nome, double prezzo, int quat, int categoria) {
		super(categoria);
		this.nome= nome;
		this.id=id;
		this.prezzo= prezzo;
		this.quantita=quat;
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
	
	
}
