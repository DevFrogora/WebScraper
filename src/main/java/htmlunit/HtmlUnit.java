/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htmlunit;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

/**
 *
 * @author root
 */
public class HtmlUnit {

    public static void main(String[] args) throws Exception {
//        homePage();
        submittingForm();
    }

    public static void homePage() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
            System.out.println(page.getTitleText());

            final String pageAsXml = page.asXml();
            System.out.println(pageAsXml.contains("<body class=\"composite\">"));

            final String pageAsText = page.asText();
            System.out.println(pageAsText.contains("Support for the HTTP and HTTPS protocols"));
        }
    }

    public static void submittingForm() throws Exception {
        try (final WebClient webClient = new WebClient()) {
            String urlToButtonSubmit = "https://dowhateveryouwant.000webhostapp.com/webscrap/Form.html";
            // Get the first page
            final HtmlPage page1 = webClient.getPage(urlToButtonSubmit);

            // Get the form that we are dealing with and within that form, 
            // find the submit button and the field that we want to change.
            final HtmlForm form = page1.getFormByName("myForm");

            final HtmlSubmitInput button = form.getInputByName("submitbutton");
            final HtmlTextInput fnameTF = form.getInputByName("fname");
            final HtmlTextInput emailTF = form.getInputByName("email");

            // Change the value of the text field
            fnameTF.type("Frogora");
            emailTF.type("frogora420@gmail.com");

            // Now submit the form by clicking the button and get back the second page.
            final HtmlPage page2 = button.click();
            System.out.println(page2.getUrl());

            final HtmlPage page = webClient.getPage(page2.getUrl());
            System.out.println(page.asText());
        }
    }

}
