package com.example.Home;

import javax.swing.ImageIcon;

import org.bson.Document;

public class AllImagesCopy extends AllImages {

    ImageIcon ourIcon;
    Document toAdd;

    public AllImagesCopy() {
        super();
        initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        setBackground(new java.awt.Color(245,254,255));
        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(232, 244));

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setPreferredSize(new java.awt.Dimension(232, 340));
        //jLabel1.setIcon(ourIcon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        this.setVisible(false);
    }                      

    // private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {      
    //     Binary imgFile = toAdd.get("val", org.bson.types.Binary.class);
    //     byte[] byteArray = imgFile.getData();
    //     ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
    //     BufferedImage bImage2 = null;
    //     try {
    //         bImage2 = ImageIO.read(bis);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    //     ImageIcon ic = new ImageIcon(bImage2);
    //     Image img = ic.getImage();
    //     Image newimg = img.getScaledInstance(440, 336, java.awt.Image.SCALE_SMOOTH);
    //     //ImageIcon setIcon = new ImageIcon(newimg);                       
    //     //JOptionPane.showMessageDialog(jLabel1.getParent(), new ImageLayout(setIcon, toAdd), (String)toAdd.get("Title"), JOptionPane.PLAIN_MESSAGE);
    // }                                    


    // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}
