package com.example.Drawing;

import javax.swing.JLabel;

public class ImagePanel {
    String fileName;
    JLabel label;
    
    public ImagePanel(String s, JLabel l) {
        fileName = s;
        label = l;
    }

    public JLabel getLabel() { return label; }
}