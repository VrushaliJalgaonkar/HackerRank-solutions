import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int cmd = sc.nextInt();
            switch(cmd){
                case 1:
                    int val = sc.nextInt();
                    pq.add(val);
                    break;
                case 2:
                    val = sc.nextInt();
                    pq.remove(val);
                    break;
                case 3:
                val = pq.peek();
                System.out.println(val);
                break;
            }
        }
        sc.close();
    }
}
