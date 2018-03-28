package action;
import contenu.Panneau;

import personne.*;
public class ActionAddCavalier implements Runnable
{
	Panneau panneau;
	boolean running=true;
	
	public ActionAddCavalier(Panneau p)
	{
		this.panneau=p;
	}
	 
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	public void run()
	{
		
		while(getPanneau().getAdv().getCavaliersVector().size()<=15)
		{
			getPanneau().getAdv().ajoutCavalier();
			try
			{
				Thread.sleep(10000);
				getPanneau().repaint();
			}
			catch(InterruptedException g)
			{
				System.out.println(g);
			}
		}
	}
}