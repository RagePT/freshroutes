package projeto;

public class Admin {

	private String username;
	private String pass;
	private int numTel;
	
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

	@Override
	public String toString() {
		return "Admin [username=" + username + ", pass=" + pass + ", numTel=" + numTel + "]";
	}
	
	
	
}
