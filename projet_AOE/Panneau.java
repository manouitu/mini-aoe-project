package contenu;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Button;
import jeu.Personnage;
import terrain.Terrain;
import java.awt.Toolkit;
import java.awt.Image;
import listepers.*;
import ressource.*;
import ecouteur.*;
import image.ManageImage;
import java.awt.Scrollbar;
import java.awt.event.*;
import java.awt.*;
import zone.Zone;
import personne.*;
import action.*;
import pseudo.*;
import screen.*;
import java.lang.*;


public class Panneau extends Panel 
{
	int indiceSelectionned;
	Equipe equipe;
	EquipeAdv equipeadv;
	Arbre[] arbre;
	Pierre[] pierre;
	Or[] or;
	Cerf[] cerf;
	ManageImage img;
	Thread ajoutCavalier;
	Thread ajoutMilitaire;
	Thread ajoutPaysan;
	Thread deplCavalier;
	Thread deplMilitaire;
	Thread deplPaysan;
	Thread avancePaysan;
	Thread avanceMilitaire;
	Thread avanceCavalier;
	PseudoCaserne pseudocaserne;
	PseudoStockage pseudostockage;
	Display display;
	
	public Panneau()
	{	
		
		setLayout(null);
		setPreferredSize(new Dimension(1500,1500));
		equipe=new Equipe();
		equipeadv=new EquipeAdv();
		
		arbre=new Arbre[10];
		arbre[0]=new Arbre(50,80);
		arbre[1]=new Arbre(120,600);
		arbre[2]=new Arbre(100,51);
		arbre[3]=new Arbre(147,10);
		arbre[4]=new Arbre(486,59);
		arbre[5]=new Arbre(481,237);
		arbre[6]=new Arbre(12,500);
		arbre[7]=new Arbre(158,596);
		arbre[8]=new Arbre(203,571);
		arbre[9]=new Arbre(482,123);
		
		cerf=new Cerf[10];
		cerf[0]=new Cerf(589,236);
		cerf[1]=new Cerf(135,469);
		cerf[2]=new Cerf(243,590);
		cerf[3]=new Cerf(345,890);
		cerf[4]=new Cerf(1040,253);
		cerf[5]=new Cerf(1289,590);
		cerf[6]=new Cerf(1000,456);
		cerf[7]=new Cerf(154,789);
		cerf[8]=new Cerf(749,478);
		cerf[9]=new Cerf(190,398);
		
		or=new Or[5];
		or[0]=new Or(670,745);
		or[1]=new Or(139,567);
		or[2]=new Or(900,875);
		or[3]=new Or(800,400);
		or[4]=new Or(590,980);
		
		pierre=new Pierre[5];
		pierre[0]=new Pierre(500,678);
		pierre[1]=new Pierre(687,809);
		pierre[2]=new Pierre(798,100);
		pierre[3]=new Pierre(490,1000);
		pierre[4]=new Pierre(1000,468);
		img=new ManageImage(1500,1500,"sary/field.gif");
		
		pseudocaserne=new PseudoCaserne();
		pseudostockage=new PseudoStockage();
		
		
		/*ajoutCavalier=new Thread(new ActionAddCavalier(this));
		ajoutCavalier.start();
		
		ajoutMilitaire=new Thread(new ActionAddMilitaire(this));
		ajoutMilitaire.start();
		
		ajoutPaysan=new Thread(new ActionAddPaysan(this));
		ajoutPaysan.start();
		*/
		deplCavalier=new Thread(new ActionDeplCavalier(this));
		deplCavalier.start();
		
		
		ActionDeplMilitaire adm=new ActionDeplMilitaire(this);
		deplMilitaire=new Thread(adm);
		deplMilitaire.start();
		avanceMilitaire=new Thread(new ActionAvanceMilitaire(adm));
		avanceMilitaire.start();
		
		ActionDeplPaysan adp=new ActionDeplPaysan(this);
		deplPaysan=new Thread(adp);
		deplPaysan.start();
		avancePaysan=new Thread(new ActionAvancePaysan(adp));
		avancePaysan.start();
		
		ActionDeplCavalier adc=new ActionDeplCavalier(this);
		deplCavalier=new Thread(adc);
		deplCavalier.start();
		avanceCavalier=new Thread(new ActionAvanceCavalier(adc));
		avanceCavalier.start();/**/
		
		addMouseListener(new EcouteurCavalier(this));
		addMouseListener(new EcouteurPaysan(this));
		addMouseListener(new EcouteurMilitaire(this));
		//init();
		display=new Display("ESSAI",this);
		getDisplay().getButtonCavalier().addActionListener(new EcouteurBoutonCavalier(this));
		getDisplay().getButtonMilitaire().addActionListener(new EcouteurBoutonMilitaire(this));
		getDisplay().getButtonPaysan().addActionListener(new EcouteurBoutonPaysan(this));
		getDisplay().getButtonCaserne().addActionListener(new EcouteurBoutonCaserne(this));
		getDisplay().getButtonStockage().addActionListener(new EcouteurBoutonStockage(this));
		//resize(500,500);
		//System.out.println(getEquipe().getCavaliersArray()[1].getVie());
	}
	
