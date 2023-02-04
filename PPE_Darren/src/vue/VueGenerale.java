package vue;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;


import javax.swing.*;

import controleur.PPE_Darren;
import controleur.User;


public class VueGenerale extends JFrame implements ActionListener
{
	private JButton btQuitter = new JButton("Se Déconnecter");
	
	private JButton btProfil = new JButton("Profil");
	private JButton btFamille = new JButton("Famille");
	private JButton btTypeEvent = new JButton("Type Event");
	private JButton btEvenement = new JButton("Evenement");
	private JButton btTypePresta = new JButton("Type Prestation");
	private JButton btPresta = new JButton("Prestation");
	private JButton btStats = new JButton("Statistiques");
	private JButton btBoard = new JButton("Tableau de bord");

	

	
	
	/******************LES PANELS***************/
	private JPanel panelMenu = new JPanel();
	private JPanel panelProfil = new JPanel();
	private static PanelFamille unPanelFamille = new PanelFamille();
	private static PanelTypeEvent unPanelTypeEvent = new PanelTypeEvent();//21-01
	private static PanelEvenement unPanelEvenement = new PanelEvenement();
	private static PanelTypePresta unPanelTypePresta = new PanelTypePresta();
	private static PanelPrestation unPanelPrestation = new PanelPrestation();
	private static PanelStatistique unPanelStatistique = new PanelStatistique();	
	//private static PanelBoard unPanelBoard = new Panel();	

	
	
	
	public VueGenerale(User unUser)
	{
		this.setTitle("Mairie de Villiers - Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(245,245,220));
		this.setBounds(200,0,1290,800);
		this.setLayout(null);
		
		//construction du panel menu 
		this.panelMenu.setLayout(new GridLayout(1,7));
		this.panelMenu.setBounds(20, 20, 1200, 40);
		this.panelMenu.setBackground(Color.cyan);
		
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btFamille);
		this.panelMenu.add(this.btTypeEvent);
		this.panelMenu.add(this.btEvenement);
		this.panelMenu.add(this.btTypePresta);
		this.panelMenu.add(this.btPresta);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btBoard);
		this.panelMenu.add(this.btQuitter);
		
		
		
		
		
		this.btQuitter.setBackground(new Color(118,94,50));
		this.btProfil.setBackground(new Color(118,94,50));
		this.btFamille.setBackground(new Color(118,94,50));
		this.btTypeEvent.setBackground(new Color(118,94,50));
		this.btEvenement.setBackground(new Color(118,94,50)); 
		this.btTypePresta.setBackground(new Color(118,94,50));
		this.btPresta.setBackground(new Color(118,94,50));
		this.btStats.setBackground(new Color(118,94,50)); 
		this.btBoard.setBackground(new Color(118,94,50));
		
		this.btQuitter.setForeground(Color.white);
		this.btProfil.setForeground(Color.white);
		this.btFamille.setForeground(Color.white);
		this.btTypeEvent.setForeground(Color.white);
		this.btEvenement.setForeground(Color.white);
		this.btTypePresta.setForeground(Color.white);
		this.btPresta.setForeground(Color.white);
		this.btStats.setForeground(Color.white);
		this.btBoard.setForeground(Color.white);
		
		
		this.add(this.panelMenu);
		
		//118,94,50
		
//construction du panel profil 22/01 //ajout User unUser
		
		this.panelProfil.setLayout(new GridLayout(4,1));
		this.panelProfil.setBounds(250,100, 800, 400);
		this.panelProfil.setBackground(new Color(225,210,184)); //225 210 184
		this.panelProfil.setVisible(false);
		this.panelProfil.add(new JLabel("Nom de l'user:  "+unUser.getNom()));
		this.panelProfil.add(new JLabel("Prenom de l'user:  "+unUser.getPrenom()));
		this.panelProfil.add(new JLabel("Email de l'user:  "+unUser.getEmail()));
		this.panelProfil.add(new JLabel("Le rôle de l'user:  "+unUser.getRole()));
		this.panelProfil.add(new JLabel("Dernière connexion :"+unUser.getDerniereConnexion()));
		this.add(this.panelProfil);	
		
		
		//insertion des panels d'administration // pilote /avion /vol 
		this.add(unPanelFamille);
		
		this.add(unPanelTypeEvent);
			
		this.add(unPanelEvenement);
				
		this.add(unPanelTypePresta);
		
		this.add(unPanelPrestation);
		
		this.add(unPanelStatistique);
		
		//this.add(unPanelBoard);
		
		//this.add(unPanelPresta);
		
		
		
				
		//rendre les boutons cliquables
		this.btQuitter.addActionListener(this);
		this.btProfil.addActionListener(this);
		this.btFamille.addActionListener(this);
		this.btTypeEvent.addActionListener(this);
		this.btEvenement.addActionListener(this);
		this.btTypePresta.addActionListener(this);
		this.btPresta.addActionListener(this);
		this.btStats.addActionListener(this);
		this.btBoard.addActionListener(this);
		
		this.panelMenu.setBackground(Color.black);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btQuitter)
		{
			PPE_Darren.fermerVueGenerale();
			PPE_Darren.rendreVisibleVueConnexion(true);
		}
		else if(e.getSource()== this.btProfil) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(true);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(false);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
			
		}else if(e.getSource()== this.btFamille) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(true);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
	}

		else if(e.getSource()== this.btTypeEvent) {
			unPanelTypeEvent.setVisible(true);
				this.panelProfil.setVisible(false);
				unPanelEvenement.setVisible(false);
				unPanelTypePresta.setVisible(false);
				unPanelPrestation.setVisible(false);
				unPanelFamille.setVisible(false);
				unPanelStatistique.setVisible(false);
				//unPanelBoard.setVisible(false);
				
		}
		else if(e.getSource()== this.btEvenement) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(true);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(false);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
		}
		else if(e.getSource()== this.btTypePresta) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(true);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(false);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
		}
		else if(e.getSource()== this.btPresta) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(true);
			unPanelFamille.setVisible(false);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
		}
		else if(e.getSource()== this.btStats) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(false);
			unPanelStatistique.setVisible(true);
			///		unPanelBoard.setVisible(false);
		}
		else if(e.getSource()== this.btFamille) {
			unPanelTypeEvent.setVisible(false);
			this.panelProfil.setVisible(false);
			unPanelEvenement.setVisible(false);
			unPanelTypePresta.setVisible(false);
			unPanelPrestation.setVisible(false);
			unPanelFamille.setVisible(true);
			unPanelStatistique.setVisible(false);
			//unPanelBoard.setVisible(false);
		}
	
	}
}



