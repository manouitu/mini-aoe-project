package box;
import java.awt.*;
import ecouteur.*;

public class BoxDialog extends Frame
{
	Label message1,message2,message3;
	Button ok;
	Panel principal;
	
	public BoxDialog(String but,String mes1,String mes2)
	{
		setSize(230,200);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		principal=new Panel();
		principal.setLayout(null);
		message1=new Label(mes1);
		message1.setVisible(true);
		message1.setBounds(20,0,200,50);
		message2=new Label(mes2);
		message2.setVisible(true);
		//message2.setBounds(40,0,100,50);
		/*message3=new Label(mes3);
		message3.setVisible(true);
		message3.setBounds(60,0,100,50);*/
		message2.setBounds(20,50,200,50);
		ok=new Button(but);
		ok.setBounds(100,100,30,30);
		ok.setVisible(true);
		ok.addActionListener(new EcouteurBoutonDialog(this));
		
		principal.add(message1,BorderLayout.CENTER);
		principal.add(message2,BorderLayout.CENTER);
		//principal.add(message3,BorderLayout.CENTER);
		principal.add(ok);
		add(principal);
		addWindowListener(new EcouteurDialog(this));
	}
	
	public Button getButtonOk()
	{
		return ok;
	}
}