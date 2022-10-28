//notice that all methods have "void" as the return type -- test methods *cannot* return anything
// also notice they dont have access modifiers -- test methods don't need AM's but they *cannot* be private

package junit5tests;

import org.junit.jupiter.api.*;

//the next lines purpose is to avoid having to define the other methods as static
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstTestClass {

  //runs before all the methods in this file
    @BeforeAll
    void beforeAll(){
        System.out.println("--This is the before All method");
    }

  //runs each time another method runs, right before it (look at bottom for output/expample)
    @BeforeEach
    void beforeEach(){
        System.out.println("----This is the before Each method");
    }

  //runs at the end once all the other methods have ran
    @AfterAll
    void afterAll(){
        System.out.println("-------This is the after all method");
    }

  //similar to BeforeEach except it runs *after*
    @AfterEach
    void  afterEach(){
        System.out.println("------------this is the after each method");
    }

    @Test
    void firstMethod(){
        System.out.println("First test method");
    }
    @Test
    @DisplayName("Second method")
    void secondMethod(){
        System.out.println("Second test method");
    }
}

//output =>
// --This is the before All method
// ----This is the before Each method
// First test method
// ------------this is the after each method
// ----This is the before Each method
// Second test method
// ------------this is the after each method
// -------This is the after all method
