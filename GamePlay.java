package com.game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.ThreadLocalRandom;


public class GamePlay {

    int count=0;
    final static int WIDTH = 983, HEIGHT = 622;
	final static Dimension gameDimension = new Dimension(WIDTH, HEIGHT);
	ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	
	
	
	
    GamePlay() throws IOException{
    	new gamePlayGUI();
    }


class gamePlayGUI{
    JFrame gamePlayFrame = new JFrame();
    int count;
    String[] array;
    char[] guessWord;
    char clickedValue;
    int index;
    char userGuess;
    int x_left;
    int x_right;
    
    gamePlayGUI(int x) {
    	
    }
    
    gamePlayGUI() throws IOException{
        retrieveArrayOfCharac();
        initComponents();
    }
    
    void retrieveArrayOfCharac() throws IOException{
        array = shuffleArray(createArray());
        Stack stack = new Stack();
        for(int i=0; i<array.length; i++){
            stack.push(array[i]);
            System.out.println(array[i]);
        } 
        guessWord = toCharArray(stack.pop().toString());
        for(int i=0; i<guessWord.length; i++){
            count++;
            System.out.println("KIM: " + guessWord[i]);
        }
    }
    
    
    static char[] toCharArray(String str){
        char[] ch = str.toCharArray();
        return ch;
    }
    
    
    
    
    
    static String[] createArray() throws IOException{
        java.util.List<String> listOfStrings
            = new ArrayList<String>();
 
        listOfStrings 
            = Files.readAllLines(Paths.get("C:\\\\Projects\\\\Timeslice\\\\resources\\\\source.txt"));

        String[] array
            = listOfStrings.toArray(new String[0]);
        return array;
    }
     
    
    static String[] shuffleArray(String[] ar)
  {
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      String a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
    return ar;
  }
    
    void createBlankSpaceArray(){
        int x_odd_center = 461;
        int x_even_center = 491;
        int y = 280;
        int order = 0;
        int x_left;
        int x_right;
        
        if(count%2==0){
            x_left 	= x_even_center-65;
            x_right = x_even_center+5;
            for(int i = 0; i < count; i++){
                if(i%2 == 0){
                    gamePlayFrame.add(new blankspace(++order, x_left, y, "__"));
                    System.out.println("Even left: " + x_left);
                    x_left-=70;
                }
                else{
                    gamePlayFrame.add(new blankspace(++order,x_right, y, "__"));
                    System.out.println("Even right: " + x_right);
                    x_right+=70;
                }
            }
        }else{
            x_left=x_odd_center-70;
            x_right=x_odd_center+70;
            for(int i=0; i<count; i++){
                if(i==0){
                    gamePlayFrame.add(new blankspace(++order,x_odd_center, y, "__"));
                }
                else if(i%2==0){
                    gamePlayFrame.add(new blankspace(++order, x_left, y, "__"));
                    x_left-=70;
                }
                else{
                    gamePlayFrame.add(new blankspace(++order, x_right, y, "__"));
                    x_right+=70;
                }
            }
        }
        
    }
    
