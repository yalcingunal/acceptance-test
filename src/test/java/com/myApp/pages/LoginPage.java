package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePageBase {

    @FindBy(id = "ap_email")
    private WebElement emailTextBox;

    @FindBy(id = "ap_password")
    private WebElement passwordTextBox;

    @FindBy(id = "signInSubmit")
    private WebElement loginButton;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(css = "[name='code']")
    private WebElement verificationInputBox;

    public LoginPage(MyWebDriver driver) {
        super(driver);
    }

    public void loginWithEmailAndPassword(String email, String password) throws InterruptedException {
        emailTextBox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        loginButton.click();
        //verify();
    }

    public void verify() throws InterruptedException {
        Thread.sleep(5000);
        continueButton.click();
        Thread.sleep(5000);
        verificationInputBox.click();
        driver.getKeyboard().sendKeys("");
        driver.findElement(By.cssSelector("[type='submit']")).click();

    }
}
