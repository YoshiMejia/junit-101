package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedTests {
    //if we want to annotate a method to specify that we will pass args into that test, use the following annotation...
    @ParameterizedTest(name = "Run: {index} - value: {arguments}")
    //by passing args to the PT annotation above, you are adjusting the test info shown in the console window below to have a more detailed output

    //specify how we want to pass in values
    // ValueSource is for passing literal/constant values. when using it, you can only pass in 1 param. so here we used an array of values bc each of the vals will correspond to the param we're sending.
    @ValueSource(ints = {1,5,6})

    void intValues(int param){
        System.out.println("param = " + param);
        // the shortcut 'soutp' autogens the line above, which will be outputting to the console whichever params were passed into the method
    }
    //output ->
    //    param = 1
    //    param = 5
    //    param = 6

    //passing strings as params

    @ParameterizedTest
    @ValueSource(strings = {"firstStr", "secondStr"})
    // with strings and VS we can pass in null/empty strings there are 2 other annotations to use:
    @EmptySource
    //empty string ^ this does not work with int, floats, booleans, or other primitives
    @NullSource
    // passes null as an arg
    @NullAndEmptySource
    // both null and empty string to be passed as an arg.
    void stringValues(String param){
        System.out.println("param = " + param);
    }
    // output ->
    // param = firstStr
    // param = secondStr
}



