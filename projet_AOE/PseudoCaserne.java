package pseudo;
import java.awt.*;
import image.*;
import contenu.*;
public class PseudoCaserne
{
	ManageImage image;
	int PosX,PosY;
	boolean visibilite;
	
	
	public PseudoCaserne()
	{
		image=new ManageImage(225,225,"sary/Caserne.gif");
		visibilite=false;
		setPosition(0,0);
	}
	
	public void setPosition(int x,int y)
	{
		PosX=x;
		PosY=y;
	}
	
	public void setVisibilite(boolean v)
	{
		visibilite=v;
	}
	
	public void updatePosition(int x,int y)
	{
		setPosition(x,y);
	}
	
	public int getPosX()
	{
		return PosX;
	}
	
	public int getPosY()
	{
		return PosY;
	}
	
	public ManageImage getManageImage()
	{
		return image;
	}
	
	public boolean getVisibilite()
	{
		return visibilite;
	}
	
	public void dessinerPseudo(Graphics g,boolean visibilite,Image i,int x,int y,int width,int height,Panneau panneau)
	{
		if(visibilite==true)
		{
			g.drawImage(i,x,y,width,height,panneau);
		}
	}
}