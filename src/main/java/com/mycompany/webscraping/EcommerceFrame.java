/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webscraping;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author root
 */
public class EcommerceFrame extends JFrame{
    
       JPanel mainPanel = null;
    JScrollPane scrollPane = null;

    public EcommerceFrame() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(900, 700));
        mainPanel = new JPanel();

        GridLayout gridLayout = new GridLayout(0, 3);
        gridLayout.setHgap(10);
        gridLayout.setVgap(10);

        mainPanel.setLayout(gridLayout);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//        scrollPane.setLayout(new ScrollPaneLayout());  // no needed its still working
        JButton jButton = new JButton("My Button");
        int a = 1;
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(jButton, BorderLayout.NORTH);

        scrollPane.setViewportBorder(
                BorderFactory.createLineBorder(Color.red));
        add(scrollPane, BorderLayout.CENTER);

//        pack();
//        setVisible(true);
    }

    public static JPanel addPanel(String productName, Image itemImage,String price,  String description) {
        EcommerseItemTemplate newPanel = new EcommerseItemTemplate(productName,itemImage,price,description);
//        newPanel.setPreferredSize(new Dimension(200, 200));
        return newPanel;
    }

    public void addAppInPanel(String productName, Image itemImage,String price,  String description) {
        mainPanel.add(addPanel(productName,itemImage,price,description));
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    
}
