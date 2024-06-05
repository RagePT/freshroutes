package projeto;

import java.util.ArrayList;
public class User extends Admin{

	private int idade;
	private boolean deficiencia;
	private ArrayList<RotasAdminA>rotasFav;
	private ArrayList<Feedback>feedback;
	
	public User(String username, String pass, int numTel, int idade, boolean deficiencia) {
		super(username, pass, numTel);
		this.idade = idade;
		this.deficiencia = deficiencia;
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
	@Override
	public RotasAdminA getFavoritos(int index) {
		return rotasFav.get(index);
		
	}
	@Override
	public void addFavoritos(RotasAdminA rota) {
		rotasFav.add(rota);
	}

	@Override
	public void addFeedback(Feedback feed) {
		feedback.add(feed);
	}
	@Override
	public Feedback getFeedback(int index) {
		return feedback.get(index);
	}

	@Override
	public int sizeFeedback() {
		return feedback.size();
	}


	@Override
	public String toString() {
		return "User [idade=" + idade + ", deficiencia=" + deficiencia + ", rotasFav=" + rotasFav + ", Password="
				+ getPass() + ", Username=" + getUsername() + ", Numero=" + getNumTel() + "]";
	}
	








}
