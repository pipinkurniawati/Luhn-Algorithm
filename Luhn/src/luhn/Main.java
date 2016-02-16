package luhn;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class Main extends JFrame {
	public Main() {
		setTitle ("Credit Card Validator");
		setSize (800,590);
		setLocation (270,60);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		// Window Listeners
		addWindowListener(new WindowAdapter() {
		  public void windowClosing(WindowEvent e) {
		    int confirmed = JOptionPane.showConfirmDialog(null, 
		        "Are you sure you want to exit the program?", "Exit Program",
		        JOptionPane.YES_NO_OPTION);

		    if (confirmed == JOptionPane.YES_OPTION) {
		      dispose(); 
		    }
		  }
		});
		
		//Add Home Panel
		Container contentPane = getContentPane();
		Home home = new Home();
		contentPane.add(home);
		
		Start start = new Start();
		
		//OnClick Start Button
		home.getStartbtn().addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
		    // ... called when button clicked
			  contentPane.remove(home);
			  contentPane.add(start);
              contentPane.revalidate();
              contentPane.repaint();
              pack();
              setSize (800,590);
              setResizable(false);			  
		  }
		});
		
		//OnClick Back Button
		start.getBackbtn().addActionListener(new ActionListener() {
		  public void actionPerformed(ActionEvent evt) {
		    // ... called when button clicked
		  	contentPane.remove(start);
			contentPane.add(home);
            contentPane.revalidate();
            contentPane.repaint();
            pack();
            setSize (800,590);
            setResizable(false);
		  }
		});

		
	}
	
	@SuppressWarnings("deprecation")
	public static void main (String[] args) {
		JFrame f = new Main();
		f.show();
	}
}
