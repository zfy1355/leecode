package org.gd.code;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 示例 1:

 输入: [7,1,5,3,6,4]
 输出: 7
 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 示例 2:

 输入: [1,2,3,4,5]
 输出: 4
 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 */
public class StockMaxProfit122 {
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if(length <2)
            return 0;
        int temp = prices[0];
        int profit = 0;
        for(int i=0;i<=length -2;i++){
            if(temp > prices[i+1])
                temp = prices[i+1];
            else{
                profit += prices[i+1] - temp;
                temp = prices[i+1];
            }
        }
        return profit;
    }

    public static int maxProfitSimple(int[] prices) {
        int length = prices.length;
        if(length <2)
            return 0;
        int profit =0;
        int diff;
        for(int i=0;i<=length-2;i++){
            diff = prices[i+1] - prices[i];
            if(diff>0)
                profit += diff;
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] data = {7,1,5,3,6,4};
        System.out.println(maxProfitSimple(data));
    }
}
