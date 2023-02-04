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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Famille;
import controleur.Tableau;
import controleur.TypeEvent;
import modele.Modele;

public class PanelTypeEvent extends PanelDeBase implements ActionListener
{
	private JPanel panelForm = new JPanel();
	private JPanel panelTable = new JPanel();
	private JButton btEnregistrer = new JButton("Enregistrer");
	private JButton btAnnuler = new JButton("Annuler");
	private JTextField txtNomTypeEvent = new JTextField();
	
	private JTable uneTable = null; //séance 24/01
	
	private static Tableau unTableau = null;
	
	private JTextField txtMot = new JTextField();
	private JButton btRechercher = new JButton("Rechercher");
	
	private JButton btAide = new JButton("Aide");

	public PanelTypeEvent()
	{
		super(new Color(225,210,184));
		this.panelForm.setLayout(new GridLayout(2,2));
		
		this.panelForm.add(new JLabel("Nom du Type de l'evenement :"));
		this.panelForm.add(this.txtNomTypeEvent);

		
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btEnregistrer);
		
		this.panelForm.setBounds(20,80,450,100);
		this.add(this.panelForm);
		
		this.btEnregistrer.setBackground(Color.green);
		this.btAnnuler.setBackground(Color.red);
		
		//Construction du panel Table // 24/01
		this.panelTable.setBounds(520,20,800,700);
		this.panelTable.setBackground(new Color(225,210,184));
		this.panelTable.setLayout(null); 
		String entetes[]= {"ID Type Event","Nom Type Event"};

		Object donnees [][]=this.getLesDonnees("");
		unTableau = new Tableau(entetes,donnees); //appelle du constructeur tableau
		
		this.uneTable = new JTable(unTableau); //JTable composée de données entetes
		JScrollPane uneScroll = new JScrollPane(this.uneTable);
		uneScroll.setBounds(0,60,550,200);

		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		
		this.txtMot.setBounds(50,20,120,20);
		this.panelTable.add(this.txtMot);
		this.btRechercher.setBounds(190,20,120,20);
		this.panelTable.add(this.btRechercher);
		
		this.btAide.setBounds(430,20,120,20);
		this.panelTable.add(this.btAide);
		
		ImageIcon leLogo = new ImageIcon("src/images/typeevent.png");
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
						int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce type d'evenement ?",
								"Suppression du Type d'evenement",JOptionPane.YES_NO_OPTION);
						if (retour == 0)
						{
							//suppression d'un type d'evenement
							int codetypeevent = Integer.parseInt(unTableau.getValueAt(numLigne, 0).toString());
							Modele.deleteTypeEvent(codetypeevent);
							
							//actualiser l'affichage
							unTableau.supprimerLigne(numLigne);
						}
					}
					else if (nbclic==1)
					{
						int numLigne = uneTable.getSelectedRow();
						String nomtypeevent = unTableau.getValueAt(numLigne, 1).toString();
						txtNomTypeEvent.setText(nomtypeevent);
						
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
	
	public Object[][] getLesDonnees(String mot) // 24/01
	{
		ArrayList<TypeEvent> lesTypesEvents = null;
		if(mot.equals(""))
		{
			lesTypesEvents = Modele.selectAllTypeEvents();
		}
		else {
			lesTypesEvents = Modele.selectLikeTypeEvents(mot);
		}
		Object[][] matrice = new Object[lesTypesEvents.size()][2]; //.size pour le nombre de lignes et 6 pour le nb 
		int i = 0;												// de colonnes
		for(TypeEvent unTypeEvent : lesTypesEvents)
		{
			matrice[i][0] = unTypeEvent.getCodetypeevent();
			matrice[i][1] = unTypeEvent.getNomtypeevent();

			i++;
		}
		return matrice;
		
	}
	public void viderChamps() //méthode permettant une fois le bouton
								//annuler appuyé, vide les champs
	{
		this.txtNomTypeEvent.setText("");

		this.btEnregistrer.setText("Enregistrer"); //séance 28/01
	}
	
	public void mettreEnBlanc()
	{
		this.txtNomTypeEvent.setBackground(Color.white);

	}
	
	
	public TypeEvent saisirTypeEvent() //séance 28/01
	{
		TypeEvent unTypeEvent = null;
		String nomtypeevent = this.txtNomTypeEvent.getText();
		
		if (nomtypeevent.equals(""))
		{
			this.txtNomTypeEvent.setBackground(Color.red);	
		}else {
			this.txtNomTypeEvent.setBackground(Color.white);
		}
		if(! nomtypeevent.equals(""))
		{
			unTypeEvent = new TypeEvent(nomtypeevent);
		}else {
			
			return null;
		}
		return unTypeEvent;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btAnnuler)
		{
			this.viderChamps(); //on appelle la méthode viderchamps si le bt annuler est presse
			this.mettreEnBlanc(); //remet en blanc les zone de texte après avoir appuyé sur annuler
		}
		else if(e.getSource() == this.btEnregistrer  && e.getActionCommand().equals("Enregistrer"))
		{
			TypeEvent unTypeEvent = this.saisirTypeEvent();
			
			Modele.insertTypeEvent(unTypeEvent);
			
			//récuperer l'id auto_increment de la BDD 24/01
			unTypeEvent = Modele.selectWhereTypeEvent(unTypeEvent.getNomtypeevent()); //séance 28/01

			Object ligne[] = {unTypeEvent.getCodetypeevent(),
					unTypeEvent.getNomtypeevent()};
			
			unTableau.ajouterLigne(ligne);
			
			JOptionPane.showMessageDialog(this, "Insertion Réussie");
			this.viderChamps();
			
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
			TypeEvent unTypeEvent = this.saisirTypeEvent();
			
			JOptionPane.showConfirmDialog(this, "Modification éfféctuée");
			int numLigne = this.uneTable.getSelectedRow();
			int codetypeevent = Integer.parseInt(unTableau.getValueAt(numLigne,0).toString());
			unTypeEvent.setCodetypeevent(codetypeevent);
			
			Modele.updateTypeEvent(unTypeEvent);
			
			Object ligne[] = {unTypeEvent.getCodetypeevent(),
					unTypeEvent.getNomtypeevent()};
			
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
