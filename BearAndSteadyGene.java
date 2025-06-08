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

public class BearAndSteadyGene {
    public static int steadyGene(String gene) {
        int n = gene.length();
        int[] count = new int[4]; // A, C, G, T
        for (char c : gene.toCharArray()) {
            count[charIdx(c)]++;
        }
        int target = n / 4;
        if (count[0] == target && count[1] == target && count[2] == target && count[3] == target) return 0;

        int minLen = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            count[charIdx(gene.charAt(right))]--;
            while (count[0] <= target && count[1] <= target && count[2] <= target && count[3] <= target) {
                minLen = Math.min(minLen, right - left + 1);
                count[charIdx(gene.charAt(left))]++;
                left++;
            }
        }
        return minLen;
    }

    private static int charIdx(char c) {
        if (c == 'A') return 0;
        if (c == 'C') return 1;
        if (c == 'G') return 2;
        return 3; // 'T'
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String gene = sc.next();
        System.out.println(steadyGene(gene));
        sc.close();
    }
}