package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameExample {
    WebDriver driver;

    @BeforeMethod
    public void windowTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }

    @Test
    public void FrameTest(){
        //Click me inside Frame
        //Driver can't call items inside the frame, so we want to switch to the frame
        driver.switchTo().frame(0);

        WebElement clickmebutton = driver.findElement(By.id("Click"));
        clickmebutton.click();

        String afterclickbutton = clickmebutton.getText();

        System.out.println("After click inside frame button : " + afterclickbutton);

        driver.close();
    }


}
