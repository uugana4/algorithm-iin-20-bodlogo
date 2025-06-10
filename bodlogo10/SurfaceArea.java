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

public class SurfaceArea {
    public static int surfaceArea(int[][] A) {
        int H = A.length;
        int W = A[0].length;
        int area = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (A[i][j] > 0) area += 2; // top and bottom
                // up
                area += Math.max(A[i][j] - (i > 0 ? A[i - 1][j] : 0), 0);
                // down
                area += Math.max(A[i][j] - (i < H - 1 ? A[i + 1][j] : 0), 0);
                // left
                area += Math.max(A[i][j] - (j > 0 ? A[i][j - 1] : 0), 0);
                // right
                area += Math.max(A[i][j] - (j < W - 1 ? A[i][j + 1] : 0), 0);
            }
        }
        return area;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[][] A = new int[H][W];
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                A[i][j] = sc.nextInt();
        System.out.println(surfaceArea(A));
        sc.close();
    }
}