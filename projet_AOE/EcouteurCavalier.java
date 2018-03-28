package ecouteur;
import personne.*;
import java.awt.event.*;
import java.awt.*;
import contenu.Panneau;
public class EcouteurCavalier implements MouseListener
{
	Panneau panneau;
	String selectionned;
	int indice;
	
	public EcouteurCavalier(Panneau p)
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
	
	public int zoneCavalier(MouseEvent e)
	{
		for(int i=0;i<getPanneau().getEquipe().getCavaliersArray().length;i++)
		{
			if(getPanneau().getEquipe().getCavaliersArray()[i].getZone().getBounds().contains(e.getX(),e.getY())==true)
			{
				return i;
			}
		}
		return -1;
	}
	
	public void deplacement(int indice,String select,MouseEvent e)
	{
		if(select=="cavalier" && getPanneau().getEquipe().getPaysansVector().size()!=0)
		{
			getPanneau().getEquipe().getCavaliersArray()[indice].updatePosition(e.getX(),e.getY());
		}
	}
	
	public boolean cliqueGauche(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			return true;
		}
		return false;
	}
	
	public boolean cliqueDroite(MouseEvent e)
	{
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			return true;
		}
		return false;
	}
	
	public void CavalierSelectionned(MouseEvent e)
	{
		if(zoneCavalier(e)>=0)
		{
			indice=zoneCavalier(e);
			selectionned="cavalier";				
			getPanneau().setIndiceSelectionned(indice);
			System.out.println(selectionned);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(cliqueGauche(e)==true)
		{
			CavalierSelectionned(e);
		}
		
		if((cliqueDroite(e)==true) && (this.selectionned!=null))
		{
			deplacement(indice,selectionned,e);
			getPanneau().repaint();
			getPanneau().VerificationZoneCavalier(getPanneau().getEquipe().getCavaliersArray()[indice]);
			
			selectionned=null;
		}
	}
	
	public void mouseEntered(MouseEvent e){
		
	}
	public void	mouseExited(MouseEvent e){
	}
	public void	mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}