package projeto;

import java.util.Scanner;
import java.util.ArrayList;
public class RotasAdminA {

	private ArrayList<Feedback>feedback;
	private ArrayList<ParagensRota>Paragens;
	private String numRota;
	private String inicio;
	private String fim;
	Scanner sc = new Scanner(System.in);
	
	public RotasAdminA(String numRota, String inicio, String fim) {
		Paragens = new ArrayList<ParagensRota>();
		feedback = new ArrayList<Feedback>();
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

	public void addParagem(int tempo, RotasAdminA rota, Paragens paragem) {

		ParagensRota tempoentreparagem = new ParagensRota(tempo, rota, paragem);
		Paragens.add(tempoentreparagem);
	}

	public void delParagem(int index) {
		Paragens.remove(index);
	}


	public void addFeedback(Feedback feed) {
		feedback.add(feed);
	}

	public Feedback getFeedback(int index) {
		return feedback.get(index);
	}

	@Override
	public String toString() {
		return "Rota [Paragens associadas=" + Paragens + ", numRota=" + numRota + ", inicio=" + inicio + ", fim=" + fim + "]"; // ns ate q ponto e q dar print a paragnes funfa
	}

}
