package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;
import construction.*;


public class EcouteurBoutonCaserne implements ActionListener
{
	Panneau panneau;
	
	
	
	public EcouteurBoutonCaserne(Panneau p)
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
        if(e.getSource()==getPanneau().getDisplay().getButtonCaserne())
		{
			System.out.println("ajout Caserne");
			getPanneau().getPseudocaserne().setVisibilite(getPanneau().getEquipe().ajoutCASERNE());
			getPanneau().repaint();
			getPanneau().getDisplay().getRepArbre().setText(Integer.toString(getPanneau().getEquipe().getNbrArbre()));
			getPanneau().getDisplay().getRepOr().setText(Integer.toString(getPanneau().getEquipe().getQteOr()));
			getPanneau().getDisplay().getRepPierre().setText(Integer.toString(getPanneau().getEquipe().getQtePierre()));
			getPanneau().getDisplay().getRepNourriture().setText(Integer.toString(getPanneau().getEquipe().getQteNourriture()));
			getPanneau().addMouseListener(new EcouteurAjoutCaserne(this));
			getPanneau().addMouseMotionListener(new EcouteurAjoutCaserne(this));
			getPanneau().repaint();
		}
    }
}