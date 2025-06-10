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

public class BiggerIsGreater {
    public static String biggerIsGreater(String w) {
        char[] arr = w.toCharArray();
        int n = arr.length;
        int i = n - 2;
        // Step 1: Find the rightmost character which is smaller than its next character
        while (i >= 0 && arr[i] >= arr[i + 1]) i--;
        if (i < 0) return "no answer";
        // Step 2: Find the smallest character on right of i which is greater than arr[i]
        int j = n - 1;
        while (arr[j] <= arr[i]) j--;
        // Step 3: Swap arr[i] and arr[j]
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        // Step 4: Reverse the substring after i
        int left = i + 1, right = n - 1;
        while (left < right) {
            temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < T; t++) {
            String w = sc.nextLine();
            System.out.println(biggerIsGreater(w));
        }
        sc.close();
    }
}