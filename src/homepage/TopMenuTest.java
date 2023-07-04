package homepage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser();
    }

    public void selectMenu(String menu) {
//1.2 This method should click on the menu whatever name is passed as parameter.
        clickOnElement(By.xpath(menu));
    }

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() throws InterruptedException {

        //1.1 Mouse hover on “Desktops” Tab and click
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav']//a[text()='Desktops']"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”*******************
        selectMenu("//a[contains(text(),'Show AllDesktops')]");
        Thread.sleep(1000);

        //1.3 Verify the text ‘Desktops’
        String expectedText = "Desktops";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'Desktops')]"));
        Assert.assertEquals("Desktops text not found", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab
        clickOnElement(By.xpath("//a[text()='Laptops & Notebooks']"));
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("//a[text()='Show AllLaptops & Notebooks']");
        //2.3 Verify the text ‘Laptops & Notebooks
        Thread.sleep(1000);
        String expectedText1 = "Laptops & Notebooks";
        String actualText1 = getTextFromElement(By.xpath("//h2[text()= 'Laptops & Notebooks']"));
        Assert.assertEquals("Laptops & Notebooks text not found", expectedText1, actualText1);
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() throws InterruptedException {
        //3.1 Mouse hover on “Components” Tab
        clickOnElement(By.xpath("//a[text()='Components']"));
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        selectMenu("//a[text()='Show AllComponents']");
        Thread.sleep(1000);

        //3.3 Verify the text ‘Components’

        String expectedText2 = "Components";
        String actualText2 = getTextFromElement(By.xpath("//h2[text()='Components']"));
        Assert.assertEquals("Desktops text not found", expectedText2, actualText2);

    }


    @After
    public void closeBrowser() {
        driver.quit();
    }


}




















