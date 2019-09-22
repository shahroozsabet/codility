package alten2;

/**
 * Created by shsabet on 1/23/2019.
 */
public class MainTest {

    public static void main(String[] args) {
        task1();
//        task2();
//        task3();
//        task4();
    }

    private static void task4() {
        SolutionInterface solutionInterface = new Solution();
        System.out.println(solutionInterface.lengthOfLISNaive(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solutionInterface.lengthOfLISBS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solutionInterface.lengthOfLISNaive(new int[]{9, 1, 3, 7, 5, 6, 20}));
        System.out.println(solutionInterface.lengthOfLISBS(new int[]{9, 1, 3, 7, 5, 6, 20}));
    }

    private static void task3() {
        SolutionInterface solutionInterface = new Solution();
        solutionInterface.getLongestSeq(new int[]{1, 2, -3, 2, 3, 4, -6,
                1, 2, 3, 4, 5, -8, 5, 6});
        solutionInterface.getLongestSeq(new int[]{-3, -6, -1, -3, -8});
    }

    private static void task2() {
        SolutionInterface solutionInterface = new Solution();
        System.out.println(solutionInterface.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    private static void task1() {
        SolutionInterface solutionInterface = new Solution();
        System.out.println("Length of the Longest consecutive subsequence is " +
                solutionInterface.findLongestConseqSubseq(new int[]{1, 9, 3, 10, 4, 20, 2}));
        System.out.println(solutionInterface.findLongestConseqSubseq(new int[]{36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}));
    }

}
