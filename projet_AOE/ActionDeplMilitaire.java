package action;
import contenu.Panneau;
import java.util.*;

import personne.*;
public class ActionDeplMilitaire implements Runnable
{
	Panneau panneau;
	boolean running=true;
	
	int x0,x1;
	int y0,y1;
	
	public void setX0(int x)
	{
		x0=x;
	}
	
	public int getX0()
	{
		return x0;
	}
	
	public void setX1(int x)
	{
		x1=x;
	}
	
	public int getX1()
	{
		return x1;
	}
	
	public void setY0(int y)
	{
		y0=y;
	}
	
	public int getY0()
	{
		return y0;
	}
	
	public void setY1(int y)
	{
		y1=y;
	}
	
	public int getY1()
	{
		return y1;
	}
	
	public ActionDeplMilitaire(Panneau p)
	{
		this.panneau=p;
		setX0(1400);
		setX1(1500);
		setY0(1400);
		setY1(1500);
	}
	
	 
	public Panneau getPanneau()
	{
		return this.panneau;
	}
	
	public int randomIntervalle(int ValeurMax,int ValeurMin)
	{
		int valeur=0;
		if(ValeurMax<ValeurMin)
		{
			valeur=ValeurMax;
			ValeurMax=ValeurMin;
			ValeurMin=valeur;
		}
		Random r = new Random();
		valeur = ValeurMin + r.nextInt(ValeurMax - ValeurMin);
		return valeur;
	}
	
	
	public void run()
	{
		
		while(1<2)
		{
			
			for(int i=0;i<getPanneau().getAdv().getMilitairesArray().length;i++)
			{
				getPanneau().getAdv().getMilitairesArray()[i].updatePosition(randomIntervalle(getX0(),getX1()),randomIntervalle(getY0(),getY1()));
				
			}
			try
			{
				
				Thread.sleep(1000);
				panneau.getAdv().VerificationZoneMilitaireAdv(panneau);
				getPanneau().repaint();
			}
			catch(InterruptedException g)
			{
				System.out.println(g);
			}
			catch(ArrayIndexOutOfBoundsException a)
			{
				System.out.println(a);
			}
		}
	}
}