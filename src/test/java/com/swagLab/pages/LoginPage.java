package com.swagLab.pages;

import com.swagLab.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    //h3[@data-test='error']

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement errorMsg;



    public void login(String user, String pass) {
        this.username.sendKeys(user);
        this.password.sendKeys(pass);
        this.loginButton.click();

    }

    public void errorMessage(String message){
        String expected=message;
        String actual=errorMsg.getText();

        Assert.assertEquals(expected,actual);
    }
}
