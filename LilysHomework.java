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

public class LilysHomework {
    public static int lilysHomework(int[] arr) {
        int n = arr.length;
        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        return Math.min(swaps(arr, sorted), swaps(arr, reverse(sorted)));
    }

    private static int swaps(int[] arr, int[] target) {
        int n = arr.length;
        int[] pos = new int[n];
        Map<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) valueToIndex.put(arr[i], i);
        int[] temp = arr.clone();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (temp[i] != target[i]) {
                count++;
                int idx = valueToIndex.get(target[i]);
                // Swap in temp
                valueToIndex.put(temp[i], idx);
                valueToIndex.put(temp[idx], i);
                int t = temp[i];
                temp[i] = temp[idx];
                temp[idx] = t;
            }
        }
        return count;
    }

    private static int[] reverse(int[] arr) {
        int n = arr.length;
        int[] rev = new int[n];
        for (int i = 0; i < n; i++) rev[i] = arr[n - 1 - i];
        return rev;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(lilysHomework(arr));
        sc.close();
    }
}