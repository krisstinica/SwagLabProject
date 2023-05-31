package com.swagLab.pages;

import com.swagLab.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    public WebElement cartsymbol;

    @FindBy(xpath = "//div[@class='bm-burger-button']")
    public WebElement dropdown;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    public WebElement logout;

    @FindBy(xpath = "//a[@id='item_4_img_link']")
    public WebElement dogPix;

    @FindBy(xpath = "//span[.='Products']")
    public WebElement productTitle;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement dropDownMenu;

    @FindBy(xpath = "//a[.=\"Logout\"]")
    public WebElement logOutBtn;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addFleeceToCart;


    public void logOut(){
        dropDownMenu.click();
        logout.click();
    }




}
