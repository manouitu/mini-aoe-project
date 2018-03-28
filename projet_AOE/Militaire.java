package personne;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import image.ManageImage;
import zone.Zone;
public class Militaire extends Personnage
{
	public Militaire(int x,int y)
	{
		super.nameGrade="militaire";
		super.setVie(100);
		super.setXp(10);
		super.setPosition(x,y);
		this.img=new ManageImage(50,50,"sary/militaire.gif");
		super.ImageCalqueVie=new ManageImage(100,2,"sary/calquevie.png");
		super.ImageVie=new ManageImage(100,2,"sary/vie.png");
		super.zone=new Zone(super.getPosX(),super.getPosY(),super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}
	
	public void updatePosition(int x,int y)
	{
		super.setPosition(x,y);
		super.zone=new Zone(x,y,super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}
	
	public Militaire ToMilitaireAdverse()
	{
		getManageImage().updateManageImage(50,50,"sary/militaireAdve.gif");
		return this;
	}
}