package action;
import contenu.Panneau;
import java.util.*;

import personne.*;
public class ActionAvanceMilitaire implements Runnable
{
	ActionDeplMilitaire actiondeplmilitaire;
	
	public ActionAvanceMilitaire(ActionDeplMilitaire adp)
	{
		actiondeplmilitaire=adp;
	}
	
	public void run()
	{
		while(1<2)
		{
				while(actiondeplmilitaire.getX0()>0 && actiondeplmilitaire.getX1()>100 && actiondeplmilitaire.getY0()>0 && actiondeplmilitaire.getY1()>100)
				{
					try
					{
						Thread.sleep(1000);
						
					}
					catch(InterruptedException g)
					{
						System.out.println(g);
					}
					actiondeplmilitaire.setX0(actiondeplmilitaire.getX0()-10);
					actiondeplmilitaire.setX1(actiondeplmilitaire.getX1()-10);
					actiondeplmilitaire.setY0(actiondeplmilitaire.getY0()-10);
					actiondeplmilitaire.setY1(actiondeplmilitaire.getY1()-10);
					actiondeplmilitaire.getPanneau().repaint();
					System.out.println("wewe");
				}
				while(actiondeplmilitaire.getX0()<=1400 || actiondeplmilitaire.getX1()<=1500 || actiondeplmilitaire.getY0()<=1400 || actiondeplmilitaire.getY1()<=1500)
				{
						try
						{
							Thread.sleep(1000);
							
						}
						catch(InterruptedException g)
						{
							System.out.println(g);
						}
						actiondeplmilitaire.setX0(actiondeplmilitaire.getX0()+10);
						actiondeplmilitaire.setX1(actiondeplmilitaire.getX1()+10);
						actiondeplmilitaire.setY0(actiondeplmilitaire.getY0()+10);
						actiondeplmilitaire.setY1(actiondeplmilitaire.getY1()+10);
						actiondeplmilitaire.getPanneau().repaint();
						System.out.println("wewe");
				}
		}
	}
		
}