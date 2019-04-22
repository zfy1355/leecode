package org.gd.code;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 注意：给定 n 是一个正整数。

 解题思路：斐波那契f(n)=f(n-1)+f(n-2)
 类似题目：兔子繁殖、杨辉三角
 */
public class ClimbStairs70 {
    public int climbStairs(int n) {
        if(n==1 || n==2)
            return n;
        else{
            int f1=1;
            int f2=2;
            int res =0;
            for(int k=3;k<=n;k++){
                res = f1 +f2;
                f1 = f2;
                f2 = res;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs70().climbStairs(4));
    }
}
