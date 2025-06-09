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

public class NonDivisibleSubset {
    public static int nonDivisibleSubset(int k, List<Integer> S) {
        int[] freq = new int[k];
        for (int num : S) {
            freq[num % k]++;
        }
        int count = Math.min(freq[0], 1); // at most one element with remainder 0

        for (int i = 1; i <= k / 2; i++) {
            if (i != k - i) {
                count += Math.max(freq[i], freq[k - i]);
            }
        }
        // If k is even, only one element with remainder k/2 can be chosen
        if (k % 2 == 0) {
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> S = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            S.add(sc.nextInt());
        }
        System.out.println(nonDivisibleSubset(k, S));
        sc.close();
    }
}