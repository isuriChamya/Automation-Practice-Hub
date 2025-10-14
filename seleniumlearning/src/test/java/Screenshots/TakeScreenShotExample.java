package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TakeScreenShotExample {
    WebDriver driver;

    @BeforeMethod
    public void openWebPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test
    public void takeScreenshotTest() throws IOException, AWTException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        //capture screenshot of full web page
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_full_web_page.png");
        FileHandler.copy(sourceFile,destinationFile );

        //capture screenshot of section of a web page
        WebElement section1pageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1pageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_section_of_the_page.png");
        FileUtils.copyFile(source,target );

        //capture screenshot of entire page
        //advantages : include url and tabs opened.
                    //when alert is opened --> not handling the alert

        Robot robot = new Robot();
        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screensize);
        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\Screenshot\\" + "alert_page_EntireScreen.png");
        ImageIO.write(source2, "png", destinationFile2);

    }
}
