import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */
     
     //My solution code start
     
    public static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if(lowers.size() == 0 || number < lowers.peek()){
            lowers.add(number);
        } else{
            highers.add(number);
        }
    }
    
    public static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        
        if(biggerHeap.size() - smallerHeap.size() >= 2){
            smallerHeap.add(biggerHeap.poll());
        }
    }
    
    public static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smallerHeap = lowers.size() > highers.size() ? highers : lowers;
        
        if(biggerHeap.size() == smallerHeap.size()){
            return ((double)biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    public static List<Double> runningMedian(List<Integer> a) {
    // Write your code here
        PriorityQueue<Integer> lowers = new PriorityQueue<Integer> (a.size(), new Comparator<Integer>(){
            public int compare(Integer x, Integer y){
                return -1 * x.compareTo(y);
            }
        });
        PriorityQueue<Integer> highers = new PriorityQueue<Integer>();
        List<Double> medians = new ArrayList<>();
        for(int n : a){
            int number = n;
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians.add(getMedian(lowers, highers));
        }
        return medians;
    }
    
    //My solution code end
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < aCount; i++) {
            int aItem = Integer.parseInt(bufferedReader.readLine().trim());
            a.add(aItem);
        }

        List<Double> result = Result.runningMedian(a);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
