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

public class HackerlandRadioTransmitters {
    public static int hackerlandRadioTransmitters(int[] x, int k) {
        Arrays.sort(x);
        int n = x.length;
        int count = 0;
        int i = 0;
        while (i < n) {
            count++;
            int loc = x[i] + k;
            // Move to the rightmost house within range of loc
            while (i < n && x[i] <= loc) i++;
            // Place transmitter at the furthest such house
            int transmitter = x[i - 1];
            loc = transmitter + k;
            // Skip all houses covered by this transmitter
            while (i < n && x[i] <= loc) i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] x = new int[n];
        for (int i = 0; i < n; i++) x[i] = sc.nextInt();
        System.out.println(hackerlandRadioTransmitters(x, k));
        sc.close();
    }
}