package vue;


import java.awt.Color;   
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import controleur.Famille;
import controleur.Tableau;
import modele.Modele;

public class PanelFamille extends PanelDeBase implements ActionListener
{

			private JPanel panelForm = new JPanel();
			private JPanel panelTable = new JPanel();
			private JButton btEnregistrer = new JButton("Enregistrer");
			private JButton btAnnuler = new JButton("Annuler");
			private JTextField txtNom = new JTextField();
			private JTextField txtPrenom = new JTextField();
			private JTextField txtAdresse = new JTextField();
			private JTextField txtVille = new JTextField();
			private JTextField txtEmail = new JTextField();
			private JTextField txtMdp = new JTextField();
			private JTextField txtTelephone = new JTextField();
			private JTextField txtRevenu_Imposable = new JTextField();
			private JTextField txtNombreEnfants = new JTextField();
			private JTextField txtDateInscription = new JTextField();
			private JTextField txtSexe = new JTextField();
			private JTextField txtPhoto = new JTextField();
			
			private JTable uneTable = null; //séance 24/01
			
			private static Tableau unTableau = null;
			
			
			private JTextField txtMot = new JTextField();
			private JButton btRechercher = new JButton("Rechercher");
			
			private JButton btAide = new JButton("Aide");
			

	public PanelFamille() 
	{
				super(new Color(225,210,184));
				this.panelForm.setLayout(new GridLayout(13,2));
				
				this.panelForm.add(new JLabel("Nom de Famille :"));
				this.panelForm.add(this.txtNom);
				
				this.panelForm.add(new JLabel("Prénom du responsable :"));
				this.panelForm.add(this.txtPrenom);
				
				this.panelForm.add(new JLabel("Adresse :"));
				this.panelForm.add(this.txtAdresse);
				
				this.panelForm.add(new JLabel("Ville :"));
				this.panelForm.add(this.txtVille);
				
				this.panelForm.add(new JLabel("Email :"));
				this.panelForm.add(this.txtEmail);
				
				this.panelForm.add(new JLabel("Mdp :"));
				this.panelForm.add(this.txtMdp);
				
				this.panelForm.add(new JLabel("Numéro de téléphone:"));
				this.panelForm.add(this.txtTelephone);
				
				this.panelForm.add(new JLabel("Revenu Imposable :"));
				this.panelForm.add(this.txtRevenu_Imposable);
				
				this.panelForm.add(new JLabel("Nombre d'enfants :"));
				this.panelForm.add(this.txtNombreEnfants);
				
				this.panelForm.add(new JLabel("Date d'inscription :"));
				this.panelForm.add(this.txtDateInscription);
				
				this.panelForm.add(new JLabel("Sexe :"));
				this.panelForm.add(this.txtSexe);
				
				
				
				this.panelForm.add(this.btAnnuler);
				this.panelForm.add(this.btEnregistrer);
				
				this.panelForm.setBounds(20,20,400,500); //20,20,300,32020,20,800,400
				this.add(this.panelForm);
				
				this.btEnregistrer.setBackground(Color.green);
				this.btAnnuler.setBackground(Color.red);
				
				
				//Construction du panel Table // 24/01
				this.panelTable.setBounds(425,20,800,700);
				this.panelTable.setBackground(new Color(225,210,184));
				this.panelTable.setLayout(null); 
				String entetes[]= {"ID","Nom","Prenom","Adresse","Ville","Email","Mdp","Telephone",
						"Revenu","nombre","dateinscription","Sexe"};
	
				Object donnees [][]=this.getLesDonnees("");
				unTableau = new Tableau(entetes,donnees); //appelle du constructeur tableau
				
				this.uneTable = new JTable(unTableau); //JTable composée de données entetes
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(20,70,650,200);
				
				
				ImageIcon leLogo = new ImageIcon("src/images/famille.png");
				JLabel lbLogo = new JLabel(leLogo);
				lbLogo.setBounds(15,300,645,150);
				this.panelTable.add(lbLogo);
				
				
				
				this.panelTable.add(uneScroll);
				this.add(this.panelTable);
			
				
				this.txtMot.setBounds(50,20,120,20);
				this.panelTable.add(this.txtMot);
				this.btRechercher.setBounds(190,20,120,20);
				this.panelTable.add(this.btRechercher);
				
				this.btAide.setBounds(550,20,120,20);
				this.panelTable.add(this.btAide);
				
				this.uneTable.addMouseListener(new MouseListener() {

					@Override
					public void mouseClicked(MouseEvent e) 
					{
						int nbclic = e.getClickCount();
						if (nbclic==2)
						{
							int numLigne = uneTable.getSelectedRow();
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette famille ?",
									"Suppression Famille",JOptionPane.YES_NO_OPTION);
							if (retour == 0)
							{
								//suppression d'une famille
								int idfamille = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
								Modele.deleteFamille(idfamille);
								
								//actualiser l'affichage
								unTableau.supprimerLigne(numLigne);
							}
						}
						else if (nbclic==1)
						{
							int numLigne = uneTable.getSelectedRow();
							String nom = unTableau.getValueAt(numLigne, 1).toString();
							txtNom.setText(nom);
							String prenom = unTableau.getValueAt(numLigne, 2).toString();
							txtPrenom.setText(prenom);
							String adresse = unTableau.getValueAt(numLigne, 3).toString();
							txtAdresse.setText(adresse);
							String ville = unTableau.getValueAt(numLigne, 4).toString();
							txtVille.setText(ville);
							String email = unTableau.getValueAt(numLigne, 5).toString();
							txtEmail.setText(email);
							String mdp = unTableau.getValueAt(numLigne, 6).toString();
							txtMdp.setText(mdp);
							String telephone = unTableau.getValueAt(numLigne, 7).toString();
							txtTelephone.setText(telephone);
							String revenuimposable = unTableau.getValueAt(numLigne, 8).toString();
							txtRevenu_Imposable.setText(revenuimposable);
							String nombreenfants = unTableau.getValueAt(numLigne, 9).toString();
							txtNombreEnfants.setText(nombreenfants);
							String dateinscription = unTableau.getValueAt(numLigne, 10).toString();
							txtDateInscription.setText(dateinscription);
							String sexe = unTableau.getValueAt(numLigne, 11).toString();
							txtSexe.setText(sexe);
							//String Photo = unTableau.getValueAt(numLigne, 11).toString();
							//txtPhoto.setText(Photo);
							
							
							btEnregistrer.setText("Modifier");
						}
						
						
					}
		

					@Override
					public void mousePressed(MouseEvent e) {
						
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						
						
					}
				});

