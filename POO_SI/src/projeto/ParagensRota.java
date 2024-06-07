package projeto;

public class ParagensRota {

	// inicializacao de variaveis
	private int tempEntreParagens;
	private RotasAdminA refRota; 
	private Paragens refParagem;
	
	// Construtor da classe ParagensRota
	public ParagensRota(int tempEntreParagens, RotasAdminA refRota, Paragens refParagem) {
		this.tempEntreParagens = tempEntreParagens;
		this.refRota = refRota;
		this.refParagem = refParagem;
	}

	// Método para representar o objeto como uma string
	@Override
	public String toString() {
		return "ParagensRota [Tempo entre paragens=" + tempEntreParagens + ", Rota associada=" + refRota.getNumRota() + ", Paragem associada="
				+ refParagem.getNomeStop() + "]";
	}




	

}
