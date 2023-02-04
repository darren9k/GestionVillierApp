package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel //24/01
{
	private String entetes[];
	private Object [][] donnees;
	
	

	public Tableau(String[] entetes, Object[][] donnees) {
		super();
		this.entetes = entetes;
		this.donnees = donnees;
	}
	

	@Override
	public int getRowCount() 
	{
		return this.donnees.length;
	}

	@Override
	public int getColumnCount() 
	{
		
		return this.entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		return this.donnees[rowIndex][columnIndex];
	}


	@Override
	public String getColumnName(int column) //intitul�s des colonnes
	{
		return this.entetes[column];
	}
	
	public void ajouterLigne(Object ligne[]) //se�ance 24/01
	{
		Object matrice[][] = new Object [this.getRowCount()+1][this.getColumnCount()];
		for (int i=0; i < this.getRowCount(); i++)
		{
			matrice[i] = this.donnees[i];
		}
		//ajout de la donn�e
		matrice[this.getRowCount()] = ligne;
		//ecrasement de la donn�e
		this.donnees = matrice;
		//actualisation de la page
		this.fireTableDataChanged();
	}



	public void supprimerLigne(int numLigne) 
	{
		Object matrice[][] = new Object[this.getRowCount()-1][this.getColumnCount()];
		int j = 0;
		for (int i=0; i < this.getRowCount(); i++)
		{
			//v�rifier que ce n'est pas la ligne qu'on vient de supprimer
			if(numLigne!=i)
			{
			matrice[j] = this.donnees[i];
			j++;
			}
		}
			
		//ecrasement de la donn�e
				this.donnees = matrice;
				//actualisation de la page
				this.fireTableDataChanged();
	}

	public void modifierLigne(int numLigne, Object[] ligne)  //28/01
	{
		Object matrice[][] = new Object[this.getRowCount()][this.getColumnCount()];
		
		for (int i=0; i < this.getRowCount(); i++)
		{
			if(numLigne==i)
			{
				matrice[i] = ligne;
				
			}else
			{
				matrice [i] = this.donnees[i];
			}
			
		}
		this.donnees = matrice;
		//actualisation de la page
		this.fireTableDataChanged();
	}
	


	public void setDonnees(Object[][] matrice) 
	{
		this.donnees = matrice;
		
		this.fireTableDataChanged();
	}

	
	
}
