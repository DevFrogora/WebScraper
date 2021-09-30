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
public class EcommerceScraper {

    String siteRoot;
    String absoluteUrlToScrap;
    Document document;

    public EcommerceScraper() throws IOException {
        siteRoot = "https://webscraper.io";
        absoluteUrlToScrap = "https://webscraper.io/test-sites/e-commerce/allinone";
        document = Jsoup.connect(absoluteUrlToScrap).get();

    }

    ArrayList<ProductItemData> getProductList() {
        ArrayList<ProductItemData> productList = new ArrayList<ProductItemData>();
        for (Element element : document.select("div.col-md-9 div.row div.col-sm-4.col-lg-4.col-md-4")) {

            Elements imageE = element.select("img");
            Elements priceE = element.select("h4.pull-right.price");
            Elements productE = element.select("a[title]");
            Elements descriptionE = element.select("p.description");

            String imagesrc = siteRoot + imageE.attr("src");
            String price = priceE.text();
            String product = productE.attr("title");
            String productLink = siteRoot + productE.attr("href");
            String description = descriptionE.text();

            productList.add(new ProductItemData(imagesrc, price, product, description));
        }

        return productList;

    }

}
