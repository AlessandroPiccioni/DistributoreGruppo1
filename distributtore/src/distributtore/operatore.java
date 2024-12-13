package distributtore;

import java.util.ArrayList;
import java.util.Scanner;
//import java.util.ArrayList;


public class operatore {
	 
	//Overloading del metodo richiesta
	//Metodo controllo se vuoi continuare
	static boolean richiesta(String frase, Scanner scanner) {
		boolean ris= false;
		String scelta=" ";
		do {
			System.out.println(frase);
			scelta= scanner.nextLine().trim().toLowerCase();
			if(!(scelta.equals("si")||scelta.equals("no"))) {
				System.out.println("input non valido sbagliato.");
			}else if(scelta.equals("no")) //Ha detto di non essere un operatore
			{
				return ris;
			}
		}while(!(scelta.equals("si")||scelta.equals("no")));
		ris=true;
		return ris;
	}
	//Metodo per richiedere l'opzioni admin
	static int richiesta (Scanner scanner) {
		String scelta=" ";
		System.out.println("1) Aggiungere un prodotto. \n2) Rimuovere un prodotto. \n3) Cambiare la quantià di un prodotto. \n4) Cambiare prezzo di un prodtto. \n5) Il totale incasso di un distributtore. \n6) Elenco dei prodotti acquistati con le relative quantità. \n7)Uscita...");
			//Ciclo per vedere se l'input utente sia valido
			do {
				for(int i=0; i<3; i++) {
					System.out.print("Inserici il numero dell'opzione che vuoi selezionare: ");
					scelta= scanner.nextLine().trim().toLowerCase();
					//Controllo solo per i caratteri numerici
					if(!scelta.matches("\\d+")) {
						System.out.println("Il codice è solo caratteri numerici");
					}else if(!(scelta.equals("1")||scelta.equals("2")||scelta.equals("3")||scelta.equals("4")||scelta.equals("5")||scelta.equals("6")||scelta.equals("7"))) {//Controlla se abbia inserito numeri da 0-9
						System.out.println("input non valido sbagliato.");
					}else {
						break;
					}
					//Controlla i numeri di tentativi
					if(i==2){
						//System.out.println("Vuoi continuare ad inserire i codici?");
						if(richiesta("Vuoi continuare ad inserire i codici?", scanner)==false) {
							System.out.println("Uscita dal programma...");
							return 7;
						}else {
							i=-1;
						}
					}
				}
			}while(!(scelta.equals("1")||scelta.equals("2")||scelta.equals("3")||scelta.equals("4")||scelta.equals("5")||scelta.equals("6")||scelta.equals("7")));
		//Ritorna un intero
		return  Integer.parseInt(scelta);
	}
	
	//Controllo tipologia di utenza
	static boolean richiestaAutenticazione (String admin, Scanner scanner) {
		boolean ris = false;//Se è true è admin
		String id=" ";
		//Controllo scelta utente
		if(richiesta("Sei un operatore? [si/no]:", scanner)==false) {
			return false;
		}
		System.out.println("Hai selezionato l'interfaccia operatore");
		//Ciclo controllo numero tentativi
		for(int i=0; i<3; i++) {
			System.out.print("Inserisci il tuo codice univoco: ");
			id= scanner.nextLine().trim().toUpperCase();
			//Controllo se l'input è stato inserito correttamente
			if(id.length()>4) {
				System.out.println("Codice superiore di 4 caratteri. Numero di tentativi: " + (i+1) + "\rInserire di nuovo il codice.");
			}else if(!id.equals("A123")){
				System.out.println("Codice sbagliato. Numero di tentativi: " + (i+1) + "\rInserire di nuovo il codice.");
			}else {
				return ris= true;
			}
		}
		return ris;	  
	}
 
