package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.mysql.jdbc.log.Jdk14Logger;


import controleur.Tableau;
import controleur.UserPresta;
import modele.Modele; 

public class PanelStatistique extends PanelDeBase
{
	private JPanel unPanel = new JPanel(); 
	private JPanel unPanel2 = new JPanel();
	private JPanel unPanel3 = new JPanel();

	public PanelStatistique() 
	{
		super(new Color(225,210,184));

		this.unPanel.setBackground(new Color(225,210,184));
		this.unPanel.setBounds(200, 200, 700, 200);
		this.unPanel.setLayout(new GridLayout(3,1));
		
		int nbFamille = Modele.countFamille (); 
		int nbTypeEvent = Modele.countTypeEvent(); 
		int nbEvent = Modele.countEvent (); 
		int nbTypePresta = Modele.countTypePresta();
		int nbPresta = Modele.countPresta(); 
		
		
		String entetes [] = {"Nombre Famille","Nombre Type Event","Nombre Evenement",
				"Nombre Type Presta", "Nombre Prestation"}; 
		Object matrice [][]= {{nbFamille,nbTypeEvent,nbEvent,nbTypePresta,nbPresta}}; 
		Tableau unTableau = new Tableau (entetes, matrice); 
		JTable uneTable = new JTable(unTableau);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer(); 
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); 
		for (int i =0; i < uneTable.getColumnCount() ; i++)
		{
			uneTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer); 
		}
		
		JScrollPane uneScroll = new JScrollPane(uneTable); 
		uneScroll.setBounds(40, 0, 350, 150);
		this.unPanel.add(uneScroll);
		
		this.add(this.unPanel); 
		
		/*String entetes2 [] = {"email",
		 "nb_presta" }; 
		Object matrice2 [][]= this.getLesDonneesPresta();
		Tableau unTableau2 = new Tableau (entetes2, matrice2);
		JTable uneTable2 = new JTable(unTableau2);
		JScrollPane uneScroll2 = new JScrollPane(uneTable2);
		uneScroll2.setBounds(40, 500, 350, 100);
		 this.add(uneScroll2);
		 */
		
	}

/*	private Object[][] getLesDonneesPresta() {
		//ArrayList<UserPresta> lesUserPrestas = Modele.selectAllUserPresta();
		Object [][] matrice = new Object[lesUserPrestas.size()][2];
		int i =0; 
		for (UserPresta unUP : lesUserPrestas)
		{
			matrice[i][0] = unUP.getEmail();
			matrice[i][1] = unUP.getNb();
			i++;
		}
		return matrice ; 
	}*/
}
