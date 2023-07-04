package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser();
    }

    public void selectMyAccountOptions(String option) {

    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter
        //“Register”
        Thread.sleep(1000);
        selectMyAccountOptions("Register");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));

        //1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Register Account')]"));
        Assert.assertEquals("Register Account text not found", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
        Thread.sleep(1000);
        //2.3 Verify the text “Returning Customer”.
        String expectedText1 = "Returning Customer";
        String actualText1 = getTextFromElement(By.xpath("//h2[contains(text(),'Returning Customer')]"));
        Assert.assertEquals(" Returning Customer text not found", expectedText1, actualText1);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);

        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']"));
        Thread.sleep(1000);

        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Rita");
        Thread.sleep(1000);
        //3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Smith");
        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "tearl123@gamil.com");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "09876543234");
        Thread.sleep(1000);
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "reakk132");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "reakk132");
        Thread.sleep(1000);
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[@class='radio-inline']//input[@value='1']"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@type='checkbox']"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        Thread.sleep(1000);
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedText2 = "Your Account Has Been Created!";
        String actualText2 = getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertEquals("  Your Account Has Been Created! text not found", expectedText2, actualText2);
        Thread.sleep(1000);
        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        Thread.sleep(1000);
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter Logout
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        Thread.sleep(1000);
        //3.16 Verify the text “Account Logout”
        String expectedText3 = "Account Logout";
        String actualText3 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("  Account Logout text not found", expectedText3, actualText3);
        Thread.sleep(1000);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter Login
        selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']"));
        Thread.sleep(1000);
        //4.3 Enter Email address Last Name
        sendTextToElement(By.xpath("//input[@id='input-email']"), "rina1234@gamil.com");

        //4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "reaal1234");

        //4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        //4.7 Verify text “My Account”
        String expectedText4 = "My Account";
        String actualText4 = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        Assert.assertEquals("  My Account text not found", expectedText4, actualText4);
        Thread.sleep(1000);
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameterLogout
        selectMyAccountOptions("Logout");
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
        //4.10 Verify the text “Account Logout”
        String expectedText5 = "Account Logout";
        String actualText5 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("  Account Logout text not found", expectedText5, actualText5);
        Thread.sleep(1000);

        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));


    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
