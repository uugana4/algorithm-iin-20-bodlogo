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

public class GridSearch {
    public static String gridSearch(String[] G, String[] P) {
        int R = G.length, C = G[0].length();
        int r = P.length, c = P[0].length();

        for (int i = 0; i <= R - r; i++) {
            for (int j = 0; j <= C - c; j++) {
                boolean found = true;
                for (int k = 0; k < r; k++) {
                    if (!G[i + k].substring(j, j + c).equals(P[k])) {
                        found = false;
                        break;
                    }
                }
                if (found) return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int test = 0; test < t; test++) {
            int R = sc.nextInt();
            int C = sc.nextInt();
            sc.nextLine();
            String[] G = new String[R];
            for (int i = 0; i < R; i++) G[i] = sc.nextLine();
            int r = sc.nextInt();
            int c = sc.nextInt();
            sc.nextLine();
            String[] P = new String[r];
            for (int i = 0; i < r; i++) P[i] = sc.nextLine();
            System.out.println(gridSearch(G, P));
        }
        sc.close();
    }
}