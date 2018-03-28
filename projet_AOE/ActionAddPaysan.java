package action;
import contenu.Panneau;

import personne.*;
public class ActionAddPaysan implements Runnable
{
	Panneau panneau;
	boolean running=true;
	
	public ActionAddPaysan(Panneau p)
	{
		this.panneau=p;
	}
	 
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	public void run()
	{
		
		while(getPanneau().getAdv().getPaysansVector().size()<=10)
		{
			getPanneau().getAdv().ajoutPaysan();
			try
			{
				Thread.sleep(5000);
				getPanneau().repaint();
			}
			catch(InterruptedException g)
			{
				System.out.println(g);
			}
		}
	}
}