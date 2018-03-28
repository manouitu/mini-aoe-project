import java.awt.*;
import java.awt.image.*;
import java.awt.geom.*;
public class ImageToDraw {
    private Image image;
    private Point2D.Double position;
   
   
    private ImageToDraw(double x,double y) {
        position=new Point2D.Double(x,y);
    }
    public ImageToDraw(String source,double x,double y) {
        this(x,y);
        image=Toolkit.getDefaultToolkit().createImage(source);
    }
    public ImageToDraw(Image image,double x,double y) {
        this(x,y);
        this.image=image;
    }
    public ImageToDraw(Image image) {
        this(image,0f,0f);
    }
    public ImageToDraw(String source) {
        this(source,0f,0f);
    }
   
    public void setImage(Image image) {
        this.image=image;
    }
    public Image getImage() {
        return image;
    }
    public Point2D.Double getPosition() {
        return position;
    }
    public double getX() {
        return position.getX();
    }
    public double getY() {
        return position.getY();
    }
    public int getWidth(ImageObserver o) {
        return image.getWidth(o);
    }
    public int getHeight(ImageObserver o) {
        return image.getHeight(o);
    }
   
    public void setLocation(double x,double y) {
        position.setLocation(x,y);
    }
    public void setX(double x) {
        position.setLocation(x,position.getY());
    }
    public void setY(double y) {
        position.setLocation(position.getX(),y);
    }
    public void translate(double xOff,double yOff) {
        position.setLocation(position.getX()+xOff,position.getY()+yOff);
    }
   
    // Place l'image en dehors du panel
    public void hide(Panel p) {
        this.setLocation(p.getWidth()+10,p.getHeight()+10);
    }
   
    public boolean drawImage(Graphics g,Panel p) {
        return g.drawImage(this.getImage(),(int)this.getX(),(int)this.getY(),p);
    }
    public boolean fitImage(Graphics g,Panel p) {
        return g.drawImage(this.getImage(),(int)this.getX(),(int)this.getY(),p.getWidth(),p.getHeight(),p);
    }
}