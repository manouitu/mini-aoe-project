package ecouteur;
import screen.Display;
import java.awt.event.*;
public class EcouteurFenetre implements WindowListener
{
	private Display disp;

	public void setFrame(Display f)
	{
		this.disp=f;
	}

	public Display getDisplay()
	{
		return this.disp;
	}

	public EcouteurFenetre()
	{
	}

	public EcouteurFenetre(Display f)
	{
		this.setFrame(f);
	}

	public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    public void windowActivated(java.awt.event.WindowEvent e) {}
	public void windowClosed(java.awt.event.WindowEvent e) {}
	public void windowDeactivated(java.awt.event.WindowEvent e) {}
	public void windowDeiconified(java.awt.event.WindowEvent e) {}
	public void windowIconified(java.awt.event.WindowEvent e) {}
	public void windowOpened(java.awt.event.WindowEvent e) {} 
}