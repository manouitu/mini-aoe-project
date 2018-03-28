package background;
import java.awt.Graphics;
import java.awt.Image;
public class Background
{
	Graphics g;
	Image img;
	int posx;
	int posy;
	int width;
	int height;

	public Background()
	{

	}

	public void setGraphics()
	{
		this.g.create();
	}

	public void setImage(Image pt)
	{
		this.img=pt;
	}

	public Image getFond()
	{
		return this.img;
	}

	public void setPosition(int x,int y)
	{
		this.posx=x;
		this.posy=y;
	}

	public int getX()
	{
		return this.posx;
	}

	public int getY()
	{
		return this.posy;
	}

	public void setTaille(int w,int h)
	{
		this.width=w;
		this.height=h;
	}

	public int getHeight()
	{
		return this.height;
	}

	public int getWidth()
	{
		return this.width;
	}
}