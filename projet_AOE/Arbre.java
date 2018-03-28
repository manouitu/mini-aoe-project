package ressource;
import image.ManageImage;
import zone.Zone;
public class Arbre
{
	private int quantite;
	private int posX;
	private int posY;
	private ManageImage img;
	private Zone zone;
	
	public void setQuantite(int q)
	{
		this.quantite=q;
	}
	
	public int getQuantite()
	{
		return this.quantite;
	}
	
	public Arbre(int x,int y)
	{
		this.setQuantite(25);
		this.setPosition(x,y);
		this.img=new ManageImage(100,100,"sary/arbre.gif");
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
}