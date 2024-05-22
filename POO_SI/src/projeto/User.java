package projeto;

import java.util.ArrayList;
public class User extends Admin{

	private int idade;
	private boolean deficiencia;
	private ArrayList<RotasAdminA>rotasFav;
	
	public User(String username, String pass, int numTel, int idade, boolean deficiencia) {
		super(username, pass, numTel);
		this.idade = idade;
		this.deficiencia = deficiencia;
		rotasFav = new ArrayList<RotasAdminA>();
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
	public int sizeRotasFav() {
		return rotasFav.size();
	}
	
	public RotasAdminA getRotasFav(int index) {
		return rotasFav.get(index);
		
	}
	
	public void addFav(RotasAdminA rota) {
		rotasFav.add(rota);
	}

	@Override
	public String toString() {
		return "User [idade=" + idade + ", deficiencia=" + deficiencia + ", rotasFav=" + rotasFav + ", Password="
				+ getPass() + ", Username=" + getUsername() + ", Numero=" + getNumTel() + "]";
	}
	








}
