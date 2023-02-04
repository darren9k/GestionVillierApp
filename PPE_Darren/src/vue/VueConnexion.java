package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import controleur.PPE_Darren;
import controleur.User;


public class VueConnexion extends JFrame implements ActionListener, KeyListener
{	
	 private JPanel panelConnexion = new JPanel();
	 private JButton btSeConnecter = new JButton("Se connecter");
	 private JButton btAnnuler = new JButton("Annuler");
	 private JTextField txtEmail = new JTextField("a@hotmail.fr");
	 private JPasswordField txtMdp = new JPasswordField("123");
	
	public VueConnexion()
	{
		this.setTitle("Mairie de Villiers - Administration");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.getContentPane().setBackground(new Color(225,210,184));
		this.setBounds(300,200,600,500);
		this.setLayout(null);
		

		
		//construction du panel
		this.panelConnexion.setLayout(new GridLayout(3,2));
		this.panelConnexion.setBounds(300, 150, 260, 150);
		this.panelConnexion.setBackground(Color.gray);
		
		this.panelConnexion.add(new JLabel("Email :"));
		this.panelConnexion.add(this.txtEmail);
		
		this.panelConnexion.add(new JLabel("MDP :"));
		this.panelConnexion.add(this.txtMdp);
		
		this.panelConnexion.add(this.btAnnuler);
		this.panelConnexion.add(this.btSeConnecter);
		
		this.add(this.panelConnexion);
		
		//installation du logo 
		ImageIcon leLogo = new ImageIcon("src/images/background.png");
		JLabel lbLogo = new JLabel(leLogo);
		lbLogo.setBounds(20,150,250,150);
		this.add(lbLogo);
		
		//rendre les boutons écoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else if(e.getSource() == this.btSeConnecter)
		{
			traitement();
		}
		
	}

	public void traitement()
	{
		String email = this.txtEmail.getText();
		String mdp = new String (this.txtMdp.getPassword());
		
		//22/04
		//mdp = PPE_Darren.crypterMdp(mdp);
		
		User unUser = PPE_Darren.selectWhereUser(email, mdp);
		if(unUser == null)
		{
			JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}else 
		{
			JOptionPane.showMessageDialog(this, "Bienvenue M./Mme  "+ unUser.getNom()
			+"\n Vous avez le rôle : "+unUser.getRole());
			//appel de la vue Générale
			//instancier la vue générale 
			PPE_Darren.instancierVueGenerale(unUser);
			//cacher la vue Connexion.
			PPE_Darren.rendreVisibleVueGenerale(false);
			
		}
	}
	
	@Override 
	public void keyTyped(KeyEvent e) 
	{
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			traitement ();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) 
	{
			
	}
}






























