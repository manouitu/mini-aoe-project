package personne;
import java.awt.Image;
import java.awt.Panel;
import image.ManageImage;
import zone.Zone;
public abstract class Personnage
{
	//Attribut
	protected String nameGrade;
	protected int vie;
	protected int xp;
	protected ManageImage img;
	protected ManageImage ImageCalqueVie;
	protected ManageImage ImageVie;
	protected int posX;
	protected int posY;
	protected Zone zone;

	//constructeur

	/*public Personnage()
	{
		this.vie=100;
		this.xp=0;
		this.setPosX(10);
		this.setPosY(10);
	}

	public Personnage(int v,int x)
	{
		vie=v;
		xp=x;
	}*/
	
	

	public void setXp(int x)
	{
		this.xp=x;
	}
	
	public void setNameGrade(String n)
	{
		this.nameGrade=n;
	}
	
	public String getNameGrade()
	{
		return this.nameGrade;
	}
	
	public void setVie(int v)
	{
		if(v>100)
		{
			this.vie=100;
		}
		if(v<0)
		{
			this.vie=0;
		}
		else if(v<=100 && v>=0)
		{
			this.vie=v;
		}
	}
	
	//position sur terrain
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

	/*public void setTailleImage(int w,int h)
	{
		this.width=w;
		this.height=h;
	}
	
	//image
	public abstract void setImage();
	 

	public Image get_Image()
	{
		return this.image;
	}*/

	//vie et Xp
	public int getVie()
	{
		return this.vie;
	}

	public int getXp()
	{
		return this.xp;
	}
	
	/*public int getWidth()
	{
		return this.width;
	}*/

	/*public int getHeight()
	{
		return this.height;
	}*/
	
	public void seReposer(int i)
	{
		if (i<1)
		{
			i=1;
		}
		if (i>2)
		{
			i=2;
		}
		if (i==1)
		{
			vie=vie+5;
			if(vie>100)
			{
				vie=100;
			}
		}

		if (i==2) {
			vie=vie+10;
			if(vie>100)
			{
				vie=100;
			}
		}
	}

	public ManageImage getManageImage()
	{
		return this.img;
	}
	
	public ManageImage getImageVie()
	{
		return ImageVie;
	}
	
	public ManageImage getImageCalqueVie()
	{
		return ImageCalqueVie;
	}
	
	public Zone getZone()
	{
		return this.zone;
	}
	
	/*Vector selection(MouseEvent e,Personnage[] p)
	{
		Vector v=new Vector();
		for(int i=0;i<p.length;i++)
		{
			if((e.getX()>=p[i].getPosX) && (e.getX()<=p[i].posX+p.getSizeX) && (e.getY()>=p[i].posY) && (e.getY()<=p[i].getPosY()+p[i].getSizeY())
			{
				p[i].selectionned=true;
				v.addElement(p[i]);
			}
		}
	return v;
	}*/
	
	public boolean estMort() //throws Exception
	{
		if(getVie()<=0)
		{
			//throw new Exception();
			return true;
		}
		return false;
	}
}