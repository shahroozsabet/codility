package alten;

/**
 * Created by shsabet on 1/23/2019.
 */
public class MainTest {

    public static void main(String[] args) {
//        task1();
//        task2();
        task3();
    }

    private static void task3() {
        SolutionInterface solution = new Solution();
        System.out.println(solution.string_contains("ae", "elephant"));
        System.out.println(solution.string_contains("car", "race"));
        System.out.println(solution.string_contains("piano", "gruel"));
        System.out.println(solution.string_contains("abc", "abcd"));
        System.out.println(solution.string_contains("aeiou", "carolina"));
        System.out.println(solution.string_contains("zx", "xxxxyyxxz"));
        System.out.println(solution.string_contains("xyz", null));
        System.out.println(solution.string_contains("xyz", ""));
    }

    private static void task2() {
        SolutionInterface solution = new Solution();
        System.out.println(solution.indexOfDeviation("abc", "abd"));
        System.out.println(solution.indexOfDeviation("abcd", "abc"));
        System.out.println(solution.indexOfDeviation("xyz", "123"));
        System.out.println(solution.indexOfDeviation("abc", "abc"));
        System.out.println(solution.indexOfDeviation("qwerty", "qwertp"));
        System.out.println(solution.indexOfDeviation("t", "p"));
        System.out.println(solution.indexOfDeviation("heplo", "hello"));
        System.out.println(solution.indexOfDeviation("earth_mars_pluto", "earth_mars"));
        System.out.println(solution.indexOfDeviation("earth_mars", "earth_mars_pluto"));
        System.out.println(solution.indexOfDeviation("abc", null));
        System.out.println(solution.indexOfDeviation(null, "abc"));
        System.out.println(solution.indexOfDeviation("", "abc"));
        System.out.println(solution.indexOfDeviation("abc", ""));
    }

    private static void task1() {
        SolutionInterface solution = new Solution();
        System.out.println(solution.isEqual("abc", "abc"));
        System.out.println(solution.isEqual("carp", "cart"));
        System.out.println(solution.isEqual("pool", "tool"));
        System.out.println(solution.isEqual("jasmine", "jasm"));
    }

}
