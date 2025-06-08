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

public class SherlockAndAnagrams {
    public static int sherlockAndAnagrams(String s) {
        int n = s.length();
        Map<String, Integer> freq = new HashMap<String, Integer>();
        // Generate all substrings
        for (int len = 1; len < n; len++) {
            for (int i = 0; i <= n - len; i++) {
                char[] sub = s.substring(i, i + len).toCharArray();
                Arrays.sort(sub);
                String key = new String(sub);
                freq.put(key, freq.getOrDefault(key, 0) + 1);
            }
        }
        int count = 0;
        for (int v : freq.values()) {
            count += v * (v - 1) / 2;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();
        for (int t = 0; t < q; t++) {
            String s = sc.nextLine();
            System.out.println(sherlockAndAnagrams(s));
        }
        sc.close();
    }
}