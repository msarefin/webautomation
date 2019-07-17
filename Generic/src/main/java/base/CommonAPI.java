package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class CommonAPI {
    public WebDriver driver =null;
    @Parameters({"url"})
    @BeforeMethod
    public void setup(String url){
        String ChromeDriver = "C:/Users/sunsh/IdeaProjects/WebAutomation/Generic/drivers/Windows/ChromeDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",ChromeDriver);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void cleanUp(){
        driver.close();
    }


}
