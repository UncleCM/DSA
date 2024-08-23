package solutions.pack7;

import java.util.HashMap;
import java.util.Map;

public class EqualSubsets_661277 {

    // Recursive Approach without helper method
    public static boolean canPartition_Recur(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;
        return canPartition_Recur(arr, arr.length - 1, totalSum / 2);
    }

    private static boolean canPartition_Recur(int[] arr, int index, int target) {
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;

        return canPartition_Recur(arr, index - 1, target) ||
               canPartition_Recur(arr, index - 1, target - arr[index]);
    }

    // Memoization Approach without helper method
    public static boolean canPartition_Memoiz(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;

        Map<String, Boolean> memo = new HashMap<>();
        return canPartition_Memoiz(arr, arr.length - 1, totalSum / 2, memo);
    }

    private static boolean canPartition_Memoiz(int[] arr, int index, int target, Map<String, Boolean> memo) {
        if (target == 0) return true;
        if (index < 0 || target < 0) return false;

        String key = index + "-" + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        boolean result = canPartition_Memoiz(arr, index - 1, target, memo) ||
                         canPartition_Memoiz(arr, index - 1, target - arr[index], memo);

        memo.put(key, result);
        return result;
    }

    // Dynamic Programming Approach without helper method
    public static boolean canPartition_DP(int[] arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        boolean[][] dp = new boolean[arr.length + 1][target + 1];

        for (int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][target];
    }
}
