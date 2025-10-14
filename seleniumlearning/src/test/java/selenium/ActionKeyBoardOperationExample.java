package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionKeyBoardOperationExample{
    WebDriver driver;

    @BeforeMethod
    public void KeyBoardOperation(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void KeyboardTest() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement textbox = driver.findElement(By.name("q"));
        textbox.sendKeys("Welcome");

        Actions action = new Actions(driver);
        //select the text
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        Thread.sleep(5000);

        action.keyDown(Keys.SHIFT)
                .sendKeys("Writing capital letters")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL)
                .sendKeys("x")
                .perform();

        driver.close();


    }

}
