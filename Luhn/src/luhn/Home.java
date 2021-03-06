package luhn;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Home extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BufferedImage background;
	private JButton startbtn;
	
	public Home() {
       try {                
          background = ImageIO.read(new File("images/background.jpg"));
          
          
          //start button
          startbtn = new JButton(new ImageIcon("images/startbutton.png"));
          setLayout(null);
          startbtn.setLocation(320, 365);
          startbtn.setSize(150, 180);
          startbtn.setOpaque(false);
          startbtn.setContentAreaFilled(false);
          startbtn.setBorderPainted(false);
          startbtn.setFocusPainted(false);
          startbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
          
          add(startbtn);
          
          startbtn.addMouseListener(new java.awt.event.MouseAdapter() {
        	    public void mouseEntered(java.awt.event.MouseEvent evt) {
        	        startbtn.setSize(155,185);
        	    }

        	    public void mouseExited(java.awt.event.MouseEvent evt) {
        	        startbtn.setSize(150,180);
        	    }
        	});
          
       } catch (IOException ex) {
            // handle exception...
       }
    }
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,-20,1,null);
	}
	
	public JButton getStartbtn() {
		return startbtn;
	}

	public void setStartbtn(JButton startbtn) {
		this.startbtn = startbtn;
	}
}
