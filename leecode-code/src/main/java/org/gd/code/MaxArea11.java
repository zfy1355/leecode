package org.gd.code;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * container-with-most-water
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */
public class MaxArea11 {
    public int maxArea(int[] height) {
        //求两个最大数之间的面积
        int maxInd = 0;
        int secInd = 1;
        int maxArea = 0;
        for(int j=0;j<height.length;j++) {
            for (int i = j; i < height.length; i++) {
                if (height[secInd] < height[i]) {
                    secInd = i;
                }
                int tempMaxArea = getArea(height, secInd, maxInd);
                if(maxArea <tempMaxArea){
                    maxArea = tempMaxArea;
                }
            }
            maxInd = j;
        }
        return maxArea;
    }
    public int getArea(int[] height,int maxInd,int secInd){
        int x = secInd - maxInd;
        int y = height[maxInd]>height[secInd]?height[maxInd]:height[secInd];
        return Math.abs(x*y);
    }

    public static void main(String[] args) {
        int[] arr = {1,1};
        System.out.println (new MaxArea11().maxArea(arr));
        int[] arr2 = {1,8,6,2,5,4,8,3,7};
        System.out.println (new MaxArea11().maxArea(arr2));
    }
}
