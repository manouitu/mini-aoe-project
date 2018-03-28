package ecouteur;
import java.awt.*;
import java.awt.event.*;
import contenu.Panneau;
import screen.Display;
public class Ecouteur_bouton extends Panel implements ActionListener
{
	private Display display;
	Graphics g=getGraphics();
	
	public Ecouteur_bouton(Display d)
	{
		display=d;
	}
		
	void set_Display(Display d)
	{
		this.display=d;
	}
	
	public Display get_Display()
	{
		return this.display;
	}
	
	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==this.get_Display().getButton_add())
		{
			System.out.println("ajout personnage");
			//this.g.drawImage(Toolkit.getDefaultToolkit().getImage("image/cavalier.jpg"),30,30,10,10,this);
		}
    }
	
}