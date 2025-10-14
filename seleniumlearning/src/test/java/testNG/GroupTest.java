package testNG;

import org.testng.annotations.Test;

public class GroupTest {
    //s = Smoke     R = Regression

    @Test(groups = {"S","R"})
    public void test01(){
        System.out.println("This is smoke and regression Test case");
    }

    @Test(groups = {"R"})
    public void test02(){
        System.out.println("This is regression Test case");
    }

    @Test
    public void test03(){
        System.out.println("This is not smoke and regression Test case");
    }

    @Test(groups = {"S"})
    public void test04(){
        System.out.println("This is smoke Test case");
    }

    @Test(groups = {"S","R"})
    public void test05(){
        System.out.println("This is smoke and regression Test case");
    }

}
