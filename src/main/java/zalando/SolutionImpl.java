package zalando;

/**
 * Created by shsabet on 1/23/2019.
 */
public class SolutionImpl implements Solution {

    @Override
    public int treeCutting(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        boolean[] trees = new boolean[A.length];
        trees[A.length - 1] = true;
        for (int i = A.length - 2; i > -1; i--) {
            trees[i] = (A[i] <= A[i + 1] && trees[i + 1]);
        }
        int numberOfTrees = 0;
        for (int i = 0; i < A.length; i++) {
            if (i > 0 && i + 1 < A.length) {
                if (A[i - 1] <= A[i + 1] && trees[i + 1]) {
                    numberOfTrees += 1;
                }
                if (A[i] < A[i - 1]) {
                    break;
                }
            } else if (i == 0) {
                if (trees[i + 1]) {
                    numberOfTrees += 1;
                }
            } else if (i == A.length - 1) {
                numberOfTrees += 1;
            }
        }

        return numberOfTrees;
    }

    @Override
    public int task2(int A, int B) {
        return A;
    }

}
