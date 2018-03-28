package ressource;
import image.ManageImage;
import zone.Zone;
public class Cerf
{
	private int vie;
	private int posX;
	private int posY;
	private ManageImage img;
	private Zone zone;
	
	public void setVie(int q)
	{
		this.vie=q;
	}
	
	public int getVie()
	{
		return this.vie;
	}
	
	public Cerf(int x,int y)
	{
		this.setVie(10);
		this.setPosition(x,y);
		this.img=new ManageImage(38,50,"sary/cerf.gif");
		zone=new Zone(x,y,getManageImage().getWidth(),getManageImage().getHeight());
	}
	
	public void setPosition(int x,int y)
	{
		this.posX=x;
		this.posY=y;
	}
	
	public int getPosX()
	{
		return this.posX;
	}
	
	public int getPosY()
	{
		return this.posY;
	}
	
	public ManageImage getManageImage()
	{
		return this.img;
	}
	
	public Zone getZone()
	{
		return this.zone;
	}
	
	public boolean estMort()
	{
		if(getVie()<=0)
		{
			return true;
		}
		return false;
	}
	
	
	public void updatePosition(int x,int y)
	{
		setPosition(x,y);
		zone=new Zone(x,y,getManageImage().getWidth(),getManageImage().getHeight());
	}
}