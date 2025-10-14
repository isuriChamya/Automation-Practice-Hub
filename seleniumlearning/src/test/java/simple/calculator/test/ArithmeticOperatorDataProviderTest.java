package simple.calculator.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import simple.calculator.ArithmeticOperator;

public class ArithmeticOperatorDataProviderTest {

    SoftAssert softAssert = new SoftAssert();

    @Test(dataProvider = "setOfData")
    public void testSum(int input1, int input2, int expectedOutput){
        softAssert.assertEquals(ArithmeticOperator.calSum(input1,input2),expectedOutput,"Failed to cal sum");
        softAssert.assertAll();
    }

    @DataProvider(name = "setOfData")
    public Object[][] getData(){
        Object[][] data = {
            {0,1,1},{0,-1,-1},{-1341356,-1,-321343},{433333575,1,34569819}
        };
        return data;
    }
}
