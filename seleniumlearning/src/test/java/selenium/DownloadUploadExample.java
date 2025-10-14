package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.File;

public class DownloadUploadExample {
    WebDriver driver;

    @BeforeMethod
    public void DownloadPage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Isuri.Weeraman\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/file.xhtml");
    }

    @Test
    public void DownloadUploadFile() throws InterruptedException {
        WebElement downloadbtn = driver.findElement(By.id("j_idt93:j_idt95"));
        downloadbtn.click();
        Thread.sleep(2000);

        File file = new File("Downloads");
        File[] totalFIles = file.listFiles();
        for (File findfile : totalFIles){
            if (findfile.getName().equals("gdfn")){
                System.out.println("File is found");
                break;
            }
        }//not working this yet
    }

    @Test
    public void UploadFile() throws AWTException, InterruptedException {
        //using robot class
        WebElement uploadbtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadbtn.click();

        //windows control begin here
//        String data = "C:\\upload seleniumFile";
//        StringSelection selection = new StringSelection(data);
//
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
//
//        //want to use robot class,can't use actions class bcz this is not a web application now, this is a windows application
//        Robot robot = new Robot();
//        robot.keyPress(KeyEvent.VK_CONTROL);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_CONTROL);
//        //Thread.sleep(2000);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        //2nd way - using sendkeys : make sure that type is a file
        String data = "C:\\upload seleniumFile";
        WebElement uploadbtn2 = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadbtn2.sendKeys(data);

    }

}
