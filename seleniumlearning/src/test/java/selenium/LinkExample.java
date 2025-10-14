package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LinkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


    @Test
    public void Linktests(){

        //take me to dash board
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard")); // press ctrl + findelement to find the store type
        homeLink.click();
        driver.navigate().back();

        //Find my destination
        WebElement whereToGo =  driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This link is going to : " + path);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("The link is broken");
        }else {
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //duplicate link
        WebElement homeLinkAgain = driver.findElement(By.linkText("Go to Dashboard"));
        homeLinkAgain.click();
        //staleElement exception : when interacting with a WebElement that is no longer associated with an HTML element in the DOM.
        driver.navigate().back();

        //count page links
        List<WebElement> countfullpageLinks =  driver.findElements(By.tagName("a")); //we can't store tagnames in a webelement. Store in a list.
        int pageLinkCount = countfullpageLinks.size();
        System.out.println("Count of full page count = " + pageLinkCount);

        //count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> CountOfLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of Layout Links = " + CountOfLayoutLinks.size());

    }


}
