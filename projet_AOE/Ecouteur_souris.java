package ecouteur;
import screen.Display;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;

public class Ecouteur_souris extends MouseAdapter
{
	Personnage[] p;
	
	Personnage selection(MouseEvent e,Personnage[] p)
	{
		for(int i=0;i<p.length;i++)
		{
			if((e.getX()>=p[i].getPosX) && (e.getX()<=p[i].posX+p.getSizeX) && (e.getY()>=p[i].posY) && (e.getY()<=p[i].getPosY()+p[i].getSizeY())
			{
				p[i].selectionned=true;
				//v.addElement(p[i]);
				return p[i];
			}
		}
	}
	
	public Ecouteur_souris(Panneau pan)
	{
		p=pan;
	}
	
	public void panel_mousePressed(MouseEvent e)
	{
		int buttonDown = e.getButton();
		if (buttonDown == MouseEvent.BUTTON1)
		{
           // Bouton GAUCHE enfoncé
		   System.out.println("clique gauche"+ e.getX() + "et" + e.getY);
		}
		else if(buttonDown == MouseEvent.BUTTON2)
		{
			System.out.println("clique molette");
           // Bouton du MILIEU enfoncé
		} 
		else if(buttonDown == MouseEvent.BUTTON3) 
		{
			System.out.println("clique droite");
           // Bouton DROIT enfoncé
		}
	}

	public void mousePressed(MouseEvent e){
        panel_mousePressed(e);
      }
	  
	public void mouseDragged(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void	mouseExited(MouseEvent e){}
	public void	mouseMoved(MouseEvent e){}
	public void	mouseReleased(MouseEvent e){}
	public void	mouseWheelMoved(MouseWheelEvent e){}
}