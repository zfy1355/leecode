package org.gd.code;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution20{


        private static HashMap<Character,Character> dict = new HashMap();
        private static LinkedList<Character> quque = new LinkedList();
        static {
            dict.put('(',')');
            dict.put('[',']');
            dict.put('{','}');
        }

        public boolean isValid(String s) {
            if(s == null)
                return true;
            char[] cc = s.toCharArray();
            for(char c : cc){
                if(dict.get(c)!=null)
                    quque.add(c);
                else if(c == quque.getLast()){
                    quque.removeLast();
                }else{
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{}"));
    }
}