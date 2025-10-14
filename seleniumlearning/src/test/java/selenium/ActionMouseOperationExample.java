package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperationExample {
    WebDriver driver;

    @BeforeMethod
    public void ActionPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.get("https://www.leafground.com/drag.xhtml");
    }

    @Test
    public void MouseOperationTest() throws InterruptedException {
        driver.get("https://www.leafground.com/drag.xhtml");

        System.out.println("<<<<<<<<<<<<<<Move to an element operation>>>>>>>>>>>>>");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();
        Thread.sleep(2000);

//        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38")))
//                .moveToElement(driver.findElement(By.id("menuform:j_idt39")))
//                .moveToElement(driver.findElement(By.id("menuform:j_idt40"))).perform();

        System.out.println("<<<<<<<<<<<<<<Drag and drop operation>>>>>>>>>>>>>>");
        WebElement from = driver.findElement(By.id("form:drag"));
        WebElement to = driver.findElement(By.id("form:drop"));

        actions.clickAndHold(from).moveToElement(to).release(to).perform(); //1st way
        actions.dragAndDrop(from, to).perform(); //2nd way
    }
}
//Difference between actions class and action interface
//Actions --> class, will use to perform mouse actions
//Action --> Interface,  will use to perform actions class having actions (Having Perform method)
// * when having actions class, mandatory to have perform method

//To right click any button --> actions.contextClick(rightclickbutton).perform();
