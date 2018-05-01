import java.awt.Insets;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class mainManagerMenu {
	public final int WIDTH = 1024;
	public final int HEIGHT = 800;
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public mainManagerMenu(String userName) {
		try {
			JFrame frame = new JFrame("Casher System - Welcome " + userName);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Date currentDate = new Date();
			System.out.println(currentDate);
	        System.out.println(dateFormat.format(currentDate));

			Inventory inventory = new Inventory();

			JTabbedPane tp = new JTabbedPane();
			tp.addTab("Sales", new SalePanel());
			tp.addTab("Return", new ReturnPanel());
			tp.addTab("Inventory", new InventoryPanel(inventory));
			tp.addTab("Orders", new OrderPanel(inventory));

			frame.getContentPane().add(tp);

			// In the main method:
			Insets insets = frame.getInsets();
			frame.setSize(WIDTH + insets.left + insets.right, HEIGHT + insets.top + insets.bottom);

			frame.pack();
			frame.setVisible(true);
		} catch (IOException e) {
			System.out.println("Initialization error when loading inventory");
		}
	}

}
