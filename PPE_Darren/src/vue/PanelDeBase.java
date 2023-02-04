package vue;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelDeBase extends JPanel
{
	public PanelDeBase(Color uneCouleur)
	{
		this.setBounds(50,70,1150,600);  //100,70,750,360  100,50,1000,900
		this.setLayout(null); 
		this.setBackground(uneCouleur);
		this.setVisible(false);
	}
}