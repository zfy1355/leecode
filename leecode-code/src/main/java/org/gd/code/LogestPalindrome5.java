package org.gd.code;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 提示：动态规划
 */
public class LogestPalindrome5 {
    public String solution(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin =0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] =true;
        }

        char[] charArray = s.toCharArray();
        for(int L = 2;L <= len;L++){
            for(int i=0;i<len;i++){
                int j = L+i -1;
                if(j>=len){
                    break;
                }
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i <3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];//todo ?
                    }
                }
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

}
