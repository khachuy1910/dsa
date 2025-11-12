/*
Bài 4
Sherlock and Array
Tóm tắt: Cho mảng có n phần tử (a_0, …, a_n-1). Có hay không chỉ số i để sao cho tổng trái bằng tổng phải
(không tính số a_i), tức (a_0 + … + a_i-1) = (a_i+1 + … + a_n-1). Nếu có thì in ra “YES", nếu không thì in ra “NO"
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    int totalSum = 0;
        for (int num : arr){
            totalSum += num;
        }

        int leftSum = 0;
        for(int i = 0; i < arr.size(); i++){
            int rightSum = totalSum - leftSum - arr.get(i);

            if(leftSum == rightSum){
                return "YES";
            }
            leftSum += arr.get(i);
        }
        return "NO";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        for (int TItr = 0; TItr < T; TItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrTemp[i]);
                arr.add(arrItem);
            }

            String result = Result.balancedSums(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
