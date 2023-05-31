package com.swagLab.step_defs;
/*
in this class we will be able to create "pre" and "post" condition for all the scenarios and even steps
 */


import com.swagLab.utilities.*;
import com.swagLab.utilities.BrowserUtils;
import com.swagLab.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {

    //import the @Before coming from io.cucumber.java
    @Before (order = 1)
    public void setupMethod(){
        //Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       // Driver.getDriver().get(ConfigurationReader.getProperty("baseURL"));
    }



    @After
    public void teardownMethod(Scenario scenario){

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        System.out.println("---> @After: RUNNING AFTER EACH SCENARIO");
        BrowserUtils.sleep(2);
     Driver.closeDriver();

    }



}
