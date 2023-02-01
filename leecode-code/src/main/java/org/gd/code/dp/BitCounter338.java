package org.gd.code.dp;

/**
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：[0,1,1]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：[0,1,1,2,1,2]
 * 解释：
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * 6     110
 * 7     111
 * 8     1000
 *
 * 提示：
 *
 * 0 <= n <= 105
 *
 *
 * 进阶：
 *
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的 __builtin_popcount ）
 */
public class BitCounter338 {
    /**
     * 方法一：i & (i - 1)可以去掉i最右边的一个1（如果有），因此 i & (i - 1）是比 i 小的，而且i & (i - 1)的1的个数已经在前面算过了，所以i的1的个数就是 i & (i - 1)的1的个数加上1
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        if(num ==0){
            return new int[1];
        }
        int[] res = new int[num +1];
        for(int i = 1;i<= num;i++){
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }

    /**
     * 方法二：i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
     * @param num
     * @return
     */
    public int[] countBits2(int num){
        int[] res = new int[num +1];
        for(int i = 1;i<= num;i++){
            res[i] = res[i>>1] + (i & 1);
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(4&3);
    }
}
