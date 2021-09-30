/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webscraping;

import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author root
 */
public class EcommerceMain {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EcommerceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EcommerceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EcommerceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EcommerceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EcommerceScraper ecommerceScraper = null;
                try {
                    ecommerceScraper = new EcommerceScraper();
                } catch (IOException ex) {
                    Logger.getLogger(EcommerceMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                EcommerceFrame ecommerceFrame = new EcommerceFrame();
                ArrayList<ProductItemData> productList = ecommerceScraper.getProductList();
                for (ProductItemData productItemData : productList) {

                    URL url = null;
                    try {
                        url = new URL(productItemData.getImage());
                        Image image = ImageIO.read(url);
                        ecommerceFrame.addAppInPanel(productItemData.getProduct(), image, productItemData.getPrice(), productItemData.getDescription());
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(EcommerceMain.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(EcommerceMain.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                ecommerceFrame.setVisible(true);
                ecommerceFrame.pack();
                ecommerceFrame.setVisible(true);

            }
        });
    }

}
