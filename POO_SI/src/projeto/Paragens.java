package projeto;

import java.util.ArrayList;
public class Paragens {

	 // Atributos da classe Paragens
	private String NomeRua;
	private String NomeStop;
	private String Zona;
	
	// Listas para armazenar as paragens e feedbacks
	private ArrayList<ParagensRota>Paragens;
	private ArrayList<Feedback>feedback;

	// Construtor da classe Paragens
	public Paragens(String nomeRua, String nomeStop, String zona) {
		NomeRua = nomeRua;
		NomeStop = nomeStop;
		Zona = zona;
		
        // Inicializa as listas de paragens e feedbacks

		Paragens = new ArrayList<ParagensRota>();
		feedback = new ArrayList<Feedback>();
	}

	/**
	 * @return the nomeRua
	 */
	public String getNomeRua() {
		return NomeRua;
	}

	/**
	 * @return the nomeStop
	 */
	public String getNomeStop() {
		return NomeStop;
	}

	/**
	 * @return the zona
	 */
	public String getZona() {
		return Zona;
	}
	
	/**
	 * @return the sizeParagens
	 */
	public int sizeParagens() {
		return Paragens.size();
	}
	
	//  @return a paragem
	public ParagensRota getParagens(int index) {
		return Paragens.get(index);
		
	}

	// Adiciona um feedback
	public void addFeedback(Feedback feed) {
		feedback.add(feed);
	}
	
	// @return o feedback
	public Feedback getFeedback(int index) {
        return feedback.get(index);
    }

	// // Método para representar o objeto como uma string
    @Override
	public String toString() {
		return "Paragem [NomeRua=" + NomeRua + ", NomeStop=" + NomeStop + ", Zona=" + Zona + "]";
	}
	
	
}
