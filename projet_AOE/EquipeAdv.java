package listepers;
import jeu.Personnage;
import java.util.Vector;
import personne.*;
import construction.*;
import java.util.Random;
import contenu.*;
import java.awt.*;
public class EquipeAdv
{
	private Vector cavaliers;
	private Vector paysans;
	private Vector militaires;
	private Vector casernes;
	private Vector stockages;
	
	
	public void init()
	{
		
		cavaliers=new Vector();
		paysans=new Vector();
		militaires=new Vector();
		casernes=new Vector();
		stockages=new Vector();
	}
	
	public EquipeAdv()
	{
		int i=0;
		this.init();
		if(cavaliers.isEmpty()==true && paysans.isEmpty()==true && militaires.isEmpty()==true)
		{
			cavaliers.addElement(new Cavalier(900,800).ToCavalierAdverse());
			cavaliers.addElement(new Cavalier(970,955).ToCavalierAdverse());
			paysans.addElement(new Paysan(970,863).ToPaysanAdverse());
			paysans.addElement(new Paysan(958,780).ToPaysanAdverse());
			paysans.addElement(new Paysan(940,940).ToPaysanAdverse());
			militaires.addElement(new Militaire(1000,800).ToMilitaireAdverse());
			// casernes.addElement(new Caserne(90,50));
			stockages.addElement(new Stockage(1000,1200).ToStockageAdverse());
			casernes.addElement(new Caserne(1000,900).ToCaserneAdverse());
			
		}
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
	
	public void ajoutCavalier()
	{
		int x,y;
		Cavalier c=new Cavalier(0,0);
		c.ToCavalierAdverse();
		x=randomIntervalle(1000,900);
		y=randomIntervalle(900,1000);
		System.out.println(x);
		System.out.println(y);
		c.updatePosition(x,y);
		cavaliers.addElement(c);
	}
	
	public void ajoutPaysan()
	{
		Paysan p=new Paysan(0,0);
		p.ToPaysanAdverse();
		paysans.addElement(p);
		int x=randomIntervalle(1000,1500);
		int y=randomIntervalle(900,1500);
		System.out.println(x);
		System.out.println(y);
		p.updatePosition(x,y);
		paysans.addElement(p);
	}
	
	public void ajoutMilitaire()
	{
		Militaire m=new Militaire(0,0);
		m.ToMilitaireAdverse();
		int x=randomIntervalle(1200,900);
		int y=randomIntervalle(800,1300);
		System.out.println(x);
		System.out.println(y);
		m.updatePosition(x,y);
		militaires.addElement(m);
	}

	
	public void setMilitaire(Militaire[] m)
	{
		int nbrmil=m.length;
		for(int i=0;i<nbrmil;i++)
		{
			//m[i].ToMilitaireAdverse();
			militaires.addElement(m[i]);
		}
	}
	
	public void setCavalier(Cavalier[] c)
	{
		int nbrcav=c.length;
		for(int i=0;i<nbrcav;i++)
		{
			//c[i].ToCavalierAdverse();
			cavaliers.addElement(c[i]);
		}
	}
	
	public void setPaysan(Paysan[] p)
	{
		int nbrpay=p.length;
		for(int i=0;i<nbrpay;i++)
		{
			//p[i].ToPaysanAdverse();
			paysans.addElement(p[i]);
		}
	}
	
	public EquipeAdv(Cavalier[] cav,Paysan[] pyn,Militaire[] mil)
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
	
	public EquipeAdv(Vector c,Vector p,Vector m)
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
		Cavalier[] c=new Cavalier[cavaliers.size()];
		for(int i=0;i<cavaliers.size();i++)
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
	
	public Vector getStockagesVector()
	{
		return this.stockages;
	}
	
	public Vector getCasernesVector()
	{
		return this.casernes;
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
	
	public void SupprimerMilitaireAdv(int indice)
	{
		militaires.remove(indice);
		/*Militaire[] recup=new Militaire[getAdv().getMilitairesArray().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getAdv().getMilitairesArray()[i];
		}
		
		for(int i=indice;i<getAdv().getMilitairesArray().length-1;i++)
		{
			recup[i]=getAdv().getMilitairesArray()[i+1];
		}
		getAdv().setMilitaire(recup);
		repaint();
	*/	
		
	}
	
	
	
	public void SupprimerCavalierAdv(int indice)
	{
		cavaliers.remove(indice);
		/*Cavalier[] recup=new Cavalier[getAdv().getCavaliersArray().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getAdv().getCavaliersArray()[i];
		}
		
		for(int i=indice;i<getEquipe().getCavaliersArray().length-1;i++)
		{
			recup[i]=getAdv().getCavaliersArray()[i+1];
		}
		getAdv().setCavalier(recup);
	*/
	
	}
	
	
	
	public void SupprimerPaysanAdv(int indice)
	{
	
		paysans.remove(indice);
		System.out.println("====>"+indice);
		/*Paysan[] recup=new Paysan[getAdv().getPaysansArray().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getAdv().getPaysansArray()[i];
		}
		
		for(int i=indice;i<getAdv().getPaysansArray().length-1;i++)
		{
			recup[i]=getAdv().getPaysansArray()[i+1];
		}
		getAdv().setPaysan(recup);
		repaint();*/
		
	}
	public void SupprimerStockageAdv(int indice)
	{
		stockages.remove(indice);
	}
	
	public void SupprimerCaserneAdv(int indice)
	{
		casernes.remove(indice);
	}
	
	public void VerificationZoneMilitaireAdv(Panneau p)
	{
		for(int j=0;j<getMilitairesArray().length;j++)
		{
			for(int i=0;i<p.getEquipe().getCavaliersArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getCavaliersArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getCavaliersArray()[i].setVie(p.getEquipe().getCavaliersArray()[i].getVie()-getMilitairesArray()[j].getXp());
					getMilitairesArray()[j].setVie(getMilitairesArray()[j].getVie()-p.getEquipe().getCavaliersArray()[i].getXp());
					System.out.println("militaireADV: "+getMilitairesArray()[j].getVie());
					System.out.println("CavalierPlayer: "+p.getEquipe().getCavaliersArray()[i].getVie());
					if(getMilitairesArray()[j].estMort()==true && getMilitairesVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerMilitaireAdv(j);
						
						p.repaint();
						
					}
					if(p.getEquipe().getCavaliersArray()[i].estMort()==true && p.getEquipe().getCavaliersVector().size()!=0)
					{
						p.getEquipe().SupprimerMilitaireEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getMilitairesVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getPaysansArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getPaysansArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getPaysansArray()[i].setVie(p.getEquipe().getPaysansArray()[i].getVie()-getMilitairesArray()[j].getXp());
					getMilitairesArray()[j].setVie(getMilitairesArray()[j].getVie()-p.getEquipe().getPaysansArray()[i].getXp());
					System.out.println("militaireADV: "+getMilitairesArray()[j].getVie());
					System.out.println("PaysanPlayer: "+p.getEquipe().getPaysansArray()[i].getVie());
					if(getMilitairesArray()[j].estMort()==true && getMilitairesVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerMilitaireAdv(j);
						p.repaint();
					}
					if(p.getEquipe().getPaysansArray()[i].estMort()==true && p.getEquipe().getPaysansVector().size()!=0)
					{
						p.getEquipe().SupprimerPaysanEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getMilitairesVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getMilitairesArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getMilitairesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getMilitairesArray()[i].setVie(p.getEquipe().getMilitairesArray()[i].getVie()-getMilitairesArray()[j].getXp());
					getMilitairesArray()[j].setVie(getMilitairesArray()[j].getVie()-p.getEquipe().getMilitairesArray()[i].getXp());
					System.out.println("militaireADV: "+getMilitairesArray()[j].getVie());
					System.out.println("MilitairePlayer: "+p.getEquipe().getMilitairesArray()[i].getVie());
					if(getMilitairesArray()[j].estMort()==true && getMilitairesVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerPaysanAdv(j);
						p.repaint();
						break;
					}
					if(p.getEquipe().getMilitairesArray()[i].estMort()==true && getMilitairesVector().size()!=0)
					{
						p.getEquipe().SupprimerMilitaireEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			if(getMilitairesVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getStockagesArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getStockagesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getStockagesArray()[i].setEtat(p.getEquipe().getStockagesArray()[i].getEtat()-getMilitairesArray()[j].getXp());
					System.out.println("militaireADV: "+getMilitairesArray()[j].getVie());
					System.out.println("StockagePlayer: "+p.getEquipe().getStockagesArray()[i].getEtat());
					if(p.getEquipe().getStockagesArray()[i].estDetruit()==true && getStockagesVector().size()!=0)
					{
						p.getEquipe().SupprimerStockageEquipe(i);
						p.repaint();
						break;
					}
					System.out.println("");
				}	
			}
			if(getMilitairesVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getCasernesArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getCasernesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getCasernesArray()[i].setEtat(p.getEquipe().getCasernesArray()[i].getEtat()-getMilitairesArray()[j].getXp());
					System.out.println("militaireADV: "+getMilitairesArray()[j].getVie());
					System.out.println("CasernePlayer: "+p.getEquipe().getCasernesArray()[i].getEtat());
					if(p.getEquipe().getCasernesArray()[i].estDetruit()==true && getCasernesVector().size()!=0)
					{
						p.getEquipe().SupprimerCaserneEquipe(i);
						p.repaint();
						break;
					}
					System.out.println("");
				}	
			}
			if(getMilitairesVector().size()!=0)
			{
				break;
			}
		}
	}
	
	public void VerificationZoneCavalierAdv(Panneau p)
	{
		for(int j=0;j<getCavaliersArray().length;j++)
		{
			for(int i=0;i<p.getEquipe().getCavaliersArray().length;i++)
			{
				if(getCavaliersArray()[j].getZone().getBounds().intersects(p.getEquipe().getCavaliersArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getCavaliersArray()[i].setVie(p.getEquipe().getCavaliersArray()[i].getVie()-getCavaliersArray()[j].getXp());
					getCavaliersArray()[j].setVie(getCavaliersArray()[j].getVie()-p.getEquipe().getCavaliersArray()[i].getXp());
					System.out.println("cavalierADV: "+getCavaliersArray()[j].getVie());
					System.out.println("CavalierPlayer: "+p.getEquipe().getCavaliersArray()[i].getVie());
					if(getCavaliersArray()[j].estMort()==true && getCavaliersVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerCavalierAdv(j);
						
						p.repaint();
						
					}
					if(p.getEquipe().getCavaliersArray()[i].estMort()==true && p.getEquipe().getCavaliersVector().size()!=0)
					{
						p.getEquipe().SupprimerCavalierEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getCavaliersVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getPaysansArray().length;i++)
			{
				if(getCavaliersArray()[j].getZone().getBounds().intersects(p.getEquipe().getPaysansArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getPaysansArray()[i].setVie(p.getEquipe().getPaysansArray()[i].getVie()-getCavaliersArray()[j].getXp());
					getCavaliersArray()[j].setVie(getCavaliersArray()[j].getVie()-p.getEquipe().getPaysansArray()[i].getXp());
					System.out.println("cavalierADV: "+getCavaliersArray()[j].getVie());
					System.out.println("PaysanPlayer: "+p.getEquipe().getPaysansArray()[i].getVie());
					if(getCavaliersArray()[j].estMort()==true && getMilitairesVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerCavalierAdv(j);
						p.repaint();
					}
					if(p.getEquipe().getPaysansArray()[i].estMort()==true && p.getEquipe().getPaysansVector().size()!=0)
					{
						p.getEquipe().SupprimerPaysanEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getCavaliersVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getMilitairesArray().length;i++)
			{
				if(getCavaliersArray()[j].getZone().getBounds().intersects(p.getEquipe().getMilitairesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getMilitairesArray()[i].setVie(p.getEquipe().getMilitairesArray()[i].getVie()-getCavaliersArray()[j].getXp());
					getCavaliersArray()[j].setVie(getCavaliersArray()[j].getVie()-p.getEquipe().getMilitairesArray()[i].getXp());
					System.out.println("cavalierADV: "+getCavaliersArray()[j].getVie());
					System.out.println("MilitairePlayer: "+p.getEquipe().getMilitairesArray()[i].getVie());
					if(getCavaliersArray()[j].estMort()==true && getCavaliersVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerCavalierAdv(j);
						p.repaint();
						break;
					}
					if(p.getEquipe().getMilitairesArray()[i].estMort()==true && getMilitairesVector().size()!=0)
					{
						p.getEquipe().SupprimerMilitaireEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			if(getCavaliersVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getStockagesArray().length;i++)
			{
				if(getCavaliersArray()[j].getZone().getBounds().intersects(p.getEquipe().getStockagesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getStockagesArray()[i].setEtat(p.getEquipe().getStockagesArray()[i].getEtat()-getCavaliersArray()[j].getXp());
					System.out.println("cavalierADV: "+getCavaliersArray()[j].getVie());
					System.out.println("StockagePlayer: "+p.getEquipe().getStockagesArray()[i].getEtat());
					if(p.getEquipe().getStockagesArray()[i].estDetruit()==true && getStockagesVector().size()!=0)
					{
						p.getEquipe().SupprimerStockageEquipe(i);
						p.repaint();
						break;
					}
					System.out.println("");
				}	
			}
			if(getCavaliersVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getCasernesArray().length;i++)
			{
				if(getMilitairesArray()[j].getZone().getBounds().intersects(p.getEquipe().getCasernesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getCasernesArray()[i].setEtat(p.getEquipe().getCasernesArray()[i].getEtat()-getCavaliersArray()[j].getXp());
					System.out.println("cavalierADV: "+getCavaliersArray()[j].getVie());
					System.out.println("CasernePlayer: "+p.getEquipe().getCasernesArray()[i].getEtat());
					if(p.getEquipe().getCasernesArray()[i].estDetruit()==true && getCasernesVector().size()!=0)
					{
						p.getEquipe().SupprimerCaserneEquipe(i);
						p.repaint();
						break;
					}
					System.out.println("");
				}	
			}
			if(getCavaliersVector().size()!=0)
			{
				break;
			}
		}
	}
			
	public void VerificationZonePaysanAdv(Panneau p)
	{
		for(int j=0;j<getPaysansArray().length;j++)
		{
			for(int i=0;i<p.getEquipe().getCavaliersArray().length;i++)
			{
				if(getPaysansArray()[j].getZone().getBounds().intersects(p.getEquipe().getCavaliersArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getCavaliersArray()[i].setVie(p.getEquipe().getCavaliersArray()[i].getVie()-getPaysansArray()[j].getXp());
					getPaysansArray()[j].setVie(getPaysansArray()[j].getVie()-p.getEquipe().getCavaliersArray()[i].getXp());
					System.out.println("paysanADV: "+getPaysansArray()[j].getVie());
					System.out.println("CavalierPlayer: "+p.getEquipe().getCavaliersArray()[i].getVie());
					if(getPaysansArray()[j].estMort()==true && getPaysansVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerPaysanAdv(j);
						
						p.repaint();
						
					}
					if(p.getEquipe().getCavaliersArray()[i].estMort()==true && p.getEquipe().getCavaliersVector().size()!=0)
					{
						p.getEquipe().SupprimerCavalierEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getPaysansVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getPaysansArray().length;i++)
			{
				if(getPaysansArray()[j].getZone().getBounds().intersects(p.getEquipe().getPaysansArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getPaysansArray()[i].setVie(p.getEquipe().getPaysansArray()[i].getVie()-getCavaliersArray()[j].getXp());
					getPaysansArray()[j].setVie(getPaysansArray()[j].getVie()-p.getEquipe().getPaysansArray()[i].getXp());
					System.out.println("paysanADV: "+getPaysansArray()[j].getVie());
					System.out.println("PaysanPlayer: "+p.getEquipe().getPaysansArray()[i].getVie());
					if(getPaysansArray()[j].estMort()==true && getPaysansVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerPaysanAdv(j);
						p.repaint();
					}
					if(p.getEquipe().getPaysansArray()[i].estMort()==true && p.getEquipe().getPaysansVector().size()!=0)
					{
						p.getEquipe().SupprimerPaysanEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getPaysansVector().size()==0)
			{
				break;
			}
			
			for(int i=0;i<p.getEquipe().getMilitairesArray().length;i++)
			{
				if(getPaysansArray()[j].getZone().getBounds().intersects(p.getEquipe().getMilitairesArray()[i].getZone().getBounds())==true)
				{
					p.getEquipe().getMilitairesArray()[i].setVie(p.getEquipe().getMilitairesArray()[i].getVie()-getPaysansArray()[j].getXp());
					getPaysansArray()[j].setVie(getPaysansArray()[j].getVie()-p.getEquipe().getMilitairesArray()[i].getXp());
					System.out.println("paysanADV: "+getPaysansArray()[j].getVie());
					System.out.println("MilitairePlayer: "+p.getEquipe().getMilitairesArray()[i].getVie());
					if(getPaysansArray()[j].estMort()==true && getPaysansVector().size()!=0)
					{
						System.out.println("mort");
						SupprimerPaysanAdv(j);
						p.repaint();
						break;
					}
					if(p.getEquipe().getMilitairesArray()[i].estMort()==true && p.getEquipe().getMilitairesVector().size()!=0)
					{
						p.getEquipe().SupprimerMilitaireEquipe(i);
						p.repaint();
					}
					System.out.println("");
				}	
			}
			
			if(getPaysansVector().size()==0)
			{
				break;
			}
		}
	}
}