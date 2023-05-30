package DemoTestNG;

import org.testng.annotations.*;
@Test(groups={"e2e"})
public class ConfigurationAnnotations_2_Listbox {

    @BeforeClass
    public void beforeClass(){
        System.out.println("   [3] Execute Before Class: List Box");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("   [3] Execute After Class: List Box");
    }


    public void test3_BootstrapListBox () {
        System.out.println("     [5] Test Method 3: Bootstrap List Box");
    }

    public void test4_JQueryListBox () {
        System.out.println("     [5] Test Method 2: JQuery List Box");
    }

    @BeforeMethod
    public void beforeMethods() {
        System.out.println("    [4] Execute Before Each Test Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("    [4] Execute After Each Method") ;
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("  (2) Execute before each Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("  (2) Execute after each Test");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println(" (1) Execute before the Sui  te");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println(" (1) Execute after the Suite");
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