    void initComponents() throws IOException{
        //gamePlayFrame.setSize(983, 622);
        gamePlayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gamePlayFrame.setTitle("Time Slice");
        gamePlayFrame.setLayout(null);
        
        Panel gamePlayPanel = new Panel();
        gamePlayPanel.setLayout(new BorderLayout()); 
        gamePlayPanel.setPreferredSize(gameDimension);
        gamePlayFrame.setContentPane(gamePlayPanel);
         
        JLabel point = new JLabel();
        point.setText("Points: 0");
        point.setSize(40, 30);
        point.setFont(new Font("Arial", Font.BOLD, 25));
        point.setBounds(800, 50, 150, 40);
        point.setForeground(Color.WHITE);
        gamePlayFrame.add(point);
        //gamePlayFrame.setLocationRelativeTo(null);
        
        createBlankSpaceArray();
        
        characterBtn btnA = new characterBtn();
        btnA.setText("A");
        btnA.setBounds(171, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnA);
        /*gamePlayFrame.add(new blankspace(0, 0, Character.toString(userGuess)));
        btnA.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        			userGuess = btnA.getText().charAt(0);
        			System.out.println(userGuess);
        			
        			//if(ifExists(userGuess)!=false) {
        			//	System.out.println(ifExists(userGuess));
        			System.out.println(index);
        			System.out.println(userGuess);
        			System.out.println(x_left);
        			//gamePlayFrame.add(new Label("KIM NIQUE"));
        			//gamePlayFrame.add(new blankspace(0, 0, Character.toString(userGuess)));
        			//}else {
        			//	System.out.println(ifExists(userGuess));
        			//}
        		}
        });*/
        
        characterBtn btnB = new characterBtn();
        btnB.setText("B");
        btnB.setBounds(236, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnB);
        
        characterBtn btnC = new characterBtn();
        btnC.setText("C");
        btnC.setBounds(301, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnC);
        btnC.setBackground(Color.red);
        
        characterBtn btnD = new characterBtn();
        btnD.setText("D");
        btnD.setBounds(366, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnD);
        
        characterBtn btnE = new characterBtn();
        btnE.setText("E");
        btnE.setBounds(431, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnE);
        
        characterBtn btnF = new characterBtn();
        btnF.setText("F");
        btnF.setBounds(496, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnF);
        
        characterBtn btnG = new characterBtn();
        btnG.setText("G");
        btnG.setBounds(561, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnG);
        
        characterBtn btnH = new characterBtn();
        btnH.setText("H");
        btnH.setBounds(626, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnH);
        
        characterBtn btnI = new characterBtn();
        btnI.setText("I");
        btnI.setBounds(691, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnI);
        
        characterBtn btnJ = new characterBtn();
        btnJ.setText("J");
        btnJ.setBounds(756, 345, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnJ);

        characterBtn btnK = new characterBtn();
        btnK.setText("K");
        btnK.setBounds(171, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnK);
        
        characterBtn btnL = new characterBtn();
        btnL.setText("L");
        btnL.setBounds(236, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnL);
        
        characterBtn btnM = new characterBtn();
        btnM.setText("M");
        btnM.setBounds(301, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnM);
        
        characterBtn btnN = new characterBtn();
        btnN.setText("N");
        btnN.setBounds(366, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnN);
        
        characterBtn btnO = new characterBtn();
        btnO.setText("O");
        btnO.setBounds(431, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnO);
        
        characterBtn btnP = new characterBtn();
        btnP.setText("P");
        btnP.setBounds(496, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnP);
        //btnP.setVisible(true);
        
        characterBtn btnQ = new characterBtn();
        btnQ.setText("Q");
        btnQ.setBounds(561, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnQ);
        //btnQ.setVisible(true);
        
        characterBtn btnR = new characterBtn();
        btnR.setText("R");
        btnR.setBounds(626, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnR);
        
        characterBtn btnS = new characterBtn();
        btnS.setText("S");
        btnS.setBounds(691, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnS);
        
        characterBtn btnT = new characterBtn();
        btnT.setText("T");
        btnT.setBounds(756, 400, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnT);
        
        characterBtn btnU = new characterBtn();
        btnU.setText("U");
        btnU.setBounds(296, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnU);
        
        characterBtn btnV = new characterBtn();
        btnV.setText("V");
        btnV.setBounds(361, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnV);
        
        characterBtn btnW = new characterBtn();
        btnW.setText("W");
        btnW.setBounds(426, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnW);
        
        characterBtn btnX = new characterBtn();
        btnX.setText("X");
        btnX.setBounds(491, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnX);
        
        characterBtn btnY = new characterBtn();
        btnY.setText("Y");
        btnY.setBounds(556, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnY);
        
        characterBtn btnZ = new characterBtn();
        btnZ.setText("Z");
        btnZ.setBounds(621, 455, btnA.getWidth(), btnA.getHeight());
        gamePlayFrame.add(btnZ);
        
        JLabel time_slice = new JLabel();
        JLabel CPU = new JLabel();
        JLabel queue = new JLabel();
        
        ImageIcon slice = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\index.png");
        time_slice.setSize(300, 250);
        Image imageCopy = slice.getImage().getScaledInstance(time_slice.getWidth(), time_slice.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon i = new ImageIcon(imageCopy);
        time_slice.setIcon(i); 
        time_slice.setBounds(335, 20, 400, 250);
        
        ImageIcon CPUIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\CPU.png");
        CPU.setSize(160, 170);
        Image CPUIconCopy = CPUIcon.getImage().getScaledInstance(CPU.getWidth(), CPU.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon CPUImage = new ImageIcon(CPUIconCopy);
        CPU.setIcon(CPUImage);
        CPU.setBounds(650, 90, 160, 170);
        
        ImageIcon queueIcon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\ReadyQueue.png");
        queue.setSize(200, 150);
        Image queueIconCopy = queueIcon.getImage().getScaledInstance(queue.getWidth(), queue.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon queueImage = new ImageIcon(queueIconCopy);
        queue.setIcon(queueImage);
        queue.setBounds(120, 30, 200, 150);
        
        BufferedImage splashImage = ImageIO.read(new File("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png"));
		JLabel screenImage = new JLabel(new ImageIcon(splashImage));
		
		
        
        gamePlayFrame.add(time_slice);
        gamePlayFrame.add(CPU);
        gamePlayFrame.add(queue);
        gamePlayFrame.add(screenImage, BorderLayout.CENTER);
        
        btnZ.setVisible(true);
        gamePlayFrame.pack();
        gamePlayFrame.setResizable(false);
        gamePlayFrame.setLocationRelativeTo(null);
        gamePlayFrame.setVisible(true);
        
        System.out.print(labelList.get(2).getLocation().x);
       
    }
    
   

boolean ifExists(char ch) {
	for(int i=0; i<guessWord.length; i++) {
		if(guessWord[i]==ch) {
			index=i;
			return true;
		}
	}
	return false;
}
    
    
}

class characterBtn extends JButton{
    
	private static final long serialVersionUID = 1290812046233637979L;
	char[] guessWord;
	int index;
	gamePlayGUI gamePlayClass = new gamePlayGUI(1);
	characterBtn(char[] guessWord){
		this.guessWord = guessWord;
	}
	characterBtn() throws IOException{
        this.setSize(55, 45);
        this.setFont(new Font("Arial", Font.BOLD, 25));
        this.setBorder(null);
        this.setFocusPainted(false);
        this.guessWord=gamePlayClass.guessWord;
        this.addMouseListener(new MouseAdapter(){
        	
        	public void mouseClicked(MouseEvent e) {
    			String charGuess = ((JButton)e.getSource()).getText();
    			System.out.println(charGuess);
    			
    		}
    		
    			@Override 
    			public void mouseEntered(MouseEvent e) {
    				//this.setBackground(Color.gray);
    				e.getComponent().setBackground(Color.gray);
    		}
    			@Override 
    			public void mouseExited (MouseEvent e){
    				e.getComponent().setBackground(null);
    		}
    });}
        
    
	
	
	
}

class blankspace extends JLabel{
   
	private static final long serialVersionUID = 7371394761947259539L;

	blankspace(int placeOrder, int x, int y, String str){
        this.setFont(new Font("Cooper Black", Font.BOLD, 40));
        this.setText(str);
        this.setForeground(Color.WHITE);
        this.setBounds(x, y, 60, 40);
        System.out.println(placeOrder + " " + x + " " + y);
        labelList.add(this);
    }
	
}


class Panel extends JPanel{
    
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
        ImageIcon icon = new ImageIcon("C:\\\\Projects\\\\TimeSli\\\\image\\\\2.png");
        this.setLayout(new BorderLayout());
        g.drawImage(icon.getImage(), 0, 0, 1000, 600, null);
    	}
	}
}
