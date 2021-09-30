/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webscraping;

/**
 *
 * @author root
 */
public class ProductItemData {

    String image;
    String price;
    String product;
    String description;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductItemData(String image, String price, String product, String description) {
        this.image = image;
        this.price = price;
        this.product = product;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductItemData{" + "image=" + image + ", price=" + price + ", product=" + product + ", description=" + description + '}';
    }
    
    

}
