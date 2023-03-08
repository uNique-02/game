package com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



public class SplashScreen extends JFrame{

	private static final long serialVersionUID = 283064228933448675L;
	final static int WIDTH = 983, HEIGHT = 622;
	final static Dimension gameDimension = new Dimension(WIDTH, HEIGHT);
	static JPanel splashPanel;
	static JProgressBar progressBar;
	static MainMenu mainMenu;
	
	SplashScreen() throws IOException{
		splashPanel = new JPanel();
		splashPanel.setFocusable(true);
		splashPanel.setPreferredSize(gameDimension); 
		splashPanel.setLayout(new BorderLayout());
		
		BufferedImage splashImage = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\SplashScreen.png"));
		JLabel screenImage = new JLabel(new ImageIcon(splashImage));
		splashPanel.add(screenImage, BorderLayout.CENTER);
		
		progressBar = new JProgressBar(); 
		progressBar.setForeground(new Color(0,128,128));
		progressBar.setStringPainted(true);
		screenImage.add(progressBar); 
		splashPanel.add(progressBar, BorderLayout.SOUTH);
		splashPanel.setPreferredSize(gameDimension);
		
		this.setContentPane(splashPanel);
		this.setTitle("Time Slice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 
		 
		int i = 0;
		try { 
			while(i <= 100) {
				progressBar.setValue(i); 
				Thread.sleep(50);
				i++;
			}  
		}	catch(Exception e) {
			e.printStackTrace();
		}
		
		MainMenu mainMenu = new MainMenu();
		this.dispose();
		
	}	
}
