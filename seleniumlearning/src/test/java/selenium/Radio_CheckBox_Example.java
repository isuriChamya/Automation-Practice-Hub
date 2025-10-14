package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_CheckBox_Example {

    WebDriver driver;

    @BeforeMethod
    public void Radio_checkBox_beforeTest(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTest(){

        driver.get("https://www.leafground.com/radio.xhtml");
        //Find the default select radio button
        WebElement selected = driver.findElement(By.id("j_idt87:console2:0"));
        boolean chromeOption = selected.isSelected();

        if (chromeOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console1:0']")).getText();
            System.out.println("default radio button is : " + chromeText);
        }else {
            System.out.println("No option selected");
        }
    }

}
