package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() throws InterruptedException {
        //1.1 Mouse hover on Desktops Tab.and click
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        Thread.sleep(1000);
        //1.4 Verify the Product will arrange in Descending order.
        String expectedText = "Name (Z - A)";
        String actualText = getTextFromElement(By.xpath("//option[contains(text(),'Name (Z - A)')]"));
        Assert.assertEquals("Text not found",expectedText,actualText);


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[text()='Show AllDesktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        Thread.sleep(1000);
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[contains(text(),'HP LP3065')]"));
        Thread.sleep(1000);
        //2.5 Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'HP LP3065')]"));
        Assert.assertEquals("HP LP3065Text not found", expectedText, actualText);
        Thread.sleep(1000);
        //2.6 Select Delivery Date "2022-11-30"
        WebElement deliveryDateInput = driver.findElement(By.id("input-option225"));
        deliveryDateInput.clear();
        deliveryDateInput.sendKeys("2022-11-30");
        //2.7.Enter Qty "1” using Select class
        WebElement quantity= driver.findElement(By.xpath("//input[@id='input-quantity']"));
        quantity.clear();
        quantity.sendKeys("1");
        Thread.sleep(1000);
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        Thread.sleep(1000);
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedText1 = "Success: You have added HP LP3065 to your shopping cart!";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Success: You have added HP LP3065 to your shopping cart! text not found", expectedText1, actualText1);
        Thread.sleep(1000);

        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        Thread.sleep(1000);
        //2.11 Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart";
        String actualText2 = getTextFromElement(By.xpath("//a[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals("Shopping Cart not found", expectedText2, actualText2);
        Thread.sleep(1000);


        //2.12 Verify the Product name "HP LP3065"
        String expectedMessage = "HP LP3065";
        String actualMessage= getTextFromElement(By.xpath("//div[@class='table-responsive']//a[text()='HP LP3065']));"));
        Assert.assertEquals("Text not found",expectedMessage,actualMessage);

        //2.13 Verify the Delivery Date "2022-11-30"
        String expectedText3 = "2022-11-30";
        String actualText3 = getTextFromElement(By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"));
        Assert.assertEquals("Date  not found", expectedText3, actualText3);
        Thread.sleep(1000);


        //2.14 Verify the Model "Product21"
        String expectedText4 = "Product21";
        String actualText4 = getTextFromElement(By.xpath("//td[contains(text(),'Product 21')]"));
        Assert.assertEquals("Product21  text not found", expectedText4, actualText4);
        Thread.sleep(1000);

        //2.15 Verify the Total "£74.73"
        String expectedText5 = "£74.73";
        String actualText5 = getTextFromElement(By.xpath("//div[@class='col-sm-4 col-sm-offset-8']//td[text()='$122.00']"));
        Assert.assertEquals(" £74.73  not found", expectedText5, actualText5);
        Thread.sleep(1000);


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }

}

