package com.example.Admin;

import com.example.Main;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.awt.Color;

public class Register extends javax.swing.JPanel {

    public Register() {
        initComponents();
    }
                         
    private void initComponents() {
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        emailTag = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        passwordBox = new javax.swing.JTextField();
        passwordTag = new javax.swing.JLabel();
        actionButton = new javax.swing.JButton();
        loginButton = new javax.swing.JLabel();
        error = new javax.swing.JLabel();

        jLabel4.setText("Username/Email");

        jTextField1.setFont(new java.awt.Font("Kohinoor Telugu", 0, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Password");

        jTextField2.setFont(new java.awt.Font("Kohinoor Telugu", 0, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField2ActionPerformed(evt);
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon("/Users/afifat/Downloads/Library - 1 of 1.jpeg")); // NOI18N

        emailTag.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        emailTag.setText("Email");

        jTextField3.setFont(new java.awt.Font("Kohinoor Telugu", 0, 18)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jTextField3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel7.setText("Username");

        jTextField4.setFont(new java.awt.Font("Kohinoor Telugu", 0, 18)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
              //  jTextField4ActionPerformed(evt);
            }
        });

        passwordBox.setFont(new java.awt.Font("Kohinoor Telugu", 0, 18)); // NOI18N
        passwordBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //passwordBoxActionPerformed(evt);
            }
        });

        passwordTag.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        passwordTag.setText("Create Password");

        actionButton.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        actionButton.setText("Create Account");
        actionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionButtonActionPerformed(evt);
            }
        });

        loginButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        loginButton.setText("Already have an account? Login");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setForeground(Color.red);
        //error.setText("test");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(actionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(loginButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTag, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(emailTag, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(emailTag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(passwordTag, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(actionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    // private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    //     
    // }                                           

    // private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    //    
    // }                                           

    // private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    //    
    // }                                           

    // private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    //    
    // }                                           

    // private void passwordBoxActionPerformed(java.awt.event.ActionEvent evt) {                                            
    //    
    // }                                           

    private void actionButtonActionPerformed(java.awt.event.ActionEvent evt) { 
        boolean good = true;
        boolean containsAt = false;
        for (int i = 0; i < jTextField3.getText().length(); i++) {
            if (jTextField3.getText().substring(i,i+1).equals("@")) { containsAt = true;}
        }
        if (jTextField3.getText().equals("")) {
            error.setText("Please enter an email!");
            good = false;
        } else if (!containsAt) {                             
            if (!containsAt) {
                error.setText("Invalid Email. Please retry!");
                good = false;
            }
        } else if (jTextField4.getText().equals("")) {
            error.setText("Please enter a username!");
            good = false;
        } else if (passwordBox.getText().equals("")) {
            error.setText("Please enter a password!");
            good = false;
        } else {
            if (good) {
                boolean add = true;
                MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
                MongoDatabase db = client.getDatabase("artistry");
                MongoCollection<Document> col = db.getCollection("data");
                // int i = 1;
                while (add) {
                    Main.user = new User(jTextField3.getText(), jTextField4.getText(), passwordBox.getText());

                    if (col.find(new Document("Username", jTextField4.getText())).first() != null) {
                        error.setText("Username already exists!");
                        jTextField4.setText("");
                        return;
                    }
                    try { 
                        Document user = new Document("_id", jTextField3.getText()).append("Username",jTextField4.getText()).append("Password",passwordBox.getText());
                        col.insertOne(user);
                        add = false;
                    } catch (com.mongodb.MongoWriteException e) {
                        error.setText("Email already used!");
                    } 
                }
                client.close();          
                System.out.println("done!");    
                Main.iPad.initComponents(new LoginPage());
            }                  
        }            
    }                                            

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        Main.iPad.initComponents(new LoginPage());
    }                                        

    private javax.swing.JButton actionButton;
    private javax.swing.JLabel emailTag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel loginButton;
    private javax.swing.JTextField passwordBox;
    private javax.swing.JLabel passwordTag;   
    private javax.swing.JLabel error;  
}