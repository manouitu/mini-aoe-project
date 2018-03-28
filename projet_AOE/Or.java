package ressource;
import image.ManageImage;
import zone.Zone;

public class Or
{
	private int quantite;
	int posX;
	int posY;
	ManageImage img;
	private Zone zone;
	
	public Or(int x,int y)
	{
		this.setQuantite(100);
		this.setPosition(x,y);
		this.img=new ManageImage(100,100,"sary/or.gif");
		zone=new Zone(x,y,getManageImage().getWidth(),getManageImage().getHeight());
	}
	
	public void setQuantite(int q)
	{
		this.quantite=q;
	}
	
	public int getQuantite()
	{
		return this.quantite;
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
}