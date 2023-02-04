package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Famille;
import controleur.Prestation;
import controleur.Tableau;
import controleur.TypePresta;
import controleur.User;
import modele.Modele;

public class PanelPrestation extends PanelDeBase implements ActionListener
{
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtLibellePresta = new JTextField();
	private JTextField txtNombrePlaces = new JTextField();
	private JTextField txtDatepresta = new JTextField();
	private JTextField txtHeurepresta = new JTextField();
	private JComboBox<String> cbxCodeTypePresta= new JComboBox<String>(); 
	private JComboBox<String> cbxIdFamille = new JComboBox<String>(); 


	private JTable uneTable = null; //séance 24/01
	
	private static Tableau unTableau = null;
	
	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");
	
	private JButton btAide = new JButton("Aide");

	public PanelPrestation()
	{
		super(new Color(225,210,184));
		this.panelForm.setLayout(new GridLayout(8,2));
		
		this.panelForm.add(new JLabel("Nom Prestation :"));
		this.panelForm.add(this.txtLibellePresta);
		
		this.panelForm.add(new JLabel("Nombre Places :"));
		this.panelForm.add(this.txtNombrePlaces);
		
		this.panelForm.add(new JLabel("Date Prestation :"));
		this.panelForm.add(this.txtDatepresta);
		
		this.panelForm.add(new JLabel("Heure Prestation :"));
		this.panelForm.add(this.txtHeurepresta);
		
		this.panelForm.add(new JLabel("Type :"));
		this.panelForm.add(this.cbxCodeTypePresta);
		
		this.panelForm.add(new JLabel("Famille :"));
		this.panelForm.add(this.cbxIdFamille);

		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		this.panelForm.setBounds(20,50,500,300);
		
		//remplir les CBX ID 
				this.remplirCBX();
		
		this.add(this.panelForm);
		
		this.btEnregistrer.setBackground(Color.green);
		this.btAnnuler.setBackground(Color.red);
		
		//Construction du panel Table // 24/01
		this.panelTable.setBounds(520,20,800,700);
		this.panelTable.setBackground(new Color(225,210,184));
		this.panelTable.setLayout(null); 
		

		
		String entetes[]= {" Code "," Libelle ",
				" Places ","  Date  ","  Heure  "," Type ","Famille","User"};
		Object donnees [][]=this.getLesDonnees("");
		unTableau = new Tableau(entetes,donnees); //appelle du constructeur tableau
		
		this.uneTable = new JTable(unTableau); //JTable composée de données entetes
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(20,60,550,250);
		
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		
		this.txtMot.setBounds(50,20,120,20);
		this.panelTable.add(this.txtMot);
		this.btRechercher.setBounds(190,20,120,20);
		this.panelTable.add(this.btRechercher);
		
		this.btAide.setBounds(450,20,120,20);
		this.panelTable.add(this.btAide);
		
		
		ImageIcon leLogo = new ImageIcon("src/images/prestation.png");
		JLabel lbLogo = new JLabel(leLogo);
		lbLogo.setBounds(15,300,645,150);
		this.panelTable.add(lbLogo);
		
		
		this.uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
				int nbclic = e.getClickCount();
				if (nbclic==2)
				{
					int numLigne = uneTable.getSelectedRow();
					int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette Prestation ?",
							"Suppression Prestation",JOptionPane.YES_NO_OPTION);
					if (retour == 0)
					{
						int codepresta = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
						Modele.deletePrestation(codepresta);
						
						//actualiser l'affichage
						unTableau.supprimerLigne(numLigne);
					}
				}
				else if (nbclic==1)
				{
					int numLigne = uneTable.getSelectedRow();
					String libelleprestation = unTableau.getValueAt(numLigne, 1).toString();
					txtLibellePresta.setText(libelleprestation);
					String nombreplaces = unTableau.getValueAt(numLigne, 2).toString();
					txtNombrePlaces.setText(nombreplaces);
					String datepresta = unTableau.getValueAt(numLigne, 3).toString();
					txtDatepresta.setText(datepresta);
					String heurepresta = unTableau.getValueAt(numLigne, 4).toString();
					txtHeurepresta.setText(heurepresta);
					int codetypepresta = (int) unTableau.getValueAt(numLigne, 5);
					cbxCodeTypePresta.setSelectedIndex(codetypepresta);		
					int idfamille = (int) unTableau.getValueAt(numLigne, 6);
					cbxIdFamille.setSelectedIndex(idfamille);		
					
					btEnregistrer.setText("Modifier");
				}
			}			
			
			@Override
			public void mouseReleased(MouseEvent e) {

			}
			
			@Override
			public void mousePressed(MouseEvent e) {

			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {

			}
			
			
		});
		
		
		this.btEnregistrer.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		this.btRechercher.addActionListener(this); //31.01
		this.btAide.addActionListener(this);
		
	}

	private void remplirCBX() {
		ArrayList<TypePresta> lesTypesPrestas = Modele.selectAllTypePrestas(); 
		for (TypePresta unTypePresta : lesTypesPrestas)
		{
			this.cbxCodeTypePresta.addItem(unTypePresta.getCodetypepresta()+"-" 
							+ unTypePresta.getNomtypepresta());
		}
		ArrayList<Famille> lesFamilles = Modele.selectAllFamilles(); 
		for (Famille uneFamille : lesFamilles)
		{
			this.cbxIdFamille.addItem(uneFamille.getIdfamille()+"-" 
							+ uneFamille.getNom()+"-"+ uneFamille.getPrenom());
		}
	}

	public Object[][] getLesDonnees(String mot) // 24/01
	{
		ArrayList<Prestation> lesPrestations = null;
		
		if(mot.equals(""))
		{
			lesPrestations = Modele.selectAllPrestations();
		}else {
			lesPrestations = Modele.selectLikePrestations(mot);
		}
		
		
		
		Object[][] matrice = new Object[lesPrestations.size()][8]; //lesPilotes.size pour le nombre de lignes et 6 pour le nb 
		int i = 0;												// de colonnes
		for(Prestation unePrestation : lesPrestations)
		{
			matrice[i][0] = unePrestation.getCodepresta();
			matrice[i][1] = unePrestation.getLibellepresta();
			matrice[i][2] = unePrestation.getNombreplaces();
			matrice[i][3] = unePrestation.getDatepresta();
			matrice[i][4] = unePrestation.getHeurepresta();
			matrice[i][5] = unePrestation.getCodetypepresta();
			matrice[i][6] = unePrestation.getIdfamille();
			matrice[i][7] = unePrestation.getEmail();
			i++;
		}
		return matrice;
		
	}
	
	public void viderChamps() //séance 28/01
	{
		this.txtLibellePresta.setText("");
		this.txtNombrePlaces.setText("");
		this.txtDatepresta.setText("");
		this.txtHeurepresta.setText("");

		
		this.btEnregistrer.setText("Enregistrer"); //séance 28/01
	}
	
	public void mettreEnBlanc()
	{
		this.txtLibellePresta.setBackground(Color.white);
		this.txtNombrePlaces.setBackground(Color.white);
		this.txtDatepresta.setBackground(Color.white);
		this.txtHeurepresta.setBackground(Color.white);
		//this.cbxICodeTypePresta.setBackground(Color.white);
	}
	
	public Prestation saisirPrestation(User unUser) //séance 28/01
	{
		Prestation unePrestation = null;
		String libellepresta = this.txtLibellePresta.getText();
		String nombreplaces = this.txtNombrePlaces.getText();
		String datepresta = this.txtDatepresta.getText();
		String heurepresta = this.txtHeurepresta.getText();
		String chaine = this.cbxCodeTypePresta.getSelectedItem().toString();
		String table[] = chaine.split("-");
		String chaine1 = this.cbxIdFamille.getSelectedItem().toString();
		String table1[] = chaine1.split("-");
		String email = unUser.getEmail();
		
		int codetypepresta = Integer.parseInt(table[0]);
		int idfamille = Integer.parseInt(table1[0]);


		
		if (libellepresta.equals(""))
		{
			this.txtLibellePresta.setBackground(Color.red);	
		}else {
			this.txtLibellePresta.setBackground(Color.white);
		}
		if(nombreplaces.equals(""))
		{
			this.txtNombrePlaces.setBackground(Color.red);
		}else {
			this.txtNombrePlaces.setBackground(Color.white);
		}
		if(datepresta.equals(""))
		{
			this.txtDatepresta.setBackground(Color.red);
		}else {
			this.txtDatepresta.setBackground(Color.white);
		}
		if(heurepresta.equals(""))
		{
			this.txtHeurepresta.setBackground(Color.red);
		}else {
			this.txtHeurepresta.setBackground(Color.white);
		}
		
		
		if( ! libellepresta.equals("") && ! nombreplaces.equals("") && ! datepresta.equals("") 
				&& ! heurepresta.equals("") )
		{
			 unePrestation= new Prestation(libellepresta,nombreplaces,datepresta,heurepresta,codetypepresta,idfamille,email);
		}
		else 
		{
			return null;
		}
		return unePrestation;
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
			
				Prestation unePrestation = this.saisirPrestation(null);
				if(unePrestation != null)
				{
					
				Modele.insertPrestation(unePrestation, null);
				
				//récuperer l'id auto_increment de la BDD 24/01
				unePrestation = Modele.selectWherePrestation(unePrestation.getLibellepresta()
						); //séance 28/01
				
				Object ligne[] = {unePrestation.getCodepresta(),
						unePrestation.getLibellepresta(),
						unePrestation.getNombreplaces(),
						unePrestation.getDatepresta(),
						unePrestation.getHeurepresta(),
						unePrestation.getCodetypepresta(),
						unePrestation.getIdfamille(),
						unePrestation.getEmail()};
				
				unTableau.ajouterLigne(ligne);
				
				JOptionPane.showMessageDialog(this, "Insertion Réussie");
				
				this.viderChamps();
				}

		}
		else if(e.getSource() == this.btRechercher) //31.01
		{
			String mot = this.txtMot.getText(); //pour récupérer le mot recherché
			
			//récuperer la matrice des données pour actualiser l'affichage
			Object matrice [][] = this.getLesDonnees(mot);
			
			unTableau.setDonnees(matrice);
			
			
		}
		else if(e.getSource() == this.btEnregistrer && e.getActionCommand().equals("Modifier") ) //séance 28/01
		{
			
			Prestation unePrestation = this.saisirPrestation(null);
			
			JOptionPane.showConfirmDialog(this, "Modification éfféctuée");
			int numLigne = this.uneTable.getSelectedRow();
			int codepresta = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
			unePrestation.setCodepresta(codepresta);
			
			Modele.updatePrestation(unePrestation);
			
			Object ligne[] = {unePrestation.getCodepresta(),
					unePrestation.getLibellepresta(),
					unePrestation.getNombreplaces(),
					unePrestation.getDatepresta(),
					unePrestation.getHeurepresta(),
					unePrestation.getCodetypepresta(),
					unePrestation.getIdfamille()};
			
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

		}
		else if (e.getSource() == this.btAide)
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
