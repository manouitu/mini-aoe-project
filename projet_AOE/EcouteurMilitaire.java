package ecouteur;
import personne.*;
import java.awt.event.*;
import java.awt.*;
import contenu.Panneau;
public class EcouteurMilitaire implements MouseListener
{
	Panneau panneau;
	String selectionned;
	int indice;
	int indiceadv;
	
	public EcouteurMilitaire(Panneau p)
	{
		this.panneau=p;
	}
	
	public void setPanneau(Panneau p)
	{
		this.panneau=p;
	}
	
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	
	public int getIndice()
	{
		return this.indice;
	}
	
	public int zoneMilitaire(MouseEvent e)
	{
		for(int i=0;i<getPanneau().getEquipe().getMilitairesArray().length;i++)
		{
			if(getPanneau().getEquipe().getMilitairesArray()[i].getZone().getBounds().contains(e.getX(),e.getY())==true)
			{
				return i;
			}
		}
		return -1;
	}
	
	public void deplacement(int indice,String select,MouseEvent e)
	{
		if(select=="militaire" && getPanneau().getEquipe().getMilitairesVector().size()!=0)
		{
			
			getPanneau().getEquipe().getMilitairesArray()[indice].updatePosition(e.getX(),e.getY());
		
		
		}
	}
		
	//action combattre
	
	
	boolean cliqueGauche(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			return true;
		}
		return false;
	}
	
	boolean cliqueDroite(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			return true;
		}
		return false;
	}
	
	public void MilitaireSelectionned(MouseEvent e)
	{
		if(zoneMilitaire(e)>=0)
		{
			indice=zoneMilitaire(e);
			getPanneau().setIndiceSelectionned(indice);
			selectionned="militaire";				
			System.out.println(selectionned);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(cliqueGauche(e)==true)
		{
			MilitaireSelectionned(e);
		}
		if((cliqueDroite(e)==true) && (this.selectionned!=null))
		{
			deplacement(indice,selectionned,e);
			getPanneau().repaint();
			getPanneau().VerificationZoneMilitaire(getPanneau().getEquipe().getMilitairesArray()[indice]);
			selectionned=null;
			//indiceadv=-5;
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	public void	mouseExited(MouseEvent e){}
	public void	mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}