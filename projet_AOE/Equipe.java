package listepers;
import jeu.Personnage;
import java.util.Vector;
import java.util.Random;
import construction.*;
import personne.*;
import ecouteur.*;
import java.awt.*;
import box.*;
public class Equipe
{
	private int score;
	private int arbre;
	private int nourriture;
	private int or;
	private int pierre;
	private Vector cavaliers;
	private Vector paysans;
	private Vector militaires;
	private Vector casernes;
	private Vector stockages;
	private boolean ajout;
	
	public void init()
	{
		score=0;
		arbre=0;
		nourriture=0;
		or=0;
		pierre=0;
		ajout=false;
		cavaliers=new Vector();
		paysans=new Vector();
		militaires=new Vector();
		casernes=new Vector();
		stockages=new Vector();
	}
	
	public Equipe()
	{
		int i=0;
		this.init();
		if(cavaliers.isEmpty()==true && paysans.isEmpty()==true && militaires.isEmpty()==true)
		{
			cavaliers.addElement(new Cavalier(50,0));
			cavaliers.addElement(new Cavalier(10,10));
			paysans.addElement(new Paysan(20,20));
			paysans.addElement(new Paysan(30,30));
			paysans.addElement(new Paysan(40,40));
			militaires.addElement(new Militaire(50,50));
			casernes.addElement(new Caserne(90,50));
			stockages.addElement(new Stockage(300,190));
		}
	}

