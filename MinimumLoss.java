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

public class MinimumLoss {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] prices = new long[n];
        for (int i = 0; i < n; i++) prices[i] = sc.nextLong();

        // Store price and original index
        List<long[]> list = new ArrayList<long[]>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{prices[i], i});
        }
        // Sort by price ascending
        Collections.sort(list, new Comparator<long[]>() {
            public int compare(long[] a, long[] b) {
                return Long.compare(a[0], b[0]);
            }
        });

        long minLoss = Long.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            // Only consider if the higher price was before the lower price in the original array
            if (list.get(i)[1] < list.get(i - 1)[1]) {
                long loss = list.get(i)[0] - list.get(i - 1)[0];
                if (loss < minLoss) minLoss = loss;
            }
        }
        System.out.println(minLoss);
        sc.close();
    }
}