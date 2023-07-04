package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {


    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));

        Thread.sleep(1000);

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        Thread.sleep(1000);

        //1.4 Verify the Product price will arrange in High to Low order
        String expectedText = "Price (High > Low)";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Price (High > Low)')]"));
        Assert.assertEquals("Price not found", expectedText, actualText);
        Thread.sleep(1000);


    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[contains(text(),'Show AllLaptops & Notebooks')]"));
        Thread.sleep(1000);
        //2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        Thread.sleep(1000);

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[text()='MacBook']"));

        Thread.sleep(1000);
        //2.5 Verify the text “MacBook”
        String expectedText1 = "MacBook";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'MacBook')]"));
        Assert.assertEquals("MacBook Text not found", expectedText1, actualText1);
        Thread.sleep(1000);

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(1000);
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        //  String expectedText2 = "Success: You have added MacBook to your shopping cart!";
        //   String actualText2 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //   Assert.assertEquals("Message not found", expectedText2, actualText2);
        Thread.sleep(1000);
        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);
        //2.9 Verify the text "Shopping Cart"
        String expectedText3 = "Shopping Cart";
        String actualText3 = getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Shopping Cart not found", expectedText3, actualText3);
        Thread.sleep(1000);
        //2.10 Verify the Product name "MacBook"
        String expectedText4 = "MacBook";
        String actualText4 = getTextFromElement(By.xpath("//form[@method='post']//a[text()='MacBook']"));
        Assert.assertEquals("MacBook Cart not found", expectedText4, actualText4);
        Thread.sleep(1000);

        //2.11 Change Quantity "2"
        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]")).clear();
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        Thread.sleep(1000);
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        Thread.sleep(1000);
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        //   String expectedText5 = "Success: You have modified your shopping cart!";
        //    String actualText5 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        //    Assert.assertEquals("Shopping Cart not found", expectedText5, actualText5);
        Thread.sleep(1000);

        //2.14 Verify the Total £737.45
        String expectedText16 = "$1,204.00";
        String actualText16 = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals("Shopping Cart not found", expectedText16, actualText16);
        Thread.sleep(1000);

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        Thread.sleep(1000);
        //2.16 Verify the text “Checkout”
        String expectedText6 = "Checkout";
        String actualText6 = getTextFromElement(By.xpath("//h1[contains(text(),'Checkout')]"));
        Assert.assertEquals("Checkout text not found", expectedText6, actualText6);
        Thread.sleep(1000);

        //2.17 Verify the Text “New Customer”
        String expectedText7 = "New Customer";
        String actualText7 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("New Customer text not found", expectedText7, actualText7);
        Thread.sleep(1000);
        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        Thread.sleep(1000);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Rina");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Smith");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "rina123@gamil.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07654123456");
        Thread.sleep(1000);
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "10,Downing Street ");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "SW1A 2AA");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"), "United Kingdom");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "County Londonderry");

        Thread.sleep(1000);

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//strong[contains(text(),'Add Comments About Your Order')]"), "Please leave it outside of my doorsteps");
        Thread.sleep(1000);
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        Thread.sleep(1000);
        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        //2.25 Verify the message “Warning: Payment method required!”
        String expectedText8 = "Warning: Payment method required";
        String actualText8 = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        Assert.assertEquals("Warning  text not found", expectedText8, actualText8);
        Thread.sleep(1000);

    }


    @After
    public void closeBrowser() {
        driver.quit();
    }


}
