package ecouteur;
import box.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurDialog implements WindowListener
{
	BoxDialog box;
	
	public EcouteurDialog(BoxDialog f)
	{
		box=f;
	}
	
	public void windowClosing(WindowEvent e)
    {
		box.dispose();
    }
    public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {} 
	
}