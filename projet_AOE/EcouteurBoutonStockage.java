package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;
import construction.*;


public class EcouteurBoutonStockage implements ActionListener
{
	Panneau panneau;
	
	
	
	public EcouteurBoutonStockage(Panneau p)
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
		
	/*public void setIndice(int i)
	{
		indice=i;
	}
	
	public int getIndice()
	{
		return indice;
	}*/
	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==getPanneau().getDisplay().getButtonStockage())
		{
			System.out.println("ajout Stockage");
			getPanneau().getPseudostockage().setVisibilite(getPanneau().getEquipe().ajoutSTOCKAGE());
			getPanneau().repaint();
			getPanneau().getDisplay().getRepArbre().setText(Integer.toString(getPanneau().getEquipe().getNbrArbre()));
			getPanneau().getDisplay().getRepOr().setText(Integer.toString(getPanneau().getEquipe().getQteOr()));
			getPanneau().getDisplay().getRepPierre().setText(Integer.toString(getPanneau().getEquipe().getQtePierre()));
			getPanneau().getDisplay().getRepNourriture().setText(Integer.toString(getPanneau().getEquipe().getQteNourriture()));
			getPanneau().addMouseListener(new EcouteurAjoutStockage(this));
			getPanneau().addMouseMotionListener(new EcouteurAjoutStockage(this));
			getPanneau().repaint();
		}
    }
}