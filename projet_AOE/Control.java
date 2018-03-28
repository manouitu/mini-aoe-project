package control;
import jeu.Personnage;
import java.util.Vector;
import java.util.Random;
import construction.*;
import personne.*;
import listepers*;
public class control
{
	private int score;
	private int arbre;
	private int nourriture;
	
	public Control()
	{
	}
	
	public Control(Panneau p)
	{
		score=p.getEquipe().getScore();
		arbre=p.getEquipe().getNbrArbre();
		nourriture=p.getEquipe().getQteNourriture();
	}
	 
	public String getScore()
	{
		return Integer.toString();
	}
}