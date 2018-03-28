package construction;
import image.ManageImage;
import zone.Zone;
public class Stockage
{
	private int etat;
	private int posX;
	private int posY;
	private ManageImage img;
	private ManageImage ImageCalqueEtat;
	private ManageImage ImageEtat;
	private Zone zone;
	
	public void setEtat(int q)
	{
		this.etat=q;
	}
	
	public int getEtat()
	{
		return this.etat;
	}
	
	public Stockage(int x,int y)
	{
		this.setEtat(300);
		this.setPosition(x,y);
		this.img=new ManageImage(200,200,"sary/stockage.gif");
		this.ImageCalqueEtat=new ManageImage(100,2,"sary/calquevie.png");
		this.ImageEtat=new ManageImage(100,2,"sary/vie.png");
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
	
	public ManageImage getImageEtat()
	{
		return ImageEtat;
	}
	
	public ManageImage getImageCalqueEtat()
	{
		return ImageCalqueEtat;
	}
	public Zone getZone()
	{
		return this.zone;
	}
	
	public Stockage ToStockageAdverse()
	{
		getManageImage().updateManageImage(300,300,"sary/stockage.gif");
		return this;
	}
	
	public boolean estDetruit()
	{
		if(getEtat()<=0)
		{
			return true;
		}
		return false;
	}
}