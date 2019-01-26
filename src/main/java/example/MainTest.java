package example;

import java.util.Arrays;

/**
 * Created by shsabet on 1/23/2019.
 */
public class MainTest {

    public static void main(String[] args) {
//        test1();
//        binaryGap1();
//        binaryGap2();
//        oddOccurrencesInArray();
//        cyclicRotation();
//        frogJmp();
//        permMissingElem();
//        tapeEquilibrium();
//        permCheck();
//        frogRiverOne();
//        missingInteger();
//        maxCounter();
//        passingCars();
//        genomicRangeQuery();
//        minAvgTwoSlice();
//        countDiv();
//        distinct();
//        maxProductOfThree();
//        triangle();
//        numberOfDiscIntersections();
//        brackets();
//        fish();
//        nesting();
        stoneWall();

    }

    private static void stoneWall() {
        System.out.println("example.MainTest.stoneWall");
        Solution solution = new SolutionImpl();
        System.out.println(solution.stoneWall(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));
    }

    private static void nesting() {
        System.out.println("example.MainTest.nesting");
        Solution solution = new SolutionImpl();
        System.out.println(solution.nesting(""));
        System.out.println(solution.nesting("()"));
        System.out.println(solution.nesting("(())"));
        System.out.println(solution.nesting("()()"));
        System.out.println(solution.nesting("(()(())())"));
        System.out.println(solution.nesting("())"));
    }

    private static void fish() {
        System.out.println("example.MainTest.fish");
        Solution solution = new SolutionImpl();
        System.out.println(solution.fish(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));
    }

    private static void brackets() {
        System.out.println("example.MainTest.brackets");
        Solution solution = new SolutionImpl();
        System.out.println(solution.brackets(""));
        System.out.println(solution.brackets("()"));
        System.out.println(solution.brackets("(())"));
        System.out.println(solution.brackets("[]"));
        System.out.println(solution.brackets("[()]"));
        System.out.println(solution.brackets("{}"));
        System.out.println(solution.brackets("{()}"));
        System.out.println(solution.brackets("{}()"));
        System.out.println(solution.brackets("{[()()]}"));
        System.out.println(solution.brackets("([)()]"));

    }

    private static void numberOfDiscIntersections() {
        System.out.println("example.MainTest.numberOfDiscIntersections");
        Solution solution = new SolutionImpl();
        System.out.println(solution.numberOfDiscIntersections(new int[]{1, 5, 2, 1, 4, 0}));
    }

    private static void triangle() {
        System.out.println("example.MainTest.triangle");
        Solution solution = new SolutionImpl();
        System.out.println(solution.triangle(new int[]{10, 2, 5, 1, 8, 20}));
        System.out.println(solution.triangle(new int[]{10, 50, 5, 1}));
    }

    private static void maxProductOfThree() {
        System.out.println("example.MainTest.maxProductOfThree");
        Solution solution = new SolutionImpl();
        System.out.println(solution.maxProductOfThree(new int[]{-3, 1, 2, -2, 5, 6}));
    }

    private static void distinct() {
        System.out.println("example.MainTest.distinct");
        Solution solution = new SolutionImpl();
        System.out.println(solution.distinct(new int[]{2, 1, 1, 2, 3, 1}));
    }

    private static void countDiv() {
        System.out.println("example.MainTest.countDiv");
        Solution solution = new SolutionImpl();
        System.out.println(solution.countDiv(6, 11, 2));
    }

    private static void minAvgTwoSlice() {
        System.out.println("example.MainTest.minAvgTwoSlice");
        Solution solution = new SolutionImpl();
        System.out.println(solution.minAvgTwoSlice(new int[]{4, 2, 2, 5, 1, 5, 8}));

    }

