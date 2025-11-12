import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
          Scanner in = new Scanner(System.in);

        Stack<Integer> stackNewest = new Stack<Integer>();
        Stack<Integer> stackOldest = new Stack<Integer>();

        int q = in.nextInt(); 

        for (int i = 0; i < q; i++) {
            int type = in.nextInt();

            if (type == 1) {
                int x = in.nextInt();
                stackNewest.push(x);

            } else if (type == 2) {
                if (stackOldest.isEmpty()) {
                    while (!stackNewest.isEmpty()) {
                        stackOldest.push(stackNewest.pop());
                    }
                }
                stackOldest.pop();

            } else if (type == 3) {
                if (stackOldest.isEmpty()) {
                    while (!stackNewest.isEmpty()) {
                        stackOldest.push(stackNewest.pop());
                    }
                }
                System.out.println(stackOldest.peek());
            }
        }
    }
}
