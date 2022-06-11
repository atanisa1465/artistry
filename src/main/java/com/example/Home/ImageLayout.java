package com.example.Home;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import org.bson.Document;

import com.example.Main;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ImageLayout extends javax.swing.JPanel {

    // private ImageIcon createdIcon;
    private Document docInfo;
    MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
    MongoDatabase db = client.getDatabase("artistry");
    MongoCollection<Document> col = db.getCollection("photos");

    private javax.swing.JLabel jLabel2;


    //public void setIcon(ImageIcon i) { createdIcon = i; }

    public ImageLayout(ImageIcon i, Document u) {
        docInfo = u;
        initComponents(i);
    }
                    
    private void initComponents(ImageIcon i) {

        usernameLabel = new javax.swing.JLabel();
        imageDisplay = new javax.swing.JLabel();
        cool = new javax.swing.JLabel();
        tada = new javax.swing.JLabel();
        like = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        like1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245,254,255));
        setBorder(new javax.swing.border.MatteBorder(null));
        setPreferredSize(new Dimension(468, 413));

        usernameLabel.setBackground(new java.awt.Color(255, 255, 255));
        usernameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        usernameLabel.setText((String)(docInfo.get("title")));
    
        imageDisplay.setPreferredSize(new java.awt.Dimension(440, 336));
        imageDisplay.setIcon(i);
        imageDisplay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cool.setBackground(new java.awt.Color(244, 249, 251));
        cool.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        cool.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cool.setText("😎");
        cool.setToolTipText(mouseEnter("cool") + " cool");
        cool.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                coolMouseClicked(evt);
            }
            // public void mouseEntered(java.awt.event.MouseEvent evt) {
            //     cool.setToolTipText(mouseEnter("cool") + " cool");
            // }
        });

        tada.setBackground(new java.awt.Color(244, 249, 251));
        tada.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        tada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tada.setText("🎉");
        tada.setToolTipText(mouseEnter("tada") + " tada");
        tada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tadaMouseClicked(evt);
            }
        });

        like.setBackground(new java.awt.Color(244, 249, 251));
        like.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        like.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        like.setText("💕");
        like.setToolTipText(mouseEnter("like") + " like");
        like.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                likeMouseClicked(evt);
            }
        });

        
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("@" + (String)(docInfo.get("user")) + ": " + (String)(docInfo.get("title")));

        like1.setBackground(new java.awt.Color(244, 249, 251));
        like1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        like1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ImageIcon ic = new ImageIcon("lib//2890596-200.png");
        jLabel2.setIcon(ic);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        this.setBorder(new LineBorder(Color.black));

   
    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(like, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cool, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imageDisplay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cool)
                            .addComponent(tada)
                            .addComponent(like))))
                )
        );

        // layout.setHorizontalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        //         .addGap(13, 13, 13)
        //         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
        //             .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        //             .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
        //                 .addComponent(like, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //                 .addComponent(tada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //                 .addComponent(cool, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
        //                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
        //                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
        //             .addComponent(imageDisplay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        //         .addGap(12, 12, 12))
        // );
        // layout.setVerticalGroup(
        //     layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //     .addGroup(layout.createSequentialGroup()
        //         .addGap(7, 7, 7)
        //         .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        //         .addComponent(imageDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
        //         .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        //             .addGroup(layout.createSequentialGroup()
        //                 .addGap(7, 7, 7)
        //                 .addComponent(jLabel2))
        //             .addGroup(layout.createSequentialGroup()
        //                 .addGap(2, 2, 2)
        //                 .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
        //                     .addComponent(cool)
        //                     .addComponent(tada)
        //                     .addComponent(like))))
        //         .addGap(0, 5, Short.MAX_VALUE))
        // );

    }

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {                                     
        clickedOn();
    } 

    public void clickedOn() {
        FindIterable<Document> filesStored = col.find();
        MongoCursor<Document> cursor = filesStored.iterator();
        Document picAdd = null;
        boolean savedYes = false;
        ArrayList<String> users = null;
        while (cursor.hasNext()) {
            picAdd = cursor.next();
            if (((String)(picAdd.get("_id"))).equals((String)docInfo.get("_id"))) {
            users = (ArrayList<String>) (picAdd.get("saved"));
            for (String userNames : users) {
                if (userNames.equals(Main.user.getUsername())) {
                    savedYes = true;
                    System.out.println("\n\n\n\nIt's saved!");
                }
            }
            break;
            }
        }
        if (savedYes) {
        for (int i = users.size()-1; i >= 0; i--) {
            if (users.get(i).equals(Main.user.getUsername())) {
                users.remove(i);
            }
        }
        col.updateOne(Filters.eq("_id", docInfo.get("_id")), (Updates.set("saved", (users))));
        JOptionPane p = new JOptionPane("Image removed!");  
        final JDialog dialog = p.createDialog(usernameLabel.getParent(), "");
        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });              
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
        } else {
            users.add(Main.user.getUsername());
            col.updateOne(Filters.eq("_id", docInfo.get("_id")), (Updates.set("saved", (users))));
            JOptionPane p = new JOptionPane("Image saved!");  
            final JDialog dialog = p.createDialog(usernameLabel.getParent(), "");
            final Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    dialog.setVisible(false);
                    dialog.dispose();
                }
            });              
            timer.setRepeats(false);
            timer.start();
            dialog.setVisible(true);
        }   
    }

    private void likeMouseClicked(java.awt.event.MouseEvent evt) {  
        like1.setText("💕");     
        int likesNum = (int) docInfo.get("likes");     
        col.updateOne(Filters.eq("_id", docInfo.get("_id")), (Updates.set("likes", (++likesNum))));           
        JOptionPane p = new JOptionPane("You reacted " + "💕");  
        final JDialog dialog = p.createDialog(imageDisplay.getParent(), "");
        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });              
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }                                 

    private void tadaMouseClicked(java.awt.event.MouseEvent evt) {                                  
        like1.setText("🎉");
        int likesNum = (int) docInfo.get("tada");     
        col.updateOne(Filters.eq("_id", docInfo.get("_id")), (Updates.set("tada", (++likesNum))));    
        JOptionPane p = new JOptionPane("You reacted " + "🎉");  
        final JDialog dialog = p.createDialog(imageDisplay.getParent(), "");
        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });              
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }                                 

    private void coolMouseClicked(java.awt.event.MouseEvent evt) {                                  
        like1.setText("😎");
        int likesNum = (int) docInfo.get("cool");     
        col.updateOne(Filters.eq("_id", docInfo.get("_id")), (Updates.set("cool", (++likesNum))));  
        JOptionPane p = new JOptionPane("You reacted " + "😎");  
        final JDialog dialog = p.createDialog(imageDisplay.getParent(), "");
        final Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        });              
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
    }   
    
    public int mouseEnter(String n) {
        FindIterable<Document> filesStored = col.find();
        MongoCursor<Document> cursor = filesStored.iterator();
        while (cursor.hasNext()) {
            Document picAdd = cursor.next();
            if (((String)(picAdd.get("_id"))).equals(((String)(docInfo.get("_id"))))) {
                if (n.equals("like")) {
                    return (int) picAdd.get("likes");
                } else if (n.equals("cool")) {
                    return (int) picAdd.get("cool");
                } else if (n.equals("tada")) {
                    return (int) picAdd.get("tada");
                } 
                break;
            }
        }
        return 0;
    }

    private javax.swing.JLabel cool;
    private javax.swing.JLabel imageDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel like;
    private javax.swing.JLabel like1 = new javax.swing.JLabel();
    private javax.swing.JLabel tada;
    private javax.swing.JLabel usernameLabel;
}