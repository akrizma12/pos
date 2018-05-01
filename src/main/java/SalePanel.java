import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SalePanel extends JPanel
{
	public final int WIDTH = 1024;
	public final int HEIGHT = 800;
	private JTextField Text1;
	private JTextField Text2;
	JButton jButton;
	public SalePanel()
	{

		setBackground(Color.white);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		JLabel L1 = new JLabel("item1");
		JLabel L2 = new JLabel("item2");
		Text1 = new JTextField(20);
		Text1.setBounds(100, 35, 160, 25);
		
		Text2 = new JTextField(20);
		Text2.setBounds(100, 35, 160, 25);
		add(L1);
		add(Text1);
		add(L2);
		add(Text2);
		
		jButton = new JButton("log In");
		jButton.setBounds(180, 110, 80, 25);
		add(jButton);
		

	}
}
