package projeto;


import java.util.ArrayList;
public class RotasAdminA {

	private ArrayList<ParagensRota>Paragens;
	private int numRota;
	private String inicio;
	private String fim;
	
	
	public RotasAdminA(int numRota, String inicio, String fim) {
		Paragens = new ArrayList<ParagensRota>();
		this.numRota = numRota;
		this.inicio = inicio;
		this.fim = fim;
	}


	/**
	 * @return the numRota
	 */
	public int getNumRota() {
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
	 * @return the rotasFav
	 */
	public int sizeParagens() {
		return Paragens.size();
	}
	
	public ParagensRota getParagens(int index) {
		return Paragens.get(index);
		
	}


}
