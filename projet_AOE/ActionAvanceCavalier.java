package action;
import contenu.Panneau;
import java.util.*;

import personne.*;
public class ActionAvanceCavalier implements Runnable
{
	ActionDeplCavalier actiondeplcavalier;
	
	public ActionAvanceCavalier(ActionDeplCavalier adc)
	{
		actiondeplcavalier=adc;
	}
	
	public void run()
	{
		while(1<2)
		{
			while(actiondeplcavalier.getX0()>0 && actiondeplcavalier.getX1()>100 && actiondeplcavalier.getY0()>0 && actiondeplcavalier.getY1()>100)
			{
				try
				{
					Thread.sleep(1000);
					
				}
				catch(InterruptedException g)
				{
					System.out.println(g);
				}
				actiondeplcavalier.setX0(actiondeplcavalier.getX0()-10);
				actiondeplcavalier.setX1(actiondeplcavalier.getX1()-10);
				actiondeplcavalier.setY0(actiondeplcavalier.getY0()-10);
				actiondeplcavalier.setY1(actiondeplcavalier.getY1()-10);
				//actiondeplcavalier.getPanneau().repaint();
				System.out.println("cavalier x="+actiondeplcavalier.getX0()+"et"+actiondeplcavalier.getX1()+"    "+"cavalier y="+actiondeplcavalier.getY0()+"et"+"et"+actiondeplcavalier.getY1());
			}
			while(actiondeplcavalier.getX0()<=1400 || actiondeplcavalier.getX1()<=1500 || actiondeplcavalier.getY0()<=1400 || actiondeplcavalier.getY1()<=1500)
			{
					try
					{
						Thread.sleep(1000);
							
					}
					catch(InterruptedException g)
					{
						System.out.println(g);
					}
					actiondeplcavalier.setX0(actiondeplcavalier.getX0()+10);
					actiondeplcavalier.setX1(actiondeplcavalier.getX1()+10);
					actiondeplcavalier.setY0(actiondeplcavalier.getY0()+10);
					actiondeplcavalier.setY1(actiondeplcavalier.getY1()+10);
					//actiondeplcavalier.getPanneau().repaint();
					System.out.println("wewe");
			}
		}
	}
}