package zalando;

/**
 * Created by shsabet on 1/23/2019.
 */
public class MainTest {

    public static void main(String[] args) {
        treeCutting();
        task2();
    }

    private static void treeCutting() {
        System.out.println("MainTest.treeCutting");
        Solution solution = new SolutionImpl();
        System.out.println(solution.treeCutting(new int[]{3, 4, 5, 4}));
        System.out.println(solution.treeCutting(new int[]{4, 5, 2, 3, 4}));
        System.out.println(solution.treeCutting(new int[]{1, 2, 3, 3, 5, 6, 7}));
        System.out.println(solution.treeCutting(new int[]{1, 2, 3, 4}));
        System.out.println(solution.treeCutting(new int[]{2, 1}));
        System.out.println(solution.treeCutting(new int[]{1}));
        System.out.println(solution.treeCutting(new int[]{}));

    }

    private static void task2() {
        System.out.println("MainTest.task2");
        Solution solution = new SolutionImpl();
        System.out.println(solution.task2(10, 20));
        System.out.println(solution.task2(6000, 7000));

    }

}
