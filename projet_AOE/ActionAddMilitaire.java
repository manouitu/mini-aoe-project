package action;
import contenu.Panneau;

import personne.*;
public class ActionAddMilitaire implements Runnable
{
	Panneau panneau;
	boolean running=true;
	
	public ActionAddMilitaire(Panneau p)
	{
		this.panneau=p;
	}
	 
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	public void run()
	{
		
		while(getPanneau().getAdv().getMilitairesVector().size()<=15)
		{
			getPanneau().getAdv().ajoutMilitaire();
			try
			{
				Thread.sleep(8000);
				getPanneau().repaint();
			}
			catch(InterruptedException g)
			{
				System.out.println(g);
			}
		}
	}
}