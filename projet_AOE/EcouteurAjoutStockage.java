package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;
import pseudo.*;

public class EcouteurAjoutStockage implements MouseListener,MouseMotionListener
{
	EcouteurBoutonStockage ajout;
	
	public EcouteurAjoutStockage(EcouteurBoutonStockage p)
	{
		setEcouteurBoutonStockage(p);
		getEcouteur().getPanneau().getPseudocaserne().setVisibilite(false);
	}
	
	public void setEcouteurBoutonStockage(EcouteurBoutonStockage p)
	{
		this.ajout=p;
	}
	
	
	public EcouteurBoutonStockage getEcouteur()
	{
		return this.ajout;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
		if(getEcouteur().getPanneau().getPseudostockage().getVisibilite()==true)
		{
			getEcouteur().getPanneau().getEquipe().ajoutStockage(e.getX()-100,e.getY()-100);
			getEcouteur().getPanneau().getPseudostockage().setVisibilite(false);
			getEcouteur().getPanneau().repaint();
		}
	}
	public void	mouseDragged(MouseEvent e)
	{}
	public void mouseEntered(MouseEvent e)
	{
	}
	public void mouseExited(MouseEvent e)
	{
	}
	public void	mouseMoved(MouseEvent e)
	{
		if(getEcouteur().getPanneau().getPseudostockage().getVisibilite()==true)
		{
			getEcouteur().getPanneau().getPseudostockage().updatePosition(e.getX()-100,e.getY()-100);
			getEcouteur().getPanneau().repaint();
		}
	}
	public void mousePressed(MouseEvent e)
	{}
	public void mouseReleased(MouseEvent e)
	{}
	
}