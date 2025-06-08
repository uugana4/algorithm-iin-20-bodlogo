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

public class GridlandMetro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        int k = sc.nextInt();

        Map<Integer, List<int[]>> tracks = new HashMap<Integer, List<int[]>>();
        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if (!tracks.containsKey(r)) tracks.put(r, new ArrayList<int[]>());
            tracks.get(r).add(new int[]{c1, c2});
        }

        long occupied = 0;
        for (List<int[]> rowTracks : tracks.values()) {
            // Sort intervals by start
            Collections.sort(rowTracks, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Integer.compare(a[0], b[0]);
                }
            });
            int prevStart = -1, prevEnd = -1;
            for (int[] track : rowTracks) {
                int start = track[0], end = track[1];
                if (start > prevEnd) {
                    occupied += end - start + 1;
                    prevStart = start;
                    prevEnd = end;
                } else if (end > prevEnd) {
                    occupied += end - prevEnd;
                    prevEnd = end;
                }
            }
        }

        long total = n * m;
        System.out.println(total - occupied);
        sc.close();
    }
}