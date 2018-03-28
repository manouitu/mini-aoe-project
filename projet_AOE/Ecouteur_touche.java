package ecouteur;
import java.awt.*;
import java.awt.event.*;
import screen.Display;
public class Ecouteur_bouton implements ActionListener
{
	private Display display;
	
	public Ecouteur_touche()
	{
		
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
        if(e.getSource()==this.get_Display().get_Bouton_ajoutp());
		{
			System.out.println("ajout personnage");
		}
    }
	
}