package org.gd.code;
import java.util.HashMap;
import java.util.LinkedList;


/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution20{


        private static HashMap<Character,Character> dict = new HashMap();
        private static LinkedList<Character> queue = new LinkedList();
        static {
            dict.put('(',')');
            dict.put('[',']');
            dict.put('{','}');
        }

        public boolean isValid(String s) {
            if(s == null|| s.length()<1)
                return true;
            char[] cc = s.toCharArray();
            for(char c : cc){
                if(dict.get(c)!=null)
                    queue.addLast(c);
                else if(c == dict.get(queue.getLast())){
                    queue.removeLast();
                }else{
                    return false;
                }
            }
            return queue.size()==0;
        }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{[]}"));
//        System.out.println(solution20.isValid("()"));
        System.out.println(solution20.isValid("{]"));
    }
}