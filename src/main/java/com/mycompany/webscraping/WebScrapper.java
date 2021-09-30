/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.webscraping;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author root
 */
public class WebScrapper {

    public static void main(String[] args) throws IOException {
        String rscRoot = "https://webscraper.io";

        final String url = "https://webscraper.io/test-sites/e-commerce/allinone";
        final Document document = Jsoup.connect(url).get();

        System.out.println(document.title());
        int i = 1;
        ArrayList<ProductItemData> productList = new ArrayList<ProductItemData>();
        for (Element element : document.select("div.col-md-9 div.row div.col-sm-4.col-lg-4.col-md-4")) {

//            System.out.println(element + "" + i);
            System.out.println("----------Product : " + i++ + "---------------");
            Elements imageE = element.select("img");
            Elements priceE = element.select("h4.pull-right.price");
            Elements productE = element.select("a[title]");
            Elements descriptionE = element.select("p.description");
            
            String imagesrc =  rscRoot + imageE.attr("src");
            String price = priceE.text();
            String product = productE.attr("title");
            String productLink = rscRoot + productE.attr("href");
            String description =  descriptionE.text();
            
            System.out.println("Image src : " + imagesrc);
            System.out.println("price : " + price);
            System.out.println("product : " + product);
            System.out.println("product link : " + productLink);
            System.out.println("description : " +description);
            
            productList.add(new ProductItemData(imagesrc, price, product, description));

//            System.out.println(thumbnail);
        }
//        System.out.println(i++);

        for (ProductItemData productItemData : productList) {
            System.out.println(productItemData.toString());
            
        }

    }

}
