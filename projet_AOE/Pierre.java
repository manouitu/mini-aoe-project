package ressource;
import java.awt.Color;
import image.ManageImage;
import zone.Zone;
public class Pierre
{
	private int quantite;
	private int posX;
	private int posY;
	private ManageImage img;
	private Zone zone;
	
	public Pierre(int x,int y)
	{
		this.setQuantite(100);
		setPosition(x,y);
		img=new ManageImage(100,100,"sary/pierre.gif");
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
		return zone;
	}
}