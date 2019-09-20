package alten;

import java.util.Objects;

public class Solution implements SolutionInterface {

    public Solution() {
        // You can initiate and calculate things here
    }

    /**
     * Question 1: Returns if two strings are equal.
     */
    @Override
    public boolean isEqual(String str2, String str1) {
        return Objects.equals(str2, str1);
    }

    /**
     * Question 2: Returns the index at which 2 strings are unequal. Otherwise returns
     * -1.
     */
    @Override
    public int indexOfDeviation(String str2, String str1) {
        if (Objects.equals(str2, str1))
            return -1;
        if (str2 == null || str1 == null)
            return 0;
        if (str2.isEmpty() || str1.isEmpty())
            return 0;
        for (int i = 0; i < str2.length(); i++) {
            if (str2.charAt(i) != str1.charAt(i))
                return i;
            if (str2.length() > str1.length() && i == str1.length() - 1)
                return i + 1;
            if (str2.length() < str1.length() && i == str2.length() - 1) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * Question 3: Return a comma delimited, alphanumerically sorted, string of all the
     * common characters between two strings. Repeat characters do not need to be
     * included.
     */
    @Override
    public String string_contains(String str2, String str1) {
        if (str2 == null || str1 == null)
            return "";
        if (str2.isEmpty() || str1.isEmpty())
            return "";
        for (int i = 0; i < str2.length(); i++) {

        }
        return "";
    }
}
