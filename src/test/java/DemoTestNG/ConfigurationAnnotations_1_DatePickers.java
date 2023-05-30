package DemoTestNG;

import org.testng.annotations.*;

public class ConfigurationAnnotations_1_DatePickers {
    @Test (groups="smoke")
    public void test1_BootstrapDatePicker() {
        System.out.println("     [5] Test Method 1: Boot strap Date Picker");
    }

    @Test(groups="sanity")
    public void test2_JQueryDatePicker() {
        System.out.println("     [5] Test Method 2: JQuery Date Picker");
    }

    @BeforeMethod
    public void beforeMethods() {
        System.out.println("    [4] Execute Before Each Test Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("    [4] Execute After Each Method") ;
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("   [3] Execute Before Class: Date Pickers");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("   [3] Execute After Class: Date Pickers");
    }
    @BeforeGroups(groups={"smoke","sanity","e2e"})
    public void beforeGroups(){
        System.out.println("Execute before group");
    }

    @AfterGroups(groups={"smoke","sanity","e2e"})
    public void afterGroups(){
        System.out.println("Execute after group");
    }


}
