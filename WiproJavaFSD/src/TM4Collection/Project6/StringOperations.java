package TM4Collection.Project6;

import java.util.ArrayList;

public class StringOperations {

    /**
     * Performs a series of specified string operations on two input strings.
     *
     * @param s1 The primary string.
     * @param s2 The secondary string, assumed to be of smaller or equal size.
     * @return An ArrayList<String> containing the results of the five operations.
     */
    public ArrayList<String> performOperations(String s1, String s2) {
        ArrayList<String> results = new ArrayList<>();

        // --- Operation 1: Replace alternate characters in S1 with S2 ---
        StringBuilder op1Result = new StringBuilder();
        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) { // Check for alternate indices (0, 2, 4...)
                op1Result.append(s2);
            } else {
                op1Result.append(s1.charAt(i));
            }
        }
        results.add(op1Result.toString());

        // --- Operation 2: Replace last occurrence of S2 if it appears more than once ---
        int firstIndex = s1.indexOf(s2);
        int lastIndex = s1.lastIndexOf(s2);

        if (firstIndex != -1 && firstIndex != lastIndex) { // Checks if S2 appears more than once
            String reversedS2 = new StringBuilder(s2).reverse().toString();
            String op2Result = s1.substring(0, lastIndex) + reversedS2 + s1.substring(lastIndex + s2.length());
            results.add(op2Result);
        } else {
            results.add(s1 + s2);
        }

        // --- Operation 3: Delete first occurrence of S2 if it appears more than once ---
        if (firstIndex != -1 && firstIndex != lastIndex) { // Re-using the condition from above
            String op3Result = s1.substring(0, firstIndex) + s1.substring(firstIndex + s2.length());
            results.add(op3Result);
        } else {
            results.add(s1);
        }

        // --- Operation 4: Add halves of S2 to the beginning and end of S1 ---
        int n = s2.length();
        String firstHalf, secondHalf;
        if (n % 2 == 0) { // Even length
            firstHalf = s2.substring(0, n / 2);
            secondHalf = s2.substring(n / 2);
        } else { // Odd length
            firstHalf = s2.substring(0, (n / 2) + 1);
            secondHalf = s2.substring((n / 2) + 1);
        }
        results.add(firstHalf + s1 + secondHalf);

        // --- Operation 5: Replace characters from S2 in S1 with "*" ---
        // Creates a regex pattern like "[VA]" to replace all V's and A's
        String regex = "[" + s2 + "]";
        String op5Result = s1.replaceAll(regex, "*");
        results.add(op5Result);

        return results;
    }

    public static void main(String[] args) {
        // Sample Input
        String s1 = "JAVAJAVA";
        String s2 = "VA";

        // Create an instance of the class and call the method
        StringOperations stringOps = new StringOperations();
        ArrayList<String> output = stringOps.performOperations(s1, s2);

        // Print the final list
        System.out.println(output);
    }
}