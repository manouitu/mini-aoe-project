package contenu;
import java.awt.*;
import contenu.Panneau;

public class Scroll extends Panel
{
	Panneau panel;
	
	public Scroll(Panneau p)
	{
		//super(true);
		setPanneau(p);
		setLayout(new BorderLayout());
		add(panel);
		
		
		Scrollbar horizontal=new Scrollbar(Scrollbar.HORIZONTAL,0,60,0,300);
		Scrollbar vertical=new Scrollbar(Scrollbar.VERTICAL,0,60,0,300);
		
		horizontal.setUnitIncrement(2);
		horizontal.setBlockIncrement(1);
	}
	
	void setPanneau(Panneau p)
	{
		this.panel=p;
	}
}