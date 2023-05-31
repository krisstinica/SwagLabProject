package com.swagLab.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {


    /*
    This method will accept int(in seconds)
    and execute Thread.sleep method for given duration
    Arg: int second
     */

    public static void sleep(int second){
        second*=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }


    public static void switchWindowAndVerify(String expectedURL, String expictedTitle){
        Set<String> allWindowHandles=Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            Driver.getDriver().switchTo().window(each);//switching to each one that is open
            System.out.println("Current URL: "+Driver.getDriver().getCurrentUrl());//getting url from open windows

            if(Driver.getDriver().getCurrentUrl().contains(expectedURL)){//and if urls contains etsy than stop there
                break;
            }

        }

        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expictedTitle));

    }

/*
TC #3: Create utility method
1. Create a new method for title verification
2. Create a method to make title verification logic re-usable
3. When method is called, it should simply verify expected title with actual
title

Method info:
• Name: verifyTitle()
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedTitle
 */


    public static void verifyTitle(String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }
    public static void verifyTitleContains( String expectedInTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));
    }



    /*
     This method accepts WebElement target,
     and waits for that WebElement not to be displayed on the page
      */
    public static void waitForInvisibilityOf(WebElement target){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.invisibilityOf(target));
    }

    /*
    This method accepts String title,
    and waits for that Title to contain given String value.
     */
    public static void waitForTitleContains(String title){
        //Create the object of 'WebDriverWait' class, and set up the constructor args
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        //use the 'wait' object with the proper syntax to create explicit wait conditions.
        wait.until(ExpectedConditions.titleContains(title));
    }
    /**
     * This method accepts a dropdown element and returns a List<String> that contains all options values as String.
     * @param dropdownElement
     * @return actualMonth_as_STRING
     */

    public static List<String> dropdownOptions_as_STRING(WebElement dropdownElement){
        Select month=new Select(dropdownElement);
//Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonthAsWebElement=month.getOptions();

        //Creating an EMPTY list of String to store ACTUAL <option> as String
        List<String> actualMonth_as_STRING=new ArrayList<>();
        //Looping through the List<WebElement>, getting all options' texts, and storing them into List<String>
        for (WebElement each : actualMonthAsWebElement) {
            actualMonth_as_STRING.add(each.getText());
        }
        return actualMonth_as_STRING;
    }


    public static void clickradioButton(List<WebElement>radioButtons,String attributeValue){
        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }

    }






}
