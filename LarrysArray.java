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

public class LarrysArray {
    public static String larrysArray(int[] A) {
        int n = A.length;
        int inversions = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) inversions++;
            }
        }
        // If the number of inversions is even, it's possible
        return (inversions % 2 == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) A[i] = sc.nextInt();
            System.out.println(larrysArray(A));
        }
        sc.close();
    }
}