package junit5tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class ParameterizedTests {

    //to use 2 csv files as the source, pass the file paths in as an array
    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/params/shoppinglist.csv", "src/test/resources/params/shoppinglist2.csv"}, numLinesToSkip = 1)
    //2nd arg above is to skip the first liine in the csv file bc it's the header line and doesnt match the values being passed in
    void csvFileSource_StrDblIntStrStr(String name, double price, int qty, String unit, String provider){
        System.out.println("name = " + name + ", price = " + price + ", qty = " + qty + ", unit = " + unit + ", provider = " + provider);
    }
    //output
    //name = tomato, price = 1.5, qty = 2, unit = kg, provider = grocery store
    //name = carrot, price = 3.0, qty = 5, unit = kg, provider = supermarket
    //name = cabbage, price = 1.2, qty = 10, unit = kg, provider = grocery store
    //name = beets, price = 5.0, qty = 1, unit = ks, provider = supermarket


    // "" in the csv file means pass in an empty string
    // leaving an empty val in one of the lines of the csv file means null 
}

// csv file looked like below

// name,price,quantity,unit of measure,provider
// tomato,1.5,2,kg,grocery store
// carrot,3,5,kg,supermarket
// cabbage,1.2,10,kg,grocery store
// beets,5,1,ks,supermarket
