import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    //My code solution
    public static int cookies(int k, List<Integer> A) {
    // Write your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int cnt = 0;
        for(int i=0;i<A.size();i++){
            pq.add(A.get(i));
        }
        while(pq.size() > 1 && pq.peek() < k){
            int a = pq.remove();
            int b = pq.remove();
            int val = a + 2 * b;
            pq.add(val);
            cnt++;
        }
        return (pq.peek() >= k) ? cnt : -1;
    }
    
    //My code solution end

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
