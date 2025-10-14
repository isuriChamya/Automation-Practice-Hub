package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalanderExample {
    WebDriver driver;

    @BeforeMethod
    public void Calender(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/datepicker/");
    }

    @Test
    public void CalenderTest(){
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class= 'demo-frame']")));
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.sendKeys("07/02/2024");

    }
    //2nd method
    //learn it later
}


//JSExecutor
//For scrolling, zooming, refresh , Alerting