package com.swagLab.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object
    private Driver(){}

    /*
    We make the WebDriver private, because we want to close access from outside the class.
    We are making it static, because we will use it in a static method.
     */
   // private static WebDriver driver; // default value = null
    private static InheritableThreadLocal<WebDriver>driverPool=new InheritableThreadLocal<>();
    //We wrap our "driver" instance with InheritableThreadLocal class coming from Java library.


    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    - If an instance doesn't exist, it will create first, and then it will always return same instance.
     */


    //Now that we are using the InheritableThreadLocal, we need to change
    // a few methods inside of the getDriver() method.
    public static WebDriver getDriver(){

        if(driverPool.get() == null){

            /*
            We will read our browserType from configuration.properties file.
            This way, we can control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties
            switch statement will determine the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                   // WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }

        }

        return  driverPool.get();

    }

   // - Instead of "driver" we used 				--> driverPool.get() --> returns a "driver" instance
	//	- Instead of "driver = new ChromeDriver();" --> driverPool.set(new ChromeDriver());
//		- Instead of "driver == null"				--> driverPool.remove(); --> sets the "driver" to "null"



    /*
    Create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driverPool.get().quit();
            /*
            We assign the value back to "null" so that my "singleton" can create a newer one if needed.
             */
            driverPool.remove();
        }
    }




}
