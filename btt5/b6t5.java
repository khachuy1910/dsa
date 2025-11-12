import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        StringBuilder text = new StringBuilder();
        Stack<String[]> history = new Stack<>();

        for (int i = 0; i < Q; i++) {
            int type = sc.nextInt();

            if (type == 1) { 
                String s = sc.next();
                history.push(new String[]{"1", String.valueOf(s.length())}); 
                text.append(s);
            } 
            else if (type == 2) { 
                int k = sc.nextInt();
                int len = text.length();
                String deleted = text.substring(len - k, len);
                history.push(new String[]{"2", deleted});
                text.delete(len - k, len);
            } 
            else if (type == 3) { 
                int k = sc.nextInt();
                System.out.println(text.charAt(k - 1));
            } 
            else if (type == 4) {
                String[] last = history.pop();
                if (last[0].equals("1")) { 
                    int count = Integer.parseInt(last[1]);
                    text.delete(text.length() - count, text.length());
                } else { 
                    text.append(last[1]);
                }
            }
        }
        sc.close();
    }
}
