import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
    char[] stack = new char[s.length()];
    int top = -1; 

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);


        if (c == '(' || c == '[' || c == '{') {
            stack[++top] = c;
        }

        else if (c == ')' || c == ']' || c == '}') {

            if (top == -1)
                return "NO";

            char open = stack[top--];

            if (!isMatching(open, c))
                return "NO";
        }
    }

    return (top == -1) ? "YES" : "NO";
}

private static boolean isMatching(char open, char close) {
    return (open == '(' && close == ')')
        || (open == '[' && close == ']')
        || (open == '{' && close == '}');
}
    }

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String s = bufferedReader.readLine();

            String result = Result.isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
