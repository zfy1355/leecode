package org.gd.code.dp;

import java.util.ArrayList;
import java.util.List;

/**
* @author zhangfengyang
# @date 2023/1/31 6:53 下午
* @description 返回杨辉三角
**/
public class YangHuiTriangle {
    public List<List<Integer>> generate(int numRows) {
        if(numRows<1 || numRows >30){
            System.out.println("超过范围");
        }
        List<List<Integer>> result = new ArrayList();
        List<Integer> one = new ArrayList();
        one.add(1);
        result.add(one);
        for(int i=1;i<numRows;i++){
            List<Integer> temp = new ArrayList();
            for(int j=0;j<i;j++){
                if(j==0 ){
                    temp.add(1);
                    continue;
                }
                temp.add(result.get(i-1).get(j)+result.get(i-1).get(j-1));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        YangHuiTriangle yang = new YangHuiTriangle();
        List<List<Integer>> res = yang.generate(10);
        System.out.println(res);
    }
}
