package com.example.Repository;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.*;

import com.example.Main;
import com.example.Drawing.Coloring;
import com.example.Framework.DrawPanel;
import com.example.Home.HomePage;
import com.example.Home.ViewImages;
import com.example.LineDraw.LineDraw;
import com.example.Photo.Edit;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.bson.types.Binary;

public class MyImages extends javax.swing.JPanel {

    private javax.swing.JButton create;
    private javax.swing.JButton home;
    private javax.swing.JPanel galleryPanel;
    private javax.swing.JLabel label;
    private javax.swing.JButton work;
    private ArrayList<ImageCards> imageShowcase = new ArrayList<ImageCards>();

    public static JPopupMenu workMenu = new JPopupMenu();
    public JMenuItem myImages = new JMenuItem("My Images");
    public JMenuItem saved = new JMenuItem("Saved Images");

    public static JPopupMenu popupMenu = new JPopupMenu();
    public JMenuItem draw = new JMenuItem("Draw");
    public JMenuItem upload = new JMenuItem("Upload");
    public JMenuItem line = new JMenuItem("Line Draw");

    public MyImages() {
        initComponents();
    }
                       
    private void initComponents() {

        home = new javax.swing.JButton();
        work = new javax.swing.JButton();
        create = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        galleryPanel = new javax.swing.JPanel();

        JScrollPane scrollFrame = new JScrollPane(galleryPanel);
        galleryPanel.setAutoscrolls(true);
        scrollFrame.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);


        scrollFrame.setBorder(BorderFactory.createEmptyBorder());

        GridLayout lay = new GridLayout(0,2,4,8);
        galleryPanel.setBackground(new java.awt.Color(245,254,255));
        galleryPanel.setLayout(lay);

        setBackground(new java.awt.Color(245,254,255));
        setPreferredSize(new java.awt.Dimension(487, 635));

        scrollFrame.setPreferredSize(new Dimension(468, 515));

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

        GridLayout galleryPanelLayout = lay;
        galleryPanel.setLayout(galleryPanelLayout);

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

        addPhotos();
        boolean falseTrue = false;
        while (imageShowcase.size() < 3) {
            imageShowcase.add(new ImageCardsCopy());
            falseTrue = true;
        }

        if (falseTrue) {
            for (int i = 0; i < imageShowcase.size(); i++) {
                ImageCards l = imageShowcase.get(i);
                l = imageShowcase.get(i);
                l.setPreferredSize(new Dimension(234, 328));
                galleryPanel.add((JPanel)(l));
            }
        } else {
            for (int i = imageShowcase.size()-1; i >= 0; i--) {
            ImageCards l = imageShowcase.get(i);
                l = imageShowcase.get(i);
                l.setPreferredSize(new Dimension(234, 328));
                galleryPanel.add((JPanel)(l));
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
    
    public void addPhotos() {
        MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
        MongoDatabase db = client.getDatabase("artistry");
        MongoCollection<Document> col = db.getCollection("photos");

        FindIterable<Document> filesStored = col.find();
        MongoCursor<Document> cursor = filesStored.iterator();
        while (cursor.hasNext()) {
            Document picAdd = cursor.next();
            if (((String)(picAdd.get("user"))).equals(Main.user.getUsername())) {
                Binary imgFile = picAdd.get("val", org.bson.types.Binary.class);
                byte[] byteArray = imgFile.getData();
                ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
                BufferedImage bImage2 = null;
                try {
                    bImage2 = ImageIO.read(bis);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ImageIcon ic = new ImageIcon(bImage2);
                Image img = ic.getImage();
                Image newimg = img.getScaledInstance(220, 245, java.awt.Image.SCALE_SMOOTH);
                ImageIcon setIcon = new ImageIcon(newimg);
                ImageCards ourImage = new ImageCards(setIcon, picAdd);
                imageShowcase.add(ourImage);
            }
        }
        client.close();
    }


        //Document userFind = (Document) col.find(new Document("_id", "7")).first();
        //Binary imgFile = userFind.get("val", org.bson.types.Binary.class);


    //    // imgFile.getData();

    //     sbyte[] byteArray = imgFile.getData();

    //     // Bitmap bmp = BitmapFactory.decodeByteArray(imgFile, 0, imgFile.length);
    //     // ImageView img = new ImageView(this);
    //     // img.setImageBitmap(bmp);
        
    //     ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
    //     BufferedImage bImage2 = ImageIO.read(bis);

    //     //n = ImageIO.read(new File(s));         
    //     ImageIcon ic = new ImageIcon(bImage2);
    //     Image img = ic.getImage();
    //     Image newimg = img.getScaledInstance(220, 200, java.awt.Image.SCALE_SMOOTH);
    //     ImageIcon setIcon = new ImageIcon(newimg);
    //     JLabel labelIcon = new JLabel();
    //     //labelIcon.setBorder(new LineBorder(Color.BLACK));
    //     labelIcon.setIcon(setIcon);
    //}

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