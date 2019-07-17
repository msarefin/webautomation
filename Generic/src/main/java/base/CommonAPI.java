package base;

import org.openqa.selenium.By;
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
        String ChromeDriver = null;
        String userDir = System.getProperty("user.dir");
        String dir = userDir.substring(0,userDir.length()-6);

        String os = System.getProperty("os.name").toLowerCase();
        if(os.contains("win")){
            ChromeDriver = dir+"Generic/drivers/Windows/ChromeDriver/chromedriver.exe";
        }else if(os.contains("mac")){
            ChromeDriver = dir+"Generic/drivers/Mac/ChromeDriver/chromedriver";
        }else{

        }

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

    public void typeByID(String id){
        driver.findElement(By.id(id));
    }


}
