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

public class QueensAttack {
    public static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        // Directions: N, NE, E, SE, S, SW, W, NW
        int[] dr = {-1, -1,  0,  1, 1,  1,  0, -1};
        int[] dc = { 0,  1,  1,  1, 0, -1, -1, -1};
        int[] maxSteps = new int[8];
        Arrays.fill(maxSteps, n);

        // Calculate max steps in each direction without obstacles
        maxSteps[0] = r_q - 1;             // N
        maxSteps[1] = Math.min(r_q - 1, n - c_q); // NE
        maxSteps[2] = n - c_q;             // E
        maxSteps[3] = Math.min(n - r_q, n - c_q); // SE
        maxSteps[4] = n - r_q;             // S
        maxSteps[5] = Math.min(n - r_q, c_q - 1); // SW
        maxSteps[6] = c_q - 1;             // W
        maxSteps[7] = Math.min(r_q - 1, c_q - 1); // NW

        // Map obstacles for quick lookup
        Map<String, Integer> obsMap = new HashMap<String, Integer>();
        for (int[] obs : obstacles) {
            int ro = obs[0], co = obs[1];
            int drObs = ro - r_q;
            int dcObs = co - c_q;
            for (int d = 0; d < 8; d++) {
                int step = 0;
                // Check if obstacle is in this direction
                while (true) {
                    int nr = r_q + dr[d] * (step + 1);
                    int nc = c_q + dc[d] * (step + 1);
                    if (nr == ro && nc == co) {
                        // Obstacle found in this direction
                        if (step < maxSteps[d]) {
                            maxSteps[d] = step;
                        }
                        break;
                    }
                    if (nr < 1 || nr > n || nc < 1 || nc > n) break;
                    step++;
                }
            }
        }

        int total = 0;
        for (int i = 0; i < 8; i++) {
            total += maxSteps[i];
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int r_q = sc.nextInt();
        int c_q = sc.nextInt();
        int[][] obstacles = new int[k][2];
        for (int i = 0; i < k; i++) {
            obstacles[i][0] = sc.nextInt();
            obstacles[i][1] = sc.nextInt();
        }
        System.out.println(queensAttack(n, k, r_q, c_q, obstacles));
        sc.close();
    }
}