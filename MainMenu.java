package com.game;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame{

	
	private static final long serialVersionUID = -398402896525103433L;
	final static int WIDTH = 983, HEIGHT = 622;
	final static Dimension gameDimension = new Dimension(WIDTH, HEIGHT);
	static JPanel mainmenuPanel;
	private HighScore hghscore;
	private HowToPlay hwtoplay;
	private BeforePlay befplay;
	
	MainMenu() throws IOException{
		mainmenuPanel = new JPanel();
		initComponents(mainmenuPanel);
		this.setContentPane(mainmenuPanel);
		this.setTitle("Time Slice");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true); 
		
	}
	
	public void playPage() throws IOException {
		befplay = new BeforePlay();
		this.dispose();
	}
	public void highscorePage() throws IOException {
		hghscore = new HighScore();
		this.dispose();
	}
	
	public void howtoplayPage() throws IOException {
		hwtoplay = new HowToPlay();
		this.dispose();
	}
	
	public void exit() {
		this.dispose();
	}
	
	public void initComponents(JPanel mainmenuPanel) throws IOException{
		mainmenuPanel.setFocusable(true); 
		mainmenuPanel.setPreferredSize(gameDimension); 
		mainmenuPanel.setLayout(new BorderLayout());
		
		
		JLabel logo = new JLabel();
        ImageIcon icon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\index.png");
        logo.setSize(350, 230);
        Image imageCopy = icon.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imageCopy);
        logo.setIcon(i);
        logo.setBounds(315, 80, 400, 200);
        mainmenuPanel.add(logo);
	     
        
        JLabel play = new JLabel();
        play.setSize(200, 50);
        ImageIcon playIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\PlayButton.png");
        Image playIconCopy = playIcon.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tempPlay = new ImageIcon(playIconCopy);
        play.setIcon(tempPlay);
        play.setBounds(395, 280, 300, 60);
        play.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        play.addMouseListener(new MouseAdapter(){
        		public void mouseClicked(MouseEvent e) {
        			try {
						playPage();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
        		}
        			@Override
        			public void mouseEntered(MouseEvent me) {
        				play.setSize(play.getWidth()+10, play.getHeight()+10);
        		}
        			@Override 
        			public void mouseExited (MouseEvent e){
        				play.setSize(play.getWidth()-10, play.getHeight()-10);
        		}
        });
        
        JLabel howToBtn = new JLabel();
        howToBtn.setSize(200, 50);
        ImageIcon howToBtnIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\HowToPlay.png");
        Image howToBtnIconCopy = howToBtnIcon.getImage().getScaledInstance(howToBtn.getWidth(), howToBtn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon temphowToBtn = new ImageIcon(howToBtnIconCopy);
        howToBtn.setIcon(temphowToBtn);
        howToBtn.setBounds(395, 340, 300, 60);
        howToBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        howToBtn.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
        		try {
        			howtoplayPage();
        		} catch (IOException e1) {
        			// TODO Auto-generated catch block
        			e1.printStackTrace();
        		}
        	}
        	@Override
            public void mouseEntered(MouseEvent me) {
                howToBtn.setSize(howToBtn.getWidth()+10, howToBtn.getHeight()+10);
            }
            
        	@Override 
        	public void mouseExited (MouseEvent e){
        		howToBtn.setSize(howToBtn.getWidth()-10, howToBtn.getHeight()-10);
        	}
        });
        
        
        JLabel scoreBtn = new JLabel();
        scoreBtn.setSize(200, 50);
        ImageIcon scoreBtnIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\HighScoreButton.png");
        Image scoreBtnIconCopy = scoreBtnIcon.getImage().getScaledInstance(scoreBtn.getWidth(), scoreBtn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tempscoreBtn = new ImageIcon(scoreBtnIconCopy);
        scoreBtn.setIcon(tempscoreBtn);
        scoreBtn.setBounds(395, 400, 300, 60);
        scoreBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        scoreBtn.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
        		try {
					highscorePage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        	@Override
            public void mouseEntered(MouseEvent me) {
                scoreBtn.setSize(scoreBtn.getWidth()+10, scoreBtn.getHeight()+10);
            }
            
        	@Override 
        	public void mouseExited (MouseEvent e){
        		scoreBtn.setSize(scoreBtn.getWidth()-10, scoreBtn.getHeight()-10);
        	}
        });
        
        
        JLabel exitBtn = new JLabel();
        exitBtn.setSize(200, 50);
        ImageIcon exitBtnIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\ExitButton.png");
        Image exitBtnIconCopy = exitBtnIcon.getImage().getScaledInstance(exitBtn.getWidth(), exitBtn.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon tempexitBtn = new ImageIcon(exitBtnIconCopy);
        exitBtn.setIcon(tempexitBtn);
        exitBtn.setBounds(395, 460, 300, 60);
        exitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        exitBtn.addMouseListener(new MouseAdapter(){
        	public void mouseClicked(MouseEvent e) {
        		exit();
        	}
        	@Override
            public void mouseEntered(MouseEvent me) {
                exitBtn.setSize(exitBtn.getWidth()+10, exitBtn.getHeight()+10);
            }
            
        	@Override 
        	public void mouseExited (MouseEvent e){
        		exitBtn.setSize(exitBtn.getWidth()-10, exitBtn.getHeight()-10);
        	}
        });
        
        	mainmenuPanel.add(play);
        	mainmenuPanel.add(howToBtn);
        	mainmenuPanel.add(scoreBtn);
        	mainmenuPanel.add(exitBtn);
 	     
	         
		BufferedImage splashImage = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png"));
		JLabel screenImage = new JLabel(new ImageIcon(splashImage));
		mainmenuPanel.add(screenImage, BorderLayout.CENTER);
	}
	
}
