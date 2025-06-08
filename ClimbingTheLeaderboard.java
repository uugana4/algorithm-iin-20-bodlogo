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

public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] alice = new int[m];
        for (int i = 0; i < m; i++) alice[i] = sc.nextInt();

        // Remove duplicates and sort descending
        List<Integer> uniqueScores = new ArrayList<Integer>();
        uniqueScores.add(scores[0]);
        for (int i = 1; i < n; i++) {
            if (scores[i] != scores[i - 1]) uniqueScores.add(scores[i]);
        }

        int l = uniqueScores.size();
        int idx = l - 1;
        for (int i = 0; i < m; i++) {
            int aliceScore = alice[i];
            while (idx >= 0 && aliceScore >= uniqueScores.get(idx)) {
                idx--;
            }
            System.out.println(idx + 2);
        }
        sc.close();
    }
}