package distributtore;

import java.util.Scanner;

public class operatore {
	 
	//Overloading del metodo richiesta
	//Metodo controllo se vuoi continuare
	static boolean richiesta(String frase, Scanner scanner) {
		boolean ris= false;
		String scelta=" ";
		do {
			System.out.print(frase+ " ");
			scelta= scanner.nextLine().trim().toLowerCase();
			if(!(scelta.equals("si")||scelta.equals("no"))) {
				System.out.println("input non valido .");
			}else if(scelta.equals("no")) 
			{
				return ris;
			}
		}while(!(scelta.equals("si")||scelta.equals("no")));
		ris=true;
		return ris;
	}
	//Metodo per richiedere l'opzioni admin //Non utilizzato
	static int richiesta (Scanner scanner) {
		String scelta=" ";
		stampaMenu();
			//Ciclo per vedere se l'input utente sia valido
			do {
				for(int i=0; i<3; i++) {
					System.out.print("Inserici il numero dell'opzione che vuoi selezionare: ");
					scelta= scanner.nextLine().trim().toLowerCase();
					//Controllo solo per i caratteri numerici
					if(!scelta.matches("\\d+")) {
						System.err.println("Il codice è solo caratteri numerici");
					}else if(!(scelta.equals("1")||scelta.equals("2")||scelta.equals("3")||scelta.equals("4")||scelta.equals("5")||scelta.equals("6")||scelta.equals("7")||scelta.equals("8"))) {//Controlla se abbia inserito numeri da 0-9
						System.err.println("input non valido.");
					}else {
						break;
					}
					//Controlla i numeri di tentativi
					if(i==2){
						//System.out.println("Vuoi continuare ad inserire i codici?");
						if(richiesta("Vuoi continuare ad inserire i codici?", scanner)==false) {
							System.out.println("Uscita dal programma...");
							return 8;
						}else {
							i=-1;
						}
					}
				}
			}while(!(scelta.equals("1")||scelta.equals("2")||scelta.equals("3")||scelta.equals("4")||scelta.equals("5")||scelta.equals("6")||scelta.equals("7")||scelta.equals("8")));
		//Ritorna un intero
		return  Integer.parseInt(scelta);
	}
	//Metodo per richiedere l'opzioni admin
	static int richiesta (String frase, String range, Scanner scanner) {
		String scelta=" ";
		System.out.println(frase);
			//Ciclo per vedere se l'input utente sia valido
			do {
				//Ciclo numero tentativi
				for(int i=0; i<3; i++) {
					System.out.print("Inserici il numero dell'opzione che vuoi selezionare: ");
					scelta= scanner.nextLine().trim().toLowerCase();
					//Controllo solo per i caratteri numerici
					if(!scelta.matches("\\d+")) {
						System.err.println("Il codice è solo caratteri numerici");
					}else if(!scelta.matches(range)) {//Controlla se abbia inserito numeri giusti dell'intervallo
						System.err.println("input non valido.");
					}else {
						break;
					}
					//Controlla i numeri di tentativi
					if(i==2){
						//System.out.println("Vuoi continuare ad inserire i codici?");
						if(richiesta("Vuoi continuare ad inserire i codici?", scanner)==false) {
							System.out.println("Uscita dal programma...");
							//da il valore dell'uscita
							return 7;
						}else {
							i=-1;
						}
					}
				}
			}while(!scelta.matches(range));
		//Ritorna un intero
		return  Integer.parseInt(scelta); 
	}
	//Metodo per la stampa del menu //Non utilizzato
	static void stampaMenu() {
		System.out.println("1) Aggiungere un prodotto.");
		System.out.println("2) Rimuovere un prodotto.");
		System.out.println("3) Cambiare la quantià di un prodotto.");
		System.out.println("4) Cambiare prezzo di un prodtto");
		System.out.println("5) Gestione del distributore");
		System.out.println("6) Il totale incasso di un distributtore.");
		System.out.println("7) Elenco dei prodotti acquistati con le relative quantità.");
		System.out.println("8) Uscita...");	
	}
	
