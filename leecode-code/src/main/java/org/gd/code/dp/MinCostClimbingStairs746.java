package org.gd.code.dp;

import com.alibaba.fastjson.JSON;

/**
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 *
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 *
 *
 *
 * 示例 1：
 *
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 *
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 *
 *
 * 提示：
 *
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] stairs){
        int n = stairs.length ;
        for(int i=2;i<n;i++){
            stairs[i] = min(stairs[i-1],stairs[i-2]) + stairs[i];
        }
        return min(stairs[n-1],stairs[n-2]);
    }

    public  int minCostClimbingStairs2(int[] cost){
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2;i<n;i++){
            dp[i] = cost[i] + min(dp[i-1] , dp[i-2]);
        }
        return min(dp[n-1],dp[n-2]);
    }

    public int min(int a,int b){
        return a < b ? a : b;
    }

    public static void main(String[] args) {
        int[] stairs = {10,15,20};
        int[] stairs2 = {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs746 stairs746 = new MinCostClimbingStairs746();
        int cost = stairs746.minCostClimbingStairs(stairs);
        int cost2 = stairs746.minCostClimbingStairs(stairs2);
        System.out.println(cost);
        System.out.println(cost2);
    }
}
