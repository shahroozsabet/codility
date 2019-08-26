package af;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by shsabet on 1/23/2019.
 */
public class SolutionImpl implements Solution {

    @Override
    public String solution(String s) {
        if (s == null || s.isEmpty())
            return "other";
        char c = s.charAt(0);
        if (Character.isUpperCase(c)) {  // please fix condition
            return "upper";
        } else if (Character.isLowerCase(c)) {  // please fix condition
            return "lower";
        } else if (Character.isDigit(c)) {  // please fix condition
            return "digit";
        } else {
            return "other";
        }
    }

    @Override
    public int task2(int A, int B) {
        return (int) IntStream.range(1, B).map(i -> i * (i + 1)).filter(res -> A <= res && res <= B).count();
    }

    @Override
    public int solution(int N, String S) {
        if (S.trim().isEmpty())
            return N * 2;
        String[] occupiedSeats = S.split(" ", 0);


        List<String> collect1 = Arrays.stream(occupiedSeats).filter(s -> s.startsWith("1")).collect(Collectors.toList());
        long count13 = collect1.stream().filter(s -> s.endsWith("d") || s.endsWith("E") || s.endsWith("F") || s.endsWith("G")).count();
        if (count13 > 2) {
            return 0;
        }
        long count11 = collect1.stream().filter(s -> s.endsWith("A") || s.endsWith("C")).count();
        long count12 = collect1.stream().filter(s -> s.endsWith("H") || s.endsWith("K")).count();
        return N;
    }
}
