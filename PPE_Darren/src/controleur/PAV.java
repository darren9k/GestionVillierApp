package controleur;

public class PAV 
{
	private String codetypeevent,codeevent,codetypepresta,codepresta,idfamille;

	public PAV(String codetypeevent, String codeevent, String codetypepresta, String codepresta, String idfamille) {
		super();
		this.codetypeevent = codetypeevent;
		this.codeevent = codeevent;
		this.codetypepresta = codetypepresta;
		this.codepresta = codepresta;
		this.idfamille = idfamille;
	}

	public String getCodetypeevent() {
		return codetypeevent;
	}

	public void setCodetypeevent(String codetypeevent) {
		this.codetypeevent = codetypeevent;
	}

	public String getCodeevent() {
		return codeevent;
	}

	public void setCodeevent(String codeevent) {
		this.codeevent = codeevent;
	}

	public String getCodetypepresta() {
		return codetypepresta;
	}

	public void setCodetypepresta(String codetypepresta) {
		this.codetypepresta = codetypepresta;
	}

	public String getCodepresta() {
		return codepresta;
	}

	public void setCodepresta(String codepresta) {
		this.codepresta = codepresta;
	}

	public String getIdfamille() {
		return idfamille;
	}

	public void setIdfamille(String idfamille) {
		this.idfamille = idfamille;
	}

	
}
