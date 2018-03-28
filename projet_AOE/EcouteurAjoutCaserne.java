package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;
import pseudo.*;

public class EcouteurAjoutCaserne implements MouseListener,MouseMotionListener
{
	EcouteurBoutonCaserne ajout;
	
	public EcouteurAjoutCaserne(EcouteurBoutonCaserne p)
	{
		setEcouteurBoutonCaserne(p);
		getEcouteur().getPanneau().getPseudostockage().setVisibilite(false);
	}
	
	public void setEcouteurBoutonCaserne(EcouteurBoutonCaserne p)
	{
		this.ajout=p;
	}
	
	
	public EcouteurBoutonCaserne getEcouteur()
	{
		return this.ajout;
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
		if(getEcouteur().getPanneau().getPseudocaserne().getVisibilite()==true)
		{
			getEcouteur().getPanneau().getEquipe().ajoutCaserne(e.getX()-100,e.getY()-100);
			getEcouteur().getPanneau().getPseudocaserne().setVisibilite(false);
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
		if(getEcouteur().getPanneau().getPseudocaserne().getVisibilite()==true)
		{
			getEcouteur().getPanneau().getPseudocaserne().updatePosition(e.getX()-100,e.getY()-100);
			getEcouteur().getPanneau().repaint();
		}
	}
	public void mousePressed(MouseEvent e)
	{}
	public void mouseReleased(MouseEvent e)
	{}
	
}