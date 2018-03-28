package ecouteur;
import java.awt.event.*;
import java.awt.*;
import personne.*;
public class EcouteurZone implements ActionListener
{
	Cavalier personne;
	
	public void setPersonne(Cavalier z)
	{
		this.personne=z;
	}
	
	public Personnage getCavalier()
	{
		return personne;
	}
	
	public EcouteurZone(Cavalier z)
	{
		setPersonne(z);
	}
	
	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==this.getCavalier().getManageImage().getZone())
		{
			System.out.println("");
			//this.g.drawImage(Toolkit.getDefaultToolkit().getImage("image/cavalier.jpg"),30,30,10,10,this);
		}
    }
}