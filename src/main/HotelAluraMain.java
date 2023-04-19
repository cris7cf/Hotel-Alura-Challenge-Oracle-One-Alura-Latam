package main;

import java.awt.EventQueue;
import views.MenuPrincipal;

public class HotelAluraMain {
	
	public static void main(String[] args) {
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		MenuPrincipal frame = new MenuPrincipal();
		frame.setVisible(true);
		
	}

}
