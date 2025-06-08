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

public class TimeInWords {
    static String[] nums = {
        "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
        "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
        "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six",
        "twenty seven", "twenty eight", "twenty nine"
    };

    public static String timeInWords(int h, int m) {
        if (m == 0) return nums[h] + " o' clock";
        if (m == 15) return "quarter past " + nums[h];
        if (m == 30) return "half past " + nums[h];
        if (m == 45) return "quarter to " + nums[h + 1];
        if (m < 30) {
            if (m == 1) return "one minute past " + nums[h];
            return nums[m] + " minutes past " + nums[h];
        } else {
            int mm = 60 - m;
            if (mm == 1) return "one minute to " + nums[h + 1];
            return nums[mm] + " minutes to " + nums[h + 1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(timeInWords(h, m));
        sc.close();
    }
}