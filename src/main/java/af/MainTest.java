package af;

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
        System.out.println("MainTest.task3");
        Solution solution = new SolutionImpl();
        System.out.println(solution.solution(2, "1A 2F 1C"));
        System.out.println(solution.solution(1, "1A 3C 2B 40G 5A"));
        System.out.println(solution.solution(1, ""));
    }

    private static void task2() {
        System.out.println("MainTest.task2");
        Solution solution = new SolutionImpl();
//        System.out.println(solution.task2(6, 20));
//        System.out.println(solution.task2(21, 29));
//        System.out.println(solution.task2(6, 6));
//        System.out.println(solution.task2(2, 3));
//        System.out.println(solution.task2(1, 3));
//        System.out.println(solution.task2(1, 6));
        System.out.println(solution.task2(20, 20));

    }

    private static void task1() {
        System.out.println("MainTest.task1");
        Solution solution = new SolutionImpl();
        String s = " 1";
        System.out.println(solution.solution(s));
    }

}
