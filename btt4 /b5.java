/*
Bài 5
Closest Numbers
Tóm tắt: Cho một dãy các số chưa được sắp. Giữa hai số bất kỳ trong dãy, chúng ta có giá trị tuyệt đối của hiệu giữa chúng.
Hãy tìm và in ra những cặp số có giá trị tuyệt đối chênh lệch trên là nhỏ nhất. Nếu có nhiều cặp như vậy thì in hết ra.
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    public static List<Integer> closestNumbers(List<Integer> arr) {
    int mi = Integer.MAX_VALUE;

    Collections.sort(arr);

    for (int i = 0; i < arr.size() - 1; i++) {
        mi = Math.min(mi, arr.get(i + 1) - arr.get(i));
    }

    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < arr.size() - 1; i++) {
        if (arr.get(i + 1) - arr.get(i) == mi) {
            result.add(arr.get(i));
            result.add(arr.get(i + 1));
        }
    }

    return result;
}

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        List<Integer> result = Result.closestNumbers(arr);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
