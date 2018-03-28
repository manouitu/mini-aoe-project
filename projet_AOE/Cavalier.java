package personne;
import java.awt.Graphics;
import ecouteur.*;
import java.awt.Image;
import java.awt.Toolkit;
import image.ManageImage;
import zone.Zone;
public class Cavalier extends Personnage
{
	public Cavalier(int x,int y)
	{
		super.setNameGrade("cavalier");
		super.setVie(100);
		super.setXp(5);
		super.setPosition(x,y);
		super.img=new ManageImage(60,60,"sary/cavalier.gif");
		super.ImageCalqueVie=new ManageImage(100,2,"sary/calquevie.png");
		super.ImageVie=new ManageImage(100,2,"sary/vie.png");
		super.zone=new Zone(super.getPosX(),super.getPosY(),super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}

	public void updatePosition(int x,int y)
	{
		super.setPosition(x,y);
		super.zone=new Zone(x,y,super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}
	
	public Cavalier ToCavalierAdverse()
	{
		getManageImage().updateManageImage(60,60,"sary/cavalierAdv.gif");
		return this;
	}
}