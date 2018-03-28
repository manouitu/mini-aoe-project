package ecouteur;
import box.*;
import java.awt.*;
import java.awt.event.*;

public class EcouteurBoutonDialog implements ActionListener
{
	BoxDialog bd;
	
	public EcouteurBoutonDialog(BoxDialog b)
	{
		this.bd=b;
	}
		
	public BoxDialog getBoxDialog()
	{
		return bd;
	}
	
	public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bd.getButtonOk())
		{
			bd.dispose();
		}
    }
}