	public Display getDisplay()
	{
		return display;
	}
	public void setIndiceSelectionned(int i)
	{
		this.indiceSelectionned=i;
	}	
	
	public int getIndiceSelectionned()
	{
		return this.indiceSelectionned;
	}
	
	public void repaindre()
	{
		try
		{
			Thread.sleep(10);
			repaint();
		}
		catch(InterruptedException g)
		{
			System.out.println(g);
		}
	}
	
	
	
	
	
	public void init()
	{
		this.repaint();
	}
	
	public ManageImage getManageImage()
	{
		return img;
	}
	
	void setArbre(Arbre[] a)
	{
		this.arbre=a;
	}
	
	
	public Equipe getEquipe()
	{
		return this.equipe;
	}
	
	public EquipeAdv getAdv()
	{
		return this.equipeadv;
	}
	
	public Arbre[] getArbre()
	{
		return this.arbre;
	}
	
	public Cerf[] getCerf()
	{
		return this.cerf;
	}
	
	public Or[] getOr()
	{
		return or;
	}
	
	public void setOr(Or[] o)
	{
		or=o;
	}
	
	public void setCerf(Cerf[] c)
	{
		cerf=c;
	}
	
	public void setPierre(Pierre[] p)
	{
		pierre=p;
	}
	
	public Pierre[] getPierre()
	{
		return pierre;
	}
	public void SupprimeArbre(int indice)
	{
		Arbre[] recup=new Arbre[getArbre().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getArbre()[i];
		}
		
		for(int i=indice;i<getArbre().length-1;i++)
		{
			recup[i]=getArbre()[i+1];
		}
		setArbre(recup);
		repaint();
	}
	
	public void SupprimeCerf(int indice)
	{
		Cerf[] recup=new Cerf[getCerf().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getCerf()[i];
		}
		
		for(int i=indice;i<getCerf().length-1;i++)
		{
			recup[i]=getCerf()[i+1];
		}
		setCerf(recup);
		repaint();
	}
	
	public void SupprimeOr(int indice)
	{
		Or[] recup=new Or[getOr().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getOr()[i];
		}
		
		for(int i=indice;i<getOr().length-1;i++)
		{
			recup[i]=getOr()[i+1];
		}
		setOr(recup);
		repaint();
	}
	
	public void SupprimePierre(int indice)
	{
		Pierre[] recup=new Pierre[getPierre().length-1];
		for(int i=0;i<indice;i++)
		{
			recup[i]=getPierre()[i];
		}
		
		for(int i=indice;i<getPierre().length-1;i++)
		{
			recup[i]=getPierre()[i+1];
		}
		setPierre(recup);
		repaint();
	}
	
	
	
	
	
	public PseudoCaserne getPseudocaserne()
	{
		return pseudocaserne;
	}
	
	public PseudoStockage getPseudostockage()
	{
		return pseudostockage;
	}
	
