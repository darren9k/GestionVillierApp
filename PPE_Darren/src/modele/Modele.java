package modele;

import java.sql.ResultSet;    
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Avion;

import controleur.Evenement;
import controleur.Famille;
import controleur.PAV;

import controleur.Famille;
import controleur.Evenement;
import controleur.TypeEvent;
import controleur.Prestation;
import controleur.TypePresta;
import controleur.User;
import controleur.UserPresta;

public class Modele 
{
	private static Bdd uneBdd = new Bdd("localhost","Villiersbdd","root","");

	//private static Bdd uneBdd = new Bdd("172.20.111.103","Villiersbdd","darren","darren");



//************************** GESTION DES USERS **************************

	public static User selectWhereUser(String email, String mdp)   //on selectionne un user
	{
	User unUser = null;  //le user que nous allons récupérer de la base de donées 
	String requete ="select * from userppe where email='"+email
			+"' and mdp='" + mdp +"';";
		//System.out.println(requete);
	try {
	uneBdd.seConnecter();
	Statement unStat = uneBdd.getMaConnexion().createStatement();
	ResultSet unResultat = unStat.executeQuery(requete);
	//extraction du pilote : fetch en PHP d
	if(unResultat.next()) //Si il y a un resultat
	{
		 unUser = new User(unResultat.getInt("iduser"),
									 unResultat.getString("nom"),
									 unResultat.getString("prenom"),
									 unResultat.getString("email"),
									 unResultat.getString("mdp"),
									 unResultat.getString("role")
									);
	}
	unStat.close();
	uneBdd.seDeconnecter();
	
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
	
	}

	return unUser;

}
	
	

	public static void insertFamille (Famille uneFamille)
	{
		String requete = "insert into famille values (null, '"
					+uneFamille.getNom()+"' , '" +uneFamille.getPrenom()+"','"
					+uneFamille.getAdresse()+"' , '" +uneFamille.getVille()+"' , '"
					+uneFamille.getEmail() + "' ,'" +uneFamille.getMdp()
							+ "', '"+uneFamille.getTelephone()+"' , '"
							+uneFamille.getRevenu_imposable()+"' , '"
							+uneFamille.getNombreenfants()+"' , '"
							+uneFamille.getDateinscription()+"','"
							+uneFamille.getSexe()+"',' ');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
	}
	
	public static ArrayList<Famille> selectAllFamilles()
	{
		ArrayList<Famille> lesFamilles = new ArrayList<Famille>();
		String requete ="select * from famille";
	
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while(desResultats.next()) //tant qu'il y a un resultat
			{
			Famille uneFamille = new Famille(desResultats.getInt("idfamille"),
										 desResultats.getString("nom"),
										 desResultats.getString("prenom"),
										 desResultats.getString("adresse"),
										 desResultats.getString("ville"),
										 desResultats.getString("email"),
										 desResultats.getString("mdp"),
										 desResultats.getString("telephone"),
										 desResultats.getString("revenu_imposable"),
										 desResultats.getString("nombreenfants"),
										 desResultats.getString("dateinscription"),
										 desResultats.getString("sexe"),
										 desResultats.getString("photo")
										);
			//on ajoute le pilote dans la liste des pilotes
			
			lesFamilles.add(uneFamille);
		}
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		exp.printStackTrace();
	}
	
