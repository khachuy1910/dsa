import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][];
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt(); 
            arr[i] = new int[d];
            for (int j = 0; j < d; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int q = sc.nextInt(); 
        for (int i = 0; i < q; i++) {
            int x = sc.nextInt() - 1; 
            int y = sc.nextInt() - 1; 

            if (x < 0 || x >= n || y < 0 || y >= arr[x].length) {
                System.out.println("ERROR!");
            } else {
                System.out.println(arr[x][y]);
            }
        }

        sc.close();
    }
}