	//Controllo tipologia di utenza
	static boolean richiestaAutenticazione (String admin, Scanner scanner) {
		boolean ris = false;//Se è true è admin
		String id=" ";
		//Controllo scelta utente
		if(richiesta("Sei un operatore? [si/no]:", scanner)==false) {
			return false;
		}
		System.out.println();
		System.out.println("Hai selezionato l'interfaccia operatore");
		//Ciclo controllo numero tentativi: Superati prendiamo per scontato che sia un cliente
		for(int i=0; i<3; i++) {
			System.out.print("Inserisci il tuo codice univoco: ");
			id= scanner.nextLine().trim().toUpperCase();
			//Controllo se l'input è stato inserito correttamente
			if(id.length()>4) {
				System.err.println("Codice superiore di 4 caratteri. Numero di tentativi: " + (i+1) + "\rInserire di nuovo il codice.");
			}else if(!id.equals("A123")){
				System.err.println("Codice sbagliato. Numero di tentativi: " + (i+1) + "\rInserire di nuovo il codice.");
			}else {
				return ris= true;
			}
		}
		return ris;	  
	}
 
	public static void main(String[] args) {
		
		//Dichiarazione di un'istanza del distributore 
		distributtore dis = new distributtore ();
		
		//dichiarazione e inizializzazione dello scanner
		Scanner scanner= new Scanner (System.in);
		
		//Dichiarazione e inizializzazione delle variabili
		final String idAdmin= "A123"; //Codice univoco dell'admin
		
		//Dichiarazione variabili
		double portafoglio=0; //Portafoglio dell'utente
		
		
		//Ciclo per ripetere il programma
		do { 
			System.out.println();
		//Controllo per smistare tra operatore e cliente(o utente)
		if(richiestaAutenticazione(idAdmin, scanner)) {
			boolean ripetizione=true;
			String frase1 = "1) Aggiungere un prodotto."
					+ "\n2) Rimuovere un prodotto."
					+ "\n3) Cambiare la quantià di un prodotto."
					+ "\n4) Cambiare prezzo di un prodtto"
					+ "\n5) Gestione del distributore"
					+ "\n6) Il totale incasso di un distributtore."
					+ "\n7) Elenco dei prodotti acquistati con le relative quantità."
					+ "\n8)Uscita...";
			System.out.println();
			System.out.println("\033[1m Sei entrato nell'interfaccia admin \033[0m");
	        //Ciclo per far continuare all'utente inserimento delle opzioni nell'interfacccia opretore
	        do {
	        	//Menu operatore
					switch (richiesta(frase1, "[1-8]", scanner)) {
					case 1:
						System.out.println("\nHai selezionato aggiungere un prodotto.");
						aggiungere(dis, scanner);
						break;   
					case 2:
						System.out.println("\nHai selezionato rimuovere un prodotto.");
						rimuovere(dis, scanner);
						break;
					case 3: 
						System.out.println("\nHai selezionato cambiare la quantià di un prodotto.");
						cambiareQuat(dis, scanner);
						break;
					case 4:
						System.out.println("\nHai selezionato cambiare prezzo di un prodotto.");
						cambiarePrezzo(dis, scanner);
						break;
					case 5:
						//Case che contiene la gestione dello distributtore
						System.out.println("\nHai selezionato gestione del distributore.");
						String frase2 = "1) Gestione quantità dei bicchieri."
								+ "\n2) Gestione quantità zucchero."
								+ "\n3) Gestione quantità bacchette."
								+ "\n4) uscita";
						boolean ripetizione2 = true;
						//Ciclo per far continuare la gestione della gestione del distributore
						//i primi 3 case richiamano imetodi per la gestione del distributore
						do{
							switch(richiesta(frase2, "[1-4]", scanner)) {
							case 1:
								String frase = String.format("\nInserisci la quantita dei bicchieri (non superiore di %d): ", dis.getquatBicchieriMax());
								System.out.println("Hai selezionato gestione dei bicchieri.");
								dis.setquatBicchieriMax(gestioneDistributore(frase, dis.getquatBicchieriMax(), scanner));
								break;
							case 2:
								System.out.println("\nHai selezionato gestione quantità zucchero.");
								frase = String.format("Inserisci la quantita dello zucchero (non superiore di %d): ", dis.getquatZuccheroMax());
								dis.setquatZuccheroMax(gestioneDistributore(frase, dis.getquatZuccheroMax(), scanner));
								break;
							case 3:
								System.out.println("\nHai selezionato gestione quantità bacchette.");
								frase = String.format("Inserisci la quantita delle bacchette (non superiore di %d): ", dis.getquatBacchetteMax());
								dis.setquatZuccheroMax(gestioneDistributore(frase, dis.getquatBacchetteMax(), scanner));
								break;
							case 4:
								//Uscita dalla gestione del menu gestione del distributore
								System.out.println("\nHai selezionato uscita dalla gestione distributore");
								if(richiesta("Vuoi uscire dalla gestione del distributore? [si/no]: ", scanner)==true) {
									ripetizione2=false;
								}
								break;
							}
							System.out.println();
						}while(ripetizione2);					
						break;
					case 6:
						System.out.println("\nHai selezionato il totale incasso di un distributore.");
						System.out.println("L'incasso totale è pari a: " +dis.getIncasso());
						break;
					case 7:
						System.out.println("\nHai selezionato elenco dei prodotti acquistati con le relative quantità.");
						dis.listaProdottiAcquistati();
						break;
					case 8:
						//Uscita dal menu
						System.out.println("\nHai selezionato uscita dall'interfaccia utente....");
						if(richiesta("Vuoi uscire dall'interfaccia operatore? [si/no]: ", scanner)==true) {
							ripetizione=false;
						}	 			 
						break; 
					}
					System.out.println();
		        } while (ripetizione);    
				System.out.println("Uscita dall'interfaccia operatore...");
			}else {
				//Sezione della gestione dell'utente
				System.out.println();
					System.out.println("\033[1m Sei entrato nell'interfaccia utente \033[0m");
					//Generazione radomiche dei valori dell'utente
					portafoglio=Math.random() * 10;//Da 0 a 10
					System.out.println(String.format("Hai un budget di %.2f", portafoglio));
					System.out.println();
					//Dichiarazione variabile
					double moneta=0;
					//Ottieno il numero di spazi vuoti
					int i=vuoti(dis, scanner);
					//Controllo per vedere se il distributtore sia vuoto
					if(i==(dis.getProdotto().length*dis.getProdotto()[0].length)) {
						System.err.println("Distributtore vuoto. \nAspetta che lo gestore lo riempa");
					}else {
						//Controllo se ha abbastanza soldi
						if(portafoglio >0) {
							//Ciclo per far continuare a d erogare altri prodotti
						do {
							System.out.println();
							//Richiesta id
							String id =controlloID(dis, scanner);
							//Controllo id valido
							if(!id.isEmpty()) {
								//Ricerca id esistente 
								int indiceProdotto []= ricerca(dis, id);
								//Controlla se lo ha trovato ind: id=-1 vuol dire che non lo ha trovato
								if(indiceProdotto[0]!=-1) {
									System.out.println(String.format("Il prodotto %s: %.2f euro", dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getNome(), dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()));
									//Controlla se ha i soldi per acquistare quel prodotto
									if(portafoglio>dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()) { 
										//Smista se è bevanda fredda o calda
										switch(dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getCont()) {
										case 1:
											//Entrato nelle bevande fredde
											System.out.println();
											//Metodo per gestire la moneta
											portafoglio = gestioneMoneta(indiceProdotto, scanner, dis, portafoglio);
											dis.prodottiAcquistati(indiceProdotto[0],indiceProdotto[1]); 
											break;
										case 2:
											System.out.println();
											//Dichiarazione e inizializzazione della variabile per la quantita dello zuccheoro
											int quatZucchero =0;
											//Controlla se abbiamo dei bicchieri (false---> non eroga)
											if(dis.getQuatBichieri()>0) {
												//Entrato nelle bevandea calda
												portafoglio = gestioneMoneta(indiceProdotto, scanner, dis, portafoglio);
												//RILASCIA IL BICCHIERE
												dis.decrementoQuatBichieri();
												System.out.println();
												//Controlla  se abbiamo lo zucchero
												if(dis.getQuatZucchero()<=0) {
													System.err.println("Zucchero insufficiente.");
													if(richiesta("Vuoi continuare senza lo zucchero?", scanner)==false) {
														break;
													}
												} else {
													//Erogazione dello zucchero
													//Ciclo per far inserire il giusto numero di zucchero
													while(true) {
														 //Chiedere la quantita zucchero da 1 a 5
														do {
															quatZucchero= controlloGenerico("Quantita zucchero: ° ° ° ° °\n Inserisci lo zucchero [1-5]: ", scanner, quatZucchero);
															if(quatZucchero>5) {
																System.err.println("Error: Quantita impostata insufficiente");
															}	
														}while(quatZucchero>5);	
														if(dis.getQuatZucchero()<quatZucchero) {
															System.out.println(String.format("Erogato solo %d zollette di zucchero", dis.getQuatZucchero()));
															quatZucchero = dis.getQuatZucchero();
														}
														//Rilascia lo zucchero
														dis.decrementoQuatZucchero(quatZucchero);
														break;
													}
												}
												//controlla le bacchette
												if(dis.getQuatBacchette()<=0) {
													System.err.println("Bacchette insufficienti.");
													if(richiesta("Vuoi continuare senza le bacchette?", scanner)==false) {
														break;
													}
												}else {
													//Rilascia la bacchetta
													dis.decrementoQuatBachette();
												}
												System.out.println("\033[1m Erogazione della bevanda... \033[0m");
												//Decremetna la quantita prodoto
												dis.prodottiAcquistati(indiceProdotto[0],indiceProdotto[1]);		
											}else {
												System.err.println("Bicchieri insufficienti.");
											}
											break;
										}
								    }else {
								    	System.err.println("Non hai abbastanza soldi per quel prodotto");
								    }
								}							
							} 
							System.out.println();
						}while(richiesta("Vuoi continuare a prendere un altro prodotto? [si/no]:",  scanner));
					}else {
						System.err.println("Non hai abbastanza soldi");		
					}
				}
			}
		System.out.println();
		}while((richiesta("Vuoi continuare con il programma? [si/no]: ", scanner)));
		System.out.println("Uscita dal programma...");
		
		//Chiusura dello scanner
		scanner.close();		
	} 
	
