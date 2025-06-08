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

public class EmaSuperComputer {
    public static int twoPluses(String[] grid) {
        int n = grid.length, m = grid[0].length();
        int[][] maxArm = new int[n][m];

        // Precompute max arm length for each cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == 'G') {
                    int arm = 0;
                    while (i - arm >= 0 && i + arm < n && j - arm >= 0 && j + arm < m &&
                           grid[i - arm].charAt(j) == 'G' &&
                           grid[i + arm].charAt(j) == 'G' &&
                           grid[i].charAt(j - arm) == 'G' &&
                           grid[i].charAt(j + arm) == 'G') {
                        arm++;
                    }
                    maxArm[i][j] = arm - 1;
                }
            }
        }

        int maxProduct = 0;
        // Try all pairs of pluses
        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int arm1 = maxArm[i1][j1]; arm1 >= 0; arm1--) {
                    boolean[][] occupied = new boolean[n][m];
                    markPlus(occupied, i1, j1, arm1);
                    int area1 = 1 + 4 * arm1;
                    for (int i2 = 0; i2 < n; i2++) {
                        for (int j2 = 0; j2 < m; j2++) {
                            for (int arm2 = maxArm[i2][j2]; arm2 >= 0; arm2--) {
                                if (!overlap(occupied, i2, j2, arm2, n, m)) {
                                    int area2 = 1 + 4 * arm2;
                                    maxProduct = Math.max(maxProduct, area1 * area2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return maxProduct;
    }

    private static void markPlus(boolean[][] occ, int x, int y, int arm) {
        occ[x][y] = true;
        for (int d = 1; d <= arm; d++) {
            occ[x + d][y] = true;
            occ[x - d][y] = true;
            occ[x][y + d] = true;
            occ[x][y - d] = true;
        }
    }

    private static boolean overlap(boolean[][] occ, int x, int y, int arm, int n, int m) {
        if (x < 0 || x >= n || y < 0 || y >= m) return true;
        if (occ[x][y]) return true;
        for (int d = 1; d <= arm; d++) {
            if (x + d >= n || occ[x + d][y]) return true;
            if (x - d < 0 || occ[x - d][y]) return true;
            if (y + d >= m || occ[x][y + d]) return true;
            if (y - d < 0 || occ[x][y - d]) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        sc.nextLine();
        String[] grid = new String[n];
        for (int i = 0; i < n; i++) grid[i] = sc.nextLine();
        System.out.println(twoPluses(grid));
        sc.close();
    }
}