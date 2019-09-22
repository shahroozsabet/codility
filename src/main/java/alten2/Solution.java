package alten2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by shsabet on 1/23/2019.
 */
public class Solution implements SolutionInterface {

    @Override
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int result = 0;

        for (int num : nums) {
            int count = 1;

            int down = num - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
                count++;
            }

            int up = num + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
                count++;
            }

            result = Math.max(result, count);
        }

        return result;
    }

    // Returns length of the longest consecutive subsequence
    @Override
    public int findLongestConseqSubseq(int[] arr) {
        int n = arr.length;
        HashSet<Integer> S = new HashSet<>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < n; ++i)
            S.add(arr[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(arr[i] - 1)) {
                // Then check for next elements in the
                // sequence
                int j = arr[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans < j - arr[i])
                    ans = j - arr[i];
            }
        }
        return ans;
    }

    @Override
    public void getLongestSeq(int[] a) {
        // Variables to keep track of maximum
        // length and  starting point of
        // maximum length. And same for current
        // length.
        int n = a.length;
        int maxIdx = 0, maxLen = 0, currLen = 0, currIdx = 0;

        for (int k = 0; k < n; k++) {
            if (a[k] > 0) {
                currLen++;

                // New sequence, store
                // beginning index.
                if (currLen == 1)
                    currIdx = k;
            } else {
                if (currLen > maxLen) {
                    maxLen = currLen;
                    maxIdx = currIdx;
                }
                currLen = 0;
            }
        }

        if (maxLen > 0) {
            System.out.print("Length " + maxLen);
            System.out.println(",starting index " + maxIdx);
        } else
            System.out.println("No positive sequence detected.");

        return;
    }

    @Override
    public int lengthOfLISNaive(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] max = new int[nums.length];
        Arrays.fill(max, 1);

        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max[i] = Math.max(max[i], max[j] + 1);

                }
            }
            result = Math.max(max[i], result);
        }

        return result;
    }

    @Override
    public int lengthOfLISBS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0; // len of sequence

        for (int num : nums) {
            int idx = Arrays.binarySearch(dp, 0, len, num);

            //if not found, return binarySearch return -insertPosition-1
            if (idx < 0) {
                idx = -(idx + 1);
            }

            dp[idx] = num;

            //update len when insert position is at the end
            if (idx == len) {
                len++;
            }
        }

        return len;
    }

}
