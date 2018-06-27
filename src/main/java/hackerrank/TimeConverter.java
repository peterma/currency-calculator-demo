package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConverter {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        // Midnight is 12:00:00AM (12) -> 00:00:00 (24). Noon is 12:00:00PM (12) -> 12:00:00 (24).
        String upperCased = s.trim().toUpperCase();
        if(upperCased.endsWith("AM")) {
            upperCased = upperCased.replace("AM", "");
            String[] substrings = upperCased.split(":");
            if (substrings[0].equals("12")) substrings[0] = "00";
            return String.join(":", substrings);
        } else {
            upperCased = upperCased.replace("PM", "");
            String[] substrings = upperCased.split(":");
            if (!substrings[0].equals("12")) {
                substrings[0] = (Integer.parseInt(substrings[0]) + 12) + "";
            }
            return String.join(":", substrings);
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scan.nextLine();
//
//        String result = timeConversion(s);
//
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    	String[] testCases = {"12:40:22AM", "12:05:39AM", "12:45:54PM", "12:00:00AM"};
    	for (int i = 0; i < testCases.length; i++) {
    		System.out.println(timeConversion(testCases[i]));
    	}
    }
}
