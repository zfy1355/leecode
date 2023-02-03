package org.gd.code.dp;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。

 * 示例 1：
 *
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 */
public class DivisorGame1025 {

    public boolean divisorGame(int n){
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int x=1;x<=n;x++){
                if( i % x == 0 && !dp[i-x]){
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[n];
    }

    public boolean divisorGame2(int n){
        return n%2==0;
    }

    public static void main(String[] args) {
        DivisorGame1025 divisorGame1025 = new DivisorGame1025();
        for(int i=2;i<30;i++){
            System.out.println(divisorGame1025.divisorGame(i) == divisorGame1025.divisorGame2(i));
        }
    }
}
