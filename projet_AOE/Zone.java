package zone;
import java.awt.Rectangle;
public class Zone
{
	Rectangle zone;
	int x,y,width,height;
	
	
	public Zone(int posX,int posY, int w,int h)
	{
		x=posX;
		y=posY;
		width=w;
		height=h;
		zone=new Rectangle(x,y,width,height);
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Rectangle getBounds()
	{
		return this.zone;
	}
}