package projeto;

public class Admin {

	// Atributos da classe Admin
	private String username;
	private String pass;
	private int numTel;
	
	// construtor da classe Admin
	public Admin(String username, String pass, int numTel) {
		this.username = username;
		this.pass = pass;
		this.numTel = numTel;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the new pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the numTel
	 */
	public int getNumTel() {
		return numTel;
	}


	public void addFeedback(Feedback feed) {
		// Não faz nada.	
	}



	@Override
	public String toString() {
		return "Admin [username=" + username + ", pass=" + pass + ", numTel=" + numTel + "]";
	}

    public int sizeFeedback() {
        // TODO Auto-generated method stub
		return 0;
    }

	public Feedback getFeedback(int index) {
		// TODO Auto-generated method stub
		return null;
	}

    public void addFavoritos(RotasAdminA rotasAdminA) {
        // TODO Auto-generated method stub
    }

    public int sizeFavoritos() {
        return 0;
    }
	
	public RotasAdminA getFavoritos(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
