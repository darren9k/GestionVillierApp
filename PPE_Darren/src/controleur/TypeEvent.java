package controleur;

public class TypeEvent {
    private int codetypeevent; 
    private String nomtypeevent;
    
    public TypeEvent(int codetypeevent, String nomtypeevent) {
        super();
        this.codetypeevent = codetypeevent;
        this.nomtypeevent = nomtypeevent;
    } 
    
    public TypeEvent(String nomtypeevent) {
        super();
        this.codetypeevent = 0;
        this.nomtypeevent = nomtypeevent;
    }

	public int getCodetypeevent() {
		return codetypeevent;
	}

	public void setCodetypeevent(int codetypeevent) {
		this.codetypeevent = codetypeevent;
	}

	public String getNomtypeevent() {
		return nomtypeevent;
	}

	public void setNomtypeevent(String nomtypeevent) {
		this.nomtypeevent = nomtypeevent;
	} 

    
}