				this.btEnregistrer.addActionListener(this);
				this.btAnnuler.addActionListener(this);
				this.btRechercher.addActionListener(this); //31.01
				this.btAide.addActionListener(this);
				

			}
	

	public Object[][] getLesDonnees(String mot) // 24/01
	{
		ArrayList<Famille> lesFamilles = null;
		if(mot.equals(""))
		{
			lesFamilles = Modele.selectAllFamilles();
		}
		else {
			lesFamilles = Modele.selectLikeFamilles(mot);
		}
		Object[][] matrice = new Object[lesFamilles.size()][12]; //.size pour le nombre de lignes et 6 pour le nb 
		int i = 0;												// de colonnes
		for(Famille uneFamille : lesFamilles)
		{
			matrice[i][0] = uneFamille.getIdfamille();
			matrice[i][1] = uneFamille.getNom();
			matrice[i][2] = uneFamille.getPrenom();
			matrice[i][3] = uneFamille.getAdresse();
			matrice[i][4] = uneFamille.getVille();
			matrice[i][5] = uneFamille.getEmail();
			matrice[i][6] = uneFamille.getMdp();
			matrice[i][7] = uneFamille.getTelephone();
			matrice[i][8] = uneFamille.getRevenu_imposable();
			matrice[i][9] = uneFamille.getNombreenfants();
			matrice[i][10] = uneFamille.getDateinscription();
			matrice[i][11]= uneFamille.getSexe();
			//matrice[i][12] = uneFamille.getPhoto();
			i++;
		}
		return matrice;
		
	}
	
	public void viderChamps() //séance 28/01
	{
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtAdresse.setText("");
		this.txtVille.setText("");
		this.txtEmail.setText("");
		this.txtMdp.setText("");
		this.txtTelephone.setText("");
		this.txtRevenu_Imposable.setText("");
		this.txtNombreEnfants.setText("");
		this.txtDateInscription.setText("");
		this.txtSexe.setText("");
		//this.txtPhoto.setText("");
		
		this.btEnregistrer.setText("Enregistrer"); //séance 28/01
	}
	
	public void mettreEnBlanc()
	{
		this.txtNom.setBackground(Color.white);
		this.txtPrenom.setBackground(Color.white);
		this.txtAdresse.setBackground(Color.white);
		this.txtVille.setBackground(Color.white);
		this.txtEmail.setBackground(Color.white);
		this.txtMdp.setBackground(Color.white);
		this.txtTelephone.setBackground(Color.white);
		this.txtRevenu_Imposable.setBackground(Color.white);
		this.txtNombreEnfants.setBackground(Color.white);
		this.txtDateInscription.setBackground(Color.white);
		this.txtSexe.setBackground(Color.white);
		//this.txtPhoto.setBackground(Color.white);
		
	}
	
	public Famille saisirFamille() //séance 28/01
	{
		Famille uneFamille = null;
		String nom = this.txtNom.getText();
		String prenom = this.txtPrenom.getText();
		String adresse = this.txtAdresse.getText();
		String ville = this.txtVille.getText();
		String email = this.txtEmail.getText();
		String mdp = this.txtMdp.getText();
		String telephone  = this.txtTelephone.getText();
		String revenu_imposable  = this.txtRevenu_Imposable.getText();
		String nombreenfants  = this.txtNombreEnfants.getText();
		String dateinscription = this.txtDateInscription.getText();
		String sexe = this.txtSexe.getText();
		String photo = this.txtPhoto.getText(); //début séance 24/01
		
		if (nom.equals(""))
		{
			this.txtNom.setBackground(Color.red);	
		}else {
			this.txtNom.setBackground(Color.white);
		}
		if(prenom.equals(""))
		{
			this.txtPrenom.setBackground(Color.red);
		}else {
			this.txtPrenom.setBackground(Color.white);
		}
		if(adresse.equals(""))
		{
			this.txtAdresse.setBackground(Color.red);
		}else {
			this.txtAdresse.setBackground(Color.white);
		}
		if(ville.equals(""))
		{
			this.txtVille.setBackground(Color.red);
		}else {
			this.txtVille.setBackground(Color.white);
		}
		if(email.equals(""))
		{
			this.txtEmail.setBackground(Color.red);
		}else {
			this.txtEmail.setBackground(Color.white);
		}if(mdp.equals(""))
		{
			this.txtMdp.setBackground(Color.red);
		}else {
			this.txtMdp.setBackground(Color.white);
		}
		if(telephone.equals(""))
		{
			this.txtTelephone.setBackground(Color.red);
		}else {
			this.txtTelephone.setBackground(Color.white);
		}
		if(revenu_imposable.equals(""))
		{
			this.txtRevenu_Imposable.setBackground(Color.red);
		}else {
			this.txtRevenu_Imposable.setBackground(Color.white);
		}
		if(nombreenfants.equals(""))
		{
			this.txtNombreEnfants.setBackground(Color.red);
		}else {
			this.txtNombreEnfants.setBackground(Color.white);
		}
		
		if(dateinscription.equals(""))
		{
			this.txtDateInscription.setBackground(Color.red);
		}else {
			this.txtDateInscription.setBackground(Color.white);
		}
		if(sexe.equals(""))
		{
			this.txtSexe.setBackground(Color.red);
		}else {
			this.txtSexe.setBackground(Color.white);
		}

		/*if(photo.equals(""))
		{
		this.txtPhoto.setBackground(Color.red);
		}else {
			this.txtPhoto.setBackground(Color.white);
		}*/

		if( ! nom.equals("") && ! prenom.equals("") && ! adresse.equals("") && ! ville.equals("") 
				&& !  email.equals("")&& ! mdp.equals("") && ! telephone.equals("") && ! revenu_imposable.equals("")
				&& ! nombreenfants.equals("") && ! sexe.equals("")) 
		{
			 uneFamille = new Famille(nom,prenom,adresse,ville ,email,mdp,telephone, revenu_imposable, nombreenfants,
					 dateinscription,sexe ,photo );
		} 
		else 
		{
			return null;
		}
		return uneFamille;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == this.btAnnuler)
		{
			this.viderChamps();
			this.mettreEnBlanc();
			
		}else if(e.getSource() == this.btEnregistrer  && e.getActionCommand().equals("Enregistrer"))
		{
			Famille uneFamille = this.saisirFamille();
			if(uneFamille != null)
			{
				
	
				Modele.insertFamille(uneFamille);
				
				//récuperer l'id auto_increment de la BDD 24/01
				uneFamille = Modele.selectWhereFamille(uneFamille.getNom(),uneFamille.getPrenom(),uneFamille.getAdresse(),
						uneFamille.getVille(),uneFamille.getEmail()); //séance 28/01
				
				Object ligne[] = {uneFamille.getIdfamille(),
						uneFamille.getNom(),
						uneFamille.getPrenom(),
						uneFamille.getAdresse(),
						uneFamille.getVille(),
						uneFamille.getEmail(),
						uneFamille.getMdp(),
						uneFamille.getTelephone(),
						uneFamille.getRevenu_imposable(),
						uneFamille.getNombreenfants(),
						uneFamille.getDateinscription(),
						uneFamille.getSexe(),
						uneFamille.getPhoto()};
				
				unTableau.ajouterLigne(ligne);
				
				JOptionPane.showMessageDialog(this, "Insertion Réussie");
				
				this.viderChamps();
			}
		}//séance 28/01
			
			else if(e.getSource() == this.btRechercher) //31.01
			{
				String mot = this.txtMot.getText(); //pour récupérer le mot recherché
				
				//récuperer la matrice des données pour actualiser l'affichage
				Object matrice [][] = this.getLesDonnees(mot);
				
				unTableau.setDonnees(matrice);
				
				
			}
			else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier") ) //séance 28/01
			{
				
				Famille uneFamille = this.saisirFamille();
				
				JOptionPane.showConfirmDialog(this, "Modification éfféctuée");
				int numLigne = this.uneTable.getSelectedRow();
				int idfamille = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
				uneFamille.setIdfamille(idfamille);
				
				Modele.updateFamille(uneFamille);
				
				Object ligne[] = {uneFamille.getIdfamille(),uneFamille.getNom(),uneFamille.getPrenom(),uneFamille.getAdresse(),
						uneFamille.getVille(),uneFamille.getEmail(),uneFamille.getMdp(),uneFamille.getTelephone(),uneFamille.getRevenu_imposable(),uneFamille.getNombreenfants()
						,uneFamille.getDateinscription(),uneFamille.getSexe(),//uneFamille.getPhoto()
						};
				unTableau.modifierLigne(numLigne, ligne);
				this.btEnregistrer.setText("Enregistrer");
				this.viderChamps();
			}
			else if(e.getSource() == this.btRechercher) //31.01
			{
				String mot = this.txtMot.getText(); //pour récupérer le mot recherché
				
				//récuperer la matrice des données pour actualiser l'affichage
				Object matrice [][] = this.getLesDonnees(mot);
				
				unTableau.setDonnees(matrice);

			}else if (e.getSource() == this.btAide)
			{
				JOptionPane.showMessageDialog(this, "Menu d'utilisation : \n\n" 
						+ "- Double Click sur une ligne pour la suppression\n\n"
						+ "- Un click sur une ligne permet de remplir le formulaire avec "
						+ "les informations de la ligne, \n pour modifier une information, modifier "
						+ "le champ correspondant "
						+ "depuis le formulaire et enregistrer\n\n"
						+ "- Pour faire une recherche par un mot, par une date entrer dans "
						+ "le champs vide l'élement\n recherché puis clicker sur rechercher");
			}

		}


	}

