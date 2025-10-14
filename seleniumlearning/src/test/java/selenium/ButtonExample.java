package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class  ButtonExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        //Dimention newSize = new Dimention(width:800, height:600);
        //driver.manage().window().setSize(newSize);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void TestButtons(){
        //Click and confirm title
        WebElement ClickButton = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']"));
        ClickButton.click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        }else {
            System.out.println("Actual Title not same as expected");
        }
        //Assert.assertEquals(actualTitle,expectedTitle,"Title miss matched");

        //Find the position of the Submit button
        driver.navigate().back();
        WebElement getposition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getposition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();
        System.out.println("X position is : " + x + "Y position is : " + y );

    }

}
