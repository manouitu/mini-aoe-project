package ecouteur;
import personne.*;
import java.awt.event.*;
import java.awt.*;
import contenu.Panneau;
public class EcouteurPaysan implements MouseListener
{
	Panneau panneau;
	String selectionned;
	int indice;
	
	public EcouteurPaysan(Panneau p)
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

	public int zonePaysan(MouseEvent e)
	{
		for(int i=0;i<getPanneau().getEquipe().getPaysansArray().length;i++)
		{
			if(getPanneau().getEquipe().getPaysansArray()[i].getZone().getBounds().contains(e.getX(),e.getY())==true)
			{
				return i;
			}
		}
		return -1;
	}
	
	
	
	public void deplacement(int indice,String select,MouseEvent e)
	{
		if(select=="paysan" && getPanneau().getEquipe().getPaysansVector().size()!=0)
		{
			getPanneau().getEquipe().getPaysansArray()[indice].updatePosition(e.getX(),e.getY());
		}
		getPanneau().repaint();
	}
	
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
	
	
	
	
	public void PaysanSelectionned(MouseEvent e)
	{
		if(zonePaysan(e)>=0)
		{
			indice=zonePaysan(e);
			getPanneau().setIndiceSelectionned(indice);
			selectionned="paysan";				
			System.out.println(selectionned);
		}
	}
	
	public void mousePressed(MouseEvent e)
	{
	
		if(cliqueGauche(e)==true)
		{
			PaysanSelectionned(e);
		}
		
		if((cliqueDroite(e)==true) && (this.selectionned!=null))
		{
			
			deplacement(indice,selectionned,e);
			getPanneau().VerificationZonePaysan(getPanneau().getEquipe().getPaysansArray()[indice]);
			selectionned=null;
		}
	}
	
	public void mouseEntered(MouseEvent e){}
	public void	mouseExited(MouseEvent e){}
	public void	mouseReleased(MouseEvent e){}
	public void mouseClicked(MouseEvent e){}
}
