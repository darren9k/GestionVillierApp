package controleur;

public class Famille 
{
	private int idfamille;
	private String nom,prenom,adresse,ville,email,mdp,
	telephone,revenu_imposable,nombreenfants,
	dateinscription,sexe,photo;
	
	public Famille(int idfamille, String nom, String prenom, String adresse, String ville, String email, String mdp,
			String telephone, String revenu_imposable, String nombreenfants, String dateinscription, String sexe,
			String photo) {
		super();
		this.idfamille = idfamille;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.revenu_imposable = revenu_imposable;
		this.nombreenfants = nombreenfants;
		this.dateinscription = dateinscription;
		this.sexe = sexe;
		this.photo = photo;
	}
	
	public Famille(String nom, String prenom, String adresse, String ville, String email, String mdp,
			String telephone, String revenu_imposable, String nombreenfants, String dateinscription, String sexe,
			String photo) {
		super();
		this.idfamille = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.ville = ville;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.revenu_imposable = revenu_imposable;
		this.nombreenfants = nombreenfants;
		this.dateinscription = dateinscription;
		this.sexe = sexe;
		this.photo = photo;
	}

	public int getIdfamille() {
		return idfamille;
	}

	public void setIdfamille(int idfamille) {
		this.idfamille = idfamille;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRevenu_imposable() {
		return revenu_imposable;
	}

	public void setRevenu_imposable(String revenu_imposable) {
		this.revenu_imposable = revenu_imposable;
	}

	public String getNombreenfants() {
		return nombreenfants;
	}

	public void setNombreenfants(String nombreenfants) {
		this.nombreenfants = nombreenfants;
	}

	public String getDateinscription() {
		return dateinscription;
	}

	public void setDateinscription(String dateinscription) {
		this.dateinscription = dateinscription;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	
	
}
