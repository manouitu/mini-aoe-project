package ecouteur;
import contenu.Panneau;
import java.awt.event.*;
import screen.Display;

public class EcouteurScrollVertical implements AdjustmentListener
{
	Display display;
	
	void setDisplay(Display d)
	{
		this.display=d;
	}
	
	public EcouteurScrollVertical(Display p)
	{
		setDisplay(p);
	}
	
	public Display getDisplay()
	{
		return this.display;
	}
	
	public void adjustmentValueChanged(AdjustmentEvent e)
	{
		System.out.println(e.getValue());
		getDisplay().getPanneau().setLocation(0,-e.getValue());
	}
	//getDisplay().getPanneau().getLocation().x
}