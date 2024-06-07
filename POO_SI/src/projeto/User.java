package projeto;

import java.util.ArrayList;
public class User extends Admin{

	// Atributos específicos da classe User
	private int idade;
	private boolean deficiencia;
	
	// Listas para armazenar rotas favoritas e feedbacks do usuário
	private ArrayList<RotasAdminA>rotasFav;
	private ArrayList<Feedback>feedback;
	
	 // Construtor da classe User
	public User(String username, String pass, int numTel, int idade, boolean deficiencia) {
		super(username, pass, numTel);
		this.idade = idade;
		this.deficiencia = deficiencia;
		
		// Inicializa as listas de rotas favoritas e feedbacks
		rotasFav = new ArrayList<RotasAdminA>();
		feedback = new ArrayList<Feedback>();
	}

	/**
	 * @return the idade
	 */
	public int getIdade() {
		return idade;
	}

	/**
	 * @return the deficiencia
	 */
	public boolean isDeficiencia() {
		return deficiencia;
	}

	/**
	 * @return the rotasFav
	 */
	@Override
	public int sizeFavoritos() {
		return rotasFav.size();
	}
	
	// @return a rota favorita
	@Override
	public RotasAdminA getFavoritos(int index) {
		return rotasFav.get(index);
		
	}
	
	// Adiciona uma rota às favoritas
	@Override
	public void addFavoritos(RotasAdminA rota) {
		rotasFav.add(rota);
	}

	// Adiciona um feedback
	@Override
	public void addFeedback(Feedback feed) {
		feedback.add(feed);
	}
	
	// @return o feedback
	@Override
	public Feedback getFeedback(int index) {
		return feedback.get(index);
	}

	// @return o número de feedbacks
	@Override
	public int sizeFeedback() {
		return feedback.size();
	}


	// Método para representar o objeto como uma string
	@Override
	public String toString() {
		return "User [idade=" + idade + ", deficiencia=" + deficiencia + ", rotasFav=" + rotasFav + ", Password="
				+ getPass() + ", Username=" + getUsername() + ", Numero=" + getNumTel() + "]";
	}
	








}