    private static void genomicRangeQuery() {
        System.out.println("example.MainTest.genomicRangeQuery");
        Solution solution = new SolutionImpl();
        System.out.println(Arrays.toString(solution.genomicRangeQuery("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));

    }

    private static void passingCars() {
        System.out.println("example.MainTest.passingCars");
        Solution solution = new SolutionImpl();
        System.out.println(solution.passingCars(new int[]{0, 1, 0, 1, 1}));
    }

    private static void maxCounter() {
        System.out.println("example.MainTest.maxCounter");
        Solution solution = new SolutionImpl();
        System.out.println(Arrays.toString(solution.maxCounter(5, new int[]{3, 4, 4, 6, 1, 4, 4})));
    }

    private static void missingInteger() {
        System.out.println("example.MainTest.missingInteger");
        Solution solution = new SolutionImpl();
        System.out.println(solution.missingInteger(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(solution.missingInteger(new int[]{1, 2, 3}));
        System.out.println(solution.missingInteger(new int[]{-1, -3}));
    }

    private static void frogRiverOne() {
        System.out.println("example.MainTest.frogRiverOne");
        Solution solution = new SolutionImpl();
        System.out.println(solution.frogRiverOne(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    private static void permCheck() {
        System.out.println("example.MainTest.permCheck");
        Solution solution = new SolutionImpl();
        System.out.println(solution.permCheck(new int[]{4, 1, 3, 2}));
        System.out.println(solution.permCheck(new int[]{4, 1, 3}));
    }

    private static void tapeEquilibrium() {
        System.out.println("example.MainTest.tapeEquilibrium");
        Solution solution = new SolutionImpl();
        System.out.println(solution.tapeEquilibrium(new int[]{3, 1, 2, 4, 3}));
    }

    private static void permMissingElem() {
        System.out.println("example.MainTest.permMissingElem");
        Solution solution = new SolutionImpl();
        System.out.println(solution.permMissingElem(new int[]{2, 3, 1, 5}));
    }

    private static void frogJmp() {
        System.out.println("example.MainTest.frogJmp");
        Solution solution = new SolutionImpl();
        System.out.println(solution.frogJmp(10, 85, 30));
    }

    private static void cyclicRotation() {
        System.out.println("example.MainTest.cyclicRotation");
        Solution solution = new SolutionImpl();
        System.out.println(Arrays.toString(solution.cyclicRotation(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(solution.cyclicRotation(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(solution.cyclicRotation(new int[]{1, 2, 3, 4}, 4)));
    }

    private static void oddOccurrencesInArray() {
        System.out.println("example.MainTest.oddOccurrencesInArray");
        Solution solution = new SolutionImpl();
        System.out.println(solution.oddOccurrencesInArray(new int[]{9, 3, 9, 3, 9, 7, 9}));
        System.out.println(solution.oddOccurrencesInArray(new int[]{9, 3, 9, 5, 9, 5, 9, 5, 9, 5, 9}));
    }

    private static void test1() {
        System.out.println("example.MainTest.binaryGap1");
        System.out.println();
    }

    private static void binaryGap1() {
        System.out.println("example.MainTest.binaryGap1");
        Solution solution = new SolutionImpl();
        System.out.println(solution.binaryGap1(7));
        System.out.println(solution.binaryGap1(8));
        System.out.println(solution.binaryGap1(9));
        System.out.println(solution.binaryGap1(15));
        System.out.println(solution.binaryGap1(20));
        System.out.println(solution.binaryGap1(32));
        System.out.println(solution.binaryGap1(40));
        System.out.println(solution.binaryGap1(457));
        System.out.println(solution.binaryGap1(529));
        System.out.println(solution.binaryGap1(1041));
        System.out.println(solution.binaryGap1(12546));
    }

    private static void binaryGap2() {
        System.out.println("example.MainTest.binaryGap2");
        Solution solution = new SolutionImpl();
        System.out.println(solution.binaryGap2(7));
        System.out.println(solution.binaryGap2(8));
        System.out.println(solution.binaryGap2(9));
        System.out.println(solution.binaryGap2(15));
        System.out.println(solution.binaryGap2(20));
        System.out.println(solution.binaryGap2(32));
        System.out.println(solution.binaryGap2(40));
        System.out.println(solution.binaryGap2(457));
        System.out.println(solution.binaryGap2(529));
        System.out.println(solution.binaryGap2(1041));
        System.out.println(solution.binaryGap2(12546));
    }

}
