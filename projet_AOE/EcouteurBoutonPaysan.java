package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;

public class EcouteurBoutonPaysan implements ActionListener
{
	Panneau panneau;
	
	public EcouteurBoutonPaysan(Panneau p)
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
	
	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==getPanneau().getDisplay().getButtonPaysan())
		{
			System.out.println("ajout paysan");
			getPanneau().getEquipe().ajoutPAYSAN();
			getPanneau().getDisplay().getRepArbre().setText(Integer.toString(getPanneau().getEquipe().getNbrArbre()));
			getPanneau().getDisplay().getRepOr().setText(Integer.toString(getPanneau().getEquipe().getQteOr()));
			getPanneau().getDisplay().getRepPierre().setText(Integer.toString(getPanneau().getEquipe().getQtePierre()));
			getPanneau().getDisplay().getRepNourriture().setText(Integer.toString(getPanneau().getEquipe().getQteNourriture()));
			
			getPanneau().repaint();
			//this.g.drawImage(Toolkit.getDefaultToolkit().getImage("image/cavalier.jpg"),30,30,10,10,this);
		}
    }
}