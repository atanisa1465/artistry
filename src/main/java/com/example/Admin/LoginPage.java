package com.example.Admin;

import java.awt.Color;
import java.util.NoSuchElementException;

import javax.swing.text.View;

import com.example.Main;
import com.example.Home.AllImages;
import com.example.Home.HomePage;
import com.example.Home.ViewImages;
import com.example.Repository.MyImages;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class LoginPage extends javax.swing.JPanel {

    public LoginPage() {
        initComponents();
    }

    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usernameBox = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        seePass = new javax.swing.JCheckBox();
        registerLink = new javax.swing.JLabel();
        passwordBox = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(487, 635));

        jLabel2.setIcon(new javax.swing.ImageIcon("lib//All Photos - 1 of 1 (1).jpeg")); // NOI18N

        usernameBox.setFont(new java.awt.Font("Kohinoor Telugu", 0, 16)); // NOI18N
        usernameBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        usernameBox.setSelectionColor(new java.awt.Color(0, 0, 0));
        usernameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameBoxActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        passwordLabel.setText("Password");

        loginButton.setBackground(new java.awt.Color(236, 246, 255));
        loginButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        seePass.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        seePass.setText("See Password");
        seePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seePassActionPerformed(evt);
            }
        });

        registerLink.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        registerLink.setText("No Account? Register Now");
        registerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLinkMouseClicked(evt);
            }
        });

        passwordBox.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordBoxActionPerformed(evt);
            }
        });

        jLabel3.setForeground(Color.red);
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerLink)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(136, 136, 136))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameBox, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seePass)
                                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordBox, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))))
                .addGap(36, 36, 36))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 244, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 243, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(usernameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(passwordBox, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seePass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerLink)
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 317, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 318, Short.MAX_VALUE)))
        );
    }                      

    private void usernameBoxActionPerformed(java.awt.event.ActionEvent evt) {                                            
    }                                           

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        boolean good = true;
        if (usernameBox.getText().equals("")) {
            jLabel3.setText("Please enter username!");
            good = false;
        } else if (passwordBox.getText().equals("")) {
            jLabel3.setText("Please enter your password!");
            good = false;
        } else {
            if (good) {
                MongoClient client = MongoClients.create("mongodb+srv://artistrymp4:artistrymp4project@artistry.zi4lf5v.mongodb.net/?retryWrites=true&w=majority");
                MongoDatabase database = client.getDatabase("artistry");
                MongoCollection<Document> col = database.getCollection("data");

                try {
                    Document userFind = col.find(new Document("Username", usernameBox.getText())).first();
                    if (userFind == null) {
                        jLabel3.setText("No account exists!");
                        passwordBox.setText("");
                        usernameBox.setText("");
                    } else if (userFind.get("Password").equals(passwordBox.getText())) {
                        Main.user = new User((String)(userFind.get("_id")), (String)(userFind.get("Username")), (String)(userFind.get("Password")));
                        Main.iPad.initComponents(new HomePage());
                        return;
                    } else {
                        passwordBox.setText("");
                        jLabel3.setText("Invalid password!");
                    }
                } catch (NoSuchElementException e) { 
                    System.out.println("u failed\n\n\n"); 
                }
                client.close();  
            }   
        }             
    }                                           

    private void seePassActionPerformed(java.awt.event.ActionEvent evt) {                                        
        if (seePass.isSelected()) { passwordBox.setEchoChar((char)0); }
        else { passwordBox.setEchoChar('●'); }
    }    


    private void passwordBoxActionPerformed(java.awt.event.ActionEvent evt) {}                                           

    private void registerLinkMouseClicked(java.awt.event.MouseEvent evt) {       
        Main.iPad.initComponents(new Register());
    }                                         


    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordBox;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerLink;
    private javax.swing.JCheckBox seePass;
    private javax.swing.JTextField usernameBox;
    private javax.swing.JLabel usernameLabel;
}
