package com.example.LineDraw;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

import com.example.Main;
import com.example.Photo.Edit;
import com.example.Repository.MyImages;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.*;  

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

//Parts of this class are from a YouTube Tutorial

public class LineDraw extends JPanel implements Runnable {

	boolean left;
	boolean right;
	boolean up;
	boolean down;
	boolean reset;
	boolean image;

	JButton changeColor = new JButton("Color");
	
	
	boolean iaState = false;
	int cptIA;
	int maxOccurences =10;
	int direction; //0:right, 1: left, 2: up, 3: down

	BufferedImage tmp;
	Graphics2D g2;
	boolean canWrite;
	boolean needImage = false;
	boolean firstTime = true;

	int hexaR;
	int hexaV;
	int hexaB;

	int nbOfPoints;

	boolean running = true;

	final int FPS = 60;
	private int currentFPS = FPS;
	int rate = 1;

	private Thread thread;

	private Color c;
	
	private int x;
	private int y;
	JButton save;

	private KeyMethods keyMap = new KeyMethods();
	public KeyMethods getKeyMap() { return keyMap; }

	public LineDraw() {
		// Color color = JColorChooser.showDialog(save.getParent(), "Select a background color", Color.black);    
        // c = color;
		setSize(new Dimension(468, 515));
		addKeyListener(keyMap);
		x = this.getWidth() / 2;
		y = this.getHeight() / 2;
		nbOfPoints = 4;
		hexaR = 255;
		hexaV = 0;
		hexaB = 0;
		save = new JButton("Save");
		//save.setBorder(new LineBorder(Color.BLACK));
        save.setSize(new Dimension(110, 65));
		save.setBackground(Color.white);
		//save.setOpaque(true);
		//save.setBorderPainted(false);
		this.add(save);
		Color color = JColorChooser.showDialog(save.getParent(), "Select a background color", Color.black);    
        c = color;
		save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					saveActionPerformed(evt);
				} catch (Exception e) {
					e.printStackTrace();
				}
            }
        });
		start();
	}
	
	public LineDraw (boolean iaState) {
		this();
		this.iaState = iaState;
		keyMap.iaActivated = true;
		cptIA = 0;
		Random r = new Random();
		maxOccurences = r.nextInt(20)+5;
	}

	private void handleControl() {
		iaState = keyMap.isIAActivated();
		if (iaState){ updateDirectionIA(); }
        else {
			right = keyMap.isRight();
			left = keyMap.isLeft();
			up = keyMap.isUp();
			down = keyMap.isDown();
		}
		reset = keyMap.hasToReset();
		canWrite = keyMap.canWrite();
		nbOfPoints = 4;
		currentFPS = FPS + keyMap.getFPSChanger();
	}

	public void start() {
		this.setBackground(c);
		thread = new Thread(this);
		thread.start();
	}

	public void addNotify() {
		super.addNotify();
		requestFocus();
	}

	public static byte[] LoadImage(String filePath) throws Exception {
        File file = new File(filePath);
        int size = (int)file.length();
        byte[] buffer = new byte[size];
        FileInputStream in = new FileInputStream(file);
        in.read(buffer);
        in.close();
        return buffer;
    }

	public static BufferedImage printScreen(JPanel panel) throws AWTException {     
        Point p = (panel.getLocationOnScreen());
        Point pointMy = new Point((int)p.getX(), (int)p.getY()+40);
        Dimension dim = new Dimension(panel.getWidth(), panel.getHeight()-40);
        Rectangle rect = new Rectangle(pointMy, dim);
        Robot robot = new Robot();  
        return robot.createScreenCapture(rect);
    }

	private void saveActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                     
        MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("artistry");
        MongoCollection<Document> col = database.getCollection("photos");
		save.setVisible(false);
        Main.numPhoto = (int) col.countDocuments();

        boolean add = true;
        while (add) {
            File f = new File(""+Main.numPhoto);

		    BufferedImage newImage = printScreen(this);

            try { ImageIO.write(newImage, "png", f); } 
            catch (IOException e) { e.printStackTrace(); }

            byte[] imgSave = null;
            try { imgSave = LoadImage(""+Main.numPhoto); } 
            catch (Exception e) { saveActionPerformed(evt); }

			ArrayList<String> usersSaved = new ArrayList<String>();
            
            try {
                Document doc = new Document("_id", ""+Main.numPhoto)
                .append("val", imgSave)
                .append("user", Main.user.getUsername())
                .append("posted", false)
				.append("title",  "")
                .append("likes",0)
                .append("tada", 0)
                .append("cool", 0)
				.append("saved", usersSaved);
                col.insertOne(doc);
                client.close();
                add = false;
            } catch (com.mongodb.MongoWriteException e) {
                Main.numPhoto++;
            }
		}
		client.close();
            Main.numPhoto++;
			Main.iPad.initComponents(new MyImages());
        //}
    }  

	// private void saveActionPerformed(java.awt.event.ActionEvent evt) throws Exception {                                     
    //     MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
    //     MongoDatabase database = client.getDatabase("artistry");
    //     MongoCollection<Document> col = database.getCollection("photos");
    //     App.numPhoto = (int) col.countDocuments();

    //     boolean add = true;
    //     while (add) {
    //         File f = new File(""+App.numPhoto);

	// 	    BufferedImage newImage = printScreen(this);

    //         try { ImageIO.write(newImage, "png", f); } 
    //         catch (IOException e) { e.printStackTrace(); }

    //         byte[] imgSave = null;
    //         try { imgSave = LoadImage(""+App.numPhoto); } 
    //         catch (Exception e) { saveActionPerformed(evt); }
            
    //         try {
    //             Document doc = new Document("_id", ""+App.numPhoto)
    //             .append("val", imgSave)
    //             .append("user", App.user.getUsername())
    //             .append("posted", false)
	// 			.append("title",  "Untitled")
    //             .append("likes",0)
    //             .append("tada", 0)
    //             .append("cool", 0);
    //             col.insertOne(doc);
    //             client.close();
    //             add = false;
    //         } catch (com.mongodb.MongoWriteException e) {
    //             App.numPhoto++;
	// 			System.out.println("Exceptiion");
    //         }
    //         App.numPhoto++;
	// 		App.iPad.initComponents(new MyImages());
    //     }
    // }  

	public void drawOnImage (boolean draw) {
		if (firstTime) {		
			//System.out.println("reset");
			tmp = new BufferedImage(getWidth(), getHeight(),			
					BufferedImage.TYPE_INT_RGB);							
			g2 = tmp.createGraphics();
			g2.setColor(c);
			g2.fillRect(0, 0, this.getWidth(), this.getHeight());
			firstTime = false;
		}
		if (draw) {
			g2.setColor(new Color(hexaR, hexaV, hexaB));
            g2.drawLine(x, y, x, y);
            g2.drawLine(this.getWidth() - x, y, this.getWidth() - x, y);
            g2.drawLine(this.getWidth() - x, this.getHeight() - y, this.getWidth() - x, this.getHeight() - y);
			g2.drawLine(x, this.getHeight() - y, x, this.getHeight() - y);
		}
	}

	public void paintComponent(Graphics g) {
		if (canWrite) {
			drawOnImage(true);
			g.drawImage(tmp, 0, 0, this.getWidth(), this.getHeight(), Color.BLACK, null);
		} else {																		
			drawOnImage(false);
			g.drawImage(tmp, 0, 0, this.getWidth(), this.getHeight(), Color.BLACK, null);
		}	
        g.drawLine(x, y, x, y);		
        g.drawLine(this.getWidth() - x, y, this.getWidth() - x, y);		
        g.drawLine(this.getWidth() - x, this.getHeight() - y, this.getWidth() - x, this.getHeight() - y);						
	    g.drawLine(x, this.getHeight() - y, x, this.getHeight()-y);

		g2.setColor(new Color(hexaR, hexaV, hexaB));
	}

	public void updateColor() {
		hexaR = hexaR % 256;
		hexaV = hexaV % 256;
		hexaB = hexaB % 256;
		if (hexaR == 255 && hexaV < 255) {
			hexaV++;
			if (hexaB > 0) hexaB--;
		} else if (hexaV == 255 && hexaB < 255) {
			hexaB++;
			if (hexaR > 0) hexaR--;
		} else if (hexaB == 255 && hexaR < 255) {
			hexaR++;
			if (hexaV > 0) hexaV--;
		}
	}

	
	
	public void saveImage(String nomImage){
		File f = new File(""+Edit.i);
		Edit.i++;
		try {
			ImageIO.write(tmp, "png", f);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void updateDirectionIA(){
		Random r = new Random();
		if (cptIA%maxOccurences == 0){
			maxOccurences = r.nextInt(10)*3+30;
			int direction = r.nextInt(4);
			switch(direction){
			case 0:
				left = true;
				up = false;
				right = false;
				down = false;
				break;
			case 1: 
				left = false;
				up = true;
				right = false;
				down = false;
				break;
			case 2:
				left = false;
				up = false;
				right = true;
				down = false;
				break;
			case 3:
				left = false;
				up = false;
				right = false;
				down = true;
				break;
			}
			direction = r.nextInt(4);
			switch(direction){
			case 0:
				if(!right)
					left = true;
				break;
			case 1: 
				if(!down)
					up = true;
				break;
			case 2:
				if(!left)
					right = true;
				break;
			case 3:
				if(!up)
					down = true;
				break;
			}
		}
		cptIA++;
	}
	
	boolean isOut(){
		return x > getWidth() || y > getHeight() || y < 0 || x < 0 ;
	}

	@Override
	public void run() {
		while (running) {
			updateColor();
			handleControl();
			if(isOut() && iaState){
				reset = true;
				x = getWidth()/2;
				y = getHeight()/2;
			}

			if (left) x -= rate;
			if (right) x += rate;
			if (up) y -= rate;
			if (down) y += rate;
			if (reset) { firstTime = true; reset = false; }
			repaint();
			try { Thread.sleep(1000 / currentFPS); } 
            catch (InterruptedException e) { e.printStackTrace(); }
		}

	}
}