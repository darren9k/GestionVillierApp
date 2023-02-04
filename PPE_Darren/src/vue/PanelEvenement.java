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

import controleur.Evenement;
import controleur.Famille;
import controleur.Tableau;
import controleur.TypeEvent;
import controleur.TypePresta;
import modele.Modele;

public class PanelEvenement extends PanelDeBase implements ActionListener
{
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtNomEvent = new JTextField();
	private JTextField txtTailleEvent = new JTextField();
	private JTextField txtDateEvent = new JTextField();
	private JTextField txtLieuEvent = new JTextField();
	private JTextField txtHeureEvent = new JTextField();
	private JComboBox<String> cbxCodeTypeEvent = new JComboBox<String>();
	private JComboBox<String> cbxIdFamille = new JComboBox<String>();

	private JTable uneTable = null; //séance 24/01
	
	private static Tableau unTableau = null;
	
	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");
	
	private JButton btAide = new JButton("Aide");
	
	public PanelEvenement()
	{
		super(new Color(225,210,184));
		this.panelForm.setLayout(new GridLayout(8,2));
		
		this.panelForm.add(new JLabel("Nom  :"));
		this.panelForm.add(this.txtNomEvent);
		
		this.panelForm.add(new JLabel("Taille  :"));
		this.panelForm.add(this.txtTailleEvent);
		
		this.panelForm.add(new JLabel("Date :"));
		this.panelForm.add(this.txtDateEvent);
		
		this.panelForm.add(new JLabel("Lieu :"));
		this.panelForm.add(this.txtLieuEvent);
		
		this.panelForm.add(new JLabel("Heure:"));
		this.panelForm.add(this.txtHeureEvent);
		
		this.panelForm.add(new JLabel("Type de l'event :"));
		this.panelForm.add(this.cbxCodeTypeEvent);
		
		this.panelForm.add(new JLabel("Id Famille :"));
		this.panelForm.add(this.cbxIdFamille);
		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		this.panelForm.setBounds(20,20,400,350);
		
		this.remplirCBX();
		
		this.add(this.panelForm);
		
		this.btEnregistrer.setBackground(Color.green);
		this.btAnnuler.setBackground(Color.red);
		
		//Construction du panel Table // 24/01
			this.panelTable.setBounds(425,20,800,700);
			this.panelTable.setBackground(new Color(225,210,184));
			this.panelTable.setLayout(null); 
			String entetes[]= {"Code","Nom","Taille","Lieu","Date",
						"Heure","Type event","famille"};
				Object donnees [][]=this.getLesDonnees("");
				unTableau = new Tableau(entetes,donnees); //appelle du constructeur tableau
				
				this.uneTable = new JTable(unTableau); //JTable composée de données entetes
				JScrollPane uneScroll = new JScrollPane(this.uneTable);
				uneScroll.setBounds(15,70,645,200);
				
				this.panelTable.add(uneScroll);
				this.add(this.panelTable);
				
				this.txtMot.setBounds(50,20,120,20);
				this.panelTable.add(this.txtMot);
				
				this.btRechercher.setBounds(190,20,140,20);
				this.panelTable.add(this.btRechercher);
				
				this.btAide.setBounds(540,20,120,20);
				this.panelTable.add(this.btAide);
				
				ImageIcon leLogo = new ImageIcon("src/images/evenement.png");
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
							int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cet evenement ?",
									"Suppression Evenement",JOptionPane.YES_NO_OPTION);
							if (retour == 0)
							{
								int codeevent = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
								Modele.deleteEvenement(codeevent);
								
								//actualiser l'affichage
								unTableau.supprimerLigne(numLigne);
							}
						}
						else if (nbclic==1)
						{
							int numLigne = uneTable.getSelectedRow();
							String nomevent = unTableau.getValueAt(numLigne, 1).toString();
							txtNomEvent.setText(nomevent);
							String tailleevent = unTableau.getValueAt(numLigne, 2).toString();
							txtTailleEvent.setText(tailleevent);
							String lieuevent = unTableau.getValueAt(numLigne, 3).toString();
							txtLieuEvent.setText(lieuevent);
							String dateevent = unTableau.getValueAt(numLigne, 4).toString();
							txtDateEvent.setText(dateevent);
							String heureevent = unTableau.getValueAt(numLigne, 5).toString();
							txtHeureEvent.setText(heureevent);
							int codetypeevent = (int) unTableau.getValueAt(numLigne, 6);
							cbxCodeTypeEvent.setSelectedItem(cbxCodeTypeEvent);	
							int idfamille = (int) unTableau.getValueAt(numLigne, 7);
							cbxCodeTypeEvent.setSelectedItem(cbxCodeTypeEvent);	
							
							btEnregistrer.setText("Modifier");
						}
						
					}
					
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				this.btEnregistrer.addActionListener(this);
				this.btAnnuler.addActionListener(this);
				this.btRechercher.addActionListener(this); //31.01
				this.btAide.addActionListener(this);
		
	}
	
	public Object[][] getLesDonnees(String mot) // 24/01
	{
		ArrayList<Evenement> lesEvenements = null;
		
		if(mot.equals(""))
		{
			lesEvenements = Modele.selectAllEvenements();
		}else {
			lesEvenements = Modele.selectLikeEvenements(mot);
		}
		
		
		
		
		
		Object[][] matrice = new Object[lesEvenements.size()][8]; //lesPilotes.size pour le nombre de lignes et 6 pour le nb 
		int i = 0;												// de colonnes
		for(Evenement unEvenement : lesEvenements)
		{
			matrice[i][0] = unEvenement.getCodeevent();
			matrice[i][1] = unEvenement.getNomevent();
			matrice[i][2] = unEvenement.getTailleevent();
			matrice[i][3] = unEvenement.getLieuevent();
			matrice[i][4] = unEvenement.getDateevent();
			matrice[i][5] = unEvenement.getHeureevent();
			matrice[i][6] = unEvenement.getCodetypeevent();
			matrice[i][7] = unEvenement.getIdfamille();
			i++;
		}
		return matrice;
		
	}
	
	public void viderChamps() //séance 28/01
	{
		this.txtNomEvent.setText("");
		this.txtTailleEvent.setText("");
		this.txtLieuEvent.setText("");
		this.txtDateEvent.setText("");
		this.txtHeureEvent.setText("");
		this.btEnregistrer.setText("Enregistrer"); //séance 28/01
	}
	
	private void remplirCBX() {
		ArrayList<TypeEvent> lesTypesEvents = Modele.selectAllTypeEvents(); 
		for (TypeEvent unTypeEvent : lesTypesEvents)
		{
			this.cbxCodeTypeEvent.addItem(unTypeEvent.getCodetypeevent()+"-" 
							+ unTypeEvent.getNomtypeevent());
		}	
		ArrayList<Famille> lesFamilles = Modele.selectAllFamilles(); 
		for (Famille uneFamille : lesFamilles)
		{
			this.cbxIdFamille.addItem(uneFamille.getIdfamille()+"-" 
							+ uneFamille.getNom()+"-"+ uneFamille.getPrenom());
		}	
	}

	
	public void mettreEnBlanc()
	{
		this.txtNomEvent.setBackground(Color.white);
		this.txtTailleEvent.setBackground(Color.white);
		this.txtLieuEvent.setBackground(Color.white);
		this.txtDateEvent.setBackground(Color.white);
		this.txtHeureEvent.setBackground(Color.white);
		
	}
	
	
	public Evenement saisirEvenement() //séance 28/01
	{
		Evenement unEvenement = null;
		String nomevent = this.txtNomEvent.getText();
		String tailleevent = this.txtTailleEvent.getText();
		String lieuevent = this.txtLieuEvent.getText();
		String dateevent = this.txtDateEvent.getText();
		String heureevent = this.txtHeureEvent.getText();
		String chaine = this.cbxCodeTypeEvent.getSelectedItem().toString();
		String table[] = chaine.split("-");
		String chaine1 = this.cbxIdFamille.getSelectedItem().toString();
		String table1[] = chaine1.split("-");
		
		int codetypeevent = Integer.parseInt(table[0]);
		
		int idfamille = Integer.parseInt(table1[0]);
		

		
		if (nomevent.equals(""))
		{
			this.txtNomEvent.setBackground(Color.red);	
		}else {
			this.txtNomEvent.setBackground(Color.white);
		}
		if(tailleevent.equals(""))
		{
			this.txtTailleEvent.setBackground(Color.red);
		}else {
			this.txtTailleEvent.setBackground(Color.white);
		}
		if(lieuevent.equals(""))
		{
			this.txtLieuEvent.setBackground(Color.red);
		}else {
			this.txtLieuEvent.setBackground(Color.white);
		}
		if(dateevent.equals(""))
		{
			this.txtDateEvent.setBackground(Color.red);
		}else {
			this.txtDateEvent.setBackground(Color.white);
		}
		if(heureevent.equals(""))
		{
			this.txtHeureEvent.setBackground(Color.red);
		}else {
			this.txtHeureEvent.setBackground(Color.white);
		}


		if( ! nomevent.equals("") && ! tailleevent.equals("") 
				&& ! lieuevent.equals("") && ! dateevent.equals("") 
				&& !  heureevent.equals(""))
		{
			 unEvenement = new Evenement(nomevent,tailleevent,lieuevent,
					 dateevent ,heureevent,codetypeevent,idfamille);
		}
		else 
		{
			return null;
		}
		return unEvenement;
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
			
			Evenement unEvenement = this.saisirEvenement();
			if (unEvenement != null)
			{
				Modele.insertEvenement(unEvenement);
				
				//récuperer l'id auto_increment de la BDD 24/01
				unEvenement = Modele.selectWhereEvenement(unEvenement.getNomevent(),
						unEvenement.getLieuevent()
						); //séance 28/01
				
				Object ligne[] = {unEvenement.getCodeevent(),
						unEvenement.getNomevent(),
						unEvenement.getTailleevent(),
						unEvenement.getLieuevent(),
						unEvenement.getDateevent(),
						unEvenement.getHeureevent(),
						unEvenement.getCodetypeevent(),
						unEvenement.getIdfamille()};
				
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
			
			Evenement unEvenement = this.saisirEvenement();
			
			JOptionPane.showConfirmDialog(this, "Modification éfféctuée");
			int numLigne = this.uneTable.getSelectedRow();
			int codeevent = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
			unEvenement.setCodeevent(codeevent);
			
			Modele.updateEvenement(unEvenement);
			
			Object ligne[] = {unEvenement.getCodeevent(),
					unEvenement.getNomevent(),
					unEvenement.getTailleevent(),
					unEvenement.getLieuevent(),
					unEvenement.getDateevent(),
					unEvenement.getHeureevent(),
					unEvenement.getCodetypeevent(),
					unEvenement.getIdfamille()};
			
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


