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

public class FullCountingSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<String>> buckets = new ArrayList<List<String>>();
        for (int i = 0; i < 100; i++) buckets.add(new ArrayList<String>());

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            String s = sc.next();
            if (i < n / 2) {
                buckets.get(x).add("-");
            } else {
                buckets.get(x).add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            for (String str : buckets.get(i)) {
                sb.append(str).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
        sc.close();
    }
}