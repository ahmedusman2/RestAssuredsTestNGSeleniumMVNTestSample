package DemoTestNG;

import org.testng.annotations.*;

public class PracticeJava {

    public void numberCheck() {
        int[] number = {1, 2, 3, 4, 5};
        for (int val : number) {
            System.out.println(val);
            if(val%2==0){}

        }

    }

    @Test
    public void AwainMethod() {
        System.out.println("hello");

        // Prime Number Check: Write a function that takes an
        // integer as input and returns true if it is a prime number, and false otherwise.
        // A prime number is a number greater than 1 that has no divisors other than 1 and itself.

        numberCheck();
    }


}
