package testNG.listners;

import okio.Timeout;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//1st way --> @Listeners  //2nd way --> by xml file,not in this class
@Listeners(CustomListnerTest.class) //in 2nd way ,not need this
public class ListenerTest {

    @Test
    public void test01(){
        System.out.println("I'm inside the method");
    }

    @Test
    public void test02(){
        System.out.println("I'm inside the method");
        Assert.assertTrue(false);
    }

    @Test(timeOut = 1000)
    public void test03() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("I'm inside the method");
    }

    @Test(dependsOnMethods = "test03")
    public void test04(){
        System.out.println("I'm inside the method");
    }
}
