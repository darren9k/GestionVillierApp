package controleur;

public class Prestation
{
	private int codepresta;
	private String libellepresta, nombreplaces, datepresta, heurepresta;
	private int  codetypepresta, idfamille;
	private String email;
	
	public Prestation(int codepresta, String libellepresta, String nombreplaces, 
			String datepresta,String heurepresta, int codetypepresta, int idfamille, String email) {
		super();
		this.codepresta = codepresta;
		this.libellepresta = libellepresta;
		this.nombreplaces = nombreplaces;
		this.datepresta = datepresta;
		this.heurepresta = heurepresta;
		this.codetypepresta = codetypepresta;
		this.idfamille = idfamille;
		this.email = email;
		
	}
	
	public Prestation(String libellepresta, String nombreplaces, String datepresta,
			String heurepresta,  int codetypepresta, int idfamille, String email) {
		super();
		this.codepresta = 0;
		this.libellepresta = libellepresta;
		this.nombreplaces = nombreplaces;
		this.datepresta = datepresta;
		this.heurepresta = heurepresta;
		this.codetypepresta = codetypepresta;
		this.idfamille = idfamille;			
		this.email = email;
	}

	public int getCodepresta() {
		return codepresta;
	}

	public void setCodepresta(int codepresta) {
		this.codepresta = codepresta;
	}

	public String getLibellepresta() {
		return libellepresta;
	}

	public void setLibellepresta(String libellepresta) {
		this.libellepresta = libellepresta;
	}

	public String getNombreplaces() {
		return nombreplaces;
	}

	public void setNombreplaces(String nombreplaces) {
		this.nombreplaces = nombreplaces;
	}
	
	public String getDatepresta() {
		return datepresta;
	}

	public void setDatepresta(String datepresta) {
		this.datepresta = datepresta;
	}
	
	public String getHeurepresta() {
		return heurepresta;
	}

	public void setHeurepresta(String heurepresta) {
		this.heurepresta = heurepresta;
	}

	public int getCodetypepresta() {
		return codetypepresta;
	}

	public void setCodetypepresta(int codetypepresta) {
		this.codetypepresta = codetypepresta;
	}

	public int getIdfamille() {
		return idfamille;
	}

	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
