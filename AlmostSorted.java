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

public class AlmostSorted {
    public static void almostSorted(int[] arr) {
        int n = arr.length;
        int l = -1, r = -1;
        // Find the first and last indices where the array is not sorted
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                l = i;
                break;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                r = i;
                break;
            }
        }
        if (l == -1) {
            System.out.println("yes");
            return;
        }
        // Try swap
        swap(arr, l, r);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("swap " + (l + 1) + " " + (r + 1));
            return;
        }
        // Undo swap and try reverse
        swap(arr, l, r);
        reverse(arr, l, r);
        if (isSorted(arr)) {
            System.out.println("yes");
            System.out.println("reverse " + (l + 1) + " " + (r + 1));
            return;
        }
        System.out.println("no");
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        almostSorted(arr);
        sc.close();
    }
}