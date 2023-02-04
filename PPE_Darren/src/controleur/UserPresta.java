package controleur;

public class UserPresta {
	private String email;
	private int nb;
	
	public UserPresta(String email, int nb)
	{
		this.email = email;
		this.nb = nb;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}
	

}