	public void VerificationZoneMilitaire(Militaire p)
	{
		for(int i=0;i<getAdv().getCavaliersArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getCavaliersArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getCavaliersArray()[i].getXp());
				getAdv().getCavaliersArray()[i].setVie(getAdv().getCavaliersArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getCavaliersArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("militaire: "+p.getVie());
				if(p.estMort()==true && getEquipe().getMilitairesVector().size()!=0)
				{
					System.out.println("mort");
					getEquipe().SupprimerMilitaireEquipe(getIndiceSelectionned());
					repaint();
				}
				System.out.println("cavalier adv: "+getAdv().getCavaliersArray()[i].getVie());
				if(getAdv().getCavaliersArray()[i].estMort()==true && getAdv().getCavaliersVector().size()!=0)
				{
					getAdv().SupprimerCavalierAdv(i);
					repaint();
				}
				System.out.println("");
			}
		}
		//ajout.start();
		for(int i=0;i<getAdv().getPaysansArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getPaysansArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getPaysansArray()[i].getXp());
				System.out.println("militaire: "+p.getVie());
				getAdv().getPaysansArray()[i].setVie(getAdv().getPaysansArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getPaysansArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("paysan adv"+getAdv().getPaysansArray()[i].getVie());
				if(p.estMort()==true && getEquipe().getMilitairesVector().size()!=0)
				{
					//System.out.println("mort");
					getEquipe().SupprimerMilitaireEquipe(i);
					repaint();
				}
				
				
				
				if(getAdv().getPaysansArray()[i].estMort()==true && getAdv().getPaysansVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerPaysanAdv(i);
					repaint();
				}
				System.out.println("");
			
			}
		}
		
		for(int i=0;i<getAdv().getMilitairesArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getMilitairesArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getMilitairesArray()[i].getXp());
				if(p.estMort()==true && getEquipe().getMilitairesVector().size()!=0)
				{
					System.out.println("mort");
					getEquipe().SupprimerMilitaireEquipe(getIndiceSelectionned());
					repaint();
				}
				getAdv().getMilitairesArray()[i].setVie(getAdv().getMilitairesArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getMilitairesArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
						System.out.println("score  "+getEquipe().getScore());
				System.out.println("militaire "+p.getVie());
				System.out.println("militaire adv"+getAdv().getMilitairesArray()[i].getVie());
				if(getAdv().getMilitairesArray()[i].estMort()==true && getAdv().getMilitairesVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerMilitaireAdv(i);
					repaint();
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getAdv().getStockagesArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getStockagesArray()[i].getZone().getBounds())==true)
			{
				
				getAdv().getStockagesArray()[i].setEtat(getAdv().getStockagesArray()[i].getEtat()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+10);
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("militaire "+p.getVie());
				System.out.println("stockage"+getAdv().getStockagesArray()[i].getEtat());
				if(getAdv().getStockagesArray()[i].estDetruit()==true && getAdv().getStockagesVector().size()!=0)
				{
					System.out.println("detruit");
					getAdv().SupprimerStockageAdv(i);
					repaint();
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getAdv().getCasernesArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getCasernesArray()[i].getZone().getBounds())==true)
			{
				
				getAdv().getCasernesArray()[i].setEtat(getAdv().getCasernesArray()[i].getEtat()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+10);
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("militaire "+p.getVie());
				System.out.println("caserne"+getAdv().getCasernesArray()[i].getEtat());
				if(getAdv().getCasernesArray()[i].estDetruit()==true && getAdv().getCasernesVector().size()!=0)
				{
					System.out.println("detruit");
					getAdv().SupprimerCaserneAdv(i);
					repaint();
				}
				System.out.println("");
			}
		}
	}

	public void VerificationZonePaysan(Paysan p)
	{
		for(int i=0;i<getAdv().getCavaliersArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getCavaliersArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getCavaliersArray()[i].getXp());
				getAdv().getCavaliersArray()[i].setVie(getAdv().getCavaliersArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getCavaliersArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				if(p.estMort()==true && getEquipe().getPaysansVector().size()!=0 && p.getZone().getBounds().intersects(getAdv().getCavaliersArray()[i].getZone().getBounds())==true)
				{
					System.out.println("mort");
					getEquipe().SupprimerPaysanEquipe(getIndiceSelectionned());
					repaint();
				}
				//System.out.println("paysan: "+p.getVie());
				System.out.println("cavalier adv: "+getAdv().getCavaliersArray()[i].getVie());
				
				if(getAdv().getCavaliersArray()[i].estMort()==true && getAdv().getCavaliersVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerCavalierAdv(i);
				
				System.out.println("");
				
				}
				break;
			}
		}
		
		for(int i=0;i<getAdv().getPaysansArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getPaysansArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getPaysansArray()[i].getXp());
				getAdv().getPaysansArray()[i].setVie(getAdv().getPaysansArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getPaysansArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("paysan: "+p.getVie());
				if(p.estMort()==true && getEquipe().getPaysansVector().size()!=0)
				{
					System.out.println("mort");
					getEquipe().SupprimerPaysanEquipe(getIndiceSelectionned());
				}
				System.out.println("paysan adv:"+getAdv().getPaysansArray()[i].getVie());
				if(getAdv().getPaysansArray()[i].estMort()==true && getAdv().getPaysansVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerPaysanAdv(i);
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getAdv().getMilitairesArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getMilitairesArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getMilitairesArray()[i].getXp());
				getAdv().getMilitairesArray()[i].setVie(getAdv().getMilitairesArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getMilitairesArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("paysan "+p.getVie());
				if(p.estMort()==true && getEquipe().getPaysansVector().size()!=0 )
				{
					System.out.println("mort");
					getEquipe().SupprimerPaysanEquipe(getIndiceSelectionned());
				}
				System.out.println("militaire adv:"+getAdv().getMilitairesArray()[i].getVie());
				if(getAdv().getMilitairesArray()[i].estMort()==true && getAdv().getMilitairesVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerMilitaireAdv(i);
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getCerf().length;i++)
		{
			if(p.getZone().getBounds().intersects(getCerf()[i].getZone().getBounds())==true)
			{
				getCerf()[i].setVie(getCerf()[i].getVie()-p.getXp());
				
				getEquipe().setScore(getEquipe().getScore()+p.getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("paysan "+p.getVie());
				System.out.println("cerf:"+getCerf()[i].getVie());
				getEquipe().setQteNourriture(getEquipe().getQteNourriture()+p.getXp());
				System.out.println("nourriture "+getEquipe().getQteNourriture());
				getDisplay().getRepNourriture().setText(Integer.toString(getEquipe().getQteNourriture()));
				
				//try
				//{
					if(getCerf()[i].estMort()==true && getCerf().length!=0)
					{
						SupprimeCerf(i);
					}
				//}
				//catch(Exception e)
				//{
					
				//}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getArbre().length;i++)
		{
			if(p.getZone().getBounds().intersects(getArbre()[i].getZone().getBounds())==true)
			{
				getArbre()[i].setQuantite(getArbre()[i].getQuantite()-p.getXp());
				System.out.println("paysan "+p.getVie());
				System.out.println("arbre:"+getArbre()[i].getQuantite());
				getEquipe().setNbrArbre(getEquipe().getNbrArbre()+p.getXp());
				getEquipe().setScore(getEquipe().getScore()+p.getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				getDisplay().getRepArbre().setText(Integer.toString(getEquipe().getNbrArbre()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("arbre   "+getEquipe().getNbrArbre());
				if(getArbre()[i].getQuantite()==0)
				{
					SupprimeArbre(i);
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getOr().length;i++)
		{
			if(p.getZone().getBounds().intersects(getOr()[i].getZone().getBounds())==true)
			{
				getOr()[i].setQuantite(getOr()[i].getQuantite()-4*p.getXp());
				System.out.println("paysan "+p.getVie());
				System.out.println("or:"+getOr()[i].getQuantite());
				getEquipe().setQteOr(getEquipe().getQteOr()+4*p.getXp());
				getEquipe().setScore(getEquipe().getScore()+p.getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				getDisplay().getRepOr().setText(Integer.toString(getEquipe().getQteOr()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("or   "+getEquipe().getQteOr());
				if(getOr()[i].getQuantite()==0)
				{
					SupprimeOr(i);
				}
				System.out.println("");
			}
		}
		
		for(int i=0;i<getPierre().length;i++)
		{
			if(p.getZone().getBounds().intersects(getPierre()[i].getZone().getBounds())==true)
			{
				getPierre()[i].setQuantite(getPierre()[i].getQuantite()-3*p.getXp());
				System.out.println("paysan "+p.getVie());
				System.out.println("pierre:"+getPierre()[i].getQuantite());
				getEquipe().setQtePierre(getEquipe().getQtePierre()+3*p.getXp());
				getEquipe().setScore(getEquipe().getScore()+p.getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				getDisplay().getRepPierre().setText(Integer.toString(getEquipe().getQtePierre()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("pierre   "+getEquipe().getQtePierre());
				if(getPierre()[i].getQuantite()==0)
				{
					SupprimePierre(i);
				}
				System.out.println("");
			}
		}
	}
	
	public void VerificationZoneCavalier(Cavalier p)
	{
		for(int i=0;i<getAdv().getCavaliersArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getCavaliersArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getCavaliersArray()[i].getXp());
				getAdv().getCavaliersArray()[i].setVie(getAdv().getCavaliersArray()[i].getVie()-p.getXp());
				System.out.println("cavalier: "+p.getVie());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getCavaliersArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				if(p.estMort()==true && getEquipe().getCavaliersVector().size()!=0 && p.getZone().getBounds().intersects(getAdv().getCavaliersArray()[i].getZone().getBounds())==true)
				{
					getEquipe().SupprimerCavalierEquipe(getIndiceSelectionned());
					System.out.println("jyfkiu");
					break;
				}
				System.out.println("cavalier adv: "+getAdv().getCavaliersArray()[i].getVie());
				if(getAdv().getCavaliersArray()[i].estMort()==true && getAdv().getCavaliersVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerCavalierAdv(i);
					repaint();
				}
			
				System.out.println("");
				break;
			}
		}
		
		for(int i=0;i<getAdv().getPaysansArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getPaysansArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getPaysansArray()[i].getXp());
				getAdv().getPaysansArray()[i].setVie(getAdv().getPaysansArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getPaysansArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				System.out.println("cavalier: "+p.getVie());
				System.out.println("paysan adv:"+getAdv().getPaysansArray()[i].getVie());
				if(p.estMort()==true && getEquipe().getCavaliersVector().size()!=0 && p.getZone().getBounds().intersects(getAdv().getPaysansArray()[i].getZone().getBounds())==true)
				{
					getEquipe().SupprimerCavalierEquipe(getIndiceSelectionned());
					
				}
				if(getAdv().getPaysansArray()[i].estMort()==true && getAdv().getPaysansVector().size()!=0 )
				{
					System.out.println("mort");
					getAdv().SupprimerPaysanAdv(i);
				}
				
				System.out.println("");
				break;
			}
		}
		
		for(int i=0;i<getAdv().getMilitairesArray().length;i++)
		{
			if(p.getZone().getBounds().intersects(getAdv().getMilitairesArray()[i].getZone().getBounds())==true)
			{
				p.setVie(p.getVie()-getAdv().getMilitairesArray()[i].getXp());
				getAdv().getMilitairesArray()[i].setVie(getAdv().getMilitairesArray()[i].getVie()-p.getXp());
				getEquipe().setScore(getEquipe().getScore()+getAdv().getMilitairesArray()[i].getXp());
				getDisplay().getRepScore().setText(Integer.toString(getEquipe().getScore()));
				System.out.println("score  "+getEquipe().getScore());
				if(p.estMort()==true && getEquipe().getCavaliersVector().size()!=0  && p.getZone().getBounds().intersects(getAdv().getMilitairesArray()[i].getZone().getBounds())==true)
				{
					getEquipe().SupprimerCavalierEquipe(getIndiceSelectionned());
					break;
				}
				System.out.println("cavalier "+p.getVie());
				System.out.println("militaire adv:"+getAdv().getMilitairesArray()[i].getVie());
				if(getAdv().getMilitairesArray()[i].estMort()==true && getAdv().getMilitairesVector().size()!=0)
				{
					System.out.println("mort");
					getAdv().SupprimerMilitaireAdv(i);
				}
				System.out.println("");
				break;
			}
		}
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(this.img.getImage(),0,0,this.getManageImage().getWidth(),this.getManageImage().getHeight(),this);
		for(int i=0;i<equipe.getCavaliersArray().length;i++)
		{
			g.drawImage(equipe.getCavaliersArray()[i].getManageImage().getImage(),equipe.getCavaliersArray()[i].getPosX(),equipe.getCavaliersArray()[i].getPosY(),equipe.getCavaliersArray()[i].getManageImage().getWidth(),equipe.getCavaliersArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getCavaliersArray().length;i++)
		{
			g.drawImage(equipe.getCavaliersArray()[i].getImageCalqueVie().getImage(),equipe.getCavaliersArray()[i].getPosX(),equipe.getCavaliersArray()[i].getPosY()-5,50,equipe.getCavaliersArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getCavaliersArray().length;i++)
		{
			g.drawImage(equipe.getCavaliersArray()[i].getImageVie().getImage(),equipe.getCavaliersArray()[i].getPosX(),equipe.getCavaliersArray()[i].getPosY()-5,equipe.getCavaliersArray()[i].getVie()/2,equipe.getCavaliersArray()[i].getImageVie().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getMilitairesArray().length;i++)
		{
			g.drawImage(equipe.getMilitairesArray()[i].getManageImage().getImage(),equipe.getMilitairesArray()[i].getPosX(),equipe.getMilitairesArray()[i].getPosY(),equipe.getMilitairesArray()[i].getManageImage().getWidth(),equipe.getMilitairesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getMilitairesArray().length;i++)
		{
			g.drawImage(equipe.getMilitairesArray()[i].getImageCalqueVie().getImage(),equipe.getMilitairesArray()[i].getPosX(),equipe.getMilitairesArray()[i].getPosY()-5,50,equipe.getMilitairesArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getMilitairesArray().length;i++)
		{
			g.drawImage(equipe.getMilitairesArray()[i].getImageVie().getImage(),equipe.getMilitairesArray()[i].getPosX(),equipe.getMilitairesArray()[i].getPosY()-5,equipe.getMilitairesArray()[i].getVie()/2,equipe.getMilitairesArray()[i].getImageVie().getHeight(),this);
		}
		
		
		for(int i=0;i<equipe.getPaysansArray().length;i++)
		{
			g.drawImage(equipe.getPaysansArray()[i].getManageImage().getImage(),equipe.getPaysansArray()[i].getPosX(),equipe.getPaysansArray()[i].getPosY(),equipe.getPaysansArray()[i].getManageImage().getWidth(),equipe.getPaysansArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getPaysansArray().length;i++)
		{
			g.drawImage(equipe.getPaysansArray()[i].getImageCalqueVie().getImage(),equipe.getPaysansArray()[i].getPosX(),equipe.getPaysansArray()[i].getPosY()-5,50,equipe.getPaysansArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getPaysansArray().length;i++)
		{
			g.drawImage(equipe.getPaysansArray()[i].getImageVie().getImage(),equipe.getPaysansArray()[i].getPosX(),equipe.getPaysansArray()[i].getPosY()-5,equipe.getPaysansArray()[i].getVie()/2,equipe.getPaysansArray()[i].getImageVie().getHeight(),this);
		}
		
		for(int i=0;i<getArbre().length;i++)
		{
			g.drawImage(getArbre()[i].getManageImage().getImage(),getArbre()[i].getPosX(),getArbre()[i].getPosY(),getArbre()[i].getManageImage().getWidth(),getArbre()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getCavaliersArray().length;i++)
		{
			g.drawImage(equipeadv.getCavaliersArray()[i].getManageImage().getImage(),equipeadv.getCavaliersArray()[i].getPosX(),equipeadv.getCavaliersArray()[i].getPosY(),equipeadv.getCavaliersArray()[i].getManageImage().getWidth(),equipeadv.getCavaliersArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getCavaliersArray().length;i++)
		{
			g.drawImage(equipeadv.getCavaliersArray()[i].getImageCalqueVie().getImage(),equipeadv.getCavaliersArray()[i].getPosX(),equipeadv.getCavaliersArray()[i].getPosY()-5,50,equipeadv.getCavaliersArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getCavaliersArray().length;i++)
		{
			g.drawImage(equipeadv.getCavaliersArray()[i].getImageVie().getImage(),equipeadv.getCavaliersArray()[i].getPosX(),equipeadv.getCavaliersArray()[i].getPosY()-5,equipeadv.getCavaliersArray()[i].getVie()/2,equipeadv.getCavaliersArray()[i].getImageVie().getHeight(),this);
		}
		
		
		
		for(int i=0;i<equipeadv.getPaysansArray().length;i++)
		{
			g.drawImage(equipeadv.getPaysansArray()[i].getManageImage().getImage(),equipeadv.getPaysansArray()[i].getPosX(),equipeadv.getPaysansArray()[i].getPosY(),equipeadv.getPaysansArray()[i].getManageImage().getWidth(),equipeadv.getPaysansArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getPaysansArray().length;i++)
		{
			g.drawImage(equipeadv.getPaysansArray()[i].getImageCalqueVie().getImage(),equipeadv.getPaysansArray()[i].getPosX(),equipeadv.getPaysansArray()[i].getPosY()-5,50,equipeadv.getPaysansArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getPaysansArray().length;i++)
		{
			g.drawImage(equipeadv.getPaysansArray()[i].getImageVie().getImage(),equipeadv.getPaysansArray()[i].getPosX(),equipeadv.getPaysansArray()[i].getPosY()-5,equipeadv.getPaysansArray()[i].getVie()/2,equipeadv.getPaysansArray()[i].getImageVie().getHeight(),this);
		}
		
		for(int i=0;i<getAdv().getMilitairesArray().length;i++)
		{
			g.drawImage(getAdv().getMilitairesArray()[i].getManageImage().getImage(),getAdv().getMilitairesArray()[i].getPosX(),getAdv().getMilitairesArray()[i].getPosY(),getAdv().getMilitairesArray()[i].getManageImage().getWidth(),getAdv().getMilitairesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getMilitairesArray().length;i++)
		{
			g.drawImage(equipeadv.getMilitairesArray()[i].getImageCalqueVie().getImage(),equipeadv.getMilitairesArray()[i].getPosX(),equipeadv.getMilitairesArray()[i].getPosY()-5,50,equipeadv.getMilitairesArray()[i].getImageCalqueVie().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getMilitairesArray().length;i++)
		{
			g.drawImage(equipeadv.getMilitairesArray()[i].getImageVie().getImage(),equipeadv.getMilitairesArray()[i].getPosX(),equipeadv.getMilitairesArray()[i].getPosY()-5,equipeadv.getMilitairesArray()[i].getVie()/2,equipeadv.getMilitairesArray()[i].getImageVie().getHeight(),this);
		}
		
		for(int i=0;i<getCerf().length;i++)
		{
			g.drawImage(getCerf()[i].getManageImage().getImage(),getCerf()[i].getPosX(),getCerf()[i].getPosY(),getCerf()[i].getManageImage().getWidth(),getCerf()[i].getManageImage().getHeight(),this);
		}
		
		
		
		for(int i=0;i<getEquipe().getCasernesArray().length;i++)
		{
			g.drawImage(getEquipe().getCasernesArray()[i].getManageImage().getImage(),getEquipe().getCasernesArray()[i].getPosX(),getEquipe().getCasernesArray()[i].getPosY(),getEquipe().getCasernesArray()[i].getManageImage().getWidth(),getEquipe().getCasernesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getCasernesArray().length;i++)
		{
			g.drawImage(equipe.getCasernesArray()[i].getImageCalqueEtat().getImage(),equipe.getCasernesArray()[i].getPosX()+10,equipe.getCasernesArray()[i].getPosY()+20,150,equipe.getCasernesArray()[i].getImageCalqueEtat().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getCasernesArray().length;i++)
		{
			g.drawImage(equipe.getCasernesArray()[i].getImageEtat().getImage(),equipe.getCasernesArray()[i].getPosX()+10,equipe.getCasernesArray()[i].getPosY()+20,equipe.getCasernesArray()[i].getEtat()/2,equipe.getCasernesArray()[i].getImageEtat().getHeight(),this);
		}
		
		for(int i=0;i<getAdv().getCasernesArray().length;i++)
		{
			g.drawImage(getAdv().getCasernesArray()[i].getManageImage().getImage(),getAdv().getCasernesArray()[i].getPosX(),getAdv().getCasernesArray()[i].getPosY(),getAdv().getCasernesArray()[i].getManageImage().getWidth(),getAdv().getCasernesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getCasernesArray().length;i++)
		{
			g.drawImage(equipeadv.getCasernesArray()[i].getImageCalqueEtat().getImage(),equipeadv.getCasernesArray()[i].getPosX()+10,equipeadv.getCasernesArray()[i].getPosY()+20,150,equipeadv.getCasernesArray()[i].getImageCalqueEtat().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getCasernesArray().length;i++)
		{
			g.drawImage(equipeadv.getCasernesArray()[i].getImageEtat().getImage(),equipeadv.getCasernesArray()[i].getPosX()+10,equipeadv.getCasernesArray()[i].getPosY()+20,equipeadv.getCasernesArray()[i].getEtat()/2,equipeadv.getCasernesArray()[i].getImageEtat().getHeight(),this);
		}
		
		for(int i=0;i<getEquipe().getStockagesArray().length;i++)
		{
			g.drawImage(getEquipe().getStockagesArray()[i].getManageImage().getImage(),getEquipe().getStockagesArray()[i].getPosX(),getEquipe().getStockagesArray()[i].getPosY(),getEquipe().getStockagesArray()[i].getManageImage().getWidth(),getEquipe().getStockagesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getStockagesArray().length;i++)
		{
			g.drawImage(equipe.getStockagesArray()[i].getImageCalqueEtat().getImage(),equipe.getStockagesArray()[i].getPosX()+10,equipe.getStockagesArray()[i].getPosY()+20,150,equipe.getStockagesArray()[i].getImageCalqueEtat().getHeight(),this);
		}
		
		for(int i=0;i<equipe.getStockagesArray().length;i++)
		{
			g.drawImage(equipe.getStockagesArray()[i].getImageEtat().getImage(),equipe.getStockagesArray()[i].getPosX()+10,equipe.getStockagesArray()[i].getPosY()+20,equipe.getStockagesArray()[i].getEtat()/2,equipe.getStockagesArray()[i].getImageEtat().getHeight(),this);
		}
		
		for(int i=0;i<getAdv().getStockagesArray().length;i++)
		{
			g.drawImage(getAdv().getStockagesArray()[i].getManageImage().getImage(),getAdv().getStockagesArray()[i].getPosX(),getAdv().getStockagesArray()[i].getPosY(),getAdv().getStockagesArray()[i].getManageImage().getWidth(),getAdv().getStockagesArray()[i].getManageImage().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getStockagesArray().length;i++)
		{
			g.drawImage(equipeadv.getStockagesArray()[i].getImageCalqueEtat().getImage(),equipeadv.getStockagesArray()[i].getPosX()+10,equipeadv.getStockagesArray()[i].getPosY()+20,150,equipeadv.getStockagesArray()[i].getImageCalqueEtat().getHeight(),this);
		}
		
		for(int i=0;i<equipeadv.getStockagesArray().length;i++)
		{
			g.drawImage(equipeadv.getStockagesArray()[i].getImageEtat().getImage(),equipeadv.getStockagesArray()[i].getPosX()+10,equipeadv.getStockagesArray()[i].getPosY()+20,equipeadv.getStockagesArray()[i].getEtat()/2,equipeadv.getStockagesArray()[i].getImageEtat().getHeight(),this);
		}
		
		for(int i=0;i<getOr().length;i++)
		{
			g.drawImage(getOr()[i].getManageImage().getImage(),getOr()[i].getPosX(),getOr()[i].getPosY(),getOr()[i].getManageImage().getWidth(),getOr()[i].getManageImage().getHeight(),this);
		}
		for(int i=0;i<getPierre().length;i++)
		{
			g.drawImage(getPierre()[i].getManageImage().getImage(),getPierre()[i].getPosX(),getPierre()[i].getPosY(),getPierre()[i].getManageImage().getWidth(),getPierre()[i].getManageImage().getHeight(),this);
		}
		getPseudocaserne().dessinerPseudo(g,getPseudocaserne().getVisibilite(),getPseudocaserne().getManageImage().getImage(),getPseudocaserne().getPosX(),getPseudocaserne().getPosY(),getPseudocaserne().getManageImage().getWidth(),getPseudocaserne().getManageImage().getHeight(),this);
		getPseudostockage().dessinerPseudo(g,getPseudostockage().getVisibilite(),getPseudostockage().getManageImage().getImage(),getPseudostockage().getPosX(),getPseudostockage().getPosY(),getPseudostockage().getManageImage().getWidth(),getPseudostockage().getManageImage().getHeight(),this);
		g.dispose();
	}
	public void update(Graphics g1)
	{
		paint(g1);
	}
}