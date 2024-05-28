package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorFeedback {
	Scanner input = new Scanner(System.in);
	ArrayList<Feedback>listaFeedback = new ArrayList<Feedback>();

/*
 * Depois temos de realocar isto mas por um motivo de organização pos aqui por enquanto
*/
	public void insereFeedback() {
		String valida;
		byte menu = 0;
		
		do {
			
			System.out.println("****************Feedback****************");
			System.out.println("Pretende enviar algum feedback? (sim/nao)");
			valida = input.nextLine();
			
			while(valida.equalsIgnoreCase("sim") && valida.equalsIgnoreCase("nao") && valida.equalsIgnoreCase("não")) {
			      System.out.println("---ERRO---Formato invalido escreva de novo (sim/nao)");
			      valida = input.nextLine();
			} 
			
			if(valida.equalsIgnoreCase("sim")) {
				Byte pontualidade = null;
				Byte conforto = null;
				Byte acessibilidade = null;
				Byte limpeza = null;
				String comentarios = null;
				String sugestoesRotas = null;
				String livroReclamacoes = null;
				
				
				do {
					System.out.println("______________Opções do menu______________\n1/ Pontualidade \n2/ Conforto \n3/ Acessibilidade "
					+ "\n4/ Limpeza \n5/ Comentários \n6/ Sugerir Rotas \n7/ Livro de Reclamações \n0/ Enviar Feedback ");
				    menu = input.nextByte();
				   
				    switch(menu) {
				    case 0:
				    	System.out.println("A enviar o feedback...");
				    	break;
				    case 1:
				    	System.out.println("Como avalia a pontualidade? (0 a 5)");
				    	pontualidade = input.nextByte();
				    	break;
				    	
				    case 2:
				    	System.out.println("Como avalia o conforto? (0 a 5)");
				    	conforto = input.nextByte();
				    	break;
				    	
				    case 3:
				    	System.out.println("Como avalia a acessibilidade? (0 a 5)");
				    	acessibilidade= input.nextByte();
				    	break;
				    	
				    case 4:
				    	System.out.println("Como avalia a nossa limpeza (0 a 5)");
				    	limpeza = input.nextByte();
				    	break;
				    case 5:
				    	System.out.println("Deixe aqui o seu comentário comentários ");
				    	comentarios = input.nextLine();
				    	break;
				    case 6:
				    	System.out.println("Deixe uma sugestão pra criar-mos novas rotas ");
				    	sugestoesRotas = input.nextLine();
				    	break;
				    case 7:
				    	System.out.println("Tem alguma reclamação escreva aqui ");
				    	livroReclamacoes = input.nextLine();
				    default:
				    	System.out.println("Escreva numeros válidos");
				    }
				}while(menu != 0);
				
				Feedback feedback = new Feedback(pontualidade, conforto, acessibilidade, limpeza, comentarios, sugestoesRotas, livroReclamacoes);
				listaFeedback.add(feedback);
				System.out.println("Obrigado pelo seu Feedback :]");
				
			}
		}while(menu != 0);
	}				
			
	
	public String FeedbackRota() {
		
		byte pontualidade = calculaPontualidade();
		byte conforto = calculaConforto();
		byte acessibilidade = calculaAcessibilidade();
		byte limpeza = calculaLimpeza();
	    return "______Avaliações da Rota (0 a 5)______\nPontualidade: "+ pontualidade+"\nConforto: "+ conforto+ 
				"\nAcessibilidade: "+ acessibilidade+"\nLimpeza: "+limpeza;
		
	}
	 public byte calculaPontualidade() {
	  	  double pontos = 0;
	  	  int i = 0;
	  	  for( i = 0; i< listaFeedback.size(); i++) {
	  		  pontos = pontos +  listaFeedback.get(i).getPontualiade().byteValue();
	  	  }
	  	   pontos = pontos/ i;
	  	  byte res = (byte) Math.round(pontos);
	  	  return res;
	    }
	    
	    public byte calculaConforto() {
	  	  double pontos = 0;
	  	  int i = 0;
	  	  for( i = 0; i< listaFeedback.size(); i++) {
	  		  pontos = pontos + listaFeedback.get(i).getConforto().byteValue();
	  	  }
	  	   pontos = pontos/ i;
	  	  byte res = (byte) Math.round(pontos);
	  	  return res;
	    }
	    
	    public byte calculaAcessibilidade() {
	  	  double pontos = 0;
	  	  int i = 0;
	  	  for( i = 0; i< listaFeedback.size(); i++) {
	  		  pontos = pontos + listaFeedback.get(i).getConforto().byteValue();
	  	  }
	  	   pontos = pontos/ i;
	  	  byte res = (byte) Math.round(pontos);
	  	  return res;
	    }
	    
	    public byte calculaLimpeza() {
	  	  double pontos = 0;
	  	  int i = 0;
	  	  for( i = 0; i< listaFeedback.size(); i++) {
	  		  pontos = pontos + listaFeedback.get(i).getConforto().byteValue();
	  	  }
	  	   pontos = pontos/ i;
	  	  byte res = (byte) Math.round(pontos);
	  	  return res;
	    }
}
