package numberrangesummarizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class NumberRangeSummarizerTest {

    nrs t = new nrs();
    String first_input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";    //input
    String second_input = "1,3";
    String third_input = "1,2";
    String fourth_input = "1,2,3,4,5,6,7,8,9";
    String fifth_input = "1,2,3,5,7,12,34,35,36";

    Collection<Integer> first_input_col = t.collect(first_input);   //collection using the collect function
    Collection<Integer> second_input_col = t.collect(second_input);
    Collection<Integer> third_input_col = t.collect(third_input);
    Collection<Integer> fourth_input_col = t.collect(fourth_input);
    Collection<Integer> fifth_input_col = t.collect(fifth_input);



    @Test
    public void test_collect(){   //test the collect function, we assume string has at least 2 numbers, is ascending and is in the right format

        
        Collection<Integer> first_col_ans = new ArrayList<Integer>(Arrays.asList(1, 3, 6,7,8,12,13,14,15,21,22,23,24,31));
        Collection<Integer> second_col_ans = new ArrayList<Integer>(Arrays.asList(1,3));
        
        assertEquals(second_input_col,second_col_ans);
        assertEquals(first_input_col,first_col_ans);    //check if the collect function returns the right collection
    }

    @Test
    public void test_summarizeCollection(){ //test the summarize collection function

        first_input = t.summarizeCollection(first_input_col);
        second_input = t.summarizeCollection(second_input_col);
        third_input = t.summarizeCollection(third_input_col);
        fourth_input= t.summarizeCollection(fourth_input_col);
        fifth_input = t.summarizeCollection(fifth_input_col);
        
        assertEquals("1,3,6-8,12-15,21-24,31",first_input);
        assertEquals("1,3", second_input);
        assertEquals("1-2", third_input);
        assertEquals("1-9", fourth_input);
        assertEquals("1-3,5,7,12,34-36", fifth_input);

        assertNotEquals("1-3", second_input);
        assertNotEquals("1,2", third_input);
    }
    
}
