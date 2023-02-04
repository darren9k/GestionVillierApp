package controleur;

public class Evenement
{
	private int codeevent;
	private String nomevent;
	private String tailleevent;
	private String lieuevent,dateevent;
	private String heureevent;
	private int codetypeevent, idfamille;
	
	public Evenement(int codeevent, String nomevent, String tailleevent, String lieuevent, String dateevent,
			String heureevent, int codetypeevent, int idfamille) {
		super();
		this.codeevent = codeevent;
		this.nomevent = nomevent;
		this.tailleevent = tailleevent;
		this.lieuevent = lieuevent;
		this.dateevent = dateevent;
		this.heureevent = heureevent;
		this.codetypeevent = codetypeevent;
		this.idfamille = idfamille;
	}
	
	public Evenement(String nomevent, String tailleevent, String lieuevent, String dateevent,
			String heureevent, int codetypeevent, int idfamille) {
		super();
		this.codeevent = 0;
		this.nomevent = nomevent;
		this.tailleevent = tailleevent;
		this.lieuevent = lieuevent;
		this.dateevent = dateevent;
		this.heureevent = heureevent;
		this.codetypeevent = codetypeevent;
		this.idfamille = idfamille;
	}

	public int getCodeevent() {
		return codeevent;
	}

	public void setCodeevent(int codeevent) {
		this.codeevent = codeevent;
	}

	public String getNomevent() {
		return nomevent;
	}

	public void setNomevent(String nomevent) {
		this.nomevent = nomevent;
	}

	public String getTailleevent() {
		return tailleevent;
	}

	public void setTailleevent(String tailleevent) {
		this.tailleevent = tailleevent;
	}

	public String getLieuevent() {
		return lieuevent;
	}

	public void setLieuevent(String lieuevent) {
		this.lieuevent = lieuevent;
	}

	public String getDateevent() {
		return dateevent;
	}

	public void setDateevent(String dateevent) {
		this.dateevent = dateevent;
	}

	public String getHeureevent() {
		return heureevent;
	}

	public void setHeureevent(String heureevent) {
		this.heureevent = heureevent;
	}

	public int getCodetypeevent() {
		return codetypeevent;
	}

	public void setCodetypeevent(int codetypeevent) {
		this.codetypeevent = codetypeevent;
	}

	public int getIdfamille() {
		return idfamille;
	}

	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}
	

	
	
	
}
