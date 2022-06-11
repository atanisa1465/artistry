package com.example.Photo;

import javax.imageio.ImageIO;
import javax.swing.border.LineBorder;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.image.RescaleOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.awt.image.BufferedImageOp;

import com.example.Main;
import com.example.Repository.MyImages;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class Edit extends javax.swing.JPanel {

    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem original = new JMenuItem("Revert to Original");
    JMenuItem undo = new JMenuItem("Undo");
    JMenuItem flipV = new JMenuItem("Flip Vertically");
    JMenuItem flipH = new JMenuItem("Flip Horizontally");
    JMenuItem bright = new JMenuItem("Add Brightness");
    JMenuItem contrast = new JMenuItem("Add Contrast");
    JMenuItem sharp = new JMenuItem("Add Sharpness");
    JMenuItem invertColor = new JMenuItem("Invert Color");
    JMenuItem gray = new JMenuItem("Gray Scale");
    File pic;
    static BufferedImage initialImage, lastImage, newImage;
    public static int i = 0;

    public Edit() {
        initComponents();

    }
                        
    private void initComponents() {

        open = new javax.swing.JButton();
        open.setBorder(new LineBorder(Color.BLACK));
        open.setSize(new Dimension(106, 55));
        changeLine = new javax.swing.JButton();
        changeLine.setBorder(new LineBorder(Color.BLACK));
        changeLine.setSize(new Dimension(106, 55));
        saveButton = new javax.swing.JButton();
        saveButton.setBorder(new LineBorder(Color.BLACK));
        saveButton.setSize(new Dimension(106, 55));
        jLabelIcon = new javax.swing.JLabel();
        jLabelIcon.setBorder(new LineBorder(Color.BLACK));

        setBackground(new java.awt.Color(255, 255, 255));

        open.setText("Open Image");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        changeLine.setText("Add Edits");
        changeLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeLineActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    saveButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jLabelIconLayout = new javax.swing.GroupLayout(jLabelIcon);
        jLabelIcon.setLayout(jLabelIconLayout);
        jLabelIconLayout.setHorizontalGroup(
            jLabelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jLabelIconLayout.setVerticalGroup(
            jLabelIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(open, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeLine, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(open)
                    .addComponent(changeLine)
                    .addComponent(saveButton))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        

        original.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                newImage = copyImage(initialImage);
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try { paintImage(lastImage); } catch (IOException e) {}
                BufferedImage temp = copyImage(newImage);;
                newImage = copyImage(lastImage);;
                lastImage = copyImage(temp);
            }
        });

        flipV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                int y = (newImage.getHeight()) / 2;
                int y1 = y - 1;
                int y2 = y + 1;
                int x = 0;
                while (x < newImage.getWidth()) {
                    while (y1 > 0) {
                        int num = newImage.getRGB(x, y2);
                        newImage.setRGB(x, y2, newImage.getRGB(x, y1));
                        newImage.setRGB(x, y1, num);
                        y1--;
                        y2++;
                    }
                    y1 = y - 1;
                    y2 = y + 1;
                    x++;
                } try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        flipH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                int x = (newImage.getWidth()) / 2;
                int x1 = x - 1;
                int x2 = x + 1;
                int y = 0;
                while (y < newImage.getHeight()) {
                    while (x1 > 0) {
                        int count = newImage.getRGB(x2, y);
                        newImage.setRGB(x2, y, newImage.getRGB(x1, y));
                        newImage.setRGB(x1, y, count);
                        x1--;
                        x2++;
                    }
                    x1 = x - 1;
                    x2 = x + 1;
                    y++;
                }  try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        bright.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                RescaleOp brighterOp = new RescaleOp((float) 1.1, 0, null);
                newImage = brighterOp.filter(newImage,null); 
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        contrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                RescaleOp brighterOp = new RescaleOp((float) 1.2, (float) 20.0, null);
                newImage = brighterOp.filter(newImage,null); 
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        sharp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                Kernel kernel = new Kernel(3, 3, new float[] { -1, -1, -1, -1, 9, -1, -1, -1, -1 });
                BufferedImageOp op = new ConvolveOp(kernel);
                newImage = op.filter(lastImage, null);
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        invertColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                for (int x = 0; x < newImage.getWidth(); x++) {
                    for (int y = 0; y < newImage.getHeight(); y++) {
                        Color old = new Color(newImage.getRGB(x, y));
                        double newRed = 255 - old.getRed();
                        double newGreen = 255 - old.getGreen();
                        double newBlue = 255 - old.getBlue();
                        Color now = new Color((int) newRed, (int) newGreen, (int) newBlue); 
                        newImage.setRGB(x, y, now.getRGB());
                    }
                }
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });

        gray.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastImage = copyImage(newImage);
                for (int x = 0; x < newImage.getWidth(); x++) {
                    for (int y = 0; y < newImage.getHeight(); y++) {
                        Color old = new Color(newImage.getRGB(x, y));
                        double average = (old.getRed() + old.getGreen() + old.getBlue()) / 3;
                        Color now = new Color((int) average, (int) average, (int) average);
                        newImage.setRGB(x, y, now.getRGB());
                    }
                }
                try { paintImage(newImage); } catch (IOException e) {}
            }
        });
    }                      

    private void openActionPerformed(java.awt.event.ActionEvent evt) {                                     
        JFileChooser fileChoose = new JFileChooser(".\\src\\image");
        int userInput = fileChoose.showOpenDialog(open.getParent());
            if (userInput == fileChoose.APPROVE_OPTION) {
                pic = fileChoose.getSelectedFile();
                try {
                    initialImage = ImageIO.read(pic);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                catch (java.lang.IllegalArgumentException e) {
                    e.printStackTrace();
                }
                lastImage = copyImage(initialImage);
                newImage = copyImage(initialImage);
            }
           try { paintImage(newImage); } 
           catch (IOException e) { e.printStackTrace(); openActionPerformed(evt); }
           catch (java.lang.IllegalArgumentException j)  { j.printStackTrace(); openActionPerformed(evt); }
    }                                    

    private void changeLineActionPerformed(java.awt.event.ActionEvent evt) { 
        popupMenu = new JPopupMenu();  
        popupMenu.add(original);
        popupMenu.add(undo);
        popupMenu.add(flipV);
        popupMenu.add(flipH);
        popupMenu.add(bright);
        popupMenu.add(contrast);
        popupMenu.add(sharp);
        popupMenu.add(invertColor);
        popupMenu.add(gray);                                        
        popupMenu.show(open, open.getWidth()/60, open.getHeight()/1);
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

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {    
        MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase database = client.getDatabase("artistry");
        MongoCollection<Document> col = database.getCollection("photos");

        Main.numPhoto = (int) col.countDocuments();

        boolean add = true;
        while (add) {
            File f = new File(""+Main.numPhoto);

            try { ImageIO.write(newImage, "png", f); } 
            catch (IOException e) { e.printStackTrace(); }

            byte[] imgSave = null;
            try { imgSave = LoadImage(""+Main.numPhoto); } 
            catch (Exception e) { saveButtonActionPerformed(evt); }

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
    
    public void hide() {
        open.setVisible(false);
        changeLine.setVisible(false);
        saveButton.setVisible(false);
    }
    
    public static void paintImage(ImageIcon image) throws IOException {
        Image img = image.getImage();
        Image newimg = img.getScaledInstance(455, 468,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon setIcon = new ImageIcon(newimg);
        jLabelIcon.setBorder(new LineBorder(Color.BLACK));
        jLabelIcon.setIcon(setIcon);
    }

    public static void paintImage(BufferedImage image) throws IOException {
        ImageIcon newIcon = new ImageIcon(image);
        paintImage(newIcon);
    }

    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    private javax.swing.JButton changeLine;
    private javax.swing.JButton saveButton;
    private static javax.swing.JLabel jLabelIcon;
    private javax.swing.JButton open;
}