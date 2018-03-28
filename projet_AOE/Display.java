package screen;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.*;
import ecouteur.*;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Button;
import java.awt.Dimension;
import contenu.*;
import ecouteur.EcouteurFenetre;
import java.awt.Adjustable;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Label;
import java.lang.*;

public class Display extends Frame
{
	String title;
	int width,height;
	private Panel ContentPane;
	private Panel panelnorth;
	private Panel panelsouth;
	private Button ajoutMilitaire;
	private Button ajoutPaysan;
	private Button ajoutCavalier;
	private Button ajoutCaserne;
	private Button ajoutStockage;
	private Label ajout,vie,score,repscore,nouriture,repnourriture,arbre,reparbre,or,repor,pierre,reppierre;

	
	public Display(String titre,Panneau t)
	{
		this.title=titre;
		this.width=1000;
		this.height=700;

		this.createDisplay(t);
	}

	public void createDisplay(Panneau t)
	{
		this.setTitle(this.title);
		this.setSize(width,height);
		this.setResizable(false);
		this.setVisible(true);
		setLocationRelativeTo(null);
		
		
			
		ScrollPane sp=new ScrollPane(ScrollPane.SCROLLBARS_AS_NEEDED);
		sp.setSize(995,500);
		sp.add(t,BorderLayout.CENTER);
		sp.setLocation(0,100);
		
		
		
		panelnorth=new Panel();
		panelnorth.setBackground(Color.black);
		panelnorth.setLayout(null);
		panelnorth.setSize(1000,100);
		panelnorth.setLocation(0,0);
		panelnorth.setVisible(true);
		setNorthPane(panelnorth);
		getPanelNorth().repaint();
		
		Font font=new Font("Times new Roman", Font.BOLD, 15);
		setSouthPane(panelsouth);
		
		score=new Label("score");
		score.setVisible(true);
		score.setForeground(new Color(120,29,18));
		score.setBounds(20,0,110,60);
		score.setFont(new Font("Times new Roman", Font.BOLD, 15));
		setLabelScore(score);
		
		repscore=new Label(Integer.toString(t.getEquipe().getScore()));
		repscore.setVisible(true);
		repscore.setForeground(new Color(255,255,255));
		repscore.setBounds(20,40,110,60);
		repscore.setFont(new Font("Times new Roman", Font.BOLD, 15));
		setLabelRepScore(repscore);
		
		vie=new Label("");
		vie.setVisible(true);
		vie.setForeground(new Color(120,29,18));
		vie.setFont(new Font("Times new Roman", Font.BOLD, 15));
		vie.setBounds(200,0,110,60);
		setLabelVie(vie);
		
		nouriture=new Label("NOURRITURE");
		nouriture.setVisible(true);
		nouriture.setForeground(new Color(120,29,18));
		nouriture.setFont(new Font("Times new Roman", Font.BOLD, 15));
		nouriture.setBounds(380,0,110,60);
		setLabelNourriture(nouriture);
		
		repnourriture=new Label("0");
		repnourriture.setVisible(true);
		repnourriture.setForeground(new Color(255,255,255));
		repnourriture.setBounds(380,40,110,60);
		repnourriture.setFont(new Font("Times new Roman", Font.BOLD, 15));
		setLabelRepNouriture(repnourriture);
		
		
		reparbre=new Label("0");
		reparbre.setVisible(true);
		reparbre.setForeground(new Color(255,255,255));
		reparbre.setBounds(600,40,110,60);
		reparbre.setFont(new Font("Times new Roman", Font.BOLD, 15));
		setLabelRepArbre(reparbre);
		
		arbre=new Label("ARBRE");
		arbre.setVisible(true);
		arbre.setForeground(new Color(120,29,18));
		arbre.setFont(new Font("Times new Roman", Font.BOLD, 15));
		arbre.setBounds(600,0,110,60);
		setLabelArbre(arbre);
		
		
		
		or=new Label("OR");
		or.setVisible(true);
		or.setForeground(new Color(120,29,18));
		or.setFont(new Font("Times new Roman", Font.BOLD, 15));
		or.setBounds(780,0,110,60);
		setLabelOr(or);
				
		repor=new Label("0");
		repor.setVisible(true);
		repor.setForeground(new Color(255,255,255));
		repor.setBounds(780,40,110,60);
		repor.setFont(new Font("Times new Roman", Font.BOLD, 15));
		//setLabelRepOr(repor);
		
		
		pierre=new Label("PIERRE");
		pierre.setVisible(true);
		pierre.setForeground(new Color(120,29,18));
		pierre.setFont(new Font("Times new Roman", Font.BOLD, 15));
		pierre.setBounds(910,0,110,60);
		//setLabelPierre(pierre);
		
		reppierre=new Label("0");
		reppierre.setVisible(true);
		reppierre.setForeground(new Color(255,255,255));
		reppierre.setBounds(910,40,110,60);
		reppierre.setFont(new Font("Times new Roman", Font.BOLD, 15));
		//setLabelRepNouriture(reppierre);
		
		panelsouth=new Panel();
		panelsouth.setBackground(Color.black);
		panelsouth.setSize(1000,100);
		panelsouth.setLocation(0,600);
		panelsouth.setVisible(true);
		panelsouth.setLayout(null);
		
		
		
		font=new Font("Times new Roman", Font.BOLD, 15);
		setSouthPane(panelsouth);
		
		ajout=new Label("Ajouter :",Label.LEFT);
		ajout.setVisible(true);
		ajout.setForeground(new Color(120,29,18));
		ajout.setBounds(20,0,100,60);
		ajout.setFont(new Font("Times new Roman", Font.BOLD, 20));
		
		ajoutMilitaire=new Button("Militaire");
		ajoutMilitaire.setVisible(true);
		ajoutMilitaire.setFont(font);
		ajoutMilitaire.setBounds(115,0,100,60);
		
		
		ajoutPaysan=new Button("Paysan");
		ajoutPaysan.setVisible(true);
		ajoutPaysan.setFont(font);
		ajoutPaysan.setBounds(220,0,100,60);
		setButtonPaysan(ajoutPaysan);
		
		ajoutCavalier=new Button("Cavalier");
		ajoutCavalier.setVisible(true);
		ajoutCavalier.setFont(font);
		ajoutCavalier.setBounds(325,0,100,60);
		setButtonCavalier(ajoutCavalier);
		
		ajoutCaserne=new Button("CASERNE");
		ajoutCaserne.setVisible(true);
		ajoutCaserne.setFont(font);
		ajoutCaserne.setBounds(430,0,100,60);
		setButtonCaserne(ajoutCaserne);
		
		
		ajoutStockage=new Button("MAISON STOCKAGE");
		ajoutStockage.setVisible(true);
		ajoutStockage.setFont(font);
		ajoutStockage.setBounds(535,0,160,60);
		setButtonStockage(ajoutStockage);
		
		panelnorth.add(score);
		panelnorth.add(repscore);
		panelnorth.add(vie);
		panelnorth.add(nouriture);
		panelnorth.add(repnourriture);
		panelnorth.add(arbre);
		panelnorth.add(reparbre);
		panelnorth.add(or);
		panelnorth.add(repor);
		panelnorth.add(pierre);
		panelnorth.add(reppierre);
		
		panelsouth.add(ajout);
		panelsouth.add(ajoutMilitaire);
		panelsouth.add(ajoutPaysan);
		panelsouth.add(ajoutCavalier);
		panelsouth.add(ajoutCaserne);
		panelsouth.add(ajoutStockage);
		
		ContentPane=new Panel();
		getContentPane().setLayout(null);
		getContentPane().add(sp);
		getContentPane().add(panelnorth);
		getContentPane().add(panelsouth);
		add(ContentPane);
		
		this.addWindowListener(new EcouteurFenetre(this));
		
	}
		
