package personne;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import image.ManageImage;
import zone.Zone;
public class Paysan extends Personnage
{
	public Paysan(int x,int y)
	{
		super.nameGrade="paysan";
		super.setVie(100);
		super.setXp(1);
		super.setPosition(x,y);
		super.img=new ManageImage(20,50,"sary/paysan.png");
		super.ImageCalqueVie=new ManageImage(100,2,"sary/calquevie.png");
		super.ImageVie=new ManageImage(100,2,"sary/vie.png");
		super.zone=new Zone(super.getPosX(),super.getPosY(),super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}
	
	public void updatePosition(int x,int y)
	{
		super.setPosition(x,y);
		super.zone=new Zone(x,y,super.getManageImage().getWidth(),super.getManageImage().getHeight());
	}
	
	public Paysan ToPaysanAdverse()
	{
		getManageImage().updateManageImage(20,50,"sary/paysanAdve.png");
		return this;
	}
}