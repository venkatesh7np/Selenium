package nike;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MinCostProduct {
    Utility utility=new Utility();
    @BeforeTest
    void setup(){
        utility.openURL();
    }
    @Test
    void validate(){
        utility.lowestPrice("Shoes");
    }
    @AfterTest
    void teardown(){
    }
}