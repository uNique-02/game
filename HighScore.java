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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HighScore extends JFrame{
	
	private static final long serialVersionUID = 8523730927971119547L;
	final static int WIDTH = 983, HEIGHT = 622;
	final static Dimension gameDimension = new Dimension(WIDTH, HEIGHT);
	JPanel hghScore;
	MainMenu backtoMenu;
	
	
	HighScore() throws IOException{
		hghScore = new JPanel();
		initComponent(hghScore);
		this.setContentPane(hghScore);
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
	
	
	public void initComponent(JPanel hghPanel) throws IOException {
		hghPanel.setFocusable(true); 
		hghPanel.setPreferredSize(gameDimension);  
		hghPanel.setLayout(new BorderLayout());
		hghPanel.setVisible(true);
		
		BufferedImage highScore = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\highscore1.jpg"));
		JLabel highScores = new JLabel(new ImageIcon(highScore));
		highScores.setBounds(10, 10, 960, 100);
		hghPanel.add(highScores); 
		
		JButton backBtn = new JButton();
		//backBtn.setSize(40, 40);
		backBtn.setBounds(15, 593, 60, 20);
		backBtn.setText("back");
		hghPanel.add(backBtn);
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
		
        
		JTextField txtField = new JTextField();
		txtField.setText("     Name                                                                                                             Scores    ");
		txtField.setFont(new Font("Showcard Gothic", 0, 20));
		txtField.setBackground(new Color(0, 0, 0));
		txtField.setForeground(new Color(255, 255, 255));
		txtField.setBorder(BorderFactory.createLineBorder(Color.black));
		txtField.setBounds(205, 130, 600, 50);
		txtField.setHorizontalAlignment(JTextField.CENTER);
		hghPanel.add(txtField);
		
		BufferedImage splashImage = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png"));
		JLabel screenImage = new JLabel(new ImageIcon(splashImage));
		hghPanel.add(screenImage, BorderLayout.CENTER);
		
	} 
}
