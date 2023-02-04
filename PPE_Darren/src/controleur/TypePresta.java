package controleur;

public class TypePresta 
{
	private int codetypepresta;
	private String nomtypepresta;
	
	public TypePresta(int codetypepresta, String nomtypepresta) {
		super();
		this.codetypepresta = codetypepresta;
		this.nomtypepresta = nomtypepresta;
	}
	
	public TypePresta(String nomtypepresta) {
		super();
		this.codetypepresta = 0;
		this.nomtypepresta = nomtypepresta;
	}

	public int getCodetypepresta() {
		return codetypepresta;
	}

	public void setCodetypepresta(int codetypepresta) {
		this.codetypepresta = codetypepresta;
	}

	public String getNomtypepresta() {
		return nomtypepresta;
	}

	public void setNomtypepresta(String nomtypepresta) {
		this.nomtypepresta = nomtypepresta;
	}
	
	
	
}
