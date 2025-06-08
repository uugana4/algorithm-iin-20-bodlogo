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

public class SherlockAndValidString {
    public static String isValid(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        for (int f : freq) {
            if (f > 0) freqCount.put(f, freqCount.getOrDefault(f, 0) + 1);
        }

        if (freqCount.size() == 1) return "YES";
        if (freqCount.size() > 2) return "NO";

        List<Integer> keys = new ArrayList<Integer>(freqCount.keySet());
        int f1 = keys.get(0), f2 = keys.get(1);
        int c1 = freqCount.get(f1), c2 = freqCount.get(f2);

        // One character can be removed (either one char with freq 1, or one char with freq+1)
        if ((c1 == 1 && (f1 - 1 == 0 || f1 - 1 == f2)) ||
            (c2 == 1 && (f2 - 1 == 0 || f2 - 1 == f1))) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isValid(s));
        sc.close();
    }
}