package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

        //To change the browser version
        //ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBrowserVersion("122");
        //driver = new ChromeDriver(chromeOptions);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //chromeOptions.addArguments("--start-maximized");
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests(){
        //Type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Isuri Weeraman");

        //Append Country to this City : Not overriding, connect with the text already in
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //Verify if text box is disabled
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box enabled" + enabled);

        //Clear the typed text.
        ////*[@id="j_idt88:j_idt95"]
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        //Retrieve the typed text.
        WebElement retrieveTypedText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = retrieveTypedText.getAttribute("value");
        System.out.println(value);

        //Type email and Tab. Confirm control moved to next element.
        WebElement ConfirmMovements = driver.findElement(By.id("j_idt88:j_idt99"));
        ConfirmMovements.sendKeys("isuriweeraman0714@gmail.com" + Keys.TAB + "Confirm control moved to next element.");

    }

}
