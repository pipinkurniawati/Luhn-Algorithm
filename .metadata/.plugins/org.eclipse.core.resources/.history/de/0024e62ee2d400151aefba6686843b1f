package luhn;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/**
 * @file StartingMenu.java
 * @author Pipin Kurniawati
 *
 * Kelas StartingMenu berisi method yang berkaitan dengan tampilan awal program
 *
 */
@SuppressWarnings("serial")
public class StartingMenu extends JFrame{
	
	public static void main(String args[]) throws IOException {
		new StartingMenu();
	}
	
	private static final String TXT_EXT = "txt";
	private Window window;
	private JLabel jLabel; //untuk gambar background
	private JMenu menu;
	private JMenuItem generate, load; 
	private JMenuBar menuBar;
	
	/**
	 * Konstruktor
	 * @throws IOException
	 */
	public StartingMenu() throws IOException {
		super("Crossword Puzzle");
		init();
	}
	
	/**
	 * prosedur untuk untuk menginisialisasi frame yang akan ditampilkan
	 */
	public void init() {
		setTitle("Crossword Puzzle");
		initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(730, 730);
        setLocationRelativeTo(null);
        setVisible(true);
	}
	
	/**
	 * prosedur untuk menginisialisasi komponen
	 * yang terdapat pada panel frame
	 */
	public void initComponents() {
		jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon(getClass().getResource("images/background.jpg"))); //gambar background tampilan awal
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel)
                .addContainerGap(0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(0, 0)
                .addComponent(jLabel, 0, 730, 730)
                .addContainerGap())
        );
    	
        //membuat menubar untuk perintah yang dapat dilakukan melalui Starting menu
        menuBar = new JMenuBar();
        
        menu = new JMenu();
        menu.setText("START");
        
        generate = new JMenuItem(); //men-generate TTS baru
        generate.setText("Generate New Puzzle");
        generate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        generate.setMnemonic(KeyEvent.VK_G);
		generate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        menu.add(generate);
        
        menu.addSeparator();
        
        load = new JMenuItem(); //melakuukan load terhadap TTS yang disimpan
        load.setText("Load Saved Puzzle");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        load.setMnemonic(KeyEvent.VK_L);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menu.add(load);
        
        menuBar.add(menu);
        
        setJMenuBar(menuBar);
        
        pack();
	}
	
	/**
	 * prosedur yang berisi eksekusi perintah generate, yaitu dengan memanggil konstruktor kelas
	 * GUI dengan parameter yang akan melakukan generate TTS berdasarkan file masukan
	 * @param evt
	 * @throws IOException
	 */
	                                       

	/**
	 * prosedur yang berisi eksekusi perintah load, yaitu dengan memanggil konstruktor kelas
	 * GUI tanpa parameter yang akan melakukan aksi load TTS yang disimpan berdasarkan file masukan
	 * @param evt
	 * @throws IOException
	 */
    
}
