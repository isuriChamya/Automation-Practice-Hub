package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;

    @BeforeMethod
    public void beforeAlertTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void alerttest() throws InterruptedException {
        //Accept alert
        WebElement clickButton = driver.findElement(By.id("j_idt88:j_idt91"));
        clickButton.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        //Alert dismiss
        driver.findElement(By.id("j_idt88:j_idt93")).click();
        Alert canselAlert = driver.switchTo().alert();
        Thread.sleep(3000);
        canselAlert.dismiss();

        //pomt dialog
        WebElement alert2 = driver.findElement(By.id("j_idt88:j_idt104"));
        alert2.click();
        Alert pomtAlert = driver.switchTo().alert();
        String pomttext = pomtAlert.getText();
        System.out.println("Alert text is : " + pomttext);
        pomtAlert.sendKeys("My name is Isuri");
        Thread.sleep(3000);
        pomtAlert.accept();
    }
}
