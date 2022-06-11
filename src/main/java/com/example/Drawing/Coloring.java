package com.example.Drawing;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import com.example.Main;
import com.example.Framework.DrawPanel;
import com.example.Home.HomePage;
import com.example.Home.ViewImages;
import com.example.LineDraw.LineDraw;
import com.example.Photo.Edit;
import com.example.Repository.MyImages;
import com.example.Repository.SavedImages;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.*;

public class Coloring extends javax.swing.JPanel {

    JButton blankCanvas = new JButton("Blank Canvas");
    JButton personalImage = new JButton("Add Image");

    final JComponent[] dialog = new JComponent[] { blankCanvas, personalImage };

    public static JPopupMenu workMenu = new JPopupMenu();
    public JMenuItem myImages = new JMenuItem("My Images");
    public JMenuItem saved = new JMenuItem("Saved Images");

    private javax.swing.JButton create;
    private javax.swing.JButton home;
    private javax.swing.JPanel coloringOptions;
    private javax.swing.JLabel label;
    private javax.swing.JButton work;

    JPopupMenu popupMenu = new JPopupMenu();
    JMenuItem draw = new JMenuItem("Draw");
    JMenuItem upload = new JMenuItem("Upload");
    JMenuItem line = new JMenuItem("Line Draw");
    String[] colorLists = {"lib//add.png", "lib//baseball.png", "lib//bff.png", "lib//ferriswheel.png", "lib//icecream.png","lib//nascar.png", "lib//summerSol.png", "lib//sunnyDaze.png"};

    public Coloring() {
        try {
            initComponents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
                       
    private void initComponents() throws IOException {

        home = new javax.swing.JButton();
        work = new javax.swing.JButton();
        create = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        coloringOptions = new javax.swing.JPanel();

        JScrollPane scrollFrame = new JScrollPane(coloringOptions);
        coloringOptions.setAutoscrolls(true);
        //coloringOptions.setPreferredSize(new Dimension(468, 515));

        GridLayout lay = new GridLayout(0,2,8,8);
        coloringOptions.setBackground(Color.white);
        coloringOptions.setLayout(lay);

        setBackground(new java.awt.Color(245,254,255));
        setPreferredSize(new java.awt.Dimension(487, 635));

        scrollFrame.setPreferredSize(new Dimension(468, 515));
        scrollFrame.setBackground(new java.awt.Color(245,254,255));

        home.setBackground(new java.awt.Color(255, 255, 255));
        home.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        home.setText("🏠");
        home.setOpaque(true);
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        work.setBackground(new java.awt.Color(255, 255, 255));
        work.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        work.setText("🎨");
        work.setOpaque(true);
        work.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                workActionPerformed(evt);
            }
        });

        create.setBackground(new java.awt.Color(255, 255, 255));
        create.setFont(new java.awt.Font("Lucida Grande", 1, 22)); // NOI18N
        create.setText("➕");
        create.setOpaque(true);
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });

        label.setFont(new java.awt.Font("Academy Engraved LET", 1, 48)); // NOI18N
        label.setForeground(Color.BLACK);
        label.setText("a r t i s t r y");

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Main.iPad.initComponents(new ViewImages());
            }
        });

        GridLayout coloringOptionsLayout = lay;
        coloringOptions.setLayout(coloringOptionsLayout);
        coloringOptions.setBackground(new java.awt.Color(245,254,255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label)
                .addGap(18, 18, 18)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scrollFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE)
                //.addGap(10, 10, 10)
                )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(work, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(create, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(home)))
               .addComponent(scrollFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        blankCanvas.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
              Main.iPad.initComponents(new DrawPanel(new Drawing(null)));
            } 
        });

        personalImage.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                JFileChooser fileChoose = new JFileChooser(".\\src\\image");
                int userInput = fileChoose.showOpenDialog(coloringOptions.getParent());
                Image initialImage = null;
                File pic = null;
                Image img = null;
                    if (userInput == fileChoose.APPROVE_OPTION) {
                        pic = fileChoose.getSelectedFile();
                        try {
                            initialImage = ImageIO.read(pic);
                            ImageIcon ic = new ImageIcon(initialImage);
                            img = ic.getImage();
                            initialImage = img.getScaledInstance(468, 515, java.awt.Image.SCALE_SMOOTH);
                        } catch (IOException j) { j.printStackTrace(); }
                        catch (java.lang.IllegalArgumentException k) { k.printStackTrace(); }
                        Drawing d = new Drawing(img);
                        d.setFile(pic);
                        Main.iPad.initComponents(new DrawPanel(d));
                    }
            } 
        });

            JLabel labelIcon = new JLabel();
            BufferedImage n = null;
            ImageIcon ic = null;
            Image img = null;
            Image newimg = null;
            ImageIcon setIcon = null;

            JLabel[] drawImages = new JLabel[8];
            for (JLabel d : drawImages) {
                d = new JLabel();
                d.setPreferredSize(new Dimension(225, 200));
            }

            ArrayList<ImagePanel> list = new ArrayList<ImagePanel>();

            for (String s : colorLists) {
                try {
                    labelIcon = new JLabel();
                    labelIcon.setPreferredSize(new Dimension(220, 200));
                    n = ImageIO.read(new File(s));         
                    ic = new ImageIcon(n);
                    img = ic.getImage();
                    newimg = img.getScaledInstance(240, 200, java.awt.Image.SCALE_SMOOTH);
                    setIcon = new ImageIcon(newimg);
                    labelIcon.setBorder(new LineBorder(Color.BLACK));
                    labelIcon.setIcon(setIcon);
                    coloringOptions.add(labelIcon);
                    list.add(new ImagePanel(s, labelIcon));
                } catch (javax.imageio.IIOException l) { System.out.println(s); }
                final JLabel currentLabel = labelIcon; 
                final Image toScale = img;
                final String currentPath = s;
                if (s.equals("lib//add.png")) {
                    currentLabel.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent me) {
                            JOptionPane.showConfirmDialog(coloringOptions.getParent(), dialog, "Choose Option", JOptionPane.PLAIN_MESSAGE);
                        }
                        });
                } else {
                    currentLabel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent me) {
                        File pic = new File(currentPath);
                        Drawing d = new Drawing(toScale);
                        d.setFile(pic);
                        Main.iPad.initComponents(new DrawPanel(d));;   
                    }
                    });
                }
            }
       

        draw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new Coloring());
            }
        });
        line.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new DrawPanel(new LineDraw()));
        }
        });
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new DrawPanel(new Edit()));
            }
        });

        myImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new MyImages());
            }
        });
        saved.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Main.iPad.initComponents(new SavedImages());
        }
        });

        
    }
    

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {      
        Main.iPad.initComponents(new HomePage());                               
    }                                    

    private void workActionPerformed(java.awt.event.ActionEvent evt) {               
        workMenu = new JPopupMenu();                                    
        workMenu.add(myImages);    
        workMenu.add(saved);                               
        workMenu.show(work, work.getWidth()/60, work.getHeight()/1);
    }                          
    

    private void createActionPerformed(java.awt.event.ActionEvent evt) {    
        popupMenu = new JPopupMenu();                                   
        popupMenu.add(draw);    
        popupMenu.add(line);  
        popupMenu.add(upload);                               
        popupMenu.show(create, create.getWidth()/60, create.getHeight()/1);
    }     
    
}