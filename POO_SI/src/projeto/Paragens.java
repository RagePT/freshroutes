package projeto;

import java.util.ArrayList;
public class Paragens {

	
	private String NomeRua;
	private String NomeStop;
	private String Zona;
	private ArrayList<ParagensRota>Paragens;

	public Paragens(String nomeRua, String nomeStop, String zona) {
		NomeRua = nomeRua;
		NomeStop = nomeStop;
		Zona = zona;
		Paragens = new ArrayList<ParagensRota>();
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
	
	public ParagensRota getParagens(int index) {
		return Paragens.get(index);
		
	}

	
}
