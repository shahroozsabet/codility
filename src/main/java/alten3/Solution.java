package alten3;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by shsabet on 1/23/2019.
 */
public class Solution implements SolutionInterface {

    public Solution() {
        // You can initiate and calculate things here
    }

    // Utility function to print the sub-array arr[i,j]
    public static void print(int[] arr, int i, int j) {
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> arr[k])
                .collect(Collectors.toList()));
    }

    @Override
    public void getStartDay(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int sum_so_far = 0;

            // consider all sub-arrays starting from i and ending at j
            for (int j = i; j < arr.length; j++) {
                // sum of elements so far
                sum_so_far += arr[j];

                // if sum so far is equal to the given sum
                if (sum_so_far == 5) {
                    print(arr, i, j);
                }
            }
        }
    }

    @Override
    public int getEndDay(int[] arr) {
        return 0;
    }

}