	//Metodo per la gestione delle quantita distributore (bicchieri, bacchette, zucchero)
	static int gestioneDistributore (String frase, int quatMax, Scanner scanner) {
		int quat=0;
		//Controllo che non abbia inserito la quanitta massima
		do {
			quat= controlloGenerico(frase, scanner, quat);
			if(quat>quatMax) {
				System.err.println("Hai superato la quantita massima possibile. ");
			}
		}while(quat>quatMax);
		System.out.println("Quantita inserita.");
		return quat;
	}
	
	//Gestione moneta 
	static double gestioneMoneta (int [] indiceProdotto, Scanner scanner, distributtore dis, double portafoglio) {
		double somma=0;
		double moneta=0;
		//Ciclo per far continuare l'inserimento delle monete fino alla cifra giusta
		while(true) {
			moneta=ControlMoneta(scanner);
			//Conta le monete inserite
			somma += moneta;
			portafoglio -= somma;
			System.out.println(String.format("Hai un budget di %.2f", portafoglio));
			//Controlla se gli bastano le monete
			if(somma<dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()) {
				System.err.println("Importo non ancora disponibile");
				continue;
				//Contrlla se ce bisogno di erogare il resto
			}else if(somma>dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()) {
				//Restituzione del resto
				portafoglio = portafoglio + (somma-dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo());
				System.out.println("Erogazione resto");
				break;
			}
			if(somma==dis.getProdotto()[indiceProdotto[0]][indiceProdotto[1]].getPrezzo()) {
				break;
			}
			
		}
		return portafoglio;
	}
	
