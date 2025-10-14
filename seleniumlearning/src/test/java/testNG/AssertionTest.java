package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionTest {

    SoftAssert softAssert = new SoftAssert(); //no static methods as in Assert class,so want to create a object and use
    //Assert --> Hard (a static method,don't want to create objects)
    //String name = "Isuri";
    String actualvalue = "ISuri";

    @Test(priority = 0)
    public void valueEqualCheck(){

        //using Java
//        if (name.equals("Isuri")){
//            System.out.println("Name is equal");
//        }else {
//            System.out.println("Name is not equal");
//        }

        //can use TestNG assertions instead of Java
        String expectedValue = "not";
        System.out.println("Prior to valueEqualCheck Assertion");
        softAssert.assertEquals(actualvalue,expectedValue,"value miss matched");
        System.out.println("After valuesEqualCheck assertion");
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void valuesNotEqualCheck(){
        String expectedValue = "Learn well";
        System.out.println("Prior to valuesNotEqualCheck Assertion");
        softAssert.assertNotEquals(actualvalue,expectedValue,"values matched");
        System.out.println("After valuesEqualCheck assertion");
    }

    @Test(priority = 2)
    public void trueConditionCheck(){
        System.out.println("Prior to trueConditionCheck Assertion");
        softAssert.assertTrue(actualvalue.startsWith("I"),"Condition return a false");
        System.out.println("After to trueConditionCheck assertion");
    }

    @Test(priority = 3)
    public void falseConditionCheck(){
        System.out.println("Prior to falseConditionCheck Assertion");
        softAssert.assertFalse(actualvalue.isEmpty(),"Condition return a True");
        System.out.println("After to falseConditionCheck assertion");
    }

}
//Hard assert --> do not execute remaining parts in a testcase after finding a assertion error.
//But execute the other testcases

//Soft asserts --> extends by Assertion class
//If there is a error, It should call  --> softAssert.assertAll(); to throw the error