	public static void main(String[] args) {
	//Prioritarrio
		//Aggiungere su aggiungere la ricerca se l'utente mette lo stesso id
		//Creare interfaccia utente
	//Non prioritario
		//Fare in modo che gneri in modo autonomo il codice (es. riga 0 avra come prima lettera 'a',...)
		//Se si ha tempo fare un metodo che controlla che il la prima cella dell'id sia una lettera
		
		//ArrayLsit che contiene i prodotti
		prodotti [][] prodotto = new prodotti[10][3];
		
		//dichiarazione e inizializzazione dello scanner
		Scanner scanner= new Scanner (System.in);
		
		//Dichiarazione e inizializzazione delle variabili
		final String idAdmin= "A123"; //Codice univoco dell'admin
		
		//Ciclo per ripetere il programma
		do { 
		//Controllo se ha scelto operatore
		if(richiestaAutenticazione(idAdmin, scanner)) {
			boolean ripetizione=true;
			System.out.println("Sei entrato nell'interfaccia admin");
	        //Ciclo per far continuare all'utente inserimento delle opzioni nell'interfacccia opretore
	        do {
					switch (richiesta(scanner)) {
					case 1:
						System.out.println("Hai selezionato aggiungere un prodotto.");
						aggiungere(prodotto, scanner);
						break;   
					case 2:
						System.out.println("Hai selezionato rimuovere un prodotto.");
						rimuovere(prodotto, scanner);
						break;
					case 3: 
						System.out.println("Hai selezionato cambiare la quantià di un prodotto.");
						cambiareQuat(prodotto, scanner);
						break;
					case 4:
						System.out.println("Hai selezionato cambiare prezzo di un prodtto.");
						cambiarePrezzo(prodotto, scanner);
						break;
					case 5:
						System.out.println("Hai selezionato il totale incasso di un distributtore.");
						break;
					case 6:
						System.out.println("Hai selezionato elenco dei prodotti acquistati con le relative quantità.");
						break;
					case 7:
						System.out.println("Hai selezionato uscita dall'interfaccia utente....");
						if(richiesta("Vuoi uscire dall'interfaccia operatore? [si/no]: ", scanner)==true) {
							ripetizione=false;
						}	 			
						break; 
					}
					System.out.println();
		        } while (ripetizione);    
				System.out.println("Uscita dall'interfaccia operatore...");
			}else {
				System.out.println("Sei entrato nell'interfaccia utente");
				int i=vuoti(prodotto, scanner);
				if(i==(prodotto.length*prodotto[0].length)) {
					System.err.println("Distributtore vuoto. \nAspetta che lo gestore lo riempa");
				}else {
					System.out.print("Inserisci l'ID della bevanda: ");
					String id =controlloID(prodotto, scanner);
					if(!id.isEmpty()) {
						int indiceProdotto []= ricerca(prodotto, id);
						System.out.println(String.format("Il prodotto %s: %.2f euro", prodotto[indiceProdotto[0]][indiceProdotto[1]].getNome(), prodotto[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()));
					} 		
				}			
			}
		}while((richiesta("Vuoi continuare con il programma? [si/no]: ", scanner)));
		System.out.println("Uscita dal programma...");
		
		//Chiusura dello scanner
		scanner.close();
		
		
	
		
		
	}
	
	static int[] ricerca(prodotti[][] prodotto, String ricercato) {
	    int[] ric = new int[]{-1, -1}; 
	    //Verifica se la lista dei prodotti è vuota o nulla
	    if (prodotto == null || prodotto.length == 0) {
	        System.out.println("La lista dei prodotti è vuota.");
	        return ric;//Restituisce l'array con valori di default
	    }
	    //Ricerca il prodotto per ID
	    for (int i = 0; i < prodotto.length; i++) {
	        for (int j = 0; j < prodotto[i].length; j++) {
	            if (prodotto[i][j] != null && ricercato.equals(prodotto[i][j].getId())) {
	                System.out.println("Prodotto trovato.");
	                ric[0] = i;//Indice della riga
	                ric[1] = j;//Indice della colonna
	                return ric;//Restituisce gli indici del prodotto trovato
	            }
	        }
	    }  

	    System.out.println("Prodotto non trovato.");
	    return ric;//Restituisce l'array con valori (-1, -1)
	}
	
	static String controlloID(prodotti[][] prodotto, Scanner scanner) {
	    final String regola = "^[a-zA-Z0-9]{1,4}$"; //Solo lettere/numeri, massimo 4 caratteri
	    String id;

	    while (true) {
	        System.out.println("Inserisci l'id:");
	        System.out.println("- Solo lettere e numeri \n- Non più lungo di 4 caratteri ");
	        id = scanner.nextLine().trim();

	        //Verifica il formato
	        if (!id.matches(regola)) {
	            System.err.println("L'ID deve contenere solo lettere e numeri ed essere lungo al massimo 4 caratteri.");
	        } else {
	            //Cerca l'ID se esiste
	            int[] posizione = ricerca(prodotto, id);
	            if (posizione[0] == -1) {
	                System.out.println("ID prodotto inesistente.");
	                if (!richiesta("Sei ancora interessato a prendere un altro prodotto? [si/no]: ", scanner)) {
	                    System.out.println("Uscita dal programma...");
	                    return " ";
	                }
	            } else {
	                return id;
	            }
	        }
	    }
	}
	 
	
    //Metodo per aggiungere prodotti alla macchinetta 
	//Se trova i scaffali pieni non puo aggiuengere nessun prodotto
	//Punta ad aggiungere il prodotto nel primo spazio libero
    static prodotti[][] aggiungere(prodotti[][] prod, Scanner scanner) {
    	int Categoria=0;
    	String id=" ";
    	String nome=" ";
    	double prezzo= 0;
    	int quantita=0;
    	//Richiama il metodo vuoti
        int spazioDisp = vuoti(prod, scanner);
        //controlla se ha i  scaffali pieni
        if (spazioDisp == 0) {
            System.out.println("Scaffali pieni.");
            return prod;
        }
        System.out.println("Hai spazio per " + spazioDisp + " prodotti.");
        int prodottiDaAggiungere;
        //Ciclo per far inserire la quantita giusta
        do {
            System.out.print("Quanti prodotti vuoi inserire? ");
            //Controlla se abbia inserito un intero
            if (scanner.hasNextInt()) {
                prodottiDaAggiungere = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                scanner.nextLine(); 
                System.out.println("Inserisci un numero valido.");
                //In modo da far ripetere il giro
                prodottiDaAggiungere = -1;
            }
        } while (prodottiDaAggiungere < 0 || prodottiDaAggiungere > spazioDisp);
        //Cicli che ci permette di viaggiare nella matrice e di controllare se faccia tutte le quantità
        for (int i = 0; i < prod.length && prodottiDaAggiungere > 0; i++) {
            for (int j = 0; j < prod[i].length && prodottiDaAggiungere > 0; j++) {
            	//Controlla se sia vuoto (se si in caso lo aggiunge)
                if (prod[i][j] == null || prod[i][j].getQuantita() == 0) { 
                	int p=0;
                	//Per controllare se scelga la giusta categoria
                    // Per controllare se scelga la giusta categoria
                    do {
                        System.out.println("Inserisci la categoria: ");
                        System.out.println("1) Bevande calde");
                        System.out.println("2) Bevande fredde");

                        if (scanner.hasNextInt()) {
                            p = scanner.nextInt(); 
                            scanner.nextLine();
                        } else {
                            scanner.nextLine(); 
                            System.out.println("Inserisci un numero valido.");
                        }

                        if (p < 1 || p > 2) {
                            System.out.println("Devi scegliere un numero da 1 a 2.");
                        }

                    } while (p < 1 || p > 2);
                	/*do {
                		p= controlloGenerico("Inserisci la categora: \n1) Bevande calde \n2) Bevande fredde", scanner, p);
                		if(p>2) {
                			System.out.println("Devi mettere un numero da 1 a %2");
                		}
                	}while(p>2);*/
                    //Richiamo il costruttore 
                    prod[i][j] = new prodotti(controlloGenerico("Inserisci il codice univoco del prdotto: ", scanner, id), controlloGenerico("Inserisci il nome del prodotto: ", scanner, nome), controlloGenerico("Inserisci il prezzo: ", scanner, prezzo), controlloGenerico("Inserisci la quantita: ", scanner, quantita),p-1);
                    //controlloGenerico("Inserisci il prezzo", scanner, prezzo)
                    //Decremento in modo da far capire che abbiamo aggiunto il prodotto
                    prodottiDaAggiungere--;
                    System.out.println("Aggiunto prodotto a posizione: [" + i + "][" + j + "]");
                }
            }
        }
        return prod;
    }
    
    
    //Metodo per rimuovere prodotti dalla macchinetta 
	//Se trova i scaffali vuoti non puo togliere nessun prodotto
	//Cerca il prodotto che vuoi eliminare
    //Eliminare un specifico prodotta dal distributtore
    static prodotti[][] rimuovere(prodotti[][] prod, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(prod, scanner);
    	String id=" ";

    	//Controllo se è vuoto
    	if(spazioVuoti==(prod.length*prod[0].length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		return prod;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (prod.length*prod[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi rimuovere: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.out.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	int a=1;//Conta i numeri di prodotti rimossi
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<prod.length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<prod[i].length; j++) {
	    			if(prod[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(prod[i][j].getId())) {
		    				System.out.println("Prodotto rimosso");
		    				prod[i][j]=null;
		    				a++;
		    				prodottoRim=true;
		    				break;
		    			}
	    			}
	    		}
	    		if(prodottoRim==false)break;
	    	}
	    	if(prodottoRim==false) {
	    		System.out.println("Id non trovato.");
	    	}
	    	prodottoRim=false;
    	}while(a<=prodRimuovere);
    	return prod;
    }
    
    //Cambiare quantita
    static prodotti[][] cambiareQuat(prodotti[][] prod, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(prod, scanner);
    	String id=" ";
    	int cambiaQuat =0;

    	//Controllo se è vuoto
    	if(spazioVuoti==(prod.length*prod[0].length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		return prod;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (prod.length*prod[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi cambiare: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.out.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	int a=1;//Conta i numeri di prodotti cambiati
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<prod.length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<prod[i].length; j++) {
	    			if(prod[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(prod[i][j].getId())) {
		    				//Controllo quantita di cambiamneto prodotti
		    				do {
		    			    	System.out.print("Quanta quantita devi cambiare: ");
		    			    	cambiaQuat = scanner.nextInt();
		    			    	scanner.nextLine();
		    			    	if(cambiaQuat>prod[i][j].getQuatScomparto()||cambiaQuat<=0) {
		    			    		System.out.println("Hai inserito un valore non valido.");
		    			    	}
		    			    	System.out.println();
		    		    	}while(cambiaQuat>prod[i][j].getQuatScomparto()||cambiaQuat<=0);
		    				prod[i][j].setQuantita(cambiaQuat);
		    				System.out.println("Quantita cambiata");
		    				a++;
		    				prodottoRim=true;
		    				break;
		    			}
	    			}
	    		}
	    		if(prodottoRim==false)break;
	    	}
	    	if(prodottoRim==false) {
	    		System.out.println("Id non trovato.");
	    	}
	    	prodottoRim=false;
    	}while(a<=prodRimuovere);
    	return prod;
    }
    
    //Cambiare quantita
    static prodotti[][] cambiarePrezzo(prodotti[][] prod, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(prod, scanner);
    	String id=" ";
    	int cambiaQuat =0;

    	//Controllo se è vuoto
    	if(spazioVuoti==(prod.length*prod[0].length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		return prod;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (prod.length*prod[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi cambiare: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.out.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	int a=1;//Conta i numeri di prodotti cambiati
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<prod.length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<prod[i].length; j++) {
	    			if(prod[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(prod[i][j].getId())) {
		    				//Controllo quantita di cambiamneto prodotti
		    				do {
		    			    	System.out.print("Inserisci il nuovo prezzo: ");
		    			    	cambiaQuat = scanner.nextInt();
		    			    	scanner.nextLine();
		    			    	if(cambiaQuat<=0) {
		    			    		System.out.println("Hai inserito un valore non valido.");
		    			    	}
		    			    	System.out.println();
		    		    	}while(cambiaQuat<=0);
		    				prod[i][j].setPrezzo(cambiaQuat);
		    				System.out.println("Prezzo cambiato");
		    				a++;
		    				prodottoRim=true;
		    				break;
		    			}
	    			}
	    		}
	    		if(prodottoRim==false)break;
	    	}
	    	if(prodottoRim==false) {
	    		System.out.println("Id non trovato.");
	    	}
	    	prodottoRim=false;
    	}while(a<=prodRimuovere);
    	return prod;
    }
    
    //Metodo per rimuovere prodotti dalla macchinetta 
	//Se trova i scaffali vuoti non puo togliere nessun prodotto
	//Cerca il prodotto che vuoi eliminare
    /*static prodotti[][] rimuovere(prodotti[][] prod, Scanner scanner) {
    	//Trovo il pieno
        int prodottiPresenti = prod.length * prod[0].length - vuoti(scaf);
        // Crea una lista di prodotti da rimuovere
        ArrayList<prodotti> prodottiDisponibili = new ArrayList<>();
        int prodottoDaRimuovere;
        prodotti prodottoSelezionato;
        //Controlla se sia vuoto i scaffalli  
        if (prodottiPresenti == 0) {
            System.out.println("Scaffali vuoti.");
            return prod;
        }
        System.out.println("Prodotti presenti: " + prodottiPresenti);
        //Cicli per viaggiare nella matrice
        for (int i = 0; i < prod.length; i++) {
            for (int j = 0; j < prod[i].length; j++) {
            	//Controlla se lo scomparso non sia vuoto e poi serve per confronto 
                if (prod[i][j] != null && prod[i][j].getQuantità() > 0) {
                    prodottiDisponibili.add(prod[i][j]);
                    System.out.println((prodottiDisponibili.size()) + ". " + prod[i][j].getNome() + " con quantità: " + prod[i][j].getQuantità());
                }
            }
        } 
        //Controlla se  non ha trovato nessun prodotto
        if (prodottiDisponibili.isEmpty()) {
            System.out.println("Nessun prodotto da rimuovere.");
            return prod;
        }
        //controllo input
        do {
            System.out.print("Scegli il prodotto da eliminare: ");
            prodottoDaRimuovere = scanner.nextInt();
            scanner.nextLine(); 
            if (prodottoDaRimuovere < 1 || prodottoDaRimuovere > prodottiDisponibili.size()) {
                System.out.println("Numero non valido.");
            }
        } while (prodottoDaRimuovere < 1 || prodottoDaRimuovere > prodottiDisponibili.size());
        prodottoSelezionato = prodottiDisponibili.get(prodottoDaRimuovere - 1);
        System.out.println("Hai scelto di rimuovere: " + prodottoSelezionato.getNome() + " con quantità: " + prodottoSelezionato.getQuantità());
        int quantitàDaRimuovere;
        //Chiede la quantità da eliminare
        do {
            System.out.print("Quanta quantità di " + prodottoSelezionato.getNome() + " vuoi rimuovere? ");
            quantitàDaRimuovere = scanner.nextInt();
            scanner.nextLine(); 
            if (quantitàDaRimuovere < 1 || quantitàDaRimuovere > prodottoSelezionato.getQuantità()) {
                System.out.println("Quantità non valida, Inserisci un valore tra 1 e " + prodottoSelezionato.getQuantità() + ".");
            }
        } while (quantitàDaRimuovere < 1 || quantitàDaRimuovere > prodottoSelezionato.getQuantità());
        //Conferma con l'utente se vuole davvero rimuovere la quantità selezionata
        if (richiesta("Vuoi rimuovere " + quantitàDaRimuovere + " unità di questo prodotto? [si/no]: ", scanner).equals("si")) {
            prodottoSelezionato.rimuoviQuantità(quantitàDaRimuovere); 
            System.out.println("Quantità rimossa.");
        } else {
            System.out.println("Nessun prodotto rimosso.");
        }

        return prod;
    }*/
    
    //Metodo per calcolare i scomparti vuoti
    //Se il ritorno è 0 vuol dire che il distributtore sia pieno
    static int vuoti(prodotti[][] prod, Scanner scanner) {
        int vuoti = 0;//Tiene conto degli spazi vuoti
        //Scorre ogni riga della matrice  prod
        for (prodotti[] sup : prod) {
            for (prodotti scomp : sup) {//Ogni cella della riga 
            	//Controllo per trovare i spazi vuoti
            	//Se li trova vuoti li conta
                if (scomp == null || scomp.getQuantita() <= 0) {
                    vuoti++;
                }
            }
        }
        return vuoti;
    }
    
    
    //Overloading
    //Metodo controllo generico di una stringa
    static String controlloGenerico (String frase, Scanner scanner, String sup) {
    	//Controllo che la stringa non sia vuota
    	do {
    		System.out.println(frase);
    		//Toglie gli spazi iniziali e mette la stringa tutto in piccolo
    		sup=scanner.nextLine().trim().toLowerCase();
    		if(sup.isEmpty()) {
    			System.out.println("Hai lasciato il campo vuoto");
    		}
    	}while(sup.isEmpty());
    	System.out.println("Valore inserito");
    	return sup;
    } 
    //Metodo controllo generico di una stringa
    static int controlloGenerico(String frase, Scanner scanner, int sup) {
        do {
            System.out.println(frase);
            
            //Controlla se è un intero
            if (scanner.hasNextInt()) {
                sup = scanner.nextInt();
                scanner.nextLine(); 
                if (sup <= 0) {
                    System.out.println("Il numero non deve essere minore o uguale a 0.");
                }
            } else {
                scanner.nextLine(); 
                System.out.println("Inserisci un numero valido.");
            }
        } while (sup <= 0);
        System.out.println("Valore inserito");
        return sup;
    }

    // Metodo per controllo di un double
    static double controlloGenerico(String frase, Scanner scanner, double sup) {
        do {
            System.out.println(frase);

            //Controlla se è un double
            if (scanner.hasNextDouble()) {
                sup = scanner.nextDouble();
                scanner.nextLine(); 
                if (sup <= 0) {
                    System.out.println("Il numero non deve essere minore o uguale a 0.");
                }
            } else {
                scanner.nextLine(); 
                System.out.println("Inserisci un numero valido.");
            }
        } while (sup <= 0); //Continua finché non è valido
        System.out.println("Valore inserito");
        return sup;
    }
    

}




