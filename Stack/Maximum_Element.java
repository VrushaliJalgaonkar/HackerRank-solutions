import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */

    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
        Stack<String> st = new Stack<String>();
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<operations.size();i++){
            char option = operations.get(i).charAt(0);
            if(option == '1'){
                String val = operations.get(i).substring(2);
                //System.out.println("Val = "+val);
                if(!st.isEmpty()){
                    int max = Math.max(Integer.valueOf(val), Integer.valueOf(st.peek()));
                    st.push(String.valueOf(max));
                } else {
                    st.push(val);
                }
                
            } else if(option == '2'){
                if(!st.isEmpty()){
                    st.pop();
                }
            } else {
                if(!st.isEmpty()){
                    res.add(Integer.valueOf(st.peek()));
                }
            }
            
        }
        return res;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops);

        bufferedWriter.write(
            res.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