	//Controllo formato moneta
	static double ControlMoneta (Scanner scanner) {
		double denaro=0;
		//Ciclo controllo formato
		do {
			denaro = controlloGenerico("Inserisci una moneta [1€, 0.50€, 0.20€, 0.10€]: ", scanner, denaro);
			if(!(denaro==1.00||denaro==0.50||denaro==0.20||denaro==0.10)) {
				System.err.println("Moneta non valida");
			}
		}while(!(denaro==1.00||denaro==0.50||denaro==0.20||denaro==0.10));
		return denaro;
	}
	
	static int[] ricerca(distributtore dis, String ricercato) {
	    int[] ric = new int[]{-1, -1}; 
	    //Verifica se la lista dei prodotti è vuota o nulla
	    if (dis == null || dis.getProdotto().length == 0) {
	        System.out.println("La lista dei prodotti è vuota.");
	        return ric;//Restituisce l'array con valori di default
	    }
	    //Ricerca il prodotto per ID
	    for (int i = 0; i < dis.getProdotto().length; i++) {
	        for (int j = 0; j < dis.getProdotto()[i].length; j++) {
	            if (dis.getProdotto()[i][j] != null && ricercato.equals(dis.getProdotto()[i][j].getId())) {
	                ric[0] = i;//Indice della riga
	                ric[1] = j;//Indice della colonna
	                return ric;//Restituisce gli indici del prodotto trovato
	            }
	        }
	    }  

	   
	    return ric;//Restituisce l'array con valori (-1, -1) quindi comporta che non abbia trovato niente
	}
	
