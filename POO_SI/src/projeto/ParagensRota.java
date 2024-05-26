package projeto;

public class ParagensRota {

	private int tempEntreParagens;
	private RotasAdminA refRota; 
	private Paragens refParagem;
	
	public ParagensRota(int tempEntreParagens, RotasAdminA refRota, Paragens refParagem) {
		this.tempEntreParagens = tempEntreParagens;
		this.refRota = refRota;
		this.refParagem = refParagem;
	}

	@Override
	public String toString() {
		return "ParagensRota [Tempo entre paragens=" + tempEntreParagens + ", Rota associada=" + refRota.getNumRota() + ", Paragem associada="
				+ refParagem.getNomeStop() + "]";
	}




	

}