	public int randomIntervalle(int ValeurMax,int ValeurMin)
	{
		int valeur=0;
		if(ValeurMax==ValeurMin)
		{
			ValeurMax=ValeurMax+30;
		}
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
	
	
	public void ajoutCavalier()
	{
		int x=randomIntervalle(700,400);
		int y=randomIntervalle(500,500);
		System.out.println(x +" "+ y);
		Cavalier c=new Cavalier(x,y);
		cavaliers.addElement(c);
	}
	
	public void ajoutPaysan()
	{
		int x=randomIntervalle(500,800);
		int y=randomIntervalle(600,600);
		Paysan p=new Paysan(x,y);
		paysans.addElement(p);
	}
	
	public void ajoutMilitaire()
	{
		int x=randomIntervalle(500,800);
		int y=randomIntervalle(600,600);
		Militaire m=new Militaire(x,y);
		militaires.addElement(m);
	}
	
	public void ajoutCaserne(int x,int y)
	{
		Caserne m=new Caserne(x,y);
		casernes.addElement(m);
	}
	
	
	
	public Equipe(Cavalier[] cav,Paysan[] pyn,Militaire[] mil)
	{
		int i=0;
		int nbrcav=cav.length;
		int nbrpaysan=pyn.length;
		int nbrmil=mil.length;
		for(i=0;i<nbrcav;i++)
		{
			cavaliers.addElement(cav[i]);
		}
		i=0;
		for(i=0;i<nbrpaysan;i++)
		{
			cavaliers.addElement(pyn[i]);
		}
		i=0;
		for(i=0;i<nbrmil;i++)
		{
			militaires.addElement(mil[i]);
		}
	}
	
	public void setMilitaire(Militaire[] m)
	{
		int nbrmil=m.length;
		for(int i=0;i<nbrmil;i++)
		{
			militaires.addElement(m[i]);
		}
	}
	
	public void setCavalier(Cavalier[] c)
	{
		int nbrcav=c.length;
		for(int i=0;i<nbrcav;i++)
		{
			cavaliers.addElement(c[i]);
		}
	}
	
	public void setPaysan(Paysan[] p)
	{
		int nbrpay=p.length;
		for(int i=0;i<nbrpay;i++)
		{
			paysans.addElement(p[i]);
		}
	}
	
	public Equipe(Vector c,Vector p,Vector m)
	{
		cavaliers=c;
		paysans=p;
		militaires=m;
	}
	
	public Vector getCavaliersVector()
	{
		return this.cavaliers;
	}
	
	public Cavalier[] getCavaliersArray()
	{
		int i=0;
		Cavalier[] c=new Cavalier[cavaliers.size()];
		for(i=0;i<cavaliers.size();i++)
		{
			c[i]=(Cavalier)cavaliers.get(i);
		}
		return c;
	}
	
	public Vector getMilitairesVector()
	{
		return this.militaires;
	}
	
	public Militaire[] getMilitairesArray()
	{
		int i=0;
		Militaire[] c=new Militaire[militaires.size()];
		for(i=0;i<militaires.size();i++)
		{
			c[i]=(Militaire)militaires.get(i);
		}
		return c;
	}
	
	public Vector getPaysansVector()
	{
		return this.paysans;
	}
	
	public Paysan[] getPaysansArray()
	{
		int i=0;
		Paysan[] c=new Paysan[paysans.size()];
		for(i=0;i<paysans.size();i++)
		{
			c[i]=(Paysan)paysans.get(i);
		}
		return c;
	}
	
	public Vector toVector(Object[] p)
	{
		int i=0;
		Vector v=new Vector();
		for(i=0;i<p.length;i++)
		{
			v.addElement(p[i]);
		}
		return v;
	}
	
	public void SupprimerCavalierEquipe(int indice)
	{
		cavaliers.remove(indice);
		
	}
	
	public void SupprimerPaysanEquipe(int indice)
	{
		paysans.remove(indice);
		System.out.println("maty");
	}
	
	public void SupprimerMilitaireEquipe(int indice)
	{
		militaires.remove(indice);
	}
	
	public void SupprimerStockageEquipe(int indice)
	{
		stockages.remove(indice);
	}
	
	public void SupprimerCaserneEquipe(int indice)
	{
		casernes.remove(indice);
	}
	
	public Caserne[] getCasernesArray()
	{
		int i=0;
		Caserne[] c=new Caserne[casernes.size()];
		for(i=0;i<casernes.size();i++)
		{
			c[i]=(Caserne)casernes.get(i);
		}
		return c;
	}
		
	public Stockage[] getStockagesArray()
	{
		int i=0;
		Stockage[] c=new Stockage[stockages.size()];
		for(i=0;i<stockages.size();i++)
		{
			c[i]=(Stockage)stockages.get(i);
		}
		return c;
	}
	
	public void ajoutStockage(int x,int y)
	{
		Stockage m=new Stockage(x,y);
		stockages.addElement(m);
	}
	
	public Vector getCasernesVector()
	{
		return this.militaires;
	}
	
	public void setScore(int s)
	{
		score=s;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public void setNbrArbre(int a)
	{
		arbre=a;
	}
	
	public int getNbrArbre()
	{
		return arbre;
	}
	
	public void setQteNourriture(int n)
	{
		nourriture=n;
		if(n<=0)
		{
			nourriture=0;
		}
	}
	
	public int getQteNourriture()
	{
		return nourriture;
	}
	
	public void setQteOr(int n)
	{
		or=n;
		if(n<=0)
		{
			or=0;
		}
	}
	
	public int getQteOr()
	{
		return or;
	}
	
	public void setQtePierre(int n)
	{
		pierre=n;
		if(n<=0)
		{
			pierre=0;
		}
	}
	
	public int getQtePierre()
	{
		return pierre;
	}
	
	public boolean getPossibleAjout()
	{
		return ajout;
	}
	
	public void ajoutPAYSAN()
	{
		if(getNbrArbre()>=5 && getQteOr()>=5 && getQtePierre()>=5 && getQteNourriture()>=10)
		{
			ajoutPaysan();
			setNbrArbre(getNbrArbre()-5);
			setQteOr(getQteOr()-5);
			setQtePierre(getQtePierre()-5);
			setQteNourriture(getQteNourriture()-10);
		}
		else
		{
			new BoxDialog("ok","Vous devrez avoir arbre=5","nourriture=10, or=5, pierre=5");
		}
	}
	
	public void ajoutMILITAIRE()
	{
		if(getNbrArbre()>=5 && getQteOr()>=20 && getQtePierre()>=10 && getQteNourriture()>=15)
		{
			ajoutMilitaire();
			setNbrArbre(getNbrArbre()-5);
			setQteOr(getQteOr()-20);
			setQtePierre(getQtePierre()-10);
			setQteNourriture(getQteNourriture()-15);
		}
		else
		{
			new BoxDialog("ok","Vous devrez avoir arbre=5","nourriture=15, or=20, pierre=10");
		}
	}
	
	public void ajoutCAVALIER()
	{
		if(getNbrArbre()>=5 && getQteOr()>=15 && getQtePierre()>=10 && getQteNourriture()>=10)
		{
			ajoutCavalier();
			setNbrArbre(getNbrArbre()-5);
			setQteOr(getQteOr()-15);
			setQtePierre(getQtePierre()-10);
			setQteNourriture(getQteNourriture()-10);
		}
		else
		{
			new BoxDialog("ok","Vous devrez avoir arbre=5","nourriture=15, or=20, pierre=10");
		}
	}
	
	public boolean ajoutCASERNE()
	{
		if(getNbrArbre()>=30 && getQteOr()>=25 && getQtePierre()>=10 && getQteNourriture()>=30)
		{
			setNbrArbre(getNbrArbre()-30);
			setQteOr(getQteOr()-25);
			setQtePierre(getQtePierre()-10);
			setQteNourriture(getQteNourriture()-30);
			return true;
		}
		else
		{
			new BoxDialog("ok","Vous devrez avoir arbre=30","nourriture=30, or=25, pierre=10");
			return false;
		}
	}
	
	public boolean ajoutSTOCKAGE()
	{
		if(getNbrArbre()>=30 && getQteOr()>=25 && getQtePierre()>=20 && getQteNourriture()>=35)
		{
			setNbrArbre(getNbrArbre()-30);
			setQteOr(getQteOr()-25);
			setQtePierre(getQtePierre()-20);
			setQteNourriture(getQteNourriture()-35);
			return true;
		}
		else
		{
			new BoxDialog("ok","Vous devrez avoir arbre=30","nourriture=35, or=25, pierre=20");
			return false;
		}
	}
}