	static String controlloID(distributtore dis, Scanner scanner) {
	    final String regola = "^[a-zA-Z0-9]{1,4}$"; //Solo lettere/numeri, massimo 4 caratteri
	    String id;

	    while (true) {
	        System.out.println("Regolamento scrittura id: ");
	        System.out.println("- Solo lettere e numeri \n- Non più lungo di 4 caratteri ");
	        System.out.print("Inserisci l'id: ");
	        id = scanner.nextLine().trim();

	        //Verifica il formato
	        if (!id.matches(regola)) {
	            System.err.println("L'ID deve contenere solo lettere e numeri ed essere lungo al massimo 4 caratteri.");
	        } else {
	            //Cerca l'ID se esiste
	            int[] posizione = ricerca(dis, id);
	            if (posizione[0] == -1) {
	                System.out.println("ID prodotto inesistente.");
	                    return " ";
	            } else {
	            	System.out.println("Prodotto trovato");
	                return id;
	            }
	        }
	    }
	}
	 
	
    //Metodo per aggiungere prodotti alla macchinetta 
	//Se trova i scaffali pieni non puo aggiuengere nessun prodotto
	//Punta ad aggiungere il prodotto nel primo spazio libero
    static distributtore aggiungere(distributtore dis, Scanner scanner) {
    	int Categoria=0;
    	String id=" ";
    	String nome=" ";
    	double prezzo= 0;
    	int quantita=0;
    	//Richiama il metodo vuoti
        int spazioDisp = vuoti(dis, scanner);
        //controlla se ha i  scaffali pieni
        if (spazioDisp == 0) {
            System.out.println("Scaffali pieni.");
            return dis;
        }
        System.out.println("Hai spazio per " + spazioDisp + " prodotti.");
        int prodottiDaAggiungere;
        //Ciclo per far inserire la quantita giusta
        do {
            System.out.print("Prodotti da inseire: ");
            //Controlla se abbia inserito un intero
            if (scanner.hasNextInt()) {
                prodottiDaAggiungere = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                scanner.nextLine(); 
                System.err.println("Inserisci un numero valido.");
                //In modo da far ripetere il giro
                prodottiDaAggiungere = -1;
            }
        } while (prodottiDaAggiungere < 0 || prodottiDaAggiungere > spazioDisp);
        System.out.println();
        //Cicli che ci permette di viaggiare nella matrice e di controllare se faccia tutte le quantità
        for (int i = 0; i < dis.getProdotto().length && prodottiDaAggiungere > 0; i++) {
            for (int j = 0; j < dis.getProdotto()[i].length && prodottiDaAggiungere > 0; j++) {
            	//Controlla se sia vuoto (se si in caso lo aggiunge)
                if (dis.getProdotto()[i][j] == null || dis.getProdotto()[i][j].getQuantita() == 0) { 
                	int p=0;
                	//Per controllare se scelga la giusta categoria
                    do {
                        System.out.println("Tipologie bevande ");
                        System.out.println("1) Bevande fredde");
                        System.out.println("2) Bevande calde");
                        System.out.print("Inserisci la categoria: ");
                        if (scanner.hasNextInt()) {
                            p = scanner.nextInt(); 
                            scanner.nextLine();
                        } else {
                            scanner.nextLine(); 
                            System.err.println("Inserisci un numero valido.");
                        }

                        if (p < 1 || p > 2) {
                            System.err.println("Devi scegliere un numero da 1 a 2.");
                        }

                    } while (p < 1 || p > 2);
                    int indice[]=new int[2];
                    //Controlla se quel prodotto sia gia stato inserito
                    while(true) {
                        id=controlloGenerico("Inserisci il codice univoco del prodotto: ", scanner, id);
                        indice= ricerca(dis, id);
                    	if(indice[0]==-1) {
         
                    		break;
                    	}
                    }
                    nome=controlloGenerico("Inserisci il nome del prodotto: ", scanner, nome);
                    prezzo=controlloGenerico("Inserisci il prezzo: ", scanner, prezzo);
                    //Controlla che la quantita non superil numero max di spazio del scomparto
                    while(true) {
                    	quantita=controlloGenerico("Inserisci la quantita: ", scanner, quantita);
                    	if(quantita<=dis.getQuatScomparto()) {
                    		break;
                    	}
                    	System.err.println(String.format("Non puoi superare la quantita massima dello scomparto di %d", dis.getQuatScomparto()));
                    }
                    //Richiamo il costruttore 
                    prodotti prodottoDaInserire=new prodotti(id, nome,prezzo , quantita,p);
                    dis.getProdotto()[i][j]=prodottoDaInserire;
                    //Decremento in modo da far capire che abbiamo aggiunto il prodotto
                    prodottiDaAggiungere--;
                    System.out.println();
                }
            }
        }
        return dis;
    }
    
    
    //Metodo per rimuovere prodotti dalla macchinetta 
	//Se trova i scaffali vuoti non puo togliere nessun prodotto
	//Cerca il prodotto che vuoi eliminare
    //Eliminare un specifico prodotta dal distributtore
    static distributtore rimuovere(distributtore dis, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(dis, scanner);
    	String id=" ";
    	
    	
    	

    	//Controllo se è vuoto
    	if(spazioVuoti==(dis.getProdotto()[0].length*dis.getProdotto().length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		
    		return dis;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (dis.getProdotto().length*dis.getProdotto()[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi rimuovere: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.err.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	int a=1;//Conta i numeri di prodotti rimossi
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<dis.getProdotto().length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<dis.getProdotto()[i].length; j++) {
	    			if(dis.getProdotto()[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(dis.getProdotto()[i][j].getId())) {
		    				System.out.println("Prodotto rimosso");
		    				dis.getProdotto()[i][j]=null;
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
	    	System.out.println();
    	}while(a<=prodRimuovere);
    	return dis;
    }
    
    //Cambiare quantita
    static distributtore cambiareQuat(distributtore dis, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(dis, scanner);
    	String id=" ";
    	int cambiaQuat =0;

    	//Controllo se è vuoto
    	if(spazioVuoti==(dis.getProdotto().length*dis.getProdotto()[0].length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		return dis;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (dis.getProdotto().length*dis.getProdotto()[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi cambiare: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.err.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	System.out.println();
    	int a=1;//Conta i numeri di prodotti cambiati
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<dis.getProdotto().length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<dis.getProdotto()[i].length; j++) {
	    			if(dis.getProdotto()[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(dis.getProdotto()[i][j].getId())) {
		    				//Controllo quantita di cambiamneto prodotti
		    				do {
		    			    	System.out.print("Quanta quantita devi cambiare: ");
		    			    	cambiaQuat = scanner.nextInt();
		    			    	scanner.nextLine();
		    			    	if(cambiaQuat>dis.getProdotto()[i][j].getQuatScomparto()||cambiaQuat<=0) {
		    			    		System.err.println("Hai inserito un valore non valido.");
		    			    	}
		    			    	System.out.println();
		    		    	}while(cambiaQuat>dis.getProdotto()[i][j].getQuatScomparto()||cambiaQuat<=0);
		    				dis.getProdotto()[i][j].setQuantita(cambiaQuat);
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
	    	System.out.println();
    	}while(a<=prodRimuovere);
    	return dis;
    }
    
    //Cambiare quantita
    static distributtore cambiarePrezzo(distributtore dis, Scanner scanner) {
    	
    	int spazioDisponibile=0; //Variabile per il totale
    	int prodRimuovere =0;
    	int spazioVuoti =vuoti(dis, scanner);
    	String id=" ";
    	double cambiaQuat =0;

    	//Controllo se è vuoto
    	if(spazioVuoti==(dis.getProdotto().length*dis.getProdotto()[0].length)) {
    		System.out.println("Il distributtore è vuoto. Non puoi rimuovere nessun prodotto.");
    		return dis;
    	}
    	
    	//Calcolo degli spazi disponibili
    	spazioDisponibile= (dis.getProdotto().length*dis.getProdotto()[0].length)-spazioVuoti;
    	System.out.println("Hai uno spazio disponibile di " + spazioDisponibile);
    	//Controllo per l'input degli spazi disponibile
    	do {
	    	System.out.print("Quanti prodotti devi cambiare: ");
	    	prodRimuovere = scanner.nextInt();
	    	scanner.nextLine();
	    	if(prodRimuovere>spazioDisponibile||prodRimuovere<=0) {
	    		System.err.println("Hai inserito un valore non valido.");
	    	}
	    	System.out.println();
    	}while(prodRimuovere>spazioDisponibile||prodRimuovere<=0);
    	System.out.println();
    	int a=1;//Conta i numeri di prodotti cambiati
    	boolean prodottoRim=false;
    	do {
        	//Controllo tentativi
        	id=controlloGenerico ("Inserire l'id: ", scanner, " ");
	    	//Ciclo per righe
	    	for(int i=0; i<dis.getProdotto().length; i++) {
	    		//Ciclo per le colonne
	    		for(int j=0; j<dis.getProdotto()[i].length; j++) {
	    			if(dis.getProdotto()[i][j] != null) {
		    			//Cotrollo se trova il valore
		    			if(id.equals(dis.getProdotto()[i][j].getId())) {
		    				//Controllo quantita di cambiamneto prodotti
		    				do {
		    			    	System.out.print("Inserisci il nuovo prezzo: ");
		    			    	cambiaQuat = scanner.nextDouble();
		    			    	scanner.nextLine();
		    			    	if(cambiaQuat<=0) {
		    			    		System.out.println("Hai inserito un valore non valido.");
		    			    	}
		    			    	System.out.println();
		    		    	}while(cambiaQuat<=0);
		    				dis.getProdotto()[i][j].setPrezzo(cambiaQuat);
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
	    	System.out.println();
    	}while(a<=prodRimuovere);
    	return dis;
    }

    
    //Metodo per calcolare i scomparti vuoti
    //Se il ritorno è 0 vuol dire che il distributtore sia pieno
    static int vuoti(distributtore dis, Scanner scanner) {
        int vuoti = 0;//Tiene conto degli spazi vuoti
        //Scorre ogni riga della matrice  prod
        for (prodotti[] sup : dis.getProdotto()) {
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
    		System.out.print(frase);
    		//Toglie gli spazi iniziali e mette la stringa tutto in piccolo
    		sup=scanner.nextLine().trim().toLowerCase();
    		if(sup.isEmpty()) {
    			System.err.println("Hai lasciato il campo vuoto");
    		}
    	}while(sup.isEmpty());
    	
    	return sup;
    } 
    //Metodo controllo generico di una stringa
    static int controlloGenerico(String frase, Scanner scanner, int sup) {
        do {
            System.out.print(frase);
            
            //Controlla se è un intero
            if (scanner.hasNextInt()) {
                sup = scanner.nextInt();
                scanner.nextLine(); 
                if (sup <= 0) {
                    System.err.println("Il numero non deve essere minore o uguale a 0.");
                }
            } else {
                scanner.nextLine(); 
                System.err.println("Inserisci un numero valido.");
            }
        } while (sup <= 0);
        
        return sup;
    }

    // Metodo per controllo di un double
    static double controlloGenerico(String frase, Scanner scanner, double sup) {
        do {
            System.out.print(frase);

            //Controlla se è un double
            if (scanner.hasNextDouble()) {
                sup = scanner.nextDouble();
                scanner.nextLine(); 
                if (sup <= 0) {
                    System.err.println("Il numero non deve essere minore o uguale a 0.");
                }
            } else {
                scanner.nextLine(); 
                System.err.println("Inserisci un numero valido.");
            }
        } while (sup <= 0); //Continua finché non è valido
       
        return sup;
    }


}



