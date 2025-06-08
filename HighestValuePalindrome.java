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

public class HighestValuePalindrome {
    public static String highestValuePalindrome(String s, int n, int k) {
        char[] arr = s.toCharArray();
        boolean[] changed = new boolean[n];
        int l = 0, r = n - 1;
        int changesNeeded = 0;

        // First pass: make it a palindrome with minimal changes
        while (l < r) {
            if (arr[l] != arr[r]) {
                char maxChar = (char) Math.max(arr[l], arr[r]);
                arr[l] = arr[r] = maxChar;
                changed[l] = changed[r] = true;
                k--;
            }
            l++;
            r--;
        }

        if (k < 0) return "-1";

        // Second pass: maximize palindrome value
        l = 0; r = n - 1;
        while (l <= r && k > 0) {
            if (l == r) {
                if (arr[l] != '9' && k > 0) {
                    arr[l] = '9';
                    k--;
                }
            } else {
                if (arr[l] != '9') {
                    if (changed[l] || changed[r]) {
                        if (k >= 1) {
                            arr[l] = arr[r] = '9';
                            k--;
                        }
                    } else if (k >= 2) {
                        arr[l] = arr[r] = '9';
                        k -= 2;
                    }
                }
            }
            l++;
            r--;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        String s = sc.nextLine();
        System.out.println(highestValuePalindrome(s, n, k));
        sc.close();
    }
}