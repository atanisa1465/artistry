package com.example.Drawing;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.LineBorder;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.*;

import com.example.Main;
import com.example.Repository.MyImages;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class Drawing extends javax.swing.JPanel {


    private javax.swing.JButton color;
    private javax.swing.JButton erase;
    private javax.swing.JButton pencil;
    private javax.swing.JButton save;
    private javax.swing.JButton shape;
    private javax.swing.JButton sizeP;

    int x2, y2, x1, y1,w,h,xx1,yy1,i=0,size=8;
	MouseMotionAdapter mouse;
	MouseAdapter mouseA;
    Graphics2D graphics2D;
    Image image;

    JPopupMenu popupMenu1 = new JPopupMenu();
    JPopupMenu popupMenu2 = new JPopupMenu();

    JMenuItem rectangleShape = new JMenuItem("Rectangle");
    JMenuItem circle = new JMenuItem("Circle");
    JMenuItem line = new JMenuItem("Line");

    JMenuItem one = new JMenuItem("1");
    JMenuItem two = new JMenuItem("2");
    JMenuItem three = new JMenuItem("3");
    JMenuItem four = new JMenuItem("4");

    File backgroundImg = null;
    Image iconToScale = null;

    public Drawing(Image iconScale) {

        iconToScale = iconScale;

        removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
		}};
		mouse=new MouseMotionAdapter(){
		public void mouseDragged(MouseEvent e){
            x2 = e.getX();
            y2 = e.getY();
            if(graphics2D != null)
                for(int c=0;c<=(i/2);c++){
                    graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
                    graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
                }
            repaint();
            x1 = x2;
            y1 = y2;
		}};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);
        initComponents();
    }

    private BufferedImage getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 20, w, h-20, null);
        g2.dispose();
        return resizedImg;
    }
    

    public void setFile(File f) { 
        Image myImg = null;
        try {
            myImg = ImageIO.read(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        image = getScaledImage(myImg, 468, 560);     
        repaint();
        graphics2D = (Graphics2D) image.getGraphics();
        graphics2D.fillRect(0, 30, getSize().width, getSize().height-30);
        graphics2D.setPaint(Color.black);
        paintComponent(graphics2D);
    }

    public void reset() {
        pencil.setBackground(Color.white);
        shape.setBackground(Color.white);
        sizeP.setBackground(Color.white);
        color.setBackground(Color.white);
        erase.setBackground(Color.white);
        save.setBackground(Color.white);
    }

    public void hide() {
        pencil.setVisible(false);
        shape.setVisible(false);
        sizeP.setVisible(false);
        color.setVisible(false);
        erase.setVisible(false);
        save.setVisible(false);
    }
                    
    private void initComponents() {

        pencil = new javax.swing.JButton();
        shape = new javax.swing.JButton();
        sizeP = new javax.swing.JButton();
        color = new javax.swing.JButton();
        erase = new javax.swing.JButton();
        save = new javax.swing.JButton();

        pencil.setBorder(new LineBorder(Color.BLACK));
        shape.setBorder(new LineBorder(Color.BLACK));
        sizeP.setBorder(new LineBorder(Color.BLACK));
        color.setBorder(new LineBorder(Color.BLACK));
        erase.setBorder(new LineBorder(Color.BLACK));
        save.setBorder(new LineBorder(Color.BLACK));

        pencil.setOpaque(true);
        shape.setOpaque(true);
        sizeP.setOpaque(true);
        color.setOpaque(true);
        erase.setOpaque(true);
        save.setOpaque(true);

        this.setBackground(Color.white);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pencil.setBackground(new java.awt.Color(255, 255, 255));
        pencil.setText("Pencil");
        pencil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pencilActionPerformed(evt);
            }
        });

        shape.setBackground(new java.awt.Color(255, 255, 255));
        shape.setText("Shape");
        shape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shapeActionPerformed(evt);
            }
        });

        sizeP.setBackground(new java.awt.Color(255, 255, 255));
        sizeP.setText("Size");
        sizeP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        color.setBackground(new java.awt.Color(255, 255, 255));
        color.setText("Color");
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });

        erase.setBackground(new java.awt.Color(255, 255, 255));
        erase.setText("Erase");
        erase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eraseActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(255, 255, 255));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(pencil, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shape, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeP, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(erase, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pencil)
                    .addComponent(shape)
                    .addComponent(sizeP)
                    .addComponent(color)
                    .addComponent(erase)
                    .addComponent(save))
                .addContainerGap(469, Short.MAX_VALUE))
        );
        this.setBackground(Color.white);
        
        rectangleShape.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repaint();
                removeMouseListener(mouseA);
                removeMouseMotionListener(mouse);
                mouseA=new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    x1 = e.getX();
                    y1 = e.getY();
                }
                public void mouseDragged(MouseEvent e){
                    x2 = e.getX();
                    y2 = e.getY();
                }
                public void mouseReleased(MouseEvent e){
                    x2 = e.getX();
                    y2 = e.getY();
                    if(graphics2D != null)
                    w=Math.abs(x1-x2);
                    h=Math.abs(y1-y2);
                    xx1=Math.min(x1,x2);
                    yy1=Math.min(y1,y2);
                    for(int c=0;c<=(i/2);c++){
                    graphics2D.drawRect(xx1+c, yy1+c, w, h);
                    graphics2D.drawRect(xx1-c, yy1-c, w, h);
                    }
                    repaint();
                    x1 = x2;
                    y1 = y2;
                }
                }; addMouseListener(mouseA);
            }
        });

        circle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMouseListener(mouseA);
                removeMouseMotionListener(mouse);
                mouseA=new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    x1 = e.getX();
                    y1 = e.getY();
                }
                public void mouseDragged(MouseEvent e){
                    x2 = e.getX();
                    y2 = e.getY();
                }
                public void mouseReleased(MouseEvent e){
                    x2 = e.getX();
                    y2 = e.getY();
                    if(graphics2D != null)
                    w=Math.abs(x1-x2);
                    h=Math.abs(y1-y2);
                    xx1=Math.min(x1,x2);
                    yy1=Math.min(y1,y2);

                    for(int c=0;c<=(i/2);c++){
                        graphics2D.drawOval(xx1+c, yy1+c,w,h);
                        graphics2D.drawOval(xx1-c, yy1-c,w,h);
                    }
                    repaint();
                    x1 = x2;
                    y1 = y2;
                }
                }; addMouseListener(mouseA);
            } });

        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeMouseListener(mouseA);
			removeMouseMotionListener(mouse);
			mouseA=new MouseAdapter(){
				public void mousePressed(MouseEvent e){
					x1 = e.getX();
					y1 = e.getY();
				}
				public void mouseReleased(MouseEvent e){
					x2 = e.getX();
					y2 = e.getY();
					if(graphics2D != null)
						for(int c=0;c<=(i/2);c++){
							graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
							graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
						}
					repaint();
					x1 = x2;
					y1 = y2;
				}
			}; addMouseListener(mouseA);
            }
        });

        one.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch(1){
                    case 1:
                        i=0;
                        break;
                    case 2:
                        i=2;
                        break;
                    case 3:
                        i=4;
                        break;
                    case 4:
                        i=6;
                        break;
                }
            }
        });
        two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch(2){
                    case 1:
                        i=0;
                        break;
                    case 2:
                        i=2;
                        break;
                    case 3:
                        i=4;
                        break;
                    case 4:
                        i=6;
                        break;
                }
            }
        });
        three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch(3){
                    case 1:
                        i=0;
                        break;
                    case 2:
                        i=2;
                        break;
                    case 3:
                        i=4;
                        break;
                    case 4:
                        i=6;
                        break;
                }
            }
        });
        four.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch(4){
                    case 1:
                        i=0;
                        break;
                    case 2:
                        i=2;
                        break;
                    case 3:
                        i=4;
                        break;
                    case 4:
                        i=6;
                        break;
                }
            }
        });
    }
    
    public void paintComponent(Graphics g){

		if(image == null) {
            image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			//graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			graphics2D.setPaint(Color.white);
            graphics2D.fillRect(0, 0, this.getSize().width, this.getSize().height);
            graphics2D.setPaint(Color.black);
            repaint();
        }
        g.drawImage(image, 0, 0, null);
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

    ArrayList<javax.swing.JButton> myButtons = new ArrayList<>();

    public void printScreen(JPanel panel) throws AWTException {    
        myButtons.add(pencil);
        myButtons.add(shape);
        myButtons.add(sizeP);
        myButtons.add(color);
        myButtons.add(erase);
        myButtons.add(save);

        for (int i = 0; i < myButtons.size(); i++) {
            myButtons.get(i).setVisible(false);
        }

        System.out.println("Outyet?");
        Point p = (panel.getLocationOnScreen());
        Dimension dim = panel.getSize();
        Rectangle rect = new Rectangle(p, dim);
        Robot robot = new Robot();  
        System.out.println("1?");
        countScreen++;
        robot.createScreenCapture(rect);
        System.out.println("2?");
    }

    public BufferedImage printScreenMain(JPanel panel) throws AWTException {    
        Point p = (panel.getLocationOnScreen());
        Point pointMy = new Point((int)p.getX(), (int)p.getY()+40);
        Dimension dim = new Dimension(panel.getWidth(), panel.getHeight()-40);
        Rectangle rect = new Rectangle(pointMy, dim);
        Robot robot = new Robot();  
        return robot.createScreenCapture(rect);
    }

    int countScreen = 0; 

    private void saveActionPerformed(java.awt.event.ActionEvent evt) throws Exception {          

        MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("artistry");
        MongoCollection<Document> col = database.getCollection("photos");

        Main.numPhoto = (int) col.countDocuments();

        boolean add = true;
        while (add) {
            File f = new File(""+Main.numPhoto);
            BufferedImage bufImage = null;
		    bufImage = printScreenMain(this);

            try { ImageIO.write(bufImage, "png", f); } 
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
                .append("title",  "Untitled")
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
    }                                    

    private void pencilActionPerformed(java.awt.event.ActionEvent evt) {     
        reset();
        pencil.setBackground(new java.awt.Color(235, 241, 255));                                  
        removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		};

		mouse = new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=(i/2);c++){
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}

		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);
    }                                      

    private void shapeActionPerformed(java.awt.event.ActionEvent evt) {    
        reset();
        shape.setBackground(new java.awt.Color(235, 241, 255));                                                         
        popupMenu1 = new JPopupMenu();
        popupMenu1.add(rectangleShape);    
        popupMenu1.add(circle);  
        popupMenu1.add(line);  
        popupMenu1.show(shape, shape.getWidth()/60, shape.getHeight()/1);
    }                                     

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {  
        popupMenu1 = new JPopupMenu();                                                         
        popupMenu2.add(one);    
        popupMenu2.add(two);  
        popupMenu2.add(three);
        popupMenu2.add(four);   
        popupMenu2.show(sizeP, sizeP.getWidth()/60, sizeP.getHeight()/1);
    }                                    

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {  
        Color color = JColorChooser.showDialog(this.getParent(), "Select a color", Color.black);    
        graphics2D.setPaint(color);
		repaint();
    }                                     

    private void eraseActionPerformed(java.awt.event.ActionEvent evt) {    
        reset();
        erase.setBackground(new java.awt.Color(235, 241, 255));                                        
        graphics2D.setPaint(Color.white);
		removeMouseListener(mouseA);
		removeMouseMotionListener(mouse);
		mouseA=new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				x1 = e.getX();
				y1 = e.getY();
			}
		};
		mouse=new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				x2 = e.getX();
				y2 = e.getY();
				if(graphics2D != null)
					for(int c=0;c<=12;c++){
						graphics2D.setPaint(Color.white);
						graphics2D.drawLine(x1-c, y1-c, x2-c, y2-c);
						graphics2D.drawLine(x1+c, y1+c, x2+c, y2+c);
						graphics2D.setPaint(Color.black);
					}
				repaint();
				x1 = x2;
				y1 = y2;
			}
		};
		addMouseMotionListener(mouse);
		addMouseListener(mouseA);
		i=0;
    }                                     

}