	return lesFamilles;

	}
	
	public static Famille selectWhereFamille(int idfamille)   //on selectionne un Famille
	{
		Famille uneFamille = null;  //le Famille que nous allons récupérer de la base de donées 
		String requete ="select * from Famille where idFamille ="+idfamille+" ;";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 uneFamille = new Famille(unResultat.getInt("idfamille"),
					 unResultat.getString("nom"),
					 unResultat.getString("prenom"),
					 unResultat.getString("adresse"),
					 unResultat.getString("ville"),
					 unResultat.getString("email"),
					 unResultat.getString("mdp"),
					 unResultat.getString("telephone"),
					 unResultat.getString("revenu_imposable"),
					 unResultat.getString("nombreenfants"),
					 unResultat.getString("dateinscription"),
					 unResultat.getString("sexe"),
					 unResultat.getString("photo"));
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return uneFamille;

	}
	
	public static Famille selectWhereFamille(String nom,String prenom, String adresse, String ville, String email) 
	//On vien de surchager la méthode 
	{
		Famille uneFamille = null;  //le Famille que nous allons récupérer de la base de donées 
		String requete ="select * from Famille where "
				+"nom ='"+nom+ "'and prenom='"+prenom+"' and adresse='" +adresse
				+"' and ville='"+ville+"' and email='" +email +"';";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 uneFamille = new Famille(unResultat.getInt("idfamille"),
					 unResultat.getString("nom"),
					 unResultat.getString("prenom"),
					 unResultat.getString("adresse"),
					 unResultat.getString("ville"),
					 unResultat.getString("email"),
					 unResultat.getString("mdp"),
					 unResultat.getString("telephone"),
					 unResultat.getString("revenu_imposable"),
					 unResultat.getString("nombreenfants"),
					 unResultat.getString("dateinscription"),
					 unResultat.getString("sexe"),
					 unResultat.getString("photo")
										);
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return uneFamille;

	}
	
	
	
	
	public static void updateFamille (Famille uneFamille)
	{
		String requete = "update famille set nom = '"
					+uneFamille.getNom()+"' , prenom= '" +uneFamille.getPrenom()+"',adresse='"
					+uneFamille.getAdresse()+"' ,ville= '" +uneFamille.getVille()+"' ,email= '"
					+uneFamille.getEmail() +"' ,mdp= '" +uneFamille.getMdp()+"' ,telephone= '" 
					+uneFamille.getTelephone()+
					"' ,revenu_imposable= '" +uneFamille.getRevenu_imposable()+
					"' ,nombreenfants= '" +uneFamille.getNombreenfants()+
					"' ,dateinscription= '" +uneFamille.getDateinscription()+
					"' ,sexe= '" +uneFamille.getSexe()+ 
					"', photo ='"+uneFamille.getPhoto()+
					"'where idfamille ="+uneFamille.getIdfamille()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
	}
	
	public static int countFamilles()
	{
		int nbfamille = 0;
		String requete = "select count(*) as nb from famille;";

		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat = unStat.executeQuery(requete);
			if(unResultat.next())
			{
				nbfamille = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
		
		
		return nbfamille;
	}
	

	
	public static void deleteFamille (int idpilote)
	{
		String requete = "delete from famille where idfamille ="+idpilote;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de requete" +requete);
		}
	}
	

	public static ArrayList<Famille> selectLikeFamilles(String mot) {
        ArrayList<Famille> lesFamilles = new ArrayList<Famille>();
        String requete="select * from Famille where " +
                "nom like '%" + mot + "%' or " +
                "prenom like '%" + mot + "%' or " +
                "adresse like '%" + mot + "%' or " +
                "ville like '%" + mot + "%' or " +
                "email like '%" + mot + "%' or " +
                "mdp like '%" + mot + "%' or " +
                "telephone like '%" + mot + "%' or " +
                "revenu_imposable like '%" + mot + "%' or " +
                "nombreenfants like '%" + mot + "%' or " +
                "dateinscription like '%" + mot + "%' or " +
                "sexe like '%" + mot + "%' or " +
                "photo like '%" + mot + "%'" +
                ";";
       // System.out.println("requete : " + mot);
        try
        {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);

            //extraction des pilotes: fetchall en PHP
            while(desResultats.next())//tant qu'il un resultat suivant
            {
                Famille uneFamille = new Famille(
                        desResultats.getInt("idfamille"),
                        desResultats.getString("nom"),
                        desResultats.getString("prenom"),
                        desResultats.getString("adresse"),
                        desResultats.getString("ville"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp"),
                        desResultats.getString("telephone"),
                        desResultats.getString("revenu_imposable"),
                        desResultats.getString("nombreenfants"),
                        desResultats.getString("dateinscription"),
                        desResultats.getString("sexe"),
                        desResultats.getString("photo")

                );

                //on ajoute le pilote dans la liste des pilotes
                lesFamilles.add(uneFamille);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }

        catch(SQLException exp)
        {
            System.out.println("Erreur de requete:" + requete);
        }
        return lesFamilles;
    }

	
	public static void insertTypeEvent (TypeEvent unTypeEvent)
	{
		String requete = "insert into TypeEvent values (null, '"
					+unTypeEvent.getNomtypeevent()+ "');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
	}
	

	public static ArrayList<TypeEvent> selectAllTypeEvents()
	{
		ArrayList<TypeEvent> lesTypeEvents= new ArrayList<TypeEvent>();
		String requete ="select * from typeevent";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		//extraction des familles : fetchAll en PHP 
		while(desResultats.next()) //tant qu'il y a un resultat
		{
			TypeEvent unTypeEvent = new TypeEvent(desResultats.getInt("codetypeevent"),
										 desResultats.getString("nomtypeevent"));
			//on ajoute le pilote dans la liste des pilotes
			
			lesTypeEvents.add(unTypeEvent);
		}
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
	
	return lesTypeEvents;

	}
	
	
	
	public static TypeEvent selectWhereTypeEvent(int codetypeevent)   //on selectionne un Famille
	{
		TypeEvent unTypeEvent = null;  //le Famille que nous allons récupérer de la base de donées 
		String requete ="select * from TypeEvent where codetypeevent ="+codetypeevent+" ;";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			unTypeEvent = new TypeEvent(
					unResultat.getInt("codetypeevent"),
					 unResultat.getString("nomtypeevent"));
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unTypeEvent;

	}
	
	public static TypeEvent selectWhereTypeEvent(String nomtypeevent) 
	//On vien de surchager la méthode 
	{
		TypeEvent unTypeEvent = null;  //le type d'Evenement que nous allons récupérer de la base de donées 
		String requete ="select * from TypeEvent where "
				+"nomtypeevent ='"+nomtypeevent +"';";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 unTypeEvent = new TypeEvent(
					 unResultat.getInt("codetypeevent"),
					 unResultat.getString("nomtypeevent")
										);
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unTypeEvent;

	}
	
	public static void updateTypeEvent(TypeEvent unTypeEvent) 
	{
		String requete = "update typeevent set nomtypeevent = '"
				+unTypeEvent.getNomtypeevent()+
				"'where codetypeevent ="+unTypeEvent.getCodetypeevent()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
		
	}



	public static ArrayList<TypeEvent> selectLikeTypeEvents(String mot) 
	{
		
		 ArrayList<TypeEvent> lesTypesEvents = new ArrayList<TypeEvent>();
	        String requete="select * from typeevent where " +
	                "nomtypeevent like '%" + mot +"';";
	       // System.out.println("requete : " + mot);
	        try
	        {
	            uneBdd.seConnecter();
	            Statement unStat = uneBdd.getMaConnexion().createStatement();
	            ResultSet desResultats = unStat.executeQuery(requete);

	            //extraction des pilotes: fetchall en PHP
	            while(desResultats.next())//tant qu'il un resultat suivant
	            {
	                TypeEvent unTypeEvent = new TypeEvent(
	                        desResultats.getInt("codetypeevent"),
	                        desResultats.getString("nomtypeevent")
	                );

	                //on ajoute le pilote dans la liste des pilotes
	                lesTypesEvents.add(unTypeEvent);
	            }
	            unStat.close();
	            uneBdd.seDeconnecter();
	        }

	        catch(SQLException exp)
	        {
	            System.out.println("Erreur de requete:" + requete);
	        }
	        return lesTypesEvents;
		
	}
	
	
	public static void deleteTypeEvent(int codetypeevent) 
	{
		String requete = "delete from typeevent where codetypeevent ="+codetypeevent;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de requete" +requete);
		}
	}
	
	
	
	public static void insertEvenement (Evenement unEvenement)
	{
		String requete = "insert into evenement values (null, '"
					+unEvenement.getNomevent()+"' , '" +unEvenement.getTailleevent()+"','"
					+unEvenement.getLieuevent()+"' , '" +unEvenement.getDateevent()+"' , '"
					+unEvenement.getHeureevent() + "' , '"+unEvenement.getCodetypeevent()+ "', '"
					+unEvenement.getIdfamille()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
	}
	
	public static ArrayList<Evenement> selectAllEvenements()
	{
		ArrayList<Evenement> lesEvenements= new ArrayList<Evenement>();
		String requete ="select * from Evenement";
	
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while(desResultats.next()) //tant qu'il y a un resultat
			{
			Evenement unEvenement = new Evenement(desResultats.getInt("codeevent"),
										 desResultats.getString("nomevent"),
										 desResultats.getString("tailleevent"),
										 desResultats.getString("lieuevent"),
										 desResultats.getString("dateevent"),
										 desResultats.getString("heureevent"),
										 desResultats.getInt("codetypeevent"),
										 desResultats.getInt("idfamille")
										);
			//on ajoute le pilote dans la liste des pilotes
			
			lesEvenements.add(unEvenement);
		}
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
	
	return lesEvenements;

	}
	
	public static Evenement selectWhereEvenement(int codeevent)  
	{
		Evenement unEvenement = null;  //le Evenement que nous allons récupérer de la base de donées 
		String requete ="select * from Evenement where codeevent ="+codeevent+" ;";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 unEvenement = new Evenement(unResultat.getInt("codeevent"),
					 unResultat.getString("nomevent"),
					 unResultat.getString("tailleevent"),
					 unResultat.getString("lieuevent"),
					 unResultat.getString("dateevent"),
					 unResultat.getString("heureevent"),
					 unResultat.getInt("codetypeevent"),
					 unResultat.getInt("idfamille"));
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unEvenement;

	}
	
	
	public static Evenement selectWhereEvenement(String nomevent, String lieuevent) 
	//On vien de surchager la méthode 
	{
		Evenement unEvenement = null;  //le Evenement que nous allons récupérer de la base de donées 
		String requete ="select * from Evenement where "
				+"nomevent ='"+nomevent+ "'and lieuevent='"+lieuevent +"';";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 unEvenement = new Evenement(unResultat.getInt("codeevent"),
					 unResultat.getString("nomevent"),
					 unResultat.getString("tailleevent"),
					 unResultat.getString("lieuevent"),
					 unResultat.getString("dateevent"),
					 unResultat.getString("heureevent"),
					 unResultat.getInt("codetypeevent"),
					 unResultat.getInt("idfamille") );
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unEvenement;

	}

	public static void deleteEvenement(int codeevent) 
	{
		String requete = "delete from evenement where codeevent ="+codeevent;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de requete" +requete);
		}
		
	}

	public static ArrayList<Evenement> selectLikeEvenements(String mot)
	{

		ArrayList<Evenement> lesEvenements = new ArrayList<Evenement>();
        String requete="select * from evenement where " +
                "nomevent like '%" + mot + "%' or " +
                "tailleevent like '%" + mot + "%' or " +
                "lieuevent like '%" + mot + "%' or " +
                "dateevent like '%" + mot + "%' or " +
                "heureevent like '%" + mot + "%' or " +
                "codetypeevent like '%" + mot + "%' or "+
                " idfamille like '%" + mot + "%';";
       // System.out.println("requete : " + mot);
        try
        {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);

            //extraction des pilotes: fetchall en PHP
            while(desResultats.next())//tant qu'il un resultat suivant
            {
                Evenement unEvenement = new Evenement(
                        desResultats.getInt("codeevent"),
                        desResultats.getString("nomevent"),
                        desResultats.getString("tailleevent"),
                        desResultats.getString("lieuevent"),
                        desResultats.getString("dateevent"),
                        desResultats.getString("heureevent"),
                        desResultats.getInt("codetypeevent"),
                        desResultats.getInt("idfamille")

                );

                //on ajoute le pilote dans la liste des pilotes
                lesEvenements.add(unEvenement);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }

        catch(SQLException exp)
        {
            System.out.println("Erreur de requete:" + requete);
        }
        return lesEvenements;
	}



	public static void updateEvenement(Evenement unEvenement) 
	{
		String requete = "update evenement set nomevent = '"
				+unEvenement.getNomevent()+"' , tailleevent= '" +unEvenement.getTailleevent()+"',lieuevent='"
				+unEvenement.getLieuevent()+"' ,dateevent= '" +unEvenement.getDateevent()+"' ,heureevent= '"
				+unEvenement.getHeureevent() +"' ,codetypeevent= '" +unEvenement.getCodeevent()+"',idfamille ='"
				+unEvenement.getIdfamille()+"'where codeevent ="+unEvenement.getCodeevent()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
		
	}



	public static void deleteTypePresta(int codetypepresta) 
	{
		String requete = "delete from typepresta where codetypepresta ="+codetypepresta;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de requete : " +requete);
		}
		
	}



	public static ArrayList<TypePresta> selectAllTypePrestas() 
	{
	
		ArrayList<TypePresta> lesTypesPrestas= new ArrayList<TypePresta>();
		String requete ="select * from typepresta";
	
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			//extraction des pilotes : fetchAll en PHP 
			while(desResultats.next()) //tant qu'il y a un resultat
			{
				TypePresta unTypePresta = new TypePresta(desResultats.getInt("codetypepresta"),
										 desResultats.getString("nomtypepresta")
										);
			//on ajoute le pilote dans la liste des pilotes
			
			lesTypesPrestas.add(unTypePresta);
		}
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
	
	return lesTypesPrestas;
	}

	public static ArrayList<TypePresta> selectLikeTypePrestas(String mot) 
	{
		

		ArrayList<TypePresta> lesTypesPrestas = new ArrayList<TypePresta>();
        String requete="select * from typepresta where " +
                "nomtypepresta like '%" + mot + "%';";
       // System.out.println("requete : " + mot);
        try
        {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);

            //extraction des pilotes: fetchall en PHP
            while(desResultats.next())//tant qu'il un resultat suivant
            {
            	TypePresta unTypePresta = new TypePresta(
                        desResultats.getInt("codetypepresta"),
                        desResultats.getString("nomtypepresta")
                );

                //on ajoute le pilote dans la liste des pilotes
                lesTypesPrestas.add(unTypePresta);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }

        catch(SQLException exp)
        {
            System.out.println("Erreur de requete:" + requete);
        }
        return lesTypesPrestas;
	}



	public static void insertTypePresta(TypePresta unTypePresta) 
	{
		
		String requete = "insert into typepresta values (null, '"
					+unTypePresta.getNomtypepresta()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
	}



	public static TypePresta selectWhereTypePresta(String nomtypepresta)
	{
	
		TypePresta unTypePresta = null;  //le type presta que nous allons récupérer de la base de donées 
		String requete ="select * from typepresta where "
				+"nomtypepresta ='"+nomtypepresta+ "';";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du Famille : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			 unTypePresta = new TypePresta(unResultat.getInt("codetypepresta"),
					 unResultat.getString("nomtypepresta"));
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unTypePresta;
	}



	public static void updateTypePresta(TypePresta unTypePresta)
	{
		String requete = "update typepresta set nomtypepresta = '"
				+unTypePresta.getNomtypepresta()+
				"'where codetypepresta ="+unTypePresta.getCodetypepresta()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
				
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
			
		}
		
	}



	public static void deletePrestation(int codepresta) 
	{
		
		String requete = "delete from prestation where codepresta ="+codepresta;
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}	
		catch(SQLException exp)
		{
			System.out.println("Erreur de requete : " +requete);
		}
	}



	public static void insertPrestation(Prestation unePrestation, User unUser) 
	 {
	
		String requete = "insert into prestation values (null, '"
				+unePrestation.getLibellepresta()+"' , '" +unePrestation.getNombreplaces()+"','"
				+unePrestation.getDatepresta()+"','" +unePrestation.getHeurepresta()+"' , '"
				+unePrestation.getCodetypepresta()+ "','"+unePrestation.getIdfamille()+"','"
				+unUser.getEmail()+"');";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
			
		uneBdd.seDeconnecter();
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
	}



	public static Prestation selectWherePrestation(String libellepresta) 
	{
		Prestation unePrestation = null;  //la prestation que nous allons récupérer de la base de donées 
		String requete ="select * from prestation where libellepresta ='"+libellepresta+"' ;";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet unResultat = unStat.executeQuery(requete);
		//extraction du pilote : fetch en PHP 
		if(unResultat.next()) //Si il y a un resultat
		{
			unePrestation = new Prestation(unResultat.getInt("codepresta"),
					unResultat.getString("libellepresta"),
					unResultat.getString("nombreplaces"),
					unResultat.getString("datepresta"),
					unResultat.getString("heurepresta"),
					unResultat.getInt("codetypepresta"),
					unResultat.getInt("idfamille"),
					unResultat.getString("email")
					);
		}
		unStat.close();
		uneBdd.seDeconnecter();
		
	}
		catch(SQLException exp) {
			System.out.println("Erreur de requête :"+requete);
		
	}
	
		return unePrestation;
		
	}



	public static void updatePrestation(Prestation unePrestation) 
	{
		String requete = "update prestation set libellepresta = '"
				+unePrestation.getLibellepresta()+"' , nombreplaces= '" 
				+unePrestation.getNombreplaces()+"',datepresta='"
				+unePrestation.getDatepresta()+"',heurepresta='"
				+unePrestation.getHeurepresta()+"',codetypepresta='"
				+unePrestation.getCodetypepresta()+"', idfamille = '"
				+unePrestation.getIdfamille()+"', email='"
				+unePrestation.getEmail()+"' where codepresta ="
				+unePrestation.getCodepresta()+";";
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		unStat.execute(requete);
		unStat.close();
			
		uneBdd.seDeconnecter();
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
		
	}



	public static ArrayList<Prestation> selectAllPrestations() 
	{
	
		ArrayList<Prestation> lesPrestations = new ArrayList<Prestation>();
		String requete ="select * from prestation";
	
	try {
		uneBdd.seConnecter();
		Statement unStat = uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		//extraction des pilotes : fetchAll en PHP 
		while(desResultats.next()) //tant qu'il y a un resultat
		{
			Prestation unePrestation = new Prestation(desResultats.getInt("codepresta"),
										 desResultats.getString("libellepresta"),
										 desResultats.getString("nombreplaces"),
										 desResultats.getString("datepresta"),
					                     desResultats.getString("heurepresta"),
					                     desResultats.getInt("codetypepresta"),
					                     desResultats.getInt("idfamille"),
					                     desResultats.getString("email")
										);
			//on ajoute le pilote dans la liste des pilotes
			
			lesPrestations.add(unePrestation);
		}
	}
	catch(SQLException exp) {
		System.out.println("Erreur de requête :"+requete);
		
	}
	
	return lesPrestations;

	}



	public static ArrayList<Prestation> selectLikePrestations(String mot)
	{
		ArrayList<Prestation> lesPrestations = new ArrayList<Prestation>();
        String requete="select * from prestation where " +
                "libellepresta like '%" + mot + "%' or " +
                "nombreplaces like '%" + mot + "%' or " +
                "codetypepresta like '%" + mot + "%' or " +
                "datepresta like '%" +mot + "%' or " +
                "heurepresta like '%" +mot + "%' or " +
                "codetypepresta like '%" +mot + "%' or " +
                "idfamille like '%" +mot + "%' " +
                ";";
       // System.out.println("requete : " + mot);
        try
        {
            uneBdd.seConnecter();
            Statement unStat = uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);

            //extraction des pilotes: fetchall en PHP
            while(desResultats.next())//tant qu'il un resultat suivant
            {
            	Prestation unePrestation = new Prestation (
                        desResultats.getInt("codepresta"),
                        desResultats.getString("libellepresta"),
                        desResultats.getString("nombreplaces"),
                        desResultats.getString("datepresta"),
                        desResultats.getString("heurepresta"),
                        desResultats.getInt("codetypresta"),
                        desResultats.getInt("idfamille"),
                        desResultats.getString("email")

                );

                //on ajoute le pilote dans la liste des pilotes
                lesPrestations.add(unePrestation);
            }
            unStat.close();
            uneBdd.seDeconnecter();
        }

        catch(SQLException exp)
        {
            System.out.println("Erreur de requete:" + requete);
        }
        return lesPrestations;
	}
	
	public static int countTypeEvent() {
		int nbTypeEvent=0;
		String requete ="select count(*) as nb from typeevent ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbTypeEvent = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbTypeEvent;
	}
	
	public static int countEvent() {
		int nbEvent=0;
		String requete ="select count(*) as nb from evenement ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbEvent = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbEvent;
	}
	
	public static int countTypePresta() {
		int nbTypePresta=0;
		String requete ="select count(*) as nb from typepresta ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbTypePresta = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbTypePresta;
	}
	
	public static int countPresta() {
		int nbPresta=0;
		String requete ="select count(*) as nb from prestation ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbPresta = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbPresta;
	}
	
	public static int countFamille() {
		int nbFamille=0;
		String requete ="select count(*) as nb from famille ; ";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unResultat= unStat.executeQuery(requete);
			if (unResultat.next())
			{
				nbFamille = unResultat.getInt("nb");
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete :"+requete);
		}
		
		return nbFamille;
	}
	
	
	/*public static ArrayList<UserPresta> selectAllUserPresta ()
	{

	ArrayList<UserPresta> lesU = new ArrayList<UserPresta>();

	 String requete = "select * from vNbPrestation ; ";

	try {

	uneBdd.seConnecter();

	Statement unStat = uneBdd.getMaConnexion().createStatement();

	ResultSet desResultats = unStat.executeQuery(requete);

	 //extraction des pilotes : fetchAll en PHP

	 while (desResultats.next()) //tant qu'il un resultat suivant

	{

	UserPresta unePresta= new UserPresta (

	desResultats.getString("email"),

	 

	desResultats.getInt("nb")

	);

	 //on ajoute le pilote dans la liste des pilotes

	 lesUserPrestas.add(unUserPresta); 

	}

	 

	unStat.close();

	uneBdd.seDeconnecter();

	}

	catch (SQLException exp) {

	System.out.println("Erreur de requete :"+requete);

	}

	 return lesUserPrestas; 

	}
	

*/
}
