package com.game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HowToPlay extends JFrame{

	private static final long serialVersionUID = 996222085917938666L;
	final static int WIDTH = 983, HEIGHT = 622;
	final static Dimension gameDimension = new Dimension(WIDTH, HEIGHT);
	JPanel hwtoplay;
	MainMenu backtoMenu;
	
	public HowToPlay() throws IOException {
		hwtoplay = new JPanel();
		initComponent(hwtoplay);
		this.setContentPane(hwtoplay);
		this.setTitle("Time Slice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
	
	public void backToMenu() throws IOException {
		backtoMenu = new MainMenu();
		this.dispose();
	}
	
	public void initComponent(JPanel howPlay) throws IOException {
		howPlay.setFocusable(true); 
		howPlay.setPreferredSize(gameDimension); 
		howPlay.setLayout(new BorderLayout());
		howPlay.setVisible(true);
		
		JButton backBtn = new JButton();
		//backBtn.setSize(40, 40);
		backBtn.setBounds(15, 593, 60, 20);
		backBtn.setText("back");
		howPlay.add(backBtn);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					backBtnActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
            }  

			private void backBtnActionPerformed(ActionEvent evt) throws IOException {
				backToMenu();
			}  
        });
		 
		BufferedImage howToPlay = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\How2Play.png"));
		JLabel labelInstruction = new JLabel(new ImageIcon(howToPlay));
		labelInstruction.setBounds(10, 10, 960, 100);
		howPlay.add(labelInstruction); 
		
		JLabel instruc1 = new JLabel("<html>Time slice is a classic word game in which you must guess the<br> secret word one letter at a time.<br><br>    -Guess one letter at a time to reveal the secret word.<br><br>    -Each incorrect guess slices a part of the clock/time in which<br>      you can only have 6 incorrect guesses.<br><br>    -You need to always guess the word to continue scoring points.<br>      Once you did not guess the secret word, you will lose the game<br>      and the score you made will be saved if it will be considered as a highscore.  </html");
		instruc1.setFont(new Font("Californian FB", 0, 22));
		instruc1.setForeground(new Color(255, 255, 255));
		instruc1.setBounds(160, 200, 670, 290);
		howPlay.add(instruc1);    
		
		
		BufferedImage howToPlay1 = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png"));
		JLabel labelInstruction1 = new JLabel(new ImageIcon(howToPlay1));
		labelInstruction1.setBounds(132, 180, 760, 350);
		labelInstruction1.setHorizontalAlignment(JLabel.NORTH_EAST);
		howPlay.add(labelInstruction1); 
		
	 
		BufferedImage splashImage = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png"));
		JLabel screenImage = new JLabel(new ImageIcon(splashImage));
		howPlay.add(screenImage, BorderLayout.CENTER);
	}
}
