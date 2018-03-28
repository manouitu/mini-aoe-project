package image;
import java.awt.Image;
import java.awt.Toolkit;
import zone.Zone;

public class ManageImage
{ 
	private String path;
	private Image image;
	private int width,height;
	
	public void setImage(String path)
	{
		this.image=Toolkit.getDefaultToolkit().getImage(path);
	}
	
	public void setTailleImage(int w,int h)
	{
		this.width=w;
		this.height=h;
	}
	
	public ManageImage(int w,int h,String p)
	{
		setImage(p);
		setTailleImage(w,h);
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}

	public Image getImage()
	{
		return this.image;
	}
	
	public void updateManageImage(int w,int h,String p)
	{
		setImage(p);
		setTailleImage(w,h);
	}
}