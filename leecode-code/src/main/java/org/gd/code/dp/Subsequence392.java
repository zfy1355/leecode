package org.gd.code.dp;

import com.alibaba.fastjson.JSON;

/**
* @author zhangfengyang
# @date 2023/2/1 11:36 上午
* @description
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 进阶：
 *
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 致谢：
 *
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abc", t = "ahbgdc"
 * 输出：true
 * 示例 2：
 *
 * 输入：s = "axc", t = "ahbgdc"
 * 输出：false
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 10^4
 * 两个字符串都只由小写字符组成。
**/
public class Subsequence392 {

    public boolean isSubsequence(String s, String t) {
        char[] source = s.toCharArray();
        char[] sub = t.toCharArray();
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(source[i-1] == sub[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        System.out.println(JSON.toJSONString(dp));
        if(dp[s.length()][t.length()] == s.length()){
            return true;
        }
        return false;
    }

    public boolean isSubsequence1(String s, String t) {
        int i = 0;
        for (int j = 0; i < s.length() && j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Subsequence392 subsequence392 = new Subsequence392();
        subsequence392.isSubsequence("abc","ahbgdc");
        subsequence392.isSubsequence1("abc","ahbgdc");
    }
}
