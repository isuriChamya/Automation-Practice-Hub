package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowExample {

    WebDriver driver;

    @BeforeMethod
    public void windowTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
    }

    @Test
    public void windowTest() throws InterruptedException {
        //Click and confirm new Window Opens

        String oldWindow = driver.getWindowHandle();
        System.out.println("Parent window : " + oldWindow);

        WebElement openButton = driver.findElement(By.id("j_idt88:new"));
        openButton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handle size : " + handles.size());

        //first method - using forEach loop
//        for(String newWindow :handles){
//            System.out.println(newWindow);
//            driver.switchTo().window(newWindow);
//            System.out.println("page title" + driver.getTitle());
//        }
//
//        driver.close();
//
//        driver.switchTo().window(oldWindow);



        //second method : Using list

        List<String> list = new ArrayList<String>(handles); //Converting set to the list
        if (list.size() > 1){
            driver.switchTo().window(list.get(1));
            System.out.println("Child page title" + driver.getTitle());
        }

        driver.close();
        driver.switchTo().window(oldWindow);

        WebElement openbutton1 = driver.findElement(By.id("j_idt88:new"));
        boolean openbuttonVisible = openbutton1.isDisplayed();
        System.out.println("Open button visibility : "+ openbuttonVisible);
    }
}