	public Panel getContentPane()
	{
		return this.ContentPane;
	}
	
	public void setNorthPane(Panel p)
	{
		this.panelnorth=p;
	}
	
	public void setSouthPane(Panel p)
	{
		this.panelsouth=p;
	}
	
	public Panel getPanelNorth()
	{
		return panelnorth;
	}
	
	
	public void setButtonMilitaire(Button b)
	{
		this.ajoutMilitaire=b;
	}
	
	public void setButtonPaysan(Button b)
	{
		this.ajoutPaysan=b;
	}
	
	public void setButtonCavalier(Button b)
	{
		this.ajoutCavalier=b;
	}
	
	public void setButtonCaserne(Button b)
	{
		this.ajoutCaserne=b;
	}
	
	public void setButtonStockage(Button b)
	{
		this.ajoutStockage=b;
	}
	
	public void setLabelAjout(Label l)
	{
		this.ajout=l;
	}
	
	public void setLabelVie(Label l)
	{
		this.vie=l;
	}
	
	public Label getLabelVie()
	{
		return this.vie;
	}
	
	public void setLabelNourriture(Label l)
	{
		this.nouriture=l;
	}
	
	public void setLabelRepNouriture(Label s)
	{
		repnourriture=s;
	}
	
	public Label getRepNourriture()
	{
		return repnourriture;
	}
	
	public void setLabelArbre(Label l)
	{
		this.arbre=l;
	}
	
	public Label getRepArbre()
	{
		return reparbre;
	}
	
	public void setLabelRepArbre(Label l)
	{
		reparbre=l;
	}
	
	public void setLabelScore(Label s)
	{
		this.score=s;
	}
	
	public Label getLabelScore()
	{
		return this.score;
	}
	
	public void setLabelRepScore(Label s)
	{
		repscore=s;
	}
	
	public Label getRepScore()
	{
		return this.repscore;
	}
	
	public void setLabelOr(Label o)
	{
		or=o;
	}
	
	

	public Label getRepOr()
	{
		return repor;
	}
	
	public void setLabelRepOr(Label r)
	{
		repor=r;
	}
	
	public void setLabelPierre(Label p)
	{
		pierre=p;
	}
	
	public void setLabelRepPierre(Label r)
	{
		reppierre=r;
	}
	
	public Label getRepPierre()
	{
		return reppierre;
	}
	
	public Button getButtonCavalier()
	{
		return this.ajoutCavalier;
	}
	
	public Button getButtonMilitaire()
	{
		return this.ajoutMilitaire;
	}
	
	public Button getButtonPaysan()
	{
		return this.ajoutPaysan;
	}
	
	public Button getButtonCaserne()
	{
		return this.ajoutCaserne;
	}
	
	public Button getButtonStockage()
	{
		return this.ajoutStockage;
	}
	
	public Display getThisDisplay()
	{
		return this;
	}
	
	
}