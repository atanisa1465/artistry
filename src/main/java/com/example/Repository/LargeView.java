package com.example.Repository;

import org.bson.Document;
import org.bson.types.Binary;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class LargeView extends javax.swing.JPanel {
    MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
    MongoDatabase db = client.getDatabase("artistry");
    MongoCollection<Document> col = db.getCollection("photos");

    Document j;
    ImageIcon setIcon;

    public LargeView(Document i) {
        j = i;
        initComponents();
    }

    public int mouseEnter(String n) {
        FindIterable<Document> filesStored = col.find();
        MongoCursor<Document> cursor = filesStored.iterator();
        while (cursor.hasNext()) {
            Document picAdd = cursor.next();
            if (((String)(picAdd.get("_id"))).equals(((String)(j.get("_id"))))) {
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
               
    private void initComponents() {

        FindIterable<Document> filesStored = col.find();
        MongoCursor<Document> cursor = filesStored.iterator();
        while (cursor.hasNext()) {
            Document picAdd = cursor.next();
            if (((String)(picAdd.get("_id"))).equals(((String)(j.get("_id"))))) {
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
                Image newimg = img.getScaledInstance(460, 339, java.awt.Image.SCALE_SMOOTH);
                setIcon = new ImageIcon(newimg);
                j = picAdd;
                break;
            }
        }

        deleteTag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(245,254,255));

        deleteTag.setBackground(new java.awt.Color(255, 255, 255));
        deleteTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deleteTag.setIcon(setIcon);
        deleteTag.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //int likeNum = (int) j.get("like");
        jLabel1.setText(mouseEnter("like") + " 💕");

       // int tadaNum = (int) j.get("tada");
        jLabel2.setText(mouseEnter("tada") + " 🎉");

       // int coolNum = (int) j.get("cool");
        jLabel3.setText(mouseEnter("cool") + " 😎");

        ArrayList<String> sizeGet = (ArrayList<String>) j.get("saved");
        jLabel4.setText(sizeGet.size() + " save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteTag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(deleteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(0, 6, Short.MAX_VALUE))
        );
    }                      

    private javax.swing.JLabel deleteTag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
}