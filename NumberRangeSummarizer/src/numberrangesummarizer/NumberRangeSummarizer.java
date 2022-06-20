package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */
public interface NumberRangeSummarizer {

    //collect the input
    Collection<Integer> collect(String input);

    //get the summarized string
    String summarizeCollection(Collection<Integer> input);

}

 class nrs     //class to implement the interface
    implements NumberRangeSummarizer{
        
        public Collection<Integer> collect(String input) {
            String [] input_string = input.split(",");  //split the input to get individual values
            Collection<Integer> hold_input = new ArrayList<Integer>();
    
            for(int i=0;i<input_string.length;++i){
                hold_input.add(Integer.parseInt(input_string[i]));  //convert each char to int before adding to collection
            }
    
            return hold_input;
        }

        public String summarizeCollection(Collection<Integer> input){
            Integer[] input_arr = input.toArray(new Integer[0]);    //convert collection to Array as it's easier to work with
            String final_answer = "";   //empty string to hold final answer
            int length = input_arr.length;
    
            for(int i=0; i<length-1;++i){   //loop through array
                
                if( (input_arr[i+1] - input_arr[i]) == 1){  //check if 2 elements are sequential
                    if(final_answer.length() == 0 || final_answer.charAt(final_answer.length()-1) != '-'){  //check if the current value is in a group
                        final_answer = final_answer + String.valueOf(input_arr[i]) + "-";   //if it isn't, add it to start a group
                    }
                    if ( i != length-2 && final_answer.charAt(final_answer.length()-1) == '-'){ //if it's sequential and in a group then ignore this value
                        continue;
                    }  
                }
                else{   //if the number isn't sequential, it can be added directly to the final string
    
                    final_answer = final_answer + String.valueOf(input_arr[i]);
                    
                }
    
                if(i+1 != length && final_answer.charAt(final_answer.length()-1) != '-' ){
                    final_answer = final_answer + ",";  //adding commas to every string if it isn't the last value and isn't in the middle of a group
                }
    
                if(i == length-2){  //adds the last value to the final_answer string
                    final_answer = final_answer + input_arr[i+1];
                }
    
            }
    
            return final_answer;
    
        }

    }

class Main{
    public static void main(String[] args) throws Exception {
        String s = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        nrs t = new nrs();
        Collection<Integer> input_col = t.collect(s);
        s = t.summarizeCollection(input_col);
        
        System.out.println(s);
   }
}


