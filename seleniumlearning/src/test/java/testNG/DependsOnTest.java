package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnTest {

    @Test()
    public void olevel(){
        System.out.println("olevel");
        Assert.assertEquals("1","1");
    }

    @Test(dependsOnMethods = "olevel")
    public void alevel(){
        System.out.println("alevel");
    }

    @Test(dependsOnMethods = {"olevel", "alevel"}, alwaysRun = true)
    public void campus(){
        System.out.println("campus");
    }
}
