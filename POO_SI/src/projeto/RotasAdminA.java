package projeto;

import java.util.Scanner;
import java.util.ArrayList;
public class RotasAdminA {

	// Lista para armazenar os feedbacks
	private ArrayList<Feedback>feedback;
	
	// Lista para armazenar as paragens associadas à rota
	private ArrayList<ParagensRota>Paragens;
	
	// inicializacao de variaveis
	private String numRota;
	private String inicio;
	private String fim;
	
	// Scanner para entrada do usuário
	Scanner sc = new Scanner(System.in);
	
	 // Construtor da classe RotasAdminA
	public RotasAdminA(String numRota, String inicio, String fim) {
		Paragens = new ArrayList<ParagensRota>();
		feedback = new ArrayList<Feedback>();
		
		// Inicializa os atributos com os valores passados
		this.numRota = numRota;
		this.inicio = inicio;
		this.fim = fim;
	}


	/**
	 * @return the numRota
	 */
	public String getNumRota() {
		return numRota;
	}

	/**
	 * @return the inicio
	 */
	public String getInicio() {
		return inicio;
	}

	/**
	 * @return the fim
	 */
	public String getFim() {
		return fim;
	}
	
	/**
	 * @param o novo inicio
	 */
	public void setInicio(String novoinicio) {
		inicio = novoinicio;
	}

	/**
	 * @param fim para alterar feIN?????
	 */
	public void setFim(String novofim) {
		fim = novofim;
	}
	
	/**
	 * @return the rotasFav
	 */
	public int sizeParagens() {
		return Paragens.size();
	}
	
	public ParagensRota getParagens(int index) {
		return Paragens.get(index);
		
	}

	
	// Adiciona uma nova paragem 
	public void addParagem(int tempo, RotasAdminA rota, Paragens paragem) {

		ParagensRota tempoentreparagem = new ParagensRota(tempo, rota, paragem);
		Paragens.add(tempoentreparagem);
	}

	// Remove a paragem
	public void delParagem(int index) {
		Paragens.remove(index);
	}


	// Adiciona um novo feedback 
	public void addFeedback(Feedback feed) {
		feedback.add(feed);
	}

	// @return o feedback 
	public Feedback getFeedback(int index) {
		return feedback.get(index);
	}

	 // Método para representar o objeto como uma string
	@Override
	public String toString() {
		return "Rota [Paragens associadas=" + Paragens + ", numRota=" + numRota + ", inicio=" + inicio + ", fim=" + fim + "]"; // ns ate q ponto e q dar print a paragnes funfa
	}

}
