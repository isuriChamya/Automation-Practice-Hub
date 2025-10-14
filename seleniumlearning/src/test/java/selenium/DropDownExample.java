package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {
    WebDriver driver;

    @BeforeMethod
    public void openDropDownTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testDropDown() throws InterruptedException {
        driver.get(" ");
        //ways of select values in basic dropdown
        WebElement selectdropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(selectdropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");

        //get no.of dropdown options
        //Generics
        List<WebElement> ListOfOptions =  select.getOptions();
        int size = ListOfOptions.size();
        System.out.println("Number of elements in dropdown :" + size);

        for (WebElement element : ListOfOptions){
            System.out.println(element.getText());
        }

        //using sendkeys select dropdown value
        selectdropDown.sendKeys("Puppeteer");
    }

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Palitha");
        Thread.sleep(3000);
        List<WebElement> googleSearchList = driver.findElements(By.xpath("//span[normalize-space()='Palitha Thewarapperuma']"));
        System.out.println(googleSearchList.size());
        for (WebElement element :googleSearchList ){
            System.out.println(element.getText());
        }
    }
}
