package action;
import contenu.Panneau;
import java.util.*;

import personne.*;
public class ActionAvancePaysan implements Runnable
{
	ActionDeplPaysan actiondeplpaysan;
	
	public ActionAvancePaysan(ActionDeplPaysan adp)
	{
		actiondeplpaysan=adp;
	}
	
	public void run()
	{
		while(1<2){
			while(actiondeplpaysan.getX0()>0 && actiondeplpaysan.getX1()>500 && actiondeplpaysan.getY0()>0 && actiondeplpaysan.getY1()>500)
			{
				try
				{
					Thread.sleep(1000);
					
				}
				catch(InterruptedException g)
				{
					System.out.println(g);
				}
				actiondeplpaysan.setX0(actiondeplpaysan.getX0()-10);
				actiondeplpaysan.setX1(actiondeplpaysan.getX1()-10);
				actiondeplpaysan.setY0(actiondeplpaysan.getY0()-10);
				actiondeplpaysan.setY1(actiondeplpaysan.getY1()-10);
				actiondeplpaysan.getPanneau().repaint();
				System.out.println("wawa");
			}
			while(actiondeplpaysan.getX0()<=1000 || actiondeplpaysan.getX1()<=1100 || actiondeplpaysan.getY0()<=1000 || actiondeplpaysan.getY1()<=1100)
			{
				try
				{
					Thread.sleep(1000);
					
				}
				catch(InterruptedException g)
				{
					System.out.println(g);
				}
				actiondeplpaysan.setX0(actiondeplpaysan.getX0()+10);
				actiondeplpaysan.setX1(actiondeplpaysan.getX1()+10);
				actiondeplpaysan.setY0(actiondeplpaysan.getY0()+10);
				actiondeplpaysan.setY1(actiondeplpaysan.getY1()+10);
				actiondeplpaysan.getPanneau().repaint();
				System.out.println("wawa");
			}
		}
	}
}