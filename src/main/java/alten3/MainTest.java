package alten3;

/**
 * Created by shsabet on 1/23/2019.
 */
public class MainTest {

    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        SolutionInterface solutionInterface = new Solution();
        solutionInterface.getStartDay(
                new int[]{11, 2, 11, 9, 9, 12, 5, 6, 3, 11, 12, 4, 3, 3, 4, 8, 4, 8, 9, 5, 6, 12, 4});
    }

}
