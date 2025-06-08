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

public class OrganizingContainers {
    public static String organizingContainers(int[][] container) {
        int n = container.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += container[i][j];
                colSum[j] += container[i][j];
            }
        }
        Arrays.sort(rowSum);
        Arrays.sort(colSum);
        for (int i = 0; i < n; i++) {
            if (rowSum[i] != colSum[i]) return "Impossible";
        }
        return "Possible";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int t = 0; t < q; t++) {
            int n = sc.nextInt();
            int[][] container = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    container[i][j] = sc.nextInt();
            System.out.println(organizingContainers(container));
        }
        sc.close();